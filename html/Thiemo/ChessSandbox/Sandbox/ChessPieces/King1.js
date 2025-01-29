export { King };

class King {
    constructor(isWhite) {
        this.__type = 'King';
        this.hasMoved = false; // Tracks if the King has moved
        this.isInCheck = false; // Tracks if the King is in check
        this.currentRow = null;
        this.currentCol = null;
        this.isWhite = isWhite;
        this.label = isWhite ? "♔" : "♚";
    }

    // Restore the King's state from saved data
    restoreData(value) {
        this.currentRow = value.currentRow;
        this.currentCol = value.currentCol;
        this.hasMoved = value.hasMoved;
        this.isInCheck = value.isInCheck;
        this.isWhite = value.isWhite;
        this.label = value.isWhite ? "♔" : "♚";
    }



    // Check if a position is out of bounds
    testOutOfBounds(rowOffset, colOffset) {
        const newRow = this.currentRow + rowOffset;
        const newCol = this.currentCol + colOffset;
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }

    // Check if castling is possible (general method)
    canCastle(chess) {
        if (this.hasMoved) return false; // Castling not allowed if the King has moved
        return this.canCastleLeft(chess) || this.canCastleRight(chess);
    }

    // Check left-side castling
    canCastleLeft(chess) {
        const rookColumn = 0; // Leftmost column for the rook
        const castlingRow = this.isWhite ? 7 : 0;

        if (this.currentRow === castlingRow && this.currentCol === 4) {
            const rook = chess.boardArray[castlingRow][rookColumn];
            if (!rook || rook.hasMoved) return false; // Rook missing or moved

            // Ensure no pieces block the path
            for (let col = rookColumn + 1; col < 4; col++) {
                if (chess.boardArray[castlingRow][col]) return false;
            }
            return true;
        }
        return false;
    }

    // Check right-side castling
    canCastleRight(chess) {
        const rookColumn = 7; // Rightmost column for the rook
        const castlingRow = this.isWhite ? 7 : 0;

        if (this.currentRow === castlingRow && this.currentCol === 4) {
            const rook = chess.boardArray[castlingRow][rookColumn];
            if (!rook || rook.hasMoved) return false; // Rook missing or moved

            // Ensure no pieces block the path
            for (let col = 5; col < rookColumn; col++) {
                if (chess.boardArray[castlingRow][col]) return false;
            }
            return true;
        }
        return false;
    }

    getValidMoves(chess) {
       
        const possibleMoves = this.getPossibleMoves(chess);
        const validMoves = [];
     console.log("valid moves i get back what",validMoves)
        // Filter out moves that would leave the King in check
        for (let move of possibleMoves) {
            // Temporarily simulate the move by updating the King's position
            const originalRow = this.currentRow;
            const originalCol = this.currentCol;
            this.currentRow = move.newRow;
            this.currentCol = move.newColumn;
    
            // Check if the King would still be in check after the move
            if (!chess.isKingInCheck(this.isWhite)) {
                validMoves.push(move);  // Keep the move if the King is not in check
            }
    
            // Restore the King's original position
            this.currentRow = originalRow;
            this.currentCol = originalCol;
        }
    
        return validMoves;  // Return the list of valid moves
    }

    // Get all possible moves for the King
    getPossibleMoves(chess) {
        const moves = [];
        const directions = [
            [-1, 0], [1, 0], [0, -1], [0, 1],    // Up, Down, Left, Right
            [-1, -1], [-1, 1], [1, -1], [1, 1]  // Diagonal directions
        ];

        // Add normal moves (1 step in each direction)
        for (const [dRow, dCol] of directions) {
            const newRow = this.currentRow + dRow;
            const newCol = this.currentCol + dCol;

            if (!this.testOutOfBounds(dRow, dCol)) {
                const targetPiece = chess.getChessPiece(newRow, newCol);
                if (!targetPiece || targetPiece.isWhite !== this.isWhite) {
                    moves.push({ newRow, newColumn: newCol, piece: this });
                }
            }
        }

        // Add castling moves
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
