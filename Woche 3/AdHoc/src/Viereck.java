/**
 * Created by p1525096 on 11/30/15.
 */
public class Viereck {
    private int x;
    private int y;
    private int width;
    private int height;
    private char fill;

    public Viereck(int x, int y, int width, int height, char fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getFill() {
        return fill;
    }
}
