export { King };

class King {
    constructor(isWhite) {
        this.__type = 'King';
        this.hasMoved = false;  // Tracks if the King has moved
        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = "♔"
        } else {
            this.label = "♚";
        }
    }

    //Black ♝,♞,♟,♜,♛,♚
    //White ♗,♘,♙,♖,♕,♔
    restoreData(value) {
        this.currentRow = value.currentRow
        this.currentCol = value.currentCol
        this.hasMoved = value.hasMoved;  // Restore the moved status
        this.isWhite = value.isWhite
        if (value.isWhite) {
            this.label = "♔"
        } else {
            this.label = "♚";
        }
    }

    testOutOfBounds(rowCount, colCount) {
        let newRow = this.currentRow + rowCount;
        let newCol = this.currentCol + colCount;

        // Return true if newRow or newCol are out of bounds (its like a boolean without creating one?? )
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }


    // Method to check if castling is possible
    canCastle(chess) {
        if (this.hasMoved) return false;  // Can't castle if the King has moved

        let row = this.currentRow;
        let col = this.currentCol;

        // Check both left and right castling
        return this.canCastleLeft(chess, row, col) || this.canCastleRight(chess, row, col);
    }

    // Method to check left castling
    canCastleLeft(chess, row, col) {
        const rookColumn = 0; // Leftmost column for the rook
        const castlingRow = this.isWhite ? 7 : 0; // Row depends on the color

        if (row === castlingRow && col === 4) { // Ensure king is in its initial position
            let rook = chess.boardArray[row][rookColumn];
            if (!rook || rook.hasMoved) {
                console.log("Left castling not possible: Rook moved or missing.");
                return false;
            }
            for (let c = rookColumn + 1; c < col; c++) {
                if (chess.boardArray[row][c] !== undefined) {
                    return false; // Path blocked
                }
            }
            return true; // Left castling possible
        }
        return false;
    }

    // Method to check right castling
    canCastleRight(chess, row, col) {
        const rookColumn = 7; // Rightmost column for the rook
        const castlingRow = this.isWhite ? 7 : 0; // Row depends on the color

        if (row === castlingRow && col === 4) { // Ensure king is in its initial position
            let rook = chess.boardArray[row][rookColumn];
            if (!rook || rook.hasMoved) {
                console.log("Right castling not possible: Rook moved or missing.");
                return false;
            }
            for (let c = col + 1; c < rookColumn; c++) {
                if (chess.boardArray[row][c] !== undefined) {
                    return false; // Path blocked
                }
            }
            return true; // Right castling possible
        }
        return false;
    }



    getPossibleMoves(chess) {
        let moves = []
        let up = true
        let down = true
        let right = true
        let left = true

        let topRight = true
        let topLeft = true
        let bottomRight = true
        let bottomLeft = true

        let distance = 1

        let row = this.currentRow
        let col = this.currentCol

        // Check castling conditions
        if (this.canCastleLeft(chess, row, col)) {
            moves.push({
                piece: this,
                newRow: row,
                newColumn: 2,
                castling: 'left'
            });
        }

        if (this.canCastleRight(chess, row, col)) {
            moves.push({
                piece: this,
                newRow: row,
                newColumn: 6,
                castling: 'right'
            });
        }


        if (up && !this.testOutOfBounds(-distance, 0)) {
            if (chess.getChessPiece(row - distance, col) == undefined ||
                chess.getChessPiece(row - distance, col).isWhite != this.isWhite) {
                moves.push({
                    newRow: row - distance,
                    newColumn: col,
                    piece: this
                })
            } else {
                up = false
            }
        }

        if (down && !this.testOutOfBounds(distance, 0)) {
            if (chess.getChessPiece(row + distance, col) == undefined ||
                chess.getChessPiece(row + distance, col).isWhite != this.isWhite) {
                moves.push({
                    newRow: row + distance,
                    newColumn: col,
                    piece: this
                })
            } else {
                down = false
            }
        }

        if (right && !this.testOutOfBounds(0, distance)) {
            if (chess.getChessPiece(row, col + distance) == undefined ||
                chess.getChessPiece(row, col + distance).isWhite != this.isWhite) {
                moves.push({ newRow: row, newColumn: col + distance, piece: this })
            } else {
                right = false
            }
        }

        if (left && !this.testOutOfBounds(0, -distance)) {
            if (chess.getChessPiece(row, col - distance) == undefined ||
                chess.getChessPiece(row, col - distance).isWhite != this.isWhite) {
                moves.push({ newRow: row, newColumn: col - distance, piece: this })
            } else {
                left = false
            }
        }

        if (topRight && !this.testOutOfBounds(-distance, distance)) {
            if (chess.getChessPiece(row - distance, col + distance) == undefined ||
                chess.getChessPiece(row - distance, col + distance).isWhite != this.isWhite) {
                moves.push({ newRow: row - distance, newColumn: col + distance, piece: this })
            } else {
                topRight = false
            }
        }

        if (topLeft && !this.testOutOfBounds(-distance, -distance)) {
            if (chess.getChessPiece(row - distance, col - distance) == undefined ||
                chess.getChessPiece(row - distance, col - distance).isWhite != this.isWhite) {
                moves.push({ newRow: row - distance, newColumn: col - distance, piece: this })
            } else {
                topLeft = false
            }
        }

        if (bottomRight && !this.testOutOfBounds(distance, distance)) {
            if (chess.getChessPiece(row + distance, col + distance) == undefined ||
                chess.getChessPiece(row + distance, col + distance).isWhite != this.isWhite) {
                moves.push({ newRow: row + distance, newColumn: col + distance, piece: this })
            } else {
                bottomRight = false
            }
        }

        if (bottomLeft && !this.testOutOfBounds(distance, -distance)) {
            if (chess.getChessPiece(row + distance, col - distance) == undefined ||
                chess.getChessPiece(row + distance, col - distance).isWhite != this.isWhite) {
                moves.push({ newRow: row + distance, newColumn: col - distance, piece: this })
            } else {
                bottomLeft = false
            }
        }

        // console.log("Queen", moves)
        return moves;
    }
}




