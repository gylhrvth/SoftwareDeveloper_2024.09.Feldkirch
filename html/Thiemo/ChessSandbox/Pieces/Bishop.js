export { Bishop };

class Bishop {
    constructor(isWhite) {
        this.__type = 'Bishop';

        this.currentRow = null
        this.currentCol = null
        this.isWhite = isWhite
        if (isWhite) {
            this.label = '♗'
        } else {
            this.label = '♝'
        }
    }

    restoreData(value) {

        this.currentRow = value.currentRow
        this.currentCol = value.currentCol
        this.isWhite = value.isWhite
        if (value.isWhite) {
            this.label = '♗'
        } else {
            this.label = '♝'
        }
    }

    testOutOfBounds(rowCount, colCount) {
        let newRow = this.currentRow + rowCount;
        let newCol = this.currentCol + colCount;

        // Return true if newRow or newCol are out of bounds (its like a boolean without creating one?? )
        return newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;
    }

    getPossibleMoves(chess) {
        let moves = []

              if (!this.isWhite) {
                  if (this.currentRow <= 7 && this.currentRow >= 0 && this.currentCol <= 7 && this.currentCol >= 0) {
      
                  }
              }
              else {
                  if (this.currentRow <= 7 && this.currentRow >= 0 && this.currentCol <= 7 && this.currentCol >= 0) {
      
                  }
              }

       // console.log("Bishop", moves)
        return moves;
    } 
}