/*
    Aufgabenstellung zu Fraction:

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO gekennzeichnet sind; genauer: die innersten runden Klammern mit dem
    TODO-Kommentar.
    Lassen Sie andere Teile der Klasse unverändert.
    Von dieser Einschränkung ausgenommen ist nur die Methode main, die Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Welche Vor- und Nachteile ergeben sich bei Verwendung der statischen Klassenmethode addFractions und der
       Objektmethode addFrac?
    2. Warum sind manche Methoden static, andere nicht? Welche sind wie?
    3. Warum sind manche Methoden public und andere private? Welche sind wie?
    4. Wozu dient reduce()?
    5. Warum gibt es in addFrac und mulFrac je einen Vergleich mit null?
    6. Warum geben addFrac und mulFrac bei null als Parameter unterschiedliche Ergebnisse zurück?
    7. Warum muss denominator > 0 gelten?
*/
public class Fraction {

    private int numerator;   // (Zähler)
    private int denominator; // (Nenner); denominator > 0 is required

    // New fraction with numerator num and denominator denom; denom != 0 is required.
    public Fraction(int num, int denom) {
        if (denom < 0) { // denominator > 0 is required, but value of fraction shall be as specified by num and denom
            num = (-num /* TODO: modify expression */);
            denom = (-denom /* TODO: modify expression */);
        }
        numerator = (num /* TODO: modify expression */);
        denominator = (denom /* TODO: modify expression */);
        reduce();
    }

    // Returns a new fraction with the result of adding frac to this fraction.
    // If frac is null, the result shall contain a copy of this fraction (new object of same state).
    public Fraction addFrac(Fraction frac){
        if(frac == null){
            return (new Fraction(this.numerator, this.denominator) /* TODO: modify expression */);
        }
        return (new Fraction(this.numerator * frac.denominator + frac.numerator * this.denominator,
                this.denominator * frac.denominator) /* TODO: modify expression */);
    }

    // Returns a new fraction with the result of adding frac to this fraction.
    // If frac is null, the result shall contain a fraction 0/1.
    public Fraction mulFrac(Fraction frac){
        if(frac == null){
            return (new Fraction(0, 1) /* TODO: modify expression */);
        }
        return (new Fraction(this.numerator * frac.numerator, this.denominator * frac.denominator) /* TODO: modify expression */);
    }

    // Reduce the fraction.
    private void reduce() {
        if (numerator == 0) {
            denominator = (0 /* TODO: modify expression */);
        } else {

            int gcd = gcd((numerator < 0) ? (-numerator) : numerator, denominator);

            numerator = (numerator / gcd/* TODO: modify expression */);
            denominator = (denominator / gcd /* TODO: modify expression */);
        }
    }

    // Returns the greatest common divisor of a und b.
    private int gcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return (b /* TODO: modify expression */);
    }

    // Adds two fractions, one specified by numerator num1 and denominator denom1, the other by numerator num1 and
    // denominator denom2. The resulting array contains the numerator at index 0 and the denominator at index 1.
    // denom1 != 0 and denom2 != 0 is required.
    public static int[] addFractions(int num1, int denom1, int num2, int denom2) {
        return (new int[]{num1 * denom2 + num2 * denom1,
                denom1 * denom2} /* TODO: modify expression */);
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    }

}
