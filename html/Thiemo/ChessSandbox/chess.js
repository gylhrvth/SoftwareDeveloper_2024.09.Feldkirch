// chess.js

class Pawn{ 
    constructor(){
        this.label = "P"
        this.currentRow = 0
        this.currentCol = 0
    }
}


class ChessGame{
    constructor(){
        // Define an 8x8 empty chessboard array
        this.boardArray = [
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
            [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined],
        ];
    }

    initGameField(){
        // this.boardArray[6][3] = new Pawn();
        this.addNewChessPiece(6, 3, new Pawn())
    }


    addNewChessPiece(row, column, piece){

    }

    moveChessPiece(piece, newRow, newColumn){

    }
    
    printGameField(){
        for (let i = 0; i < this.boardArray.length; ++i){
            let line = "";
            for (let j = 0; j < this.boardArray[i].length; ++j){
                if (this.boardArray[i][j] == undefined){
                    line += "."
                } else {
                    line += this.boardArray[i][j].label
                }    
            }
            console.log(line)
        }
    }
    
}

  


let chess = new ChessGame()
chess.initGameField()
chess.printGameField()

// move function
// get position function
// 1 class for figures but i need a function for different colors????


// let divE = document.getElementById("chess-board")

// for (let i = 0; i < 20; ++i){
//     let paragraphE = document.createElement("h2")
//     paragraphE.classList.add("para")
//     paragraphE.innerText = "Lorem ipsum " + i
//     divE.appendChild(paragraphE)
// }