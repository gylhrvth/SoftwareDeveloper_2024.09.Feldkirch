export { Pawn };

class Pawn {    //Pawn with (constructor, restoreData??, getPossibleMoves)
    constructor(isWhite) {
        this.__type = 'Pawn';

        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = "♙"
        } else {
            this.label = "♟";
        }
    }

    restoreData(value) {
        this.currentRow = value.currentRow
        this.currentCol = value.currentCol
        this.isWhite = value.isWhite
        if (value.isWhite) {
            this.label = "♙"
        } else {
            this.label = "♟";
        }
    }

    //Black ♝,♞,♟,♜,♛,♚
    //White ♗,♘,♙,♖,♕,♔

    getPossibleMoves(chess) {
        let moves = [];



    // En Passant Logic for Black Pawn (on the 4th row)
    if (!this.isWhite && this.currentRow === 4) {
        const lastMove = chess.history[chess.history.length - 1];

        // Ensure lastMove exists and has the necessary structure
        if (lastMove && lastMove.move && lastMove.move.piece === "Pawn" && Math.abs(lastMove.move.toRow - lastMove.move.fromRow) === 2) {
            const lastMovedPiece = chess.getChessPiece(lastMove.move.toRow, lastMove.move.toCol);

            // Ensure the last moved piece exists
            if (lastMovedPiece && lastMovedPiece.__type === "Pawn") {
                // Check for en passant on the left
                if (this.currentCol > 0 && lastMove.move.toRow === this.currentRow && lastMove.move.toCol === this.currentCol - 1) {
                    moves.push({
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol - 1,
                        piece: this,
                        enPassant: true  // Mark this move as en passant
                    });
                }

                // Check for en passant on the right
                if (this.currentCol < 7 && lastMove.move.toRow === this.currentRow && lastMove.move.toCol === this.currentCol + 1) {
                    moves.push({
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol + 1,
                        piece: this,
                        enPassant: true  // Mark this move as en passant
                    });
                }
            }
        } else {
            // Debug log if lastMove doesn't have the expected structure
            console.log("Invalid lastMove for en passant:", lastMove);
        }
    }

    // En Passant Logic for White Pawn (on the 3rd row)
    if (this.isWhite && this.currentRow === 3) {
        const lastMove = chess.history[chess.history.length - 1];

        // Ensure lastMove exists and has the necessary structure
        if (lastMove && lastMove.move && lastMove.move.piece === "Pawn" && Math.abs(lastMove.move.toRow - lastMove.move.fromRow) === 2) {
            const lastMovedPiece = chess.getChessPiece(lastMove.move.toRow, lastMove.move.toCol);

            // Ensure the last moved piece exists
            if (lastMovedPiece && lastMovedPiece.__type === "Pawn") {
                // Check for en passant on the left
                if (this.currentCol > 0 && lastMove.move.toRow === this.currentRow && lastMove.move.toCol === this.currentCol - 1) {
                    moves.push({
                        newRow: this.currentRow - 1,
                        newColumn: this.currentCol - 1,
                        piece: this,
                        enPassant: true  // Mark this move as en passant
                    });
                }

                // Check for en passant on the right
                if (this.currentCol < 7 && lastMove.move.toRow === this.currentRow && lastMove.move.toCol === this.currentCol + 1) {
                    moves.push({
                        newRow: this.currentRow - 1,
                        newColumn: this.currentCol + 1,
                        piece: this,
                        enPassant: true  // Mark this move as en passant
                    });
                }
            }
        } else {
            // Debug log if lastMove doesn't have the expected structure
            console.log("Invalid lastMove for en passant:", lastMove);
        }
    }


        // Black pieces
        if (!this.isWhite) {
            /*
            if (this.currentRow < 7 && chess.getChessPiece(this.currentRow + 1, this.currentCol) == undefined) {
                moves.push(
                    {
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol,
                        piece: this
                    }
                )
            } */
            if (this.currentRow == 1 && chess.getChessPiece(this.currentRow + 2, this.currentCol) == undefined &&
                chess.getChessPiece(this.currentRow + 1, this.currentCol) == undefined) {
                moves.push(
                    {
                        newRow: this.currentRow + 2,
                        newColumn: this.currentCol,
                        piece: this
                    }
                )
            }
            // Add option to HIT an other figure
            // hits left
            if (this.currentCol > 0 && this.currentRow < 7 &&
                chess.getChessPiece(this.currentRow + 1, this.currentCol - 1) != undefined &&
                chess.getChessPiece(this.currentRow + 1, this.currentCol - 1).isWhite != this.isWhite) {
                moves.push(
                    {
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol - 1,
                        piece: this
                    }
                )
            }

            // Add option to HIT an other figure
            // hits right
            if (this.currentCol < 7 && this.currentRow < 7 &&
                chess.getChessPiece(this.currentRow + 1, this.currentCol + 1) != undefined &&
                chess.getChessPiece(this.currentRow + 1, this.currentCol + 1).isWhite != this.isWhite) {
                moves.push(
                    {
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol + 1,
                        piece: this
                    }
                )
            }
        }

        // White pieces
        if (this.isWhite) {
            if (this.currentRow > 0 && chess.getChessPiece(this.currentRow - 1, this.currentCol) == undefined) {
                moves.push(
                    {
                        newRow: this.currentRow - 1,
                        newColumn: this.currentCol,
                        piece: this                 // Extend the Object in moves[] with the piece as attribute
                    }
                )
            }

            // Add option to move 2 Field at the beginnning
            if (this.currentRow == 6 && chess.getChessPiece(this.currentRow - 2, this.currentCol) == undefined &&
                chess.getChessPiece(this.currentRow - 1, this.currentCol) == undefined) {
                moves.push(
                    {
                        newRow: this.currentRow - 2,
                        newColumn: this.currentCol,
                        piece: this                 // Extend the Object in moves[] with the piece as attribute
                    }
                )
            }

            // Add option to HIT an other figure
            // hits left
            if (this.currentCol > 0 && this.currentRow > 0 &&
                chess.getChessPiece(this.currentRow - 1, this.currentCol - 1) != undefined &&
                chess.getChessPiece(this.currentRow - 1, this.currentCol - 1).isWhite != this.isWhite) {
                moves.push(
                    {
                        newRow: this.currentRow - 1,
                        newColumn: this.currentCol - 1,
                        piece: this
                    }
                )
            }

            // Add option to HIT an other figure
            // hits right
            if (this.currentCol < 7 && this.currentRow > 0 &&
                chess.getChessPiece(this.currentRow - 1, this.currentCol + 1) != undefined &&
                chess.getChessPiece(this.currentRow - 1, this.currentCol + 1).isWhite != this.isWhite) {
                moves.push(
                    {
                        newRow: this.currentRow - 1,
                        newColumn: this.currentCol + 1,
                        piece: this
                    }
                )
            }
        }
        //  console.log("Pawn", moves)
        return moves;
    }

}