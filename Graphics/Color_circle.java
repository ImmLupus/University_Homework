import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;
import java.util.Scanner;

public class Color_circle extends JFrame {

    public static int x0;
    public static int y0;
    public static int r;
    public static int N;

    public Color_circle() {
        super("simpleApp");
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;

        int x = 0, y = r;
        int D = 1 - 2 * r, Err;
        while (y >= 0) {
            g.drawLine(x0 + x, y0 + y, x0 + x, y0 + y);
            Err = 2 * (D + y) - 1;
            if ((D < 0) && (Err <= 0)) {
                D += 2 * x + 1;
                x++;
                continue;
            }
            if ((D > 0) && (Err > 0)) {
                D -= 2 * y + 1;
                y--;
                continue;
            }
            D += 2 * (x - y);
            x++; y--;
        }
        x = 0; y = r;
        D = 1 - 2 * r;
        while (y >= 0) {
            g.drawLine(x0 + x, y0 - y,x0 + x,y0 - y);
            Err = 2 * (D + y) - 1;
            if ((D < 0) && (Err <= 0)) {
                D += 2 * x + 1;
                x++;
                continue;
            }
            if ((D > 0) && (Err > 0)) {
                D -= 2 * y + 1;
                y--;
                continue;
            }
            D += 2 * (x - y);
            x++; y--;
        }
        x = 0; y = r;
        D = 1 - 2 * r;
        while (y >= 0) {
            g.drawLine(x0 - x, y0 + y,x0 - x,y0 + y);
            Err = 2 * (D + y) - 1;
            if ((D < 0) && (Err <= 0)) {
                D += 2 * x + 1;
                x++;
                continue;
            }
            if ((D > 0) && (Err > 0)) {
                D -= 2 * y + 1;
                y--;
                continue;
            }
            D += 2 * (x - y);
            x++; y--;
        }
        x = 0; y = r;
        D = 1 - 2 * r;
        while (y >= 0) {
            g.drawLine(x0-x, y0-y,x0 - x,y0 - y);
            Err = 2 * (D + y) - 1;
            if ((D < 0) && (Err <= 0)) {
                D += 2 * x + 1;
                x++;
                continue;
            }
            if ((D > 0) && (Err > 0)) {
                D -= 2 * y + 1;
                y--;
                continue;
            }
            D += 2 * (x - y);
            x++; y--;
        }
        //**************NEW_TASK****************
        double x1 = 0, y1 = r, x2, y2, x3, y3;
        //Color colors[] = {Color.red, Color.blue, Color.yellow, Color.green, Color.MAGENTA, Color.CYAN, Color.PINK};
        Random random = new Random();
        int angle = 360 / N;
        int X[] = new int[N];
        int Y[] = new int[N];

        for (int i=0; i<N; i++) {
            x2 = x1 * Math.cos(angle * Math.PI / 180) + y1 * Math.sin(angle * Math.PI / 180);
            y2 = (-1) * x1 * Math.sin(angle * Math.PI / 180) + y1 * Math.cos(angle * Math.PI / 180);
            X[i] = (int)x2+x0; Y[i] = (int)y2+y0;
            x1 = x2; y1 = y2;
        }
        //for (int i=0; i<N; i++)  System.out.println(X[i]+" "+Y[i]);
        x1 = 0; y1 = r;
        x2 = x1; y2 =y1;
        for (int i=0; i<N; i++) {
            //g.setColor(colors[random.nextInt(colors.length)]);
	    Color color = new Color((int)random.nextInt(255),(int)random.nextInt(255),(int)random.nextInt(255));
            g.setColor(color);
            x3 = X[i]; y3 = Y[i];
            for (int j=0; j<angle; j++) {
                x2 = x1 * Math.cos(1 * Math.PI / 180) + y1 * Math.sin(1 * Math.PI / 180);
                y2 = (-1) * x1 * Math.sin(1 * Math.PI / 180) + y1 * Math.cos(1 * Math.PI / 180);
                g.drawLine(x0,y0,(int)x2+x0,(int)y2+y0);
                x1 = x2; y1 = y2;
            }
        }
    }

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	x0 = in.nextInt();
	y0 = in.nextInt();
	r = in.nextInt();
	N = in.nextInt();
        Color_circle app = new Color_circle();
    }
}
