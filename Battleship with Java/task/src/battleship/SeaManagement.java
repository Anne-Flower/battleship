package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeaManagement {
    public SeaManagement() {
    }

    private static int calculLength(String start, String end) {
        int numStart = Integer.parseInt(start.substring(1));
        int numEnd = Integer.parseInt(end.substring(1));
        String letterStart = String.valueOf(start.charAt(0));
        String letterEnd = String.valueOf(end.charAt(0));
        int result = 0;

        if (numStart != numEnd) {
            int calcul = Math.abs(numEnd - numStart) + 1;
            result = calcul;
        }
        else if (!letterStart.equals(letterEnd)){
            int calcul = calculParts(start, end).size();
            result = calcul;
        }
        return result;
    }

    static void displayLength(String start, String end) {
        if (!isValidLength(start, end)) {
            System.out.println("Error!");
        }
        else {
            System.out.println("Length: " + calculLength(start, end));
        }
    }


    private static List<String> calculParts(String start, String end) {
        String letterStart = String.valueOf(start.charAt(0));
        String letterEnd = String.valueOf(end.charAt(0));
        int numStart = Integer.parseInt(start.substring(1));
        int numEnd = Integer.parseInt(end.substring(1));
        List<String> parts = new ArrayList<>();
        int min = Math.min(numStart, numEnd);
        int max = Math.max(numStart, numEnd);


        if (letterStart.equals(letterEnd)) {
            for(int i = min; i <= max; i++) {
                parts.add(letterStart + i);
            }
            return parts;
        }

        if (numStart == numEnd ) {
            String[] dico = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            int startIndex = 0;
            int endIndex = 0;
            for(int i = 0; i < dico.length; i++) {
                if (dico[i].equals(letterStart)) {
                    startIndex = i;
                }
                if (dico[i].equals(letterEnd)) {
                    endIndex = i;
                }
            }
            int minIndex = Math.min(startIndex, endIndex);
            int maxIndex = Math.max(startIndex, endIndex);
            for(int j = minIndex; j <= maxIndex; j++) {
                parts.add(dico[j] + numStart);
            }
        }
        return parts;
    }


    static void displayParts(String start, String end) {
        System.out.println("Parts: " + String.join(" ", calculParts(start, end)));
    }

    private static boolean isValidLength(String start, String end) {
        String[] dico = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String letterStart = String.valueOf(start.charAt(0));
        String letterEnd = String.valueOf(end.charAt(0));
        int numStart = Integer.parseInt(start.substring(1));
        int numEnd = Integer.parseInt(end.substring(1));
        boolean foundStart = false;
        boolean foundEnd = false;

        for(int j = 0; j <= dico.length - 1; j++) {
            if (letterStart.equals(dico[j])) {
                foundStart = true;
            }
            if (letterEnd.equals(dico[j])) {
                foundEnd = true;
            }
        }
        if (!letterStart.equals(letterEnd) && numStart != numEnd) {
            return false;
        }
        if (!foundStart) {
            return false;
        }
        if (!foundEnd) {
            return false;
        }
        if ( numStart > 10 || numEnd > 10 ) {
            return false;
        }
        if ( numStart <= 0 || numEnd <=0 ) {
            return false;
        }
        return true;
    }

    static void displayBoardAndQuestion() {
        Scanner scanner = new Scanner(System.in);
        new SeaBoard();

        for (int i = 0; i < Ship.BoatsType.values().length; i++) {
            Ship ship = new Ship(Ship.BoatsType.values()[i]);
            System.out.format("Enter the coordinates of the %s (%d cells):", ship.getNameShip(), ship.getCells());
            String beginning = scanner.next();
            String end = scanner.next();
            System.out.println();
            new SeaBoard();
        }
        scanner.close();
    }

}
