public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
        this.symbol = "P";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        if (super.canMoveToPosition(chessBoard, startLine, startColumn, toLine, toColumn)) {
            boolean start = (startColumn == toColumn && chessBoard.board[toLine][toColumn] == null) &&
                    ((this.color.equals("White") && startLine == 1 && (toLine == 2 ||
                            (toLine == 3 && chessBoard.board[2][toColumn] == null))) ||
                            (this.color.equals("Black") && startLine == 6 &&
                                    (toLine == 5 || (toLine == 4 && chessBoard.board[5][toColumn] == null))));
            boolean notStart = (startColumn == toColumn && chessBoard.board[toLine][toColumn] == null) &&
                    ((this.color.equals("White") && toLine == startLine + 1) ||
                            (this.color.equals("Black") && toLine == startLine - 1));
            boolean attack = (chessBoard.board[toLine][toColumn] != null) &&
                    (Math.abs(startColumn - toColumn) == 1) &&
                    ((this.color.equals("White") && toLine == startLine + 1) ||
                            (this.color.equals("Black") && toLine == startLine - 1));
            return start || notStart || attack;
        } else return false;
    }
}
