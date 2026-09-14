import application.UI;
import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

void main() {


    ChessMatch chessMatch = new ChessMatch();
    UI.printBoard(chessMatch.getPieces());



}
