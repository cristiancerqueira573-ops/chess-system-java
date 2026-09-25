import application.UI;
import boardgame.Board;
import boardgame.Position;
import chess.*;

void main() {


    ChessMatch chessMatch = new ChessMatch();
    Scanner sc = new Scanner(System.in);
    while (true) {
        try {
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);


            boolean[][] possibleMoves = chessMatch.possibleMoves(source);
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces(), possibleMoves);
            

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);



            ChessPiece capturedPrice = chessMatch.performChessMovie(source, target);

        } catch (ChessException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();


        }
    }
}
