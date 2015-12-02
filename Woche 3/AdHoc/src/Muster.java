import java.util.HashSet;

/**
 * Created by p1525096 on 11/30/15.
 */
public class Muster extends HashSet<Viereck> {

    public Muster() {
    }

    public Muster(int x) {
        super();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                char fill = (i%2 == 0) ? (j%2 == 0 ? 'x' : ' ') : ((j%2 == 0) ? ' ' : 'x');
                System.out.println(j*x +";" + i*x + ":" + fill);
                this.add(new Viereck(j * x, i * x, x, x, fill));
            }
        }
    }

    public void render() {
        int w = 0, h = 0;
        for(Viereck v : this) {
            if(v.getX() + v.getWidth() > w) {
                w = v.getX() + v.getWidth();
            }

            if(v.getY() + v.getHeight() > h) {
                h = v.getY() + v.getHeight();
            }
        }
        h++;

        char pane[][] = new char[h][];
        for(int lineNum = 0; lineNum < h; lineNum++) {
            char[] line = new char[w];
            fill(line, ' ');
            for(Viereck v : this) {
                // the current line intersects the rect
                if(lineNum > v.getY() && lineNum <= (v.getY() + v.getHeight())) {
                    fill(line, v.getX(), v.getX() + v.getWidth(), v.getFill());
                }
            }
            pane[lineNum] = line;
        }

        printArray(pane);


    }

    private static void printArray(char[][] a) {
        for(char[] line : a) {
            for(char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private void fill(char[] into, char fill) {
        for(int i = 0; i < into.length; i++) {
            into[i] = fill;
        }
    }

    private void fill(char[] into, int from, int to, char fill) {
        for(; from < to; from++) {
            into[from] = fill;
        }
    }

    public static void main(String[] args) {
        Muster m = new Muster();
        Viereck v = new Viereck(1, 1, 1, 1, '*');
        m.add(v);
        m.render();
//
//        Muster x = new Muster(5);
//        x.render();

    }

}
