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

        // Black pieces
        if (!this.isWhite) {
            if (this.currentRow < 7 && chess.getChessPiece(this.currentRow + 1, this.currentCol) == undefined) {
                moves.push(
                    {
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol,
                        piece: this
                    }
                )
            }
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