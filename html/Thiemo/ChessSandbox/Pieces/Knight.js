export { Knight };

class Knight {     // Knight class with(constructor, restoreData??, getPossibleMoves )
    constructor(isWhite) {
        this.__type = 'Knight';

        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = "♘"
        } else {
            this.label = "♞";
        }
    }

    restoreData(value) {
        this.currentRow = value.currentRow
        this.currentCol = value.currentCol
        this.isWhite = value.isWhite
        if (value.isWhite) {
            this.label = "♘"
        } else {
            this.label = "♞";
        }
    }


    testOutOfBounds(rowCount, colCount) {
        let newRow = this.currentRow + rowCount;
        let newCol = this.currentCol + colCount;

        // Return true if newRow or newCol are out of bounds (its like a boolean without creating one?? )
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }



    getPossibleMoves(chess) {
        let moves = [];

        // Black pieces
        if (!this.isWhite) {
            if (this.currentRow <= 7 && this.currentRow >= 0 && this.currentCol <= 7 && this.currentCol >= 0) {

                if (!this.testOutOfBounds(2, 1)) {
                    if (chess.getChessPiece(this.currentRow + 2, this.currentCol + 1) == undefined ||
                        chess.getChessPiece(this.currentRow + 2, this.currentCol + 1).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 2,
                                newColumn: this.currentCol + 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(2, -1)) {
                    if (chess.getChessPiece(this.currentRow + 2, this.currentCol - 1) == undefined ||
                        chess.getChessPiece(this.currentRow + 2, this.currentCol - 1).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 2,
                                newColumn: this.currentCol - 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-2, 1)) {
                    if (chess.getChessPiece(this.currentRow - 2, this.currentCol + 1) == undefined ||
                        chess.getChessPiece(this.currentRow - 2, this.currentCol + 1).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 2,
                                newColumn: this.currentCol + 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-2, -1)) {
                    if (chess.getChessPiece(this.currentRow - 2, this.currentCol - 1) == undefined ||
                        chess.getChessPiece(this.currentRow - 2, this.currentCol - 1).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 2,
                                newColumn: this.currentCol - 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(1, 2)) {
                    if (chess.getChessPiece(this.currentRow + 1, this.currentCol + 2) == undefined ||
                        chess.getChessPiece(this.currentRow + 1, this.currentCol + 2).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 1,
                                newColumn: this.currentCol + 2,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(1, -2)) {
                    if (chess.getChessPiece(this.currentRow + 1, this.currentCol - 2) == undefined ||
                        chess.getChessPiece(this.currentRow + 1, this.currentCol - 2).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 1,
                                newColumn: this.currentCol - 2,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-1, +2)) {
                    if (chess.getChessPiece(this.currentRow - 1, this.currentCol + 2) == undefined ||
                        chess.getChessPiece(this.currentRow - 1, this.currentCol + 2).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 1,
                                newColumn: this.currentCol + 2,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-1, -2)) {
                    if (chess.getChessPiece(this.currentRow - 1, this.currentCol - 2) == undefined ||
                        chess.getChessPiece(this.currentRow - 1, this.currentCol - 2).isWhite != this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 1,
                                newColumn: this.currentCol - 2,
                                piece: this
                            }
                        )
                    }
                }
            }
        }

        else {
            if (this.currentRow <= 7 && this.currentRow >= 0 && this.currentCol <= 7 && this.currentCol >= 0) {

                if (!this.testOutOfBounds(2, 1)) {
                    if (chess.getChessPiece(this.currentRow + 2, this.currentCol + 1) == undefined ||
                        chess.getChessPiece(this.currentRow + 2, this.currentCol + 1).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 2,
                                newColumn: this.currentCol + 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(2, -1)) {
                    if (chess.getChessPiece(this.currentRow + 2, this.currentCol - 1) == undefined ||
                        chess.getChessPiece(this.currentRow + 2, this.currentCol - 1).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 2,
                                newColumn: this.currentCol - 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-2, 1)) {
                    if (chess.getChessPiece(this.currentRow - 2, this.currentCol + 1) == undefined ||
                        chess.getChessPiece(this.currentRow - 2, this.currentCol + 1).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 2,
                                newColumn: this.currentCol + 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-2, -1)) {
                    if (chess.getChessPiece(this.currentRow - 2, this.currentCol - 1) == undefined ||
                        chess.getChessPiece(this.currentRow - 2, this.currentCol - 1).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 2,
                                newColumn: this.currentCol - 1,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(1, 2)) {
                    if (chess.getChessPiece(this.currentRow + 1, this.currentCol + 2) == undefined ||
                        chess.getChessPiece(this.currentRow + 1, this.currentCol + 2).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 1,
                                newColumn: this.currentCol + 2,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(1, -2)) {
                    if (chess.getChessPiece(this.currentRow + 1, this.currentCol - 2) == undefined ||
                        chess.getChessPiece(this.currentRow + 1, this.currentCol - 2).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow + 1,
                                newColumn: this.currentCol - 2,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-1, 2)) {
                    if (chess.getChessPiece(this.currentRow - 1, this.currentCol + 2) == undefined ||
                        chess.getChessPiece(this.currentRow - 1, this.currentCol + 2).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 1,
                                newColumn: this.currentCol + 2,
                                piece: this
                            }
                        )
                    }
                }

                if (!this.testOutOfBounds(-1, -2)) {
                    if (chess.getChessPiece(this.currentRow - 1, this.currentCol - 2) == undefined ||
                        chess.getChessPiece(this.currentRow - 1, this.currentCol - 2).isWhite == this.isWhite) {
                        moves.push(
                            {
                                newRow: this.currentRow - 1,
                                newColumn: this.currentCol - 2,
                                piece: this
                            }
                        )
                    }
                }
            }
        }
     //   console.log("Knight", moves)
        return moves;
    }
}

