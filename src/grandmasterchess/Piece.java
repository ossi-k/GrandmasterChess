package grandmasterchess;

public class Piece {
    private String name;
    private String color;
    private int rank;
    private int file;
    private int value;

    public Piece(String name, String color, int rank, int file, int value) {
        this.name = name;
        this.color = color;
        this.rank = rank;
        this.file = file;
        this.value = value;
    }

    public String getNameAndColor() {
        return color + " " +  name + " ";
    }
    
    
}


