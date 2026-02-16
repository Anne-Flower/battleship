package battleship;

public class SeaBoard {

    public SeaBoard() {
        int cols = 10;

        String[] dico = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 0; i < cols; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int j = 0; j <= dico.length - 1; j++) {
            System.out.print(dico[j] + " ");
            for (int d = 0; d < dico.length; d++) {
                System.out.print("~" + " ");
            }
            System.out.println();
        }
    System.out.println();
    }


}
