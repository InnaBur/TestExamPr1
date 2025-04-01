public class Anage01_ZahlVerarbeiter {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};


        System.out.println("Methode LiefereSumme: " + liefereSumme(list));
        System.out.println("Methode LiefereMax: " + liefereMax(list));
        System.out.println("Methode LiefereMin: " + liefereMin(list));
        System.out.println("Methode LiefereMittelwert: " + liefereMittelwert(list));
        //Viele Glück! - Das schaffen Sie! :)
    }

    //Diese Methode verrechnet durchschnitt alle Elementen in Array
    private static double liefereMittelwert(int[] list) {
        return (double) liefereSumme(list) / list.length;
    }

    //Diese Methode findet maximale Zahl in Array (mit for-each Loop)
    private static int liefereMax(int[] list) {
        int max = list[0];
        for (int j : list) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }

    //Diese Methode findet minimale Zahl in Array (mit for Loop)
    private static int liefereMin(int[] list) {
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (min > list[i]) {
                min = list[i];
            }
        }
        return min;
    }

    //Diese Methode verrechnet Summe aller Elementen in Array
    private static int liefereSumme(int[] list) {
        int sum = 0;
        for (int j : list) {
            sum += j;
        }
        return sum;
    }
}

