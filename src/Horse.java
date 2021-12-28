public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
        this.symbol = "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, startLine, startColumn, toLine, toColumn)) return false;
        if ((Math.abs(startLine - toLine) == 1 && Math.abs(startColumn - toColumn) == 2) ||
                (Math.abs(startLine - toLine) == 2 && Math.abs(startColumn - toColumn) == 1)) return true;
        else return false;
    }
}
