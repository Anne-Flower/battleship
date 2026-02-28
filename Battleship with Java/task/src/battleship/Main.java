package battleship;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ship[] playerOneShips = {
                new Ship(5, "Aircraft Carrier"),
                new Ship(4, "Battleship"),
                new Ship(3, "Submarine"),
                new Ship(3, "Cruiser"),
                new Ship(2, "Destroyer")
        };

        for(int i = 0; i < playerOneShips.length; i++) {
            placeShipPrompt(playerOneShips[i]);
            String startCoordinate = scanner.next();
            String endCoordinate = scanner.next();
        }

    }
    
    public static void placeShipPrompt(Ship ship) {
        System.out.format("Enter the coordinates of the %s (%d cells):\n", ship.name, ship.cells);
    }

    public void isValidCoordinate(String startCoordinate, String endCoordinate) {
    }
    

}
