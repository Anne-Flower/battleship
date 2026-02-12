package battleship;

import java.util.ArrayList;
import java.util.Arrays;
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

        calculLength(beginning,end);

        scanner.close();

    }


    private static void calculLength(String start, String end) {
        int numStart = Integer.parseInt(start.split("")[1]);
        int numEnd = Integer.parseInt(end.split("")[1]);
        if (!start.split("")[0].equals(end.split("")[0]) || numStart > 10 || numEnd > 10 ) {
            System.out.println("Error!");
        }

        else {
            int calcul = (numEnd - numStart) + 1;
            System.out.println("Length: " + calcul);
        }
    }

    private static void calculParts(String start, String end) {

    }


}
