public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
        this.symbol = "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        if (super.canMoveToPosition(chessBoard, startLine, startColumn, toLine, toColumn) &&
                Math.abs(startLine - toLine) == Math.abs(startColumn - toColumn)) {
            for (int i = startLine; i != toLine; i += (toLine - startLine) / Math.abs(toLine - startLine)) {
                if (i == startLine) continue;
                if (!(chessBoard.board[i][startColumn + Math.abs(i - startLine) * (toColumn - startColumn) / Math.abs(toColumn - startColumn)] == null)) {
                    return false;
                }
            } return true;
        } else return false;
    }
}
