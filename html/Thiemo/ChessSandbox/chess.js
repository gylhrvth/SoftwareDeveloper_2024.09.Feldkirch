// Pieces


class Pawn {    //Pawn with (constructor, getPossibleMoves)
    constructor(isWhite) {

        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = "♙";
        } else {
            this.label = "♟"
        }

    }

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
            if (this.currentCol > 0 && this.currentRow < 7 && chess.getChessPiece(this.currentRow + 1, this.currentCol - 1) != undefined && chess.getChessPiece(this.currentRow + 1, this.currentCol - 1).isWhite != this.isWhite) {
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
            if (this.currentCol < 7 && this.currentRow < 7 && chess.getChessPiece(this.currentRow + 1, this.currentCol + 1) != undefined && chess.getChessPiece(this.currentRow + 1, this.currentCol + 1).isWhite != this.isWhite) {
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
            if (this.currentCol > 0 && this.currentRow > 0 && chess.getChessPiece(this.currentRow - 1, this.currentCol - 1) != undefined && chess.getChessPiece(this.currentRow - 1, this.currentCol - 1).isWhite != this.isWhite) {
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
            if (this.currentCol < 8 && this.currentRow > 0 && chess.getChessPiece(this.currentRow - 1, this.currentCol + 1) != undefined && chess.getChessPiece(this.currentRow - 1, this.currentCol + 1).isWhite != this.isWhite) {
                moves.push(
                    {
                        newRow: this.currentRow - 1,
                        newColumn: this.currentCol + 1,
                        piece: this
                    }
                )
            }
        }
        return moves;
    }

}

// chessboard with (initGameField, addNewChessPiece, moveChessPiece, getChessPiece, printGameField, getAllPossibleMoves)
class ChessGame {
    constructor() {
        // Define an 8x8 empty chessboard array
        this.boardArray = [
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
        ];
    }

    initGameField() {
        for (let column = 0; column < this.boardArray[0].length; ++column) {
            this.addNewChessPiece(1, column, new Pawn(false))
            this.addNewChessPiece(6, column, new Pawn(true))
        }
    }

    addNewChessPiece(row, column, piece) {
        this.boardArray[row][column] = piece;
        piece.currentRow = row;
        piece.currentCol = column;
    }

    moveChessPiece(piece, newRow, newColumn) {
        this.boardArray[piece.currentRow][piece.currentCol] = undefined
        this.boardArray[newRow][newColumn] = piece;
        piece.currentRow = newRow;
        piece.currentCol = newColumn;
    }

    getChessPiece(row, column) {
        return this.boardArray[row][column]
    }

    printGameField() {
        for (let i = 0; i < this.boardArray.length; ++i) {
            let line = " "
            for (let j = 0; j < this.boardArray[i].length; ++j) {
                if (this.boardArray[i][j] == undefined) {
                    line += ". "
                } else {
                    line += this.boardArray[i][j].label
                }
            }
            console.log(line)
        }
    }

    // TODO : Calculae score for every eaten Piece(pawn +1, (knight +3,bishop +3, rook +5, queen +9, king +100)) 
    calculateScore() {
        let score = 0.0
        for (let row = 0; row < this.boardArray.length; row++) {
            for (let column = 0; column < this.boardArray[row].length; column++) {
                if (this.boardArray[row][column] != undefined){
                    if (this.boardArray[row][column].isWhite == true) {
                        score += 1.0
                    } else {
                        score -= 1.0
                    }
                }
                               
            }
        }          
          console.log("Score is " + score)
    }

    // possible moves white
    // TODO 005: Add new Function for getAllPossibleMoves(isWhite) to collect all moves possible for player X.
    getAllPossibleMoves(isWhite) {
        // TODO 005/a: Create a variable allPossibleMoves as an empty array
        let allPossibleMoves = [];
        // TODO 005/b: Go through all rows and columns.
        for (let row = 0; row < this.boardArray.length; row++) {
            for (let column = 0; column < this.boardArray[row].length; column++) {
                // TODO 005/c: If position not empty and piece on position is acording "isWhite"
                if (this.boardArray[row][column] != undefined && this.boardArray[row][column].isWhite == isWhite) {

                    // console.log(`Inspecting piece at row ${row}, column ${column}`);

                    // TODO 005/d: Get possible moves from the single piece
                    let possibleMovesOfPiece = this.boardArray[row][column].getPossibleMoves(chess)

                    // console.log(`Possible moves for piece at row ${row}, column ${column}:`, possibleMovesOfPiece);

                    // TODO 005/e: Push possible moves into allPossibleMoves
                    possibleMovesOfPiece.forEach(move => {
                        allPossibleMoves.push(move)
                    });
                }
            }
        }
        console.log("All Moves: ", allPossibleMoves)

        // TODO 005/f: return allPossibleMoves
        return allPossibleMoves;
    }
}




let chess = new ChessGame()
chess.initGameField()
chess.printGameField()

let allMoves = chess.getAllPossibleMoves(true)
let allMovesBlack = allMoves
let stepLeft = 100
let moves = 0

while (allMoves.length > 0 && allMovesBlack.length > 0 && stepLeft > 0) {
    // Teil WEISS
    let randomIndex = Math.floor(Math.random() * allMoves.length);
    let randomMove = allMoves[randomIndex];
    //console.log(randomMove, randomIndex);

    chess.moveChessPiece(randomMove.piece, randomMove.newRow, randomMove.newColumn);
    chess.printGameField()
    //    console.log(chess)

    // Teil SCHWARZ
    allMovesBlack = chess.getAllPossibleMoves(false)
    if (allMovesBlack.length > 0) {
        randomIndex = Math.floor(Math.random() * allMovesBlack.length);
        randomMove = allMovesBlack[randomIndex];
        chess.moveChessPiece(randomMove.piece, randomMove.newRow, randomMove.newColumn);
        chess.printGameField()


        // Vorbereitung WEISS
        allMoves = chess.getAllPossibleMoves(true)

    }
    chess.calculateScore()
    --stepLeft
    moves++
    console.log("Moves done",moves)
}


console.log("Game over")

