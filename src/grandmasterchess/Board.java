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
                //valkoiset namiskat
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

    public Piece selectPiece(int rank, int file) {
        return board[rank][file];
    }

    public void movePiece(int startRank, int startFile, int endRank, int endFile) {
        Piece piece = board[startRank][startFile];
        if (board[endRank][endFile] == null && legalMoveCheck(piece, startRank, startFile, endRank, endFile)) {
            piece.setFile(endFile);
            piece.setRank(endRank);
            board[startRank][startFile] = null;
            board[endRank][endFile] = piece;
        } else {
            System.out.println("Illegal move");
        }
    }

    public Boolean legalMoveCheck(Piece piece,int startRank, int startFile, int endRank, int endFile) {
        //Piece piece = board[startRank][startFile];
        //soldier rulescheck, double move as first move currently not possible
        if (piece.getName().equals("pawn")) {
            if (piece.getColor().equals("black")) {
                if (endRank <= startRank || endFile != startFile) {
                    return false;
                }
            }
            if (piece.getColor().equals("white")) {
                if (endRank >= startRank || endFile != startFile) {
                    return false;
                }
            }
        }
        //rook rules check
        if (piece.getName().equals("rook")) {
            if (endRank != startRank && endFile != startFile) {
                return false;
            }
        }
        //bishop rules check
        if (piece.getName().equals("bishop")) {
            if ((Math.abs(endRank - startRank) - Math.abs(endFile - startFile) != 0)) {
                return false;
            }
        }
        //knight rules check
        if (piece.getName().equals("knight")) {
            if (Math.abs(endRank - startRank) > 2 || (Math.abs(endFile - startFile) > 2)) {
                return false;
            }
            if ((Math.abs(endRank - startRank) == 2 && (Math.abs(endFile - startFile) != 1))
                    || (Math.abs(endFile - startFile) == 2) && (Math.abs(endRank - startRank) != 1)) {
                return false;
            }
        }
        //queen rules check
        if (piece.getName().equals("queen")) {
            if (endRank != startRank && endFile != startFile) {
                if ((Math.abs(endRank - startRank) - Math.abs(endFile - startFile) != 0)) {
                    return false;
                }
            }
            if ((endRank == startRank && endFile != startFile) || (endRank != startRank && endFile == startFile)) {
                if (endRank != startRank && endFile != startFile) {
                    return false;
                }
            }
        }
        //king rules check
        if (piece.getName().toLowerCase().equals("king")) {
            if (Math.abs(endRank - startRank) > 1 || Math.abs(endFile - startFile) > 1) {
                return false;
            }
        }
        return true;
    }
    
    public boolean collisionCheck(int startRank, int startFile, int endRank, int endFile) {
        return true;
    }
}
