public abstract class ChessPiece {
    String color;
    String symbol;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    protected String getColor() {
        return color;
    }

    protected String getSymbol() {
        return symbol;
    }

    public boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7) ? true:false;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        boolean basic = checkPos(startLine) && checkPos(startColumn) &&
                checkPos(toLine) && checkPos(toColumn) &&
                !(startLine == toLine && startColumn == toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color));
        return basic;
    }
}
