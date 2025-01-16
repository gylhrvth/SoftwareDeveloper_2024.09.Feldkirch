export { Bishop };

class Bishop {
    constructor(isWhite) {
        this.__type = 'Bishop';

        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = '♗'
        } else {
            this.label = '♝'
        }
    }

    restoreData(value) {

        this.currentRow = value.currentRow
        this.currentCol = value.currentCol
        this.isWhite = value.isWhite
        if (value.isWhite) {
            this.label = '♗'
        } else {
            this.label = '♝'
        }
    }
//Black ♝,♞,♟,♜,♛,♚
//White ♗,♘,♙,♖,♕,♔
    testOutOfBounds(rowCount, colCount) {
        let newRow = this.currentRow + rowCount;
        let newCol = this.currentCol + colCount;

        // Return true if newRow or newCol are out of bounds (its like a boolean without creating one?? )
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }

    getPossibleMoves(chess) {
        let moves = []
        let topRight = true
        let topLeft = true
        let bottomRight = true
        let bottomLeft = true

        let row = this.currentRow
        let col = this.currentCol


        for (let distance = 1; distance < 8; distance++) {
            if (topRight && !this.testOutOfBounds(-distance, distance)) {
                if (chess.getChessPiece(row - distance, col + distance) == undefined) {
                    moves.push({ newRow: row - distance, newColumn: col + distance, piece: this })
                } else if (chess.getChessPiece(row - distance, col + distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row - distance, newColumn: col + distance, piece: this })
                    topRight = false
                } else {
                    topRight = false
                }
            }

            if (topLeft && !this.testOutOfBounds(-distance, -distance)) {
                if (chess.getChessPiece(row - distance, col - distance) == undefined) {
                    moves.push({ newRow: row - distance, newColumn: col - distance, piece: this })
                } else if (chess.getChessPiece(row - distance, col - distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row - distance, newColumn: col - distance, piece: this })
                    topLeft = false
                } else {
                    topLeft = false
                }
            }

            if (bottomRight && !this.testOutOfBounds(distance, distance)) {
                if (chess.getChessPiece(row + distance, col + distance) == undefined) {
                    moves.push({ newRow: row + distance, newColumn: col + distance, piece: this })
                } else if (chess.getChessPiece(row + distance, col + distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row + distance, newColumn: col + distance, piece: this })
                    bottomRight = false
                } else {
                    bottomRight = false
                }
            }

            if (bottomLeft && !this.testOutOfBounds(distance, -distance)) {
                if (chess.getChessPiece(row + distance, col - distance) == undefined) {
                    moves.push({ newRow: row + distance, newColumn: col - distance, piece: this })
                } else if (chess.getChessPiece(row + distance, col - distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row + distance, newColumn: col - distance, piece: this })
                    bottomLeft = false
                } else {
                    bottomLeft = false
                }
            }
        }

      //   console.log("Bishop", moves)
        return moves;
    }
}