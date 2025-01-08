import { minmax } from "../minmaxalphabeta.js";
import { Pawn } from "../Pieces/Pawn.js";
import { Knight } from "../Pieces/Knight.js";
import { Bishop } from "../Pieces/Bishop.js";
import { Rook } from "../Pieces/Rook.js";

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

            // Pawn 
            if (typeof (value) === 'object' && value != undefined && value.__type === 'Pawn') {
                let p = new Pawn(value.isWhite)
                p.restoreData(value)
                return p
            }

            //Knight
            if (typeof (value) === 'object' && value != undefined && value.__type === 'Knight') {
                let k = new Knight(value.isWhite)
                k.restoreData(value)
                return k
            }

            //Bishop
            if (typeof (value) === 'object' && value != undefined && value.__type === 'Bishop') {
                let b = new Bishop(value.isWhite)
                b.restoreData(value)
                return b
            }

            //Rook
            if (typeof (value) === 'object' && value != undefined && value.__type === 'Rook') {
                let r = new Rook(value.isWhite)
                r.restoreData(value)
                return r
            }

            // Chessboard
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
        }
        this.addNewChessPiece(0, 1, new Knight(false))
        this.addNewChessPiece(0, 6, new Knight(false))
        this.addNewChessPiece(7, 1, new Knight(true))
        this.addNewChessPiece(7, 6, new Knight(true)) 
        this.addNewChessPiece(0, 2, new Bishop(false))
        this.addNewChessPiece(0, 5, new Bishop(false))
        this.addNewChessPiece(7, 2, new Bishop(true))
        this.addNewChessPiece(7, 5, new Bishop(true)) 
        this.addNewChessPiece(0, 0, new Rook(false))
        this.addNewChessPiece(0, 7, new Rook(false))
        this.addNewChessPiece(7, 0, new Rook(true))
        this.addNewChessPiece(7, 7, new Rook(true))

 /*       this.addNewChessPiece(1, 2, new Rook(false))
        this.addNewChessPiece(6, 5, new Rook(false))
        this.addNewChessPiece(6, 3, new Rook(true))
        this.addNewChessPiece(5, 4, new Rook(true)) */
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
                //Pawn
                if (typeof (value) === 'object' && value != undefined && value.__type === 'Pawn') {
                    let p = new Pawn(value.isWhite)
                    p.restoreData(value)
                    return p
                }
                //Knight
                if (typeof (value) === 'object' && value != undefined && value.__type === 'Knight') {
                    let k = new Knight(value.isWhite)
                    k.restoreData(value)
                    return k
                }
                //Bishop
                if (typeof (value) === 'object' && value != undefined && value.__type === 'Bishop') {
                    let b = new Bishop(value.isWhite)
                    b.restoreData(value)
                    return b
                }

                if (typeof (value) === 'object' && value != undefined && value.__type === 'Rookp') {
                    let r = new Rook(value.isWhite)
                    r.restoreData(value)
                    return r
                }
                return value;
            }
            

            )
            //console.log("Undo: ", this.boardArray)
        } else {
            console.log("No more history")
        }
    }

    getChessPiece(row, column) {
        if (row < 0 || row > 7 || column < 0 || column > 7) {
            console.error("Out of bounds", row, column)
            return undefined
        }
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

                    if (this.boardArray[row][column].__type == 'Pawn') {
                        if (this.boardArray[row][column].isWhite == true) {
                            score += 1.0
                        } else {
                            score -= 1.0
                        }
                    }
                    if (this.boardArray[row][column].__type == 'Knight' || this.boardArray[row][column].__type == 'Bishop') {
                        if (this.boardArray[row][column].isWhite == true) {
                            score += 3.0
                        } else {
                            score -= 3.0
                        }
                    }
                    if (this.boardArray[row][column].__type == 'Rook') {
                        if (this.boardArray[row][column].isWhite == true) {
                            score += 5.0
                        } else {
                            score -= 5.0
                        }
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

    printMove(player, move, oldPositionCol, oldPositionRow) {
        if (this.getChessPiece(move.newRow, move.newColumn) == undefined) {
            console.log(player, "MOVE", move.piece.__type, "from", String.fromCharCode(65 + oldPositionCol) + (8 - oldPositionRow), "to", String.fromCharCode(65 + move.newColumn) + (8 - move.newRow))
        } else {
            console.log(player, "HIT ", move.piece.__type, "from", String.fromCharCode(65 + oldPositionCol) + (8 - oldPositionRow), "to", String.fromCharCode(65 + move.newColumn) + (8 - move.newRow))
        }
    }
}




let chess = new ChessGame()
chess.initGameField()
chess.printGameField()

let allMoves = chess.getAllPossibleMoves(true)
// let allMovesBlack = ["no empty"]
let allMovesBlack = allMoves
let stepLeft = 10
let movesDone = 0
let randomIndex
let randomMove
let minmaxresult
let oldPositionRow
let oldPositionCol

while (allMoves.length > 0 && allMovesBlack.length > 0 && stepLeft > 0) {
    // Teil WEISS
    randomIndex = Math.floor(Math.random() * allMoves.length);
    randomMove = allMoves[randomIndex];
    //console.log(randomMove, randomIndex);

    //   minmaxresult = minmax(chess, 4, true, -Infinity, Infinity)
    //    randomMove = minmaxresult.move
    //console.log("MinMaxResult: ", minmaxresult)

    oldPositionRow = randomMove.piece.currentRow
    oldPositionCol = randomMove.piece.currentCol
    console.log("White", allMoves)
    chess.printMove("White", randomMove, oldPositionCol, oldPositionRow)

    chess.moveChessPiece(randomMove.piece, randomMove.newRow, randomMove.newColumn);

    chess.printGameField()
 //   chess.printMove("White", randomMove, oldPositionCol, oldPositionRow)
    console.log("Score is ", chess.calculateScore())


    //console.log(chess)

    // Teil SCHWARZ
    allMovesBlack = chess.getAllPossibleMoves(false)
    if (allMovesBlack.length > 0) {
        //   randomIndex = Math.floor(Math.random() * allMovesBlack.length);
        //   randomMove = allMovesBlack[randomIndex];

        minmaxresult = minmax(chess, 4, false, -Infinity, Infinity)
        console.log("MinMaxResult: ", minmaxresult)
        randomMove = minmaxresult.move
        oldPositionRow = randomMove.piece.currentRow
        oldPositionCol = randomMove.piece.currentCol
        console.log("Black", allMovesBlack)
        chess.printMove("Black", randomMove, oldPositionCol, oldPositionRow)

        chess.moveChessPiece(randomMove.piece, randomMove.newRow, randomMove.newColumn);

        chess.printGameField()
 //       chess.printMove("Black", randomMove, oldPositionCol, oldPositionRow)
        // Vorbereitung WEISS
        allMoves = chess.getAllPossibleMoves(true)
        console.log("Score is ", chess.calculateScore())

    }
    --stepLeft
    movesDone++
    console.log("Moves done", movesDone)

}

chess.printGameField()
console.log("Game over")

