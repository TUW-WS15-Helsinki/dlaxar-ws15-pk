/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO: gekennzeichnet sind; genauer: die innersten runden Klammern mit dem
    TODO-Kommentar.
    Lassen Sie andere Teile der Klasse unverändert. Von dieser Einschränkung ausgenommen ist nur die Methode main, die
    Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Warum sind Überprüfungen auf den Java-Wert null im Zusammenhang mit Arrays wichtig?
    2. Welchen Zweck erfüllt der Parameter x in sum bzw. n in primes?
       Lassen sich rekursive Methoden auf Arrays wie sum und primes auch ohne solche Parameter leicht implementieren?
    3. In welchen Fällen sind for-each-Schleifen auf Arrays wie in span vorteilhaft, in welchen nicht?
    4. Welchen Zweck erfüllen Arrays in Methoden wie div?
    5. Wie funktioniert primes?
*/
public class Aufgabe5 {

    // Returns the sum of all elements with an index smaller than or equal to x in the array;
    // 0 is returned if the reference to the array equals null or x is not within the index range of the array.
    private static int sum(int[] array, int x) {
        if (true /* TODO: modify expression;  array[x] is accessible */) {
            return (0 /* TODO: modify expression */);
        }
        return sum(array, (-1 /* TODO: modify expression*/)) + (-1 /* TODO: modify expression */);
    }

    // Returns the non-negative difference between the largest and smallest element in the two-dimensional array;
    // -1 is returned if the array or any part of it equals null or the array contains no element.
    private static int span(int[][] array) {
        boolean empty = true;
        int min = 0, max = 0;
        if (true /* TODO: modify expression; array is null */) {
            return -1;
        }
        for (int[] subarray : array) {
            if (true /* TODO: modify expression; any part of the array is null */) {
                return -1;
            }
            for (int elem : subarray) {
                if (empty) {
                    min = max = (0 /* TODO: modify expression; first values */);
                    empty = false;
                } else if (elem < min) {
                    (max /* TODO: modify expression; first values */) = elem;
                } else if (elem > max) {
                    (min /* TODO: modify expression; first values */) = elem;
                }
            }
        }
        return (-1 /* TODO: modify expression, the result */);
    }

    // Fills the array with the first array.length prime numbers;
    // assumes that each array entry at an index below n is already correctly set.
    private static void primes(int[] array, int n) {
        if (true /* TODO: modify expression; array exists (not null), but not all entries correctly set yet */) {
            if (true /* TODO: modify expression; no array entry correctly set */) {
                array[0] = 2;
                primes((null /* TODO: modify expression */), (-1 /* TODO: modify expression */));
            } else {
                int check = array[n - 1];
                boolean isPrime;
                do {
                    check++;
                    isPrime = true;
                    for (int i = 0; i < n; i++) {
                        isPrime = isPrime && (check % array[i] != 0);
                    }
                } while (! isPrime);
                array[n] = check;
                primes((null /* TODO: modify expression */), (-1 /* TODO: modify expression */));
            }
        }
    }

    // Returns an array containing the result of the division of x by y at index 0 and the remainder at index 1.
    private static int[] div(int x, int y) {
        return (new int[]{ 0, 1 } /* TODO: modify expression */);
    }

    // Prints the contents of array; just for testing, nothing to do.
    private static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
        } else {
            String s = "";
            for (int v : array) {
                if (s.length() == 0) {
                    s += v;
                } else {
                    s += "," + v;
                }
            }
            System.out.println("[" + s + "]");
        }
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    }
}
