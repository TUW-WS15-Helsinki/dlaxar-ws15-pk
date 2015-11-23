import java.util.Arrays;

/**
 * Created by dlaxar on 16/11/15.
 */
public class AdHoc2 {

    private static int multiplyString(String[] s, String str, int from, int to) {

        if(to-from <= 0) {
            return 0;
        } else {
            s[from] = str;
            return 1+multiplyString(s, str, from+1, to);
        }
    }

    private static String[] buildLine(int n, int max) {
        String[] line = new String[(max+1)*4];
        int index = 0;
        index += multiplyString(line, " ", index, max-n);
        index += multiplyString(line, "*", index, n+index);
        line[index++] = " ";
        index += multiplyString(line, "*", index, index + max -n+1);
        line[index++] = " ";
        index += multiplyString(line, " ", index, index+n-1);
        index += multiplyString(line, " ", index, index+n-1);
        index += multiplyString(line, "*", index, index+max-n+1);
        line[index++] = " ";
        index += multiplyString(line, "*", index, index+n);
        index += multiplyString(line, " ", index, index + max - n + 1);

        return line;
    };

    private static String[][] buildTriangles(String[][] s, int index, int n, int max) {
        if(s == null) {
            s = new String[n][];
            index = 0;
        }

        if(n <= 0) {
            return s;
        }

        s[index] = buildLine(n, max);


        String line = "";
        return buildTriangles(s, index+1, n-1, max);
    }

    public static String[][] buildTriangles(int n) {
        return buildTriangles(null, 0, n, n);
    }

    private static void mirrorHorizontal(String[][] s) {
        for(int i = 0; i < s.length/2; i++) {
            for(int n = 0; n < s[i].length; n++) {
                String t;
                t = s[i][n];
                s[i][n] = s[s.length-i-1][n];
                s[s.length-i-1][n] = t;
            }
        }
    }

    private static void print2DArray(String[][] s) {
        for(String[] line : s) {
            for(String x : line) {
                System.out.print(x);
            }
            System.out.println();
//            System.out.println(Arrays.toString(line));
        }
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.println("Calling buildTriangles with argument x = " + x);
        String[][] s = buildTriangles(x);

        print2DArray(s);
        mirrorHorizontal(s);
        print2DArray(s);
        s = buildTriangles(3);

        print2DArray(s);
        mirrorHorizontal(s);
        print2DArray(s);
        s = buildTriangles(8);

        print2DArray(s);
        mirrorHorizontal(s);
        print2DArray(s);
    }
}
