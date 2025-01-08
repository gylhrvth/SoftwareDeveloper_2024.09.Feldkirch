/*
export { Rook };

class Rook {
    constructor(isWhite) {
        this.__type = 'Rook';
        this.currentRow = null;
        this.currentCol = null;
        this.isWhite = isWhite;
        this.label = isWhite ? "♖" : "♜";
    }

    restoreData(value) {
        this.currentRow = value.currentRow;
        this.currentCol = value.currentCol;
        this.isWhite = value.isWhite;
        this.label = value.isWhite ? "♖" : "♜";
    }

    testOutOfBounds(rowOffset, colOffset) {
        let newRow = this.currentRow + rowOffset;
        let newCol = this.currentCol + colOffset;
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }

    getPossibleMoves(chess) {
        let moves = [];
        let directions = [
            { rowOffset: -1, colOffset: 0 },  // Up
            { rowOffset: 1, colOffset: 0 },   // Down
            { rowOffset: 0, colOffset: 1 },   // Right
            { rowOffset: 0, colOffset: -1 }   // Left
        ];

        for (let direction of directions) {
            let distance = 1;
            while (true) {
                let newRow = this.currentRow + direction.rowOffset * distance;
                let newCol = this.currentCol + direction.colOffset * distance;

                if (this.testOutOfBounds(direction.rowOffset * distance, direction.colOffset * distance)) break;

                let piece = chess.getChessPiece(newRow, newCol);
                if (!piece) {
                    moves.push({ newRow, newCol, piece: this });
                } else {
                    if (piece.isWhite !== this.isWhite) {
                        moves.push({ newRow, newCol, piece: this });
                    }
                    break; // Stop further movement in this direction
                }
                distance++;
            }
        }

        return moves;
    }
}
*/


export { Rook };

class Rook {
    constructor(isWhite) {
        this.__type = 'Rook';

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
                } else if (chess.getChessPiece(row - distance, col ).isWhite != this.isWhite) {
                    moves.push({ newRow: row - distance,newColumn: col ,  piece: this })
                    up = false
                } else {
                   up = false
                }
            }

            if (down && !this.testOutOfBounds(distance, 0)) {
                if (chess.getChessPiece(row + distance, col) == undefined) {
                    moves.push({ newRow: row + distance,newColumn: col , piece: this })
                } else if (chess.getChessPiece(row + distance, col ).isWhite != this.isWhite) {
                    moves.push({ newRow: row + distance,newColumn: col , piece: this })
                    down = false
                } else {
                    down = false
                }
            }

            if (right && !this.testOutOfBounds(0, distance)) {
                if (chess.getChessPiece(row , col + distance) == undefined) {
                    moves.push( {newRow: row , newColumn: col + distance, piece: this })
                } else if (chess.getChessPiece(row , col + distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row , newColumn: col + distance, piece: this })
                    right = false
                } else {
                    right = false
                }
            }

            if (left && !this.testOutOfBounds(0, -distance)) {
                if (chess.getChessPiece(row , col - distance) == undefined) {
                    moves.push({ newRow: row ,  newColumn: col - distance, piece: this })
                } else if (chess.getChessPiece(row, col - distance).isWhite != this.isWhite) {
                    moves.push({ newRow: row ,  newColumn: col - distance, piece: this })
                    left = false
                } else {
                    left = false
                }
            }
        }

        // console.log("Rook", moves)
        return moves;
    }
}

