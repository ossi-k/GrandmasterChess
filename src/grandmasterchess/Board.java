package grandmasterchess;

public class Board {

    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                //Mustat namiskat
                if (rank == 0 && (file == 0 || file == 7)) {
                    board[rank][file] = new Piece("rook", "black", rank, file, -5);
                }
                if (rank == 0 && (file == 1 || file == 6)) {
                    board[rank][file] = new Piece("knight", "black", rank, file, -3);
                }
                if (rank == 0 && (file == 2 || file == 5)) {
                    board[rank][file] = new Piece("bishop", "black", rank, file, -3);
                }
                if (rank == 0 && file == 3) {
                    board[rank][file] = new Piece("queen", "black", rank, file, -9);
                }
                if (rank == 0 && file == 4) {
                    board[rank][file] = new Piece("King", "black", rank, file, 0);
                }
                if (rank == 1) {
                    board[rank][file] = new Piece("pawn", "black", rank, file, -1);
                }
                //valkoiste namiskat
                if (rank == 7 && (file == 0 || file == 7)) {
                    board[rank][file] = new Piece("rook", "white", rank, file, 5);
                }
                if (rank == 7 && (file == 1 || file == 6)) {
                    board[rank][file] = new Piece("knight", "white", rank, file, 3);
                }
                if (rank == 7 && (file == 2 || file == 5)) {
                    board[rank][file] = new Piece("bishop", "white", rank, file, 3);
                }
                if (rank == 7 && file == 3) {
                    board[rank][file] = new Piece("queen", "white", rank, file, 9);
                }
                if (rank == 7 && file == 4) {
                    board[rank][file] = new Piece("King", "white", rank, file, 0);
                }
                if (rank == 6) {
                    board[rank][file] = new Piece("pawn", "white", rank, file, 1);
                }
            }
        }
    }

    public String printBoard() {
        String tilanne = "";
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board[rank][file] != null) {
                    tilanne += board[rank][file].getNameAndColor().substring(0, 1) + board[rank][file].getNameAndColor().substring(6, 7) + " ";
                } else {
                    tilanne += " 0 ";
                }
            }
            tilanne += "\n";
        }
        return tilanne;
    }
}
