export { Pawn };

class Pawn {
    constructor(isWhite) {
        this.__type = 'Pawn';
        this.currentRow = null;
        this.currentCol = null;
        this.isWhite = isWhite;
        this.label = isWhite ? "♙" : "♟";
    }

    restoreData(value) {
        this.currentRow = value.currentRow;
        this.currentCol = value.currentCol;
        this.isWhite = value.isWhite;
        this.label = value.isWhite ? "♙" : "♟";
    }

    addPossibleMoveEnPassant(chess, moves) {
        const direction = this.isWhite ? -1 : 1;
        const rowLimit = this.isWhite ? 3 : 4;

        if (this.currentRow === rowLimit) {
            const lastMove = chess.history[chess.history.length - 1];

            if (lastMove && lastMove.move && lastMove.move.piece === "Pawn" && Math.abs(lastMove.move.toRow - lastMove.move.fromRow) === 2 &&
                this.isAdjacentToOpponent(lastMove)) {
                moves.push({
                    newRow: this.currentRow + direction,
                    newColumn: this.currentCol + (lastMove.move.toCol - this.currentCol),
                    piece: this,
                    enPassant: true
                });
            }
        }
    }

    isAdjacentToOpponent(lastMove) {
        return (this.currentCol === lastMove.move.toCol - 1 || this.currentCol === lastMove.move.toCol + 1) && 
            lastMove.move.toRow === this.currentRow;
    }

    getPossibleMoves(chess) {
        let moves = [];
        const direction = this.isWhite ? -1 : 1;

        this.addPossibleMoveEnPassant(chess, moves);
        this.addMoveIfEmpty(chess, moves, direction); // Move forward
        if (this.currentRow === (this.isWhite ? 6 : 1)) {
            this.addMoveIfEmpty(chess, moves, direction * 2); // Double move at the start
        }
        this.addAttackMoves(chess, moves, direction); // Attack moves

        return moves;
    }

    addMoveIfEmpty(chess, moves, rowChange) {
        if (chess.getChessPiece(this.currentRow + rowChange, this.currentCol) === undefined) {
            moves.push({
                newRow: this.currentRow + rowChange,
                newColumn: this.currentCol,
                piece: this
            });
        }
    }

    addAttackMoves(chess, moves, direction) {
        const attackDirs = [-1, 1];
        attackDirs.forEach(colChange => {
            if (this.currentCol + colChange >= 0 && this.currentCol + colChange <= 7) {
                const targetPiece = chess.getChessPiece(this.currentRow + direction, this.currentCol + colChange);
                if (targetPiece && targetPiece.isWhite !== this.isWhite) {
                    moves.push({
                        newRow: this.currentRow + direction,
                        newColumn: this.currentCol + colChange,
                        piece: this
                    });
                }
            }
        });
    }
}
