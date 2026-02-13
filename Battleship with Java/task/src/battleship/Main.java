package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cols = 10;

        String[] dico = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for(int i = 0; i < cols; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for(int j = 0; j <= dico.length - 1; j++) {
            System.out.print(dico[j] + " ");
            for(int d = 0; d < dico.length; d ++) {
                System.out.print("~" + " ");
            }
            System.out.println();
        }

        System.out.println("Enter the coordinates of the ship:");
        String beginning = scanner.next();
        String end = scanner.next();

        displayLength(beginning,end);
        displayParts(beginning, end);

        scanner.close();

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

    private static void displayLength(String start, String end) {
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
    private static void displayParts(String start, String end) {
        System.out.println("Parts: " + String.join(" ", calculParts(start, end)));
    }
}
