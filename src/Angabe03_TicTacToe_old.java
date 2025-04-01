import java.util.Scanner;

public class Angabe03_TicTacToe_old {
    static char[][] field = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static Scanner input = new Scanner(System.in);
    static int[] userInput = new int[2];
    static int counter = 0;
    static boolean exit = false;

    public static void main(String[] args) {
        //Sie koennen Ihren Code hier reinschreiben oder eigene Methoden erzeugen, bleibt Ihnen ueberlassen
        displayField();
        runSpiel();
    }

    // main Methode fuer Spielablauf
    public static void runSpiel() {
        do {
            for (int i = 0; i < 2; i++) {   // Schleif ist fuer Spieler-Wechsel
                userInput(i, "Zeile");
                userInput(i, "Spalte");

                updateState(i);
                resultUeberpruefung();
                if (exit) {
                    break;
                }
            }

        } while (!exit);
    }

    //Diese Methode aktualisiert Spielfeld
    private static void updateState(int i) {
        if (i == 0) {
            if (field[userInput[0]][userInput[1]] == ' ') {
                field[userInput[0]][userInput[1]] = 'x';
                counter++;                    //for ueberpruefung 9 Eingaben
            } else {
                System.out.println("Dieses Feld ist besetzt");
            }
        } else {
            if (field[userInput[0]][userInput[1]] == ' ') {
                field[userInput[0]][userInput[1]] = 'o';
                counter++;                    //for ueberpruefung 9 Eingaben
            } else {
                System.out.println("Dieses Feld ist besetzt");
            }
        }
        displayField();
    }

    // Diese Methode nimmt von Konsole user Input  und ueberpruft richtigkeit der Eingabe
    public static void userInput(int i, String st) {
        do {
            System.out.println("Spieler " + i + ": Wählen Sie eine " + st + " aus: ");

            if (input.hasNextInt()) {
                int value = input.nextInt();
//                if (value >= 0 && value <= 2) {
                    userInput[i] = value;
                System.out.println(st + userInput[i]);
                    break;
//                } else {
//                    System.out.println("Sie koennen nur 0, 1, oder 2 eingeben");
//                }
            } else {
                System.out.println("Wrong input! Sie koennen nur 0, 1, oder 2 eingeben");
                input.next();
            }
        } while (true);

    }

    //Feld aufzeichnen
    private static void displayField() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void resultUeberpruefung() {

        checkHorizontal(field);
        checkVertikal(field);
        checkDiagonal(field);
        checkDraw();

    }

    private static void checkDraw() {
        if (counter == 9) {
            exit = true;
        }
    }

    private static void checkDiagonal(char[][] feld) {
        if (((feld[0][0] == feld[1][1]) && (feld[0][0] == feld[2][2]) && (feld[0][0] != ' '))
                || ((feld[0][2] == feld[1][1]) && (feld[2][0] == feld[0][2]) && (feld[0][2] != ' '))) {
            System.out.println(" Du hast gewonnen");
            exit = true;
        }
    }

    private static void checkVertikal(char[][] feld) {
        for (int i = 0; i < feld.length; i++) {
            if ((feld[0][i] == feld[1][i]) && (feld[1][i] == feld[2][i]) && (feld[0][i] != ' ')) {
                System.out.println(" Du hast gewonnen");
                exit = true;
            }
        }
    }


    private static void checkHorizontal(char[][] feld) {
        for (char[] chars : feld) {
            if ((chars[0] == chars[1]) && (chars[1] == chars[2]) && (chars[1] != ' ')) {
                System.out.println(" Du hast gewonnen");
                exit = true;
            }
        }
    }
}
