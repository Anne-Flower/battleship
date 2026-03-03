package battleship;


import java.util.Scanner;
import java.util.HashMap;


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

    public int[] parseStringCoordinate(String stringCoordinate) {
        HashMap<String, Integer> letterMapping = new HashMap<>();
        letterMapping.put("A", 0);
        letterMapping.put("B", 1);
        letterMapping.put("C", 2);
        letterMapping.put("D", 3);
        letterMapping.put("E", 4);
        letterMapping.put("F", 5);
        letterMapping.put("G", 6);
        letterMapping.put("H", 7);
        letterMapping.put("I", 8);
        letterMapping.put("J", 9);


        String letter = String.valueOf(stringCoordinate.charAt(0));
        int number = Integer.parseInt(stringCoordinate.substring(1));
        int letterDico = letterMapping.get(letter);
        int[] coordinate = {letterDico, number};
        return coordinate;
    }

    public void isValidCoordinate(String startCoordinate, String endCoordinate) {
    }
    

}
