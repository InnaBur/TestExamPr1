import java.util.Scanner;

public class Angabe03_TicTacToe {
    static char[][] field = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    //boolean fuer Kontrole, wenn das Spiel gestoppt werden muss
    static boolean exit = false;
    static Scanner scanner = new Scanner(System.in);

    //zeile, die der Spieler eingegeben hat
    static int zeile;

    //spalte, die der Spieler eingegeben hat
    static int spalte;

    //String fuer Ausgabe der Nummer des Spielers
    static String spieler;

    //char, das der Spieler verwendet
    static char spielerChar;

    public static void main(String[] args) {
        //Sie koennen Ihren Code hier reinschreiben oder eigene Methoden erzeugen, bleibt Ihnen ueberlassen
        displayField();

        do {

            //dieses Loop wechselt die Spieler (wenn i = 0, spielt Spieler 1, wenn i = 1 - Spieler 2
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    spieler = "Spieler 1";
                    spielerChar = 'x';
                } else {
                    spieler = "Spieler 2";
                    spielerChar = 'o';
                }

                spielerEingabe();
                updateField();
                exitUeberpruefung();

                if (exit) {
                    break;
                }
            }


        } while (!exit);
    }

    private static void exitUeberpruefung() {
        for (int i = 0; i < field.length; i++) {
            if ((field[i][0] == field[i][1]) && (field[i][0] == field[i][2]) && field[i][0] != ' ') {
                System.out.println(spieler + ", Sie haben gewonnen!");
                exit = true;
            }
        }
    }

    private static void spielerEingabe() {
        System.out.println(spieler + "Wählen Sie eine Spalte aus: ");
        zeile = scanner.nextInt();
        System.out.println(spieler + "Wählen Sie eine Spalte aus: ");
        spalte = scanner.nextInt();
    }


    //Diese Methode aktualisieren Spielbrett nach der Angabe des Spielers
    // unter Berücksichtigung der Eigenschaften des Feldes und der zusätzlichen Spalte
    //reduzieren wir die Eingabe des Spielers um 1

    private static void updateField() {
        if (field[zeile - 1][spalte - 1] == ' ') {
            field[zeile - 1][spalte - 1] = spielerChar;
        } else {
            System.out.println("-------Achtung!! Dieses Feld ist besetzt-----");

            //verwenden wir Recursion, um Spieler besetzendes Field nicht zu besetzen
            spielerEingabe();
            updateField();
        }
        displayField();
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
}
