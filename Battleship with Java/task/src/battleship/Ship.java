package battleship;

public class Ship {
    int cells;
    String nameShip;

    enum BoatsType {
        AIRCRAFT("Aircraft Carrier",5), BATTLESHIP("Battleship",4), SUBMARINE("Submarine",3), CRUISER("Cruiser", 3), DESTROYER("Destroyer",2);
        private final int cells;
        private final String nameShip;

        BoatsType(String nameShip, int cells) {
            this.nameShip = nameShip;
            this.cells = cells;
        }
    }

    public Ship(BoatsType shipType) {
        this.cells = shipType.cells;
        this.nameShip = shipType.nameShip;
    }

    public int getCells() {
        return cells;
    }

    public String getNameShip() {
        return nameShip;
    }
}
