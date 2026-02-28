package battleship;

public class Ship {
    int cells;
    String name;

    public Ship (int cells, String name ) {
        this.cells = cells;
        this.name = name;
    }




    public int getCells() {
        return cells;
    }

    public String getNameShip() {
        return name;
    }
}
