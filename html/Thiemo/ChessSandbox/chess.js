import { minmax } from "./minmaxalphabeta.js";

// Pieces


class Pawn {    //Pawn with (constructor, getPossibleMoves)
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
            if (this.currentCol < 8 && this.currentRow > 0 && 
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
        return moves;
    }

}
/*class Knight {
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
    getPossibleMoves(chess) {
        let moves = []
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

            //.....
        }

        // White Pieces
        if(this.isWhite) {
            if(this.currentRow < 7 && chess.getChessPiece(this.currentRow + 1, this.currentCol) == undefined) {
                moves.push(
                    {
                        newRow: this.currentRow + 1,
                        newColumn: this.currentCol,
                        piece: this
                    }
                )
            }

            //.....
        }
        return moves
    }
}*/


// chessboard with (restoreData, cloneChessGame, initGameField, addNewChessPiece, moveChessPiece, saveGameField, 
//                  undoGameField getChessPiece, printGameField, calculateScore, getAllPossibleMoves)
class ChessGame {
    constructor() {
        this.__type = 'ChessGame';
        this.history = []
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

    restoreData(value) {
        this.history = value.history
        this.boardArray = value.boardArray
    }

    cloneChessGame() {
        return JSON.parse(JSON.stringify(this), (key, value) => {
            if (typeof (value) === 'object' && value != undefined && value.__type === 'Pawn') {
                let p = new Pawn(value.isWhite)
                p.restoreData(value)
                return p
            }
            if (typeof (value) === 'object' && value != undefined && value.__type === 'ChessGame') {
                let c = new ChessGame()
                c.restoreData(value)
                return c
            }

            return value;
        })
    }

    initGameField() {
        for (let column = 0; column < this.boardArray[0].length; ++column) {
            this.addNewChessPiece(1, column, new Pawn(false))
            this.addNewChessPiece(6, column, new Pawn(true))
/*             this.addNewChessPiece(0,1,new Knight(false))
             this.addNewChessPiece(0,6,new Knight(false))
             this.addNewChessPiece(7,1,new Knight(true))
             this.addNewChessPiece(7,6,new Knight(true))*/
        }
    }

    addNewChessPiece(row, column, piece) {
        this.boardArray[row][column] = piece;
        piece.currentRow = row;
        piece.currentCol = column;
    }

    moveChessPiece(piece, newRow, newColumn) {
        this.saveGameField()
        this.boardArray[newRow][newColumn] = this.boardArray[piece.currentRow][piece.currentCol];
        this.boardArray[piece.currentRow][piece.currentCol] = undefined
        this.boardArray[newRow][newColumn].currentRow = newRow;
        this.boardArray[newRow][newColumn].currentCol = newColumn;
    }

    saveGameField() {
        this.history.push(JSON.stringify(this.boardArray))
        //console.log("Save: ", this.boardArray, JSON.stringify(this.boardArray))
    }

    undoGameField() {
        if (this.history.length > 0) {
            this.boardArray = JSON.parse(this.history.pop(), (key, value) => {
                if (typeof (value) === 'object' && value != undefined && value.__type === 'Pawn') {
                    let p = new Pawn(value.isWhite)
                    p.restoreData(value)
                    return p
                }
                return value;
            })
            //console.log("Undo: ", this.boardArray)
        } else {
            console.log("No more history")
        }
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
                if (this.boardArray[row][column] != undefined) {
                    if (this.boardArray[row][column].isWhite == true) {
                        score += 1.0
                    } else {
                        score -= 1.0
                    }
                }

            }
        }
        return score
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
        //console.log("All Moves: ", allPossibleMoves)

        // TODO 005/f: return allPossibleMoves
        return allPossibleMoves;
    }
}




let chess = new ChessGame()
chess.initGameField()
chess.printGameField()

let allMoves = chess.getAllPossibleMoves(true)
let allMovesBlack = ["no empty"]
let stepLeft = 100
let moves = 0

while (allMoves.length > 0 && allMovesBlack.length > 0 && stepLeft > 0) {
    // Teil WEISS
    let randomIndex = Math.floor(Math.random() * allMoves.length);
    let randomMove = allMoves[randomIndex];
    //console.log(randomMove, randomIndex);

    chess.moveChessPiece(randomMove.piece, randomMove.newRow, randomMove.newColumn);
    chess.printGameField()
    console.log("Score is " + chess.calculateScore())

    //    console.log(chess)

    // Teil SCHWARZ
    allMovesBlack = chess.getAllPossibleMoves(false)
    if (allMovesBlack.length > 0) {
        //        randomIndex = Math.floor(Math.random() * allMovesBlack.length);
        //        randomMove = allMovesBlack[randomIndex];
        let minmaxresult = minmax(chess, 5, false, -Infinity, Infinity)
        console.log("MinMaxResult: ", minmaxresult)
        randomMove = minmaxresult.move

        chess.moveChessPiece(randomMove.piece, randomMove.newRow, randomMove.newColumn);
        chess.printGameField()


        // Vorbereitung WEISS
        allMoves = chess.getAllPossibleMoves(true)

    }
    console.log("Score is " + chess.calculateScore())

    --stepLeft
    moves++
    console.log("Moves done", moves)
}


console.log("Game over")

