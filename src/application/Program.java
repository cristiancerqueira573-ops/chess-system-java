import application.UI;
import boardgame.Board;
import boardgame.Position;
import chess.*;

public static void main(String[] args) {


    ChessMatch chessMatch = new ChessMatch();
    List<ChessPiece> captured = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    while (!chessMatch.getCheckMate()) {
        try {
            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
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

            if (capturedPrice != null) {
                captured.add(capturedPrice);
            }

        } catch (ChessException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }

        }

        UI.clearScreen();
        UI.printMatch(chessMatch, captured);


    }

