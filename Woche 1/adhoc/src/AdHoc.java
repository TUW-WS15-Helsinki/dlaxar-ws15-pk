/**
 * Created by dlaxar on 16/11/15.
 */
public class AdHoc {

    private static String multiplyString(String s, int times) {
        if(times > 0) {
            return s + multiplyString(s, times-1);
        } else {
            return "";
        }
    }

    private static String buildTriangles(int n, int max) {
        if(n <= 0) {
            return "";
        }

        String line = "";
        line += multiplyString("  ", max-n);
        line += multiplyString("* ", n);
        line += " ";
        line += multiplyString("* ", max - n+1);
        line += " ";
        line += multiplyString("  ", n-1);
        line += multiplyString("  ", n-1);
        line += multiplyString("* ", max- n+1);
        line += " ";
        line += multiplyString("* ", n);

        return line + "\n" + buildTriangles(n-1, max);
    }

    public static String buildTriangles(int n) {
        return buildTriangles(n, n);
    }

    public static void main(String[] args) {
        int x = 20;
        System.out.println("Calling buildTriangles with argument x = " + x);
        System.out.println(buildTriangles(x));
    }
}
