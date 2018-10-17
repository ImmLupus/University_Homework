import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.util.Scanner;

public class Point extends JFrame {

    public static int x0;
    public static int y0;
    public static int x1;
    public static int y1;

    public Point() {
        super("simpleApp");
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;

        int x=x0,y=y0,signY,signX;
        int Dx = Math.abs(x1 - x0), Dy = Math.abs(y1 - y0);
        if (x1-x0 > 0) signX=1; else signX=-1;
        if (y1-y0 > 0) signY=1; else signY=-1;
	int Err = 0;

        if (Math.abs(x1-x0)>Math.abs(y1-y0)) {
            for (x = x0; Math.abs(x - x1) > 0; x += signX) {
                g.drawLine(x, y, x, y);
                Err += Dy;
                if (2 * Err >= Dx) {
                    y = y + signY;
                    Err -= Dx;
                }
            }
        }
        else {
            for (y = y0; Math.abs(y - y1) > 0; y += signY) {
                g.drawLine(x, y, x, y);
                Err += Dx;
                if (2 * Err >= Dy) {
                    x = x + signX;
                    Err -= Dy;
                }
            }
        }
    }

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	x0 = in.nextInt();
	y0 = in.nextInt();
	x1 = in.nextInt();
	y1 = in.nextInt();
	Point app = new Point();
    }
}
