import { minmax } from "../minmaxalphabeta.js";
import { Pawn } from "../Pieces/Pawn.js";
import { Knight } from "../Pieces/Knight.js";
import { Bishop } from "../Pieces/Bishop.js";
import { Rook } from "../Pieces/Rook.js";
import { Queen } from "../Pieces/Queen.js"
import { King } from "../Pieces/King.js"


// chessboard with (restoreData, cloneChessGame, initGameField, addNewChessPiece, moveChessPiece, saveGameField, 
//                  undoGameField getChessPiece, printGameField, calculateScore, getAllPossibleMoves)

//  TODO : Pawn == en passant + what happens if the pawn reaches the end ==> pawn ===Queen/Rook/Knight/Bishop
//  TODO : variable for the last moved pawn ???????
//  TODO : King == rochade + what happens when the King is in check ==>  FORCED MOVE or BLOCK
//  TODO : 50 Move Rule === if no pawn moved or no piece got captured in the last 50 moves(player1Move +Player2Move)



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

        this.isWhiteTurn = true;
        this.isWhiteHuman = true;
        this.isBlackHuman = false;
        this.computerIsThinking = false;
    }

    restoreData(value) {
        this.history = value.history
        this.boardArray = value.boardArray
        //console.log('Restored ChessGame', this.boardArray)
    }

    cloneChessGame() {
        let clone = structuredClone(this)
        Object.setPrototypeOf(clone, Object.getPrototypeOf(this))
        for (let i = 0; i < this.boardArray.length; i++) {
            for (let j = 0; j < this.boardArray[i].length; j++) {
                if (this.boardArray[i][j] != undefined) {
                    Object.setPrototypeOf(clone.boardArray[i][j], Object.getPrototypeOf(this.boardArray[i][j]))
                } else {
                    clone.boardArray[i][j] = undefined
                }
            }
        }
        return clone

        /*
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

            //Queen
            if (typeof (value) === 'object' && value != undefined && value.__type === 'Queen') {
                let q = new Queen(value.isWhite)
                q.restoreData(value)
                return q
            }

            if (typeof (value) === 'object' && value != undefined && value.__type === 'King') {
                let k = new King(value.isWhite)
                k.restoreData(value)
                return k
            }

            // Chessboard
            if (typeof (value) === 'object' && value != undefined && value.__type === 'ChessGame') {
                let c = new ChessGame()
                c.restoreData(value)
                return c
            }

            return value;
        })
        */
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
        this.addNewChessPiece(0, 3, new Queen(false))
        this.addNewChessPiece(7, 3, new Queen(true))
        this.addNewChessPiece(0, 4, new King(false))
        this.addNewChessPiece(7, 4, new King(true))

    }

    addNewChessPiece(row, column, piece) {
        this.boardArray[row][column] = piece;
        piece.currentRow = row;
        piece.currentCol = column;
    }

    moveChessPiece(piece, newRow, newColumn) {
        this.saveGameField(piece, newRow, newColumn)
        this.boardArray[newRow][newColumn] = this.boardArray[piece.currentRow][piece.currentCol];
        this.boardArray[piece.currentRow][piece.currentCol] = undefined
        this.boardArray[newRow][newColumn].currentRow = newRow;
        this.boardArray[newRow][newColumn].currentCol = newColumn;

        /*     if(this.boardArray[newRow][newColumn].piece.__type === 'Pawn'){
              let lastMovePawn = this.boardArray[newRow][newColumn];
             
             }
             console.log(lastMovePawn)*/
    }

    saveGameField(piece, newRow, newColumn) {
        let cloneBoard = structuredClone(this.boardArray)
        Object.setPrototypeOf(cloneBoard, Object.getPrototypeOf(this.boardArray))
        for (let i = 0; i < cloneBoard.length; i++) {
            for (let j = 0; j < cloneBoard[i].length; j++) {
                if (this.boardArray[i][j] != undefined) {
                    Object.setPrototypeOf(cloneBoard[i][j], Object.getPrototypeOf(this.boardArray[i][j]))
                } else {
                    cloneBoard[i][j] = undefined
                }
            }
        }
        this.history.push({
            board: cloneBoard,
            move: {
                piece: piece.__type,
                fromRow: piece.currentRow,
                fromColumn: piece.currentCol,
                toRow: newRow,
                toCol: newColumn
            }
        })
        console.log("History: ", this.history)
    }

    undoGameField() {
        if (this.history.length > 0) {
            this.boardArray = this.history.pop().board
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
        const chessBoard = document.getElementById('chess-board');
        chessBoard.innerText = '';

        let selectedPiece = null; // To track the selected piece

        // Loop to create 64 squares
        for (let i = 0; i < 64; i++) {
            const square = document.createElement('div');
            const figure = document.createElement('div');

            // Determine row and column
            const row = Math.floor(i / 8);
            const col = i % 8;

            // Alternating black and white squares
            if ((row + col) % 2 === 0) {
                square.classList.add('square', 'whiteSquare');
            } else {
                square.classList.add('square', 'blackSquare');
            }

            // Add rank numbers on the leftmost squares
            if (col === 0) {
                const rank = document.createElement('div');
                rank.classList.add('coordinateRank');
                rank.innerText = 8 - row;
                square.appendChild(rank);
            }

            // Add file letters on the bottom row
            if (row === 7) {
                const file = document.createElement('div');
                file.classList.add('coordinateFile');
                file.innerText = String.fromCharCode(65 + col); // A-H
                square.appendChild(file);
            }

            if (this.boardArray[row][col] != undefined) {
                figure.innerText = this.boardArray[row][col].label;
                if (this.boardArray[row][col].isWhite) {
                    figure.classList.add('whiteFigure');
                } else {
                    figure.classList.add('blackFigure');
                }
            }

            // Add event listener for each square
            square.addEventListener('click', () => {
                const piece = this.boardArray[row][col];

                // If a piece of the current turn's color is clicked
                if ((this.isWhiteTurn && this.isWhiteHuman) || (!this.isWhiteTurn && this.isBlackHuman)) {
                    if (piece && piece.isWhite === this.isWhiteTurn) {
                        selectedPiece = piece;

                        // Highlight possible moves
                        document.querySelectorAll('.highlightSquare').forEach(sq => {
                            sq.classList.remove('highlightSquare');
                        });

                        const possibleMoves = piece.getPossibleMoves(this);
                        possibleMoves.forEach(move => {
                            const targetSquare = chessBoard.children[move.newRow * 8 + move.newColumn];
                            targetSquare.classList.add('highlightSquare');
                        });

                        console.log(`Selected piece: ${piece.label} at ${String.fromCharCode(65 + col)}${8 - row}`);
                    }

                    // If a highlighted square is clicked
                    else if (selectedPiece && square.classList.contains('highlightSquare')) {
                        const targetRow = Math.floor(i / 8);
                        const targetCol = i % 8;

                        const oldPositionRow = selectedPiece.currentRow;
                        const oldPositionCol = selectedPiece.currentCol;

                        // Get the state of the target square before the move
                        const targetSquare = this.boardArray[targetRow][targetCol];

                        // Move the piece
                        this.moveChessPiece(selectedPiece, targetRow, targetCol);

                        // Switch turns
                        this.isWhiteTurn = !this.isWhiteTurn;

                        // Re-render the board
                        this.printGameField();

                        // Print the move
                        this.printMove(
                            this.isWhiteTurn ? "Black" : "White",
                            { piece: selectedPiece, newRow: targetRow, newColumn: targetCol },
                            oldPositionCol,
                            oldPositionRow,
                            targetSquare
                        );
                        console.log("Score is ", chess.calculateScore())

                    }
                }
            });

            square.appendChild(figure);
            chessBoard.appendChild(square);
        }

        // Print the board state to the console
        for (let i = 0; i < this.boardArray.length; ++i) {
            let line = " ";
            for (let j = 0; j < this.boardArray[i].length; ++j) {
                if (this.boardArray[i][j] == undefined) {
                    line += ". ";
                } else {
                    line += this.boardArray[i][j].label;
                }
            }
            console.log(line);
        }
        console.log(" ");

        // Remove highlights and clear selection when clicking outside the chessboard
        document.addEventListener('click', (event) => {
            if (!chessBoard.contains(event.target)) {
                document.querySelectorAll('.highlightSquare').forEach(sq => {
                    sq.classList.remove('highlightSquare');
                });
                selectedPiece = null;
            }
        });
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

                    if (this.boardArray[row][column].__type == 'Queen') {
                        if (this.boardArray[row][column].isWhite == true) {
                            score += 9.0
                        } else {
                            score -= 9.0
                        }
                    }

                    if (this.boardArray[row][column].__type == 'King') {
                        if (this.boardArray[row][column].isWhite == true) {
                            score += 99.0
                        } else {
                            score -= 99.0
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

    printMove(player, move, oldPositionCol, oldPositionRow, targetSquare) {
        if (targetSquare == undefined) {
            console.log(player, "MOVE", move.piece.__type, "from",
                String.fromCharCode(65 + oldPositionCol) + (8 - oldPositionRow), "to",
                String.fromCharCode(65 + move.newColumn) + (8 - move.newRow));
        } else {
            console.log(player, "HIT", move.piece.__type, "from",
                String.fromCharCode(65 + oldPositionCol) + (8 - oldPositionRow), "to",
                String.fromCharCode(65 + move.newColumn) + (8 - move.newRow));
        }
    }

    

    tryToMoveAI() {
        if (!this.computerIsThinking) {
            if ((this.isWhiteTurn && !this.isWhiteHuman) || (!this.isWhiteTurn && !this.isBlackHuman)) {
                console.log('Try to move AI')
                this.computerIsThinking = true;
                let minmaxresult = minmax(this, 4, this.isWhiteTurn, -Infinity, Infinity)
                let bestMove = minmaxresult.move

                let oldPositionRow = bestMove.piece.currentRow
                let oldPositionCol = bestMove.piece.currentCol
                this.printMove(this.isWhiteTurn ? "White" : "Black", bestMove, oldPositionCol, oldPositionRow)
                this.moveChessPiece(bestMove.piece, bestMove.newRow, bestMove.newColumn);

                // Switch turns
                this.isWhiteTurn = !this.isWhiteTurn;
                this.printGameField()
                this.computerIsThinking = false
            }
        }
    }

}




let chess = new ChessGame()
chess.initGameField()
chess.printGameField()


setInterval(() => chess.tryToMoveAI(), 1000)


/*
let allMoves = chess.getAllPossibleMoves(true)
// let allMovesBlack = ["no empty"]
let allMovesBlack = allMoves
let allMovesDone = [];
let stepLeft = 0
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

    //  minmaxresult = minmax(chess, 4, true, -Infinity, Infinity)
    //  randomMove = minmaxresult.move
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
        randomIndex = Math.floor(Math.random() * allMovesBlack.length);
        randomMove = allMovesBlack[randomIndex];

        //minmaxresult = minmax(chess, 4, false, -Infinity, Infinity)
        // console.log("MinMaxResult: ", minmaxresult)
        // randomMove = minmaxresult.move
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

*/