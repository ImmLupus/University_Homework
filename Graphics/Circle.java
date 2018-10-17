import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.util.Scanner;

public class Circle extends JFrame {

    public static int x0;
    public static int y0;
    public static int r;
    public static int N;

    public Circle() {
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
            g.drawLine(x0 - x, y0 - y,x0 - x,y0 - y);
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
	//*********************NEW_TASK**************************	
	int angle = 360 / N;
	double x1 = 0, y1 = r, x2, y2;
	g.drawLine(x0, y0, x0+(int)x1, y0+(int)y1);
	for (int i=0; i<N-1; i++){
		x2=x1*Math.cos(angle * Math.PI / 180)+y1*Math.sin(angle * Math.PI / 180);
		y2=(-1)*x1*Math.sin(angle * Math.PI / 180)+y1*Math.cos(angle * Math.PI / 180);
		g.drawLine(x0, y0, x0+(int)x2, y0+(int)y2);
		x1 = x2; y1 = y2;
	}
    }

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	x0 = in.nextInt();
	y0 = in.nextInt();
	r = in.nextInt();
	N = in.nextInt();
        Circle app = new Circle();
    }
}
