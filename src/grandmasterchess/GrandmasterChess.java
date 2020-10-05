package grandmasterchess;

public class GrandmasterChess {

    public static void main(String[] args) {
        Board board = new Board();

        System.out.println(board.printBoard());
        //System.out.println(board.selectPiece(7, 2).getNameAndColor());
        board.movePiece(0, 3, 2, 1);
        System.out.println(board.printBoard());
        //board.movePiece(5, 2, 4, 4);
        //System.out.println(board.printBoard());
    }
}
