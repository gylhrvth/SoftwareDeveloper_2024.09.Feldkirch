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