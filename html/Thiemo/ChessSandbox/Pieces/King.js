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

    canCastle(chess) {
        if (this.hasMoved) return false;  // Can't castle if the King has moved

        let row = this.currentRow;
        let col = this.currentCol;


        // Check for left and right castling (both White and Black)
        if (this.isWhite && row === 7 && col === 4) {
            // Check left castling
            let rook = chess.boardArray[row][0];
            if (!rook || rook.hasMoved) return false; // Rook has moved
            for (let c = 1; c < 4; c++) {
                if (chess.boardArray[row][c] !== undefined) {
                    return false; // Path blocked
                }
            }
            // Check right castling
            rook = chess.boardArray[row][7];
            if (!rook || rook.hasMoved) return false; // Rook has moved
            for (let c = 5; c < 7; c++) {
                if (chess.boardArray[row][c] !== undefined) {
                    return false; // Path blocked
                }
            }
        } else if (!this.isWhite && row === 0 && col === 4) {
            // Check left castling
            let rook = chess.boardArray[row][0];
            if (!rook || rook.hasMoved) return false; // Rook has moved
            for (let c = 1; c < 4; c++) {
                if (chess.boardArray[row][c] !== undefined) {
                    return false; // Path blocked
                }
            }
            // Check right castling
            rook = chess.boardArray[row][7];
            if (!rook || rook.hasMoved) return false; // Rook has moved
            for (let c = 5; c < 7; c++) {
                if (chess.boardArray[row][c] !== undefined) {
                    return false; // Path blocked
                }
            }
        }

        return true;
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

        if (this.canCastle(chess)) {
            if (chess.boardArray[row][0] && chess.boardArray[row][0].hasMoved === false) {
                moves.push({ 
                    piece: this, 
                    newRow: row, 
                    newColumn: 2, 
                    castling: 'left' });
            }
            if (chess.boardArray[row][7] && chess.boardArray[row][7].hasMoved === false) {
                moves.push({
                    piece: this, 
                    newRow: row, 
                    newColumn: 6, 
                    castling: 'right' });
            }
        }


        if (up && !this.testOutOfBounds(-distance, 0)) {
            if (chess.getChessPiece(row - distance, col) == undefined ||
                chess.getChessPiece(row - distance, col).isWhite != this.isWhite) {
                moves.push({ 
                    newRow: row - distance, 
                    newColumn: col, 
                    piece: this })
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
                    piece: this })
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




