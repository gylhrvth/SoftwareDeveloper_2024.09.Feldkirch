export { Queen };

class Queen {
    constructor(isWhite) {
        this.__type = 'Queen';
        this.score = 9;
        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        this.label = isWhite ? "♕" : "♛";
    }
/*
     restoreData(value) {
        this.score = value.score
         this.currentRow = value.currentRow
         this.currentCol = value.currentCol
         this.isWhite = value.isWhite
         this.label = isWhite ? "♕" : "♛";
     }
*/

    testOutOfBounds(row, col) {
        return row < 0 || row > 7 || col < 0 || col > 7;
    }

    getPossibleMoves(chess) {
        let moves = []
        const directions = [
            { row: 1, col: 0 },   // Down
            { row: -1, col: 0 },  // Up
            { row: 0, col: 1 },   // Right
            { row: 0, col: -1 },  // Left
            { row: 1, col: 1 },   // Down Right
            { row: 1, col: -1 },  // Down Left
            { row: -1, col: 1 },  // Up Right
            { row: -1, col: -1 }  // Up Left
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
}