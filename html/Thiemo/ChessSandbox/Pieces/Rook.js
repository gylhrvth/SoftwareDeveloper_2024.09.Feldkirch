



export { Rook };

class Rook {
    constructor(isWhite) {
        this.__type = 'Rook';
        this.hasMoved = false;
        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = "♖"
        } else {
            this.label = "♜";
        }
    }
    //Black ♝,♞,♟,♜,♛,♚
    //White ♗,♘,♙,♖,♕,♔
    restoreData(value) {
        this.hasMoved = value.hasMoved
        this.currentRow = value.currentRow
        this.currentCol = value.currentCol
        this.isWhite = value.isWhite
        if (value.isWhite) {
            this.label = "♖"
        } else {
            this.label = "♜";
        }
    }
    testOutOfBounds(rowCount, colCount) {
        let newRow = this.currentRow + rowCount;
        let newCol = this.currentCol + colCount;

        // Return true if newRow or newCol are out of bounds (its like a boolean without creating one?? )
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }
    getPossibleMoves(chess) {
        let moves = []
        let up = true
        let down = true
        let right = true
        let left = true

        let row = this.currentRow
        let col = this.currentCol


        for (let distance = 1; distance < 8; distance++) {
            if (up && !this.testOutOfBounds(-distance, 0)) {
                if (chess.getChessPiece(row - distance, col) == undefined) {
                    moves.push({ newRow: row - distance, newColumn: col, piece: this })
                } else if (chess.getChessPiece(row - distance, col).isWhite != this.isWhite) {
                    moves.push({ newRow: row - distance, newColumn: col, piece: this })
                    up = false
                } else {
                    up = false
                }
            }

            if (down && !this.testOutOfBounds(distance, 0)) {
                if (chess.getChessPiece(row + distance, col) == undefined) {
                    moves.push({ newRow: row + distance, newColumn: col, piece: this })
                } else if (chess.getChessPiece(row + distance, col).isWhite != this.isWhite) {
                    moves.push({ newRow: row + distance, newColumn: col, piece: this })
                    down = false
                } else {
                    down = false
                }
            }

            if (right && !this.testOutOfBounds(0, distance)) {
                if (chess.getChessPiece(row, col + distance) == undefined) {
                    moves.push({ newRow: row, newColumn: col + distance, piece: this })
                } else if (chess.getChessPiece(row, col + distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row, newColumn: col + distance, piece: this })
                    right = false
                } else {
                    right = false
                }
            }

            if (left && !this.testOutOfBounds(0, -distance)) {
                if (chess.getChessPiece(row, col - distance) == undefined) {
                    moves.push({ newRow: row, newColumn: col - distance, piece: this })
                } else if (chess.getChessPiece(row, col - distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row, newColumn: col - distance, piece: this })
                    left = false
                } else {
                    left = false
                }
            }
        }

        // console.log("Rook", moves)
        return moves;
    }

    getValidMoves(chess) {
        const possibleMoves = this.getPossibleMoves(chess);
        const validMoves = [];

        for (let move of possibleMoves) {
            // Temporarily simulate the move
            const originalRow = this.currentRow;
            const originalCol = this.currentCol;
            this.currentRow = move.newRow;
            this.currentCol = move.newColumn;

            // Check if King would still be in check
            if (!chess.isKingInCheck(this.isWhite)) {
                validMoves.push(move);
            }

            // Restore original position
            this.currentRow = originalRow;
            this.currentCol = originalCol;
        }

        console.log("Valid moves I get back: ", validMoves);
        return validMoves;
    }
}

