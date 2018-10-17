import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;
import java.util.Scanner;

public class Fill_Poly extends JFrame {

    public static int x0;
    public static int y0;
    public static int r;
    public static int N;

    public int Lean(double x, double y) {
        int lean;
        if (x != 0) lean = (int) (Math.atan((y / x)) / Math.PI * 180);
        else lean = 90;
        lean = Math.abs(lean);
        if (x < 0 && y < 0) lean = lean + 180;
        if (x < 0 && y >= 0) lean = 180 - lean;
        if (x >= 0 && y < 0) lean = 360 - lean;
        return lean;
    }

    public Fill_Poly() {
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
        //**************NEW_TASK*******************************
        double x1 = 0, y1 = r, x2, y2;
        Random random = new Random();
        Color color[] = new Color[N];
        for (int i=0; i<N; i++) color[i] = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
        int angle = 360 / N;
        int lean[] = new int[N+1];
        double X[] = new double[N];
        double Y[] = new double[N];

        for (int i=0; i<N; i++) {
            x2 = x1 * Math.cos(angle * Math.PI / 180) + y1 * Math.sin(angle * Math.PI / 180);
            y2 = (-1) * x1 * Math.sin(angle * Math.PI / 180) + y1 * Math.cos(angle * Math.PI / 180);
            X[i] = (int) x2;
            Y[i] = (int) y2;
            g.drawLine(x0, y0, (int) x2 + x0, (int) y2 + y0);
            x1 = x2;
            y1 = y2;
        }
        //g.drawLine(x0, y0, (int) X[1] + x0, (int) Y[1] + y0);
        //*********************FILL*****************************
        for (int i=0; i<N; i++) lean[i]=Lean(X[i],Y[i]);
        lean[N]=lean[0];
        for (int i=x0-r; i<=x0+r; i++){
            for (int j=y0-r; j<=y0+r; j++){
                if (Math.sqrt(Math.pow(i-x0,2)+Math.pow(j-y0,2))<r){
                    for (int q=0; q<N; q++) if (Lean(i-x0,j-y0)<lean[q] && Lean(i-x0,j-y0)>lean[q+1] && Math.abs(lean[q]-lean[q+1])<185) g.setColor(color[q]);
                    for (int q=0; q<N; q++) if (((Lean(i-x0,j-y0)<lean[q] && Lean(i-x0,j-y0)>0) || (Lean(i-x0,j-y0)>lean[q+1] && Lean(i-x0,j-y0)<360)) && Math.abs(lean[q]-lean[q+1])>185) g.setColor(color[q]);
                    g.drawLine(i,j,i,j);
                }
            }
        }
        for (int i=0; i<N+1; i++) System.out.println(lean[i]);
    }

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	x0 = in.nextInt();
	y0 = in.nextInt();
	r = in.nextInt();
	N = in.nextInt();
        Fill_Poly app = new Fill_Poly();
    }
}
