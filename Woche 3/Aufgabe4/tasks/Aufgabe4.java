import javax.print.DocFlavor;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
    Aufgabenstellung zur Klasse Aufgabe4:

    Implementieren Sie eine statische Methode check, die einen String als Parameter hat und genau dann true zurückgibt,
    wenn der String einen wohlgeformten Ausdruck enthält. Ein Ausdruck ist dann wohlgeformt, wenn er nur aus
      - ganzen Zahlen (Folge von Ziffern),
      - Variablennamen (Folge von Buchstaben),
      - geklammerten Ausdrücken (durch zusammenpassende öffnende und schließende Klammern '(' oder '[' bzw. ')' oder ']'
        umschlossene Ausdrücke),
      - zwei durch einen Operator +, -, * oder / verbundene Ausdrücke
    besteht.

    Beispiele für wohlgeformte Ausdrücke: "", "a*[bc+12]", "a+(b)-c", "a+[a+8+(b+c)]/a"
    Beispiele für nicht korrekt geklammerte Ausdrücke: "[a)", "()", "a--[x]", "-a+b", "]["

    Verwenden Sie einen Stack zur Überprüfung der Klammerung: Durchlaufen Sie die Zeichen im String von vorne nach
    hinten und legen Sie jede öffnende Klammer, die Sie dabei finden, auf den Stack. Wenn Sie auf eine schließende
    Klammer stoßen, nehmen Sie das oberste Element vom Stack; bei korrekter Klammerung muss die schließende Klammer
    mit der Klammer vom Stack zusammenpassen. Bei korrekter Klammerung muss der Stack am Ende leer sein.

    Hinweis: Sie können als Stack z.B. ein Objekt des Typs Deque<String> verwenden.
    Bitte verwenden Sie dafür kein Array.

    Zusatzfragen:
    1. Was versteht man unter dem LIFO- und FIFO-Prinzip?
    2. Könnte man zur Lösung dieser Aufgabe statt Deque<String> auch Queue<String> verwenden?
    3. Wie könnte man diese Aufgabe auch mit einem Array statt einem Stack lösen?
       Welche Nachteile würden sich daraus ergeben?
*/
public class Aufgabe4 {

    private static boolean check(String toBeChecked) {
        char[] charArray = toBeChecked.toCharArray();
        Deque<Character> brackets = new ArrayDeque<Character>();
        char[] ops = new char[]{'*', '+', '-', '/'};

        final int OP = 1, EXP = 2, NUMBER = 3, LETTER = 4, BOPEN = 5, BCLOSE = 6;

        int last = BOPEN;
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
//            System.out.println(c);
            switch(c) {
                // allowed operators
                case '*':
                case '/':
                case '+':
                case '-':
                    if(last == EXP || last == NUMBER || last == LETTER) {
                        last = OP;
                    } else {
                        return false;
                    }
                    break;
                case '(':
                case '[':
                    if(last == OP || last == BOPEN) {
                        brackets.push(c);
                        last = BOPEN; // allow everything just not an op
                    } else {
                        return false;
                    }
                    break;
                case ')':
                case ']':
                    if(last == BOPEN || last == NUMBER || last == LETTER || last == EXP) {
                        if(c == ')' && brackets.peekFirst() == '(' ||
                                c == ']' && brackets.peekFirst() == '[') {
                            last = EXP;
                            brackets.pop();
                        } else {
                            return false;
                        }
                    }
                    break;
                default:
                    if((c >= 48 && c <= 57)) {
                        // numbers
                        if(last == OP || last == BOPEN || last == NUMBER) {
                            last = NUMBER;
                        } else {
                            return false;
                        }
                    }
                    // letters
                    else if((c >= 65 && c <= 90)
                            || (c >= 97 && c <= 122)) {
                        if(last == LETTER || last == OP || last == BOPEN) {
                            last = LETTER;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
            }
        }
        if(brackets.size() == 0) {
            if(last == LETTER || last == NUMBER || last == EXP) {
                return true;
            }
        }
        return false;
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt.
        String only = null;
//        only = "a*[bc+12]";
        String pass[] = new String[]{
                "a+a",
                "1+2",
                "1+(2+1)",
                "[1]",
                "a*[bc+12]",
                "a+(b)-c",
                "a+[a+8+(b+c)]/a"
        };

        String fail[] = new String[]{
                "a+",
                "+a",
                "[",
                "(",
                "+",
                "1[2]",
                "[2",
                "[1)",
                "a--[x]",
                "-a+b",
                "[a+(b]+c]"
        };

        if(null != only && only.length() > 0) {
            System.out.println(only);
            System.out.println(check(only));
        } else {
            System.out.println("They should all pass");
            for(String s : pass) {
                System.out.println(s);
                System.out.println(check(s));
                continueOn(true, check(s));
            }
            System.out.println();

            System.out.println("They should all fail");
            for(String s : fail) {
                System.out.println(s);
                System.out.println(check(s));

                continueOn(false, check(s));
            }

            System.out.println("All tests passed!");
        }
    }

    private static void continueOn(boolean should, boolean is) {
        if(should != is) {
            throw new RuntimeException("Missmatch!");
        }
    }
}
