export { King };

class King {
    constructor(isWhite) {
        this.__type = 'King';

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


    // getPossibleMoves(chess) {
    //     const moves = [];
    //     const directions = [
    //         { dRow: -1, dCol: 0 },   // Up
    //         { dRow: 1, dCol: 0 },    // Down
    //         { dRow: 0, dCol: 1 },    // Right
    //         { dRow: 0, dCol: -1 },   // Left
    //         { dRow: -1, dCol: 1 },   // Top-right
    //         { dRow: -1, dCol: -1 },  // Top-left
    //         { dRow: 1, dCol: 1 },    // Bottom-right
    //         { dRow: 1, dCol: -1 }    // Bottom-left
    //     ];

    //     for (const dir of directions) {
    //         let newRow = this.currentRow + dir.dRow;
    //         let newCol = this.currentCol + dir.dCol;

    //         if (!this.testOutOfBounds(dir.dRow, dir.dCol)) {
    //             const targetPiece = chess.getChessPiece(newRow, newCol);

    //             if (targetPiece === undefined || targetPiece.isWhite !== this.isWhite) {
    //                 moves.push({newRow: newRow, newColumn: newCol, piece: this });
    //             }
    //         }
    //     }

    //     return moves;
    // }

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


        if (up && !this.testOutOfBounds(-distance, 0)) {
            if (chess.getChessPiece(row - distance, col) == undefined ||
                chess.getChessPiece(row - distance, col).isWhite != this.isWhite) {
                moves.push({ newRow: row - distance, newColumn: col, piece: this })
            } else {
                up = false
            }
        }

        if (down && !this.testOutOfBounds(distance, 0)) {
            if (chess.getChessPiece(row + distance, col) == undefined ||
                chess.getChessPiece(row + distance, col).isWhite != this.isWhite) {
                moves.push({ newRow: row + distance, newColumn: col, piece: this })
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

