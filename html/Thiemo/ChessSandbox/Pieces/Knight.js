export { Knight };

class Knight {
    constructor(isWhite) {
        this.__type = 'Knight';
        this.currentRow = null;
        this.currentCol = null;
        this.isWhite = isWhite;
        this.label = isWhite ? "♘" : "♞"; // Ternary operator for label assignment
    }

    restoreData(value) {
        this.constructor(value.isWhite); // Call constructor to reset the isWhite value
        this.currentRow = value.currentRow;
        this.currentCol = value.currentCol;
    }

    testOutOfBounds(rowCount, colCount) {
        return (this.currentRow + rowCount < 0 || this.currentRow + rowCount > 7 ||
            this.currentCol + colCount < 0 || this.currentCol + colCount > 7);
    }

    checkAndAddMove(moves, rowOffset, colOffset, chess) {
        if (!this.testOutOfBounds(rowOffset, colOffset)) {
            let piece = chess.getChessPiece(this.currentRow + rowOffset, this.currentCol + colOffset);
            if (!piece || piece.isWhite !== this.isWhite) {
                moves.push({
                    newRow: this.currentRow + rowOffset,
                    newColumn: this.currentCol + colOffset,
                    piece: this
                });
            }
        }
    }

    getPossibleMoves(chess) {
        let moves = [];
        const distance = [
            { col: -1, row: -2 }, { col: 1, row: -2 }, { col: 2, row: -1 },
            { col: 2, row: 1 }, { col: 1, row: 2 }, { col: -1, row: 2 },
            { col: -2, row: 1 }, { col: -2, row: -1 }
        ];

        // Using forEach to iterate over the distance array and add valid moves
        distance.forEach(d => this.checkAndAddMove(moves, d.row, d.col, chess));
        
        return moves;
    }
}
