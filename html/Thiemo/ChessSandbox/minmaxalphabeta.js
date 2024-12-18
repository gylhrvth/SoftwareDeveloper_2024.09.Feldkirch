

export function minmax(chessOriginal, depth, isWhite, alpha, beta){
    if(depth == 0){
        return {score: chessOriginal.calculateScore(), move: null};
    }
    let chess = chessOriginal.cloneChessGame();
    const moves = JSON.parse(JSON.stringify(chess.getAllPossibleMoves(isWhite)));
    if (moves.length == 0){
        return {score: chess.calculateScore(), move: null};
    }
    if (depth == 10){
        console.log("Possible Moves: ", moves);
    }
    let bestMove = null;
    if(isWhite){
        let maxEval = -Infinity;
        for(let move of moves){
            chess.moveChessPiece(move.piece, move.newRow, move.newColumn);
            let evalResult = minmax(chess, depth-1, !isWhite, alpha, beta);
            chess.undoGameField();
            if(evalResult.score > maxEval){
                maxEval = evalResult.score;
                bestMove = structuredClone(move);
            }
            alpha = Math.max(alpha, evalResult.score);
            if(beta <= alpha){
                break;
            }
        }
        return {score: maxEval, move: bestMove};
    }else{
        let minEval = Infinity;
        for(let move of moves){
            let originalMove = structuredClone(move)
            chess.moveChessPiece(move.piece, move.newRow, move.newColumn);
            let evalResult = minmax(chess, depth-1, !isWhite, alpha, beta);
            chess.undoGameField();
            move = structuredClone(originalMove);
            if(evalResult.score < minEval){
                minEval = evalResult.score;
                bestMove = structuredClone(move);
            }
            beta = Math.min(beta, evalResult.score);
            if(beta <= alpha){
                break;
            }
        }
        return {score: minEval, move: bestMove};
    }
}