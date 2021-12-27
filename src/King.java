public class King extends ChessPiece {
    public King(String color) {
        super(color);
        this.symbol = "K";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int toLine, int toColumn) {
        if (super.canMoveToPosition(chessBoard, startLine, startColumn, toLine, toColumn)) {
            return (Math.abs(startLine - toLine) == 1 && Math.abs(startColumn - toColumn) == 1) ||
                    (Math.abs(startLine - toLine) == 0 && Math.abs(startColumn - toColumn) == 1) ||
                    (Math.abs(startLine - toLine) == 1 && Math.abs(startColumn - toColumn) == 0);
        } else return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if (board.board[i][j] != null && !(board.board[i][j].getColor().equals(this.color)) &&
                        board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
