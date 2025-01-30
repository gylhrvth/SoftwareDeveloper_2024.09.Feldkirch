export { Bishop };

class Bishop {
    constructor(isWhite) {
        this.__type = 'Bishop';
        this.score = 3;
        this.currentRow = null;
        this.currentCol = null;
        this.isWhite = isWhite;
        this.label = isWhite ? '♗' : '♝';
    }

    /*
    restoreData(value) {
        this.currentRow = value.currentRow;
        this.currentCol = value.currentCol;
        this.isWhite = value.isWhite;
        this.label = value.isWhite ? '♗' : '♝';
    }
        */

    getPossibleMoves(chess) {
        const moves = [];
        const directions = [
            { row: 1, col: 1 },
            { row: 1, col: -1 },
            { row: -1, col: 1 },
            { row: -1, col: -1 }
        ];

        directions.forEach(direction => {
            let distance = 1;
            while (true) {
                const newRow = this.currentRow + direction.row * distance;
                const newCol = this.currentCol + direction.col * distance;

                if (this.testOutOfBounds(newRow, newCol)) break;

                const piece = chess.getChessPiece(newRow, newCol);
                if (!piece || piece.isWhite !== this.isWhite) {
                    moves.push({ newRow, newColumn: newCol, piece: this });
                }

                if (piece) break;  // Stop if an opponent's piece is encountered
                distance++;
            }
        });

        return moves;
    }

    testOutOfBounds(row, col) {
        return row < 0 || row > 7 || col < 0 || col > 7;
    }
}
