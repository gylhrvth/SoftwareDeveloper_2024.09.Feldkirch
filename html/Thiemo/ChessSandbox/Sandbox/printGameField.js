
/*
printGameField() {
    const chessBoard = document.getElementById('chess-board');
    chessBoard.innerText = ''; // Clear existing board
    const highlightedSquares = [];

    // Loop to create squares
    for (let i = 0; i < 64; i++) {
        const square = document.createElement('div');
        const figure = document.createElement('div');

        const row = Math.floor(i / 8);
        const col = i % 8;

        // Assign classes for square colors
        square.classList.add('square', (row + col) % 2 === 0 ? 'whiteSquare' : 'blackSquare');

        // Add piece if present
        const piece = this.boardArray[row][col];
        if (piece) {
            figure.innerText = piece.label;
            figure.classList.add(piece.isWhite ? 'whiteFigure' : 'blackFigure');
        }

        // Highlight possible moves
        square.addEventListener('click', () => {
            // Clear previous highlights
            highlightedSquares.forEach(sq => sq.classList.remove('highlightSquare'));
            highlightedSquares.length = 0;

            if (piece) {
                const possibleMoves = piece.getPossibleMoves(this);
                possibleMoves.forEach(move => {
                    const targetSquare = chessBoard.children[move.newRow * 8 + move.newColumn];
                    targetSquare.classList.add('highlightSquare');
                    highlightedSquares.push(targetSquare);
                });

                console.log(
                    `Clicked on ${piece.__type}, ${String.fromCharCode(65 + col)}${8 - row}`,
                    possibleMoves
                );
            }
        });

        square.appendChild(figure);
        chessBoard.appendChild(square);
    }

    // Log board state
    this.boardArray.forEach(row => {
        console.log(row.map(cell => (cell ? cell.label : '.')).join(' '));
    });
    console.log('');

    // Remove highlights on outside clicks
    document.addEventListener('click', event => {
        if (!chessBoard.contains(event.target)) {
            highlightedSquares.forEach(sq => sq.classList.remove('highlightSquare'));
            highlightedSquares.length = 0;
        }
    });
}*/
