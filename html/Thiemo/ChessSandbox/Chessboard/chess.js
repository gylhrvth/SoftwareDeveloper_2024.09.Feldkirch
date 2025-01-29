import { minmax } from "../minmaxalphabeta.js";
import { Pawn } from "../Pieces/Pawn.js";
import { Knight } from "../Pieces/Knight.js";
import { Bishop } from "../Pieces/Bishop.js";
import { Rook } from "../Pieces/Rook.js";
import { Queen } from "../Pieces/Queen.js"
import { King } from "../Pieces/King.js"

// The next time you use code I suggest, 
// pause and ask yourself: “What does each line do? 
// Why is it written this way?” 
// Break it apart and test your understanding.
// That process turns "copying" into learning.

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
        this.isBlackHuman = true;
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
    }

    initGameField() {
/*
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
        this.addNewChessPiece(0, 3, new Queen(false))
        this.addNewChessPiece(7, 3, new Queen(true))
        this.addNewChessPiece(0, 4, new King(false))
        this.addNewChessPiece(7, 4, new King(true))
        this.addNewChessPiece(0, 0, new Rook(false))
        this.addNewChessPiece(0, 7, new Rook(false))
        this.addNewChessPiece(7, 0, new Rook(true))
        this.addNewChessPiece(7, 7, new Rook(true))*/

            this.addNewChessPiece(0, 4, new King(false))
            this.addNewChessPiece(7, 4, new King(true))
            this.addNewChessPiece(3, 4, new Rook(false))
            this.addNewChessPiece(0, 7, new Rook(false))
            this.addNewChessPiece(7, 0, new Rook(true))
            this.addNewChessPiece(7, 7, new Rook(true))
            this.addNewChessPiece(0, 0, new Rook(false))
            this.addNewChessPiece(3, 2, new Rook(false))
            this.addNewChessPiece(6, 1, new Rook(true))
            this.addNewChessPiece(5, 4, new Rook(true)) 
    }

    addNewChessPiece(row, column, piece) {
        this.boardArray[row][column] = piece;
        piece.currentRow = row;
        piece.currentCol = column;
    }

    moveChessPiece(piece, newRow, newColumn, enPassant, castling) {

        this.saveGameField(piece, newRow, newColumn);
        this.boardArray[newRow][newColumn] = this.boardArray[piece.currentRow][piece.currentCol];
        this.boardArray[piece.currentRow][piece.currentCol] = undefined;
        this.boardArray[newRow][newColumn].currentRow = newRow;
        this.boardArray[newRow][newColumn].currentCol = newColumn;

        // Handle en passant
        if (enPassant) {
            console.log("moveChessPiece: En passant");

            // Correctly calculate the opponent's original row
            const opponentPawnRow = piece.isWhite ? newRow + 1 : newRow - 1;

            // Debug: Print the current row and the row where the opponent's pawn should be removed
            console.log(`En Passant - Piece: ${piece.label} | Current Row: ${piece.currentRow} | Opponent's Pawn Row: ${opponentPawnRow}`);

            // Remove the opponent's pawn from the correct position
            this.boardArray[opponentPawnRow][newColumn] = undefined;
            console.log("Opponent's pawn removed at: ", opponentPawnRow, newColumn);
        }


        //  console.log(castling)
        if (castling) {
            //console.log("moveChessPiece: Castling");

            let rookOldCol, rookNewCol;
            if (newColumn === 6) { // Kingside castling
                rookOldCol = 7;
                rookNewCol = 5;
            } else if (newColumn === 2) { // Queenside castling
                rookOldCol = 0;
                rookNewCol = 3;
            }

            // Ensure the rook exists at the correct position before attempting castling
            let rook = this.boardArray[newRow][rookOldCol];
            if (!rook) {
                //    console.error("Rook not found for castling at column ", rookOldCol);
                return;
            }

            // Move the rook to its new position
            this.boardArray[newRow][rookNewCol] = rook;
            this.boardArray[newRow][rookOldCol] = undefined;

            // Update the rook's position
            rook.currentRow = newRow;
            rook.currentCol = rookNewCol;

            //console.log(`Rook moved from column ${rookOldCol} to column ${rookNewCol}`);
        }
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
        console.log(" ")
        console.log(this.isWhiteTurn ? "White's Turn \n": "Black's Turn \n");
        
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

                const piece = structuredClone(this.boardArray[row][col]);
                if (piece) {
                    piece.__proto__ = Object.getPrototypeOf(this.boardArray[row][col])
                }

                // If a piece of the current turn's color is clicked
                if ((this.isWhiteTurn && this.isWhiteHuman) || (!this.isWhiteTurn && this.isBlackHuman)) {
                    if (piece && piece.isWhite === this.isWhiteTurn) {
                        selectedPiece = piece;

                        // Highlight possible moves
                        document.querySelectorAll('.highlightSquare').forEach(sq => {
                            sq.classList.remove('highlightSquare');
                        });

                        let possibleMoves = piece.getPossibleMoves(this);
                        // filter nach check
                        possibleMoves = this.filterMovesForCheck(possibleMoves)
                        possibleMoves.forEach(move => {
                            const targetSquare = chessBoard.children[move.newRow * 8 + move.newColumn];
                            targetSquare.classList.add('highlightSquare');
                            if (move.enPassant && move.enPassant === true) {
                                targetSquare.setAttribute('enPassant', move.enPassant);
                            }
                            if (move.castling) {
                                targetSquare.setAttribute('castling', move.castling);
                            }
                        });

                        console.log(`Selected piece: ${piece.label}${piece.__type} at ${String.fromCharCode(65 + col)}${8 - row}`, possibleMoves);
                    }

                    // If a highlighted square is clicked
                    else if (selectedPiece && square.classList.contains('highlightSquare')) {
                        const targetRow = Math.floor(i / 8);
                        const targetCol = i % 8;

                        const oldPositionRow = selectedPiece.currentRow;
                        const oldPositionCol = selectedPiece.currentCol;

                        // Get the state of the target square before the move
                        const targetSquare = this.boardArray[targetRow][targetCol];
                        let enPassant = false;
                        if (square.getAttribute('enPassant') === 'true') {
                            enPassant = true
                        }
                        if (enPassant) {
                            console.log("En passant?: ", enPassant)
                        }

                        let castling = false;
                        if (square.getAttribute('castling') !== undefined) {
                            castling = square.getAttribute('castling')
                        }
                        
                        // Move the piece
                        this.moveChessPiece(selectedPiece, targetRow, targetCol, enPassant, castling);

                        let isOpponentInCheck = this.isKingInCheck(!this.isWhiteTurn);
                        // Black just moved, so check if white is in check
                        console.log(this.isWhiteTurn ? "BLACK" : "WHITE", "in check?", isOpponentInCheck);

                        console.log("Before move:", selectedPiece.__type, selectedPiece.hasMoved);
                        if (selectedPiece.__type === 'King' || selectedPiece.__type === 'Rook') {
                            selectedPiece.hasMoved = true;
                        }
                        console.log("After move:", selectedPiece.__type, selectedPiece.hasMoved);

                        // Switch turns
                        this.isWhiteTurn = !this.isWhiteTurn;

                        // Re-render the board
                        this.printGameField();
                        console.log("History ", this.history)

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
        /*
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
                console.log("white turn?", this.isWhiteTurn)
         */
        // Remove highlights and clear selection when clicking outside the chessboard
        document.addEventListener('click', (event) => {
            if (!chessBoard.contains(event.target)) {
                document.querySelectorAll('.highlightSquare').forEach(sq => {
                    sq.classList.remove('highlightSquare');
                    //     sq.removeAttribute('enPassant');
                    //     sq.removeAttribute('castling');
                });
                selectedPiece = null;
            }
        });
        
    }

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

    getAllPossibleMoves(isWhite, filteredMoves) {
        let allPossibleMoves = [];
        for (let row = 0; row < this.boardArray.length; row++) {
            for (let column = 0; column < this.boardArray[row].length; column++) {
                if (this.boardArray[row][column] != undefined && this.boardArray[row][column].isWhite == isWhite) {

                    // console.log(`Inspecting piece at row ${row}, column ${column}`);

                    let possibleMovesOfPiece = this.boardArray[row][column].getPossibleMoves(chess)
                    if (filteredMoves) {
                        possibleMovesOfPiece = this.filterMovesForCheck(possibleMovesOfPiece)
                    }
                    // TODO: use the same filter as in human move
                    // console.log(`Possible moves for piece at row ${row}, column ${column}:`, possibleMovesOfPiece);

                    possibleMovesOfPiece.forEach(move => {
                        allPossibleMoves.push(move)
                    });
                }
            }
        }
        //console.log("All Moves: ", allPossibleMoves)
        return allPossibleMoves;
    }

    filterMovesForCheck(moves) {
        // console.log('filterMovesForCheck', moves)
        let filteredMoves = [];
        moves = structuredClone(moves)

        for (let move of moves) {
            if (move.castling === undefined || !this.isKingInCheck(move.piece.isWhite)) {
                let testCol = 0
                let kingHasAttackedOnGoThrough = false
                if (move.castling === 'left') {
                    testCol = move.piece.currentCol - 1
                } else if (move.castling === 'right') {
                    testCol = move.piece.currentCol + 1
                }
                if (testCol != 0) {
                    this.moveChessPiece(move.piece, move.newRow, testCol, undefined, undefined);
                    kingHasAttackedOnGoThrough = this.isKingInCheck(move.piece.isWhite)
                    this.undoGameField()
                }

                this.moveChessPiece(move.piece, move.newRow, move.newColumn, move.enPassant, move.castling);
                if (!kingHasAttackedOnGoThrough && !this.isKingInCheck(move.piece.isWhite)) {
                    filteredMoves.push(move);
                }
                this.undoGameField()
            }
        }
        // console.log('filterMovesForCheck RESULT', filteredMoves)
        return filteredMoves;
    }

    isKingInCheck(isWhite) {
        // console.log("Is King in Check");

        let kingPosition = this.findKingPosition(isWhite);
        if (!kingPosition) {
            //    console.error("King not found");
            return false;
        }

        let opponentMoves = this.getAllPossibleMoves(!isWhite, false);
        for (let move of opponentMoves) {
            if (move.newRow === kingPosition.row && move.newColumn === kingPosition.column) {
                return true;
            }
        }
        return false;
    }

    findKingPosition(isWhite) {
        //  console.log("Find King Position");
        for (let row = 0; row < this.boardArray.length; row++) {
            for (let column = 0; column < this.boardArray[row].length; column++) {
                let piece = this.boardArray[row][column];
                if (piece && piece.__type === 'King' && piece.isWhite === isWhite) {
                    return { row: row, column: column };
                }
            }
        }
        return null;
    }

    printMove(player, move, oldPositionCol, oldPositionRow, targetSquare) {
        if (targetSquare == undefined) {
            console.log(player, "MOVE", move.piece.label, move.piece.__type, "from",
                String.fromCharCode(65 + oldPositionCol) + (8 - oldPositionRow), "to",
                String.fromCharCode(65 + move.newColumn) + (8 - move.newRow));
        } else {
            console.log(player, "HIT", move.piece.label, move.piece.__type, "from",
                String.fromCharCode(65 + oldPositionCol) + (8 - oldPositionRow), "to",
                String.fromCharCode(65 + move.newColumn) + (8 - move.newRow));
        }
    }

    tryToMoveAI() {
        if (!this.computerIsThinking) {
            if ((this.isWhiteTurn && !this.isWhiteHuman) || (!this.isWhiteTurn && !this.isBlackHuman)) {
                console.log('Try to move AI')
                this.computerIsThinking = true;
                /*
                                // Collect all possible moves for the AI
                                const possibleMovesByPiece = [];
                                this.boardArray.forEach((row) => {
                                    row.forEach((piece) => {
                                        if (piece && piece.isWhite === this.isWhiteTurn) {
                                            const possibleMoves = piece.getPossibleMoves(this);
                                            if (possibleMoves.length > 0) {
                                                possibleMovesByPiece.push({
                                                    pieceType: piece.__type,
                                                    position: { row: piece.currentRow, col: piece.currentCol },
                                                    moves: possibleMoves.map((move) => ({ row: move.newRow, col: move.newColumn })),
                                                });
                                            }
                                        }
                                    });
                                });
                
                                // Log the structured array of possible moves
                                console.log("AI's Possible Moves by Piece:", possibleMovesByPiece);
                */
                let minmaxresult = minmax(this, 4, this.isWhiteTurn, -Infinity, Infinity)
                let bestMove = minmaxresult.move
                let enPassant = false
                if (bestMove.enPassant && bestMove.enPassant === true) {
                    enPassant = true
                }
                let castling = false;
                if (bestMove.castling && bestMove.castling === true) {
                    castling = true
                }

                let oldPositionRow = bestMove.piece.currentRow
                let oldPositionCol = bestMove.piece.currentCol
                this.printMove(this.isWhiteTurn ? "White" : "Black", bestMove, oldPositionCol, oldPositionRow)

                this.moveChessPiece(bestMove.piece, bestMove.newRow, bestMove.newColumn, enPassant, castling);

                let isOpponentInCheck = this.isKingInCheck(!this.isWhiteTurn);
                // Black just moved, so check if white is in check
                console.log("isWhiteinCheck? ", isOpponentInCheck);

                if (bestMove.__type === 'King' || bestMove.__type === 'Rook') {
                    bestMove.hasMoved = true;
                }

                // Switch turns
                this.isWhiteTurn = !this.isWhiteTurn;
                this.printGameField()
                this.computerIsThinking = false

                //  console.log("History ", this.history)
            }
        }
    }
}

let chess = new ChessGame()
chess.initGameField()
chess.printGameField()

setInterval(() => chess.tryToMoveAI(), 1000)