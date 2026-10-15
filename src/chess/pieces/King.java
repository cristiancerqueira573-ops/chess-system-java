package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color,ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private ChessMatch chessMatch;

    @Override
    public String toString() {
        return "K";

    }

    private boolean canMovie(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        p.setValues(position.getRow() - 1, position.getColum());
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow() + 1, position.getColum());
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow(), position.getColum() - 1);
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow(), position.getColum() + 1);
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }


        p.setValues(position.getRow() - 1, position.getColum() - 1);
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }


        p.setValues(position.getRow() - 1, position.getColum() + 1);
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }


        p.setValues(position.getRow() + 1, position.getColum() - 1);
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }


        p.setValues(position.getRow() + 1, position.getColum() + 1);
        if (getBoard().PositionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColum() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColum() + 1);
                Position p2 = new Position(position.getRow(), position.getColum() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColum() + 2] = true;
                }

            }

            // #specialmove castling

                Position posT2 = new Position(position.getRow(), position.getColum() + 3);
                if (testRookCastling(posT2)) {
                    Position p1 = new Position(position.getRow(), position.getColum() - 1);
                    Position p2 = new Position(position.getRow(), position.getColum() - 2);
                    Position p3 = new Position(position.getRow(), position.getColum() - 3);

                    if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                        mat[position.getRow()][position.getColum() - 2] = true;
                    }
                }

            }


            return mat;
        }
    }

