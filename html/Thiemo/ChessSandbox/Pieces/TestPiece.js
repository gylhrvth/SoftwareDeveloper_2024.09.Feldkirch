export { King };

class King {
    constructor(isWhite) {
        this.__type = 'King';
        this.hasMoved = false;
        this.currentRow = null;
        this.currentCol = null;
        this.isWhite = isWhite;
        this.label = isWhite ? "♔" : "♚";
    }

    restoreData(value) {
        this.currentRow = value.currentRow;
        this.currentCol = value.currentCol;
        this.hasMoved = value.hasMoved;
        this.isWhite = value.isWhite;
        this.label = value.isWhite ? "♔" : "♚";
    }

    testOutOfBounds(row, col) {
        return row < 0 || row > 7 || col < 0 || col > 7;
    }

    canCastle(chess) {
        if (this.hasMoved) return false;
        return this.canCastleLeft(chess) || this.canCastleRight(chess);
    }

    canCastleLeft(chess) {
        const rookColumn = 0;
        const rookRow = this.isWhite ? 7 : 0;
        if (this.currentRow !== rookRow || this.currentCol !== 4) return false;
        
        const rook = chess.boardArray[rookRow][rookColumn];
        if (!rook || rook.__type !== 'Rook' || rook.hasMoved) return false;
        
        for (let col = rookColumn + 1; col < 4; col++) {
            if (chess.boardArray[rookRow][col]) return false;
        }
        return true;
    }

    canCastleRight(chess) {
        const rookColumn = 7;
        const rookRow = this.isWhite ? 7 : 0;
        if (this.currentRow !== rookRow || this.currentCol !== 4) return false;
        
        const rook = chess.boardArray[rookRow][rookColumn];
        if (!rook || rook.__type !== 'Rook' || rook.hasMoved) return false;
        
        for (let col = 5; col < rookColumn; col++) {
            if (chess.boardArray[rookRow][col]) return false;
        }
        return true;
    }

    getPossibleMoves(chess) {
        const moves = [];
        const directions = [
            [-1, 0], [1, 0], [0, -1], [0, 1],
            [-1, -1], [-1, 1], [1, -1], [1, 1]
        ];

        for (const [dRow, dCol] of directions) {
            const newRow = this.currentRow + dRow;
            const newCol = this.currentCol + dCol;

            if (!this.testOutOfBounds(newRow, newCol)) {
                const targetPiece = chess.getChessPiece(newRow, newCol);
                if (!targetPiece || targetPiece.isWhite !== this.isWhite) {
                    moves.push({ newRow, newColumn: newCol, piece: this });
                }
            }
        }

        if (this.canCastle(chess)) {
            if (this.canCastleLeft(chess)) {
                moves.push({ piece: this, newRow: this.currentRow, newColumn: 2, castling: 'left' });
            }
            if (this.canCastleRight(chess)) {
                moves.push({ piece: this, newRow: this.currentRow, newColumn: 6, castling: 'right' });
            }
        }
        return moves;
    }
}
