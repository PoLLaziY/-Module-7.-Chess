public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
        this.symbol = "R";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        if (!(super.canMoveToPosition(chessBoard, startLine, startColumn, toLine, toColumn) &&
                (startLine == toLine || startColumn == toColumn))) return false;
        if (startLine == toLine) {
            for (int i = startColumn; i != toColumn; i += (toColumn - startColumn) / Math.abs(toColumn - startColumn)) {
                if (i == startColumn) continue;
                if (!(chessBoard.board[toLine][i] == null)) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = startLine; i != toLine; i += (toLine - startLine) / Math.abs(toLine - startLine)) {
                if (i == startLine) continue;
                if (!(chessBoard.board[i][toColumn] == null)) {
                    return false;
                }
            }
            return true;
        }
    }
}
