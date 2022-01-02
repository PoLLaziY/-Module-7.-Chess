public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
        this.symbol = "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        if (!(super.canMoveToPosition(chessBoard, startLine, startColumn, toLine, toColumn))) return false;
        if (startLine == toLine || startColumn == toColumn) {
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
        } else if (!(Math.abs(startLine - toLine) == Math.abs(startColumn - toColumn))) return false;
        for (int i = startLine; i != toLine; i += (toLine - startLine) / Math.abs(toLine - startLine)) {
            if (i == startLine) continue;
            if (!(chessBoard.board[i][startColumn +
                    Math.abs(i - startLine) * (toColumn - startColumn) / Math.abs(toColumn - startColumn)] == null))
                return false;
        }
        return true;
    }
}
