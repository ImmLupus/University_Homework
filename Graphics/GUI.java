import java.awt.*;
import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.*;
import java.lang.Thread;
import java.lang.InterruptedException;

public class GUI extends JFrame implements KeyListener {

    public static ArrayList<Coord> points = new ArrayList();
    public static ArrayList<Pair> ribs = new ArrayList();
    public static int size;
    public static int N;
    public static double alp=1;

public static Coord rotateMatrix(Coord a, int ch){
    if ((char)ch=='Q') {
        a.x = a.x * Math.cos(alp * Math.PI / 180) + a.y * (-1) * Math.sin(alp * Math.PI / 180);
        a.y = a.x * Math.sin(alp * Math.PI / 180) + a.y * Math.cos(alp * Math.PI / 180);
    }
    if ((char)ch=='E') {
        a.x = a.x * Math.cos(-alp * Math.PI / 180) + a.y * (-1) * Math.sin(-alp * Math.PI / 180);
        a.y = a.x * Math.sin(-alp * Math.PI / 180) + a.y * Math.cos(-alp * Math.PI / 180);
    }
    if ((char)ch=='W') {
        a.y = a.y * Math.cos(alp * Math.PI / 180) + (-1) * a.z * Math.sin(alp * Math.PI / 180);
        a.z = a.y * Math.sin(alp * Math.PI / 180) + a.z * Math.cos(alp * Math.PI / 180);
    }
    if ((char)ch=='S') {
        a.y = a.y * Math.cos(-alp * Math.PI / 180) + (-1) * a.z * Math.sin(-alp * Math.PI / 180);
        a.z = a.y * Math.sin(-alp * Math.PI / 180) + a.z * Math.cos(-alp * Math.PI / 180);
    }
    if ((char)ch=='A') {
        a.x = a.x * Math.cos(alp * Math.PI / 180) + a.z * (-1) * Math.sin(alp * Math.PI / 180);
        a.z = a.x * Math.sin(alp * Math.PI / 180) + a.z * Math.cos(alp * Math.PI / 180);
    }
    if ((char)ch=='D') {
        a.x = a.x * Math.cos(-alp * Math.PI / 180) + a.z * (-1) * Math.sin(-alp * Math.PI / 180);
        a.z = a.x * Math.sin(-alp * Math.PI / 180) + a.z * Math.cos(-alp * Math.PI / 180);
    }

    return a;
}

    public GUI() {
        super("simpleApp");
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
    repaint();
        try {
            Thread.sleep(50);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        super.paint(g);
        Graphics2D gr2d = (Graphics2D) g;
        for (int i=0; i<ribs.size(); i++){
            g.drawLine(350+(int)points.get(ribs.get(i).first).x,350+(int)points.get(ribs.get(i).first).y,350+(int)points.get(ribs.get(i).second).x,350+(int)points.get(ribs.get(i).second).y);
            //System.out.println((int)points.get(ribs.get(i).first).x+" "+(int)points.get(ribs.get(i).first).y+" "+(int)points.get(ribs.get(i).second).x+" "+(int)points.get(ribs.get(i).second).y);

        }

    }

    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    public void keyPressed(KeyEvent e) {
        for (int i=0; i<points.size(); i++){
            points.set(i,rotateMatrix(points.get(i),e.getKeyCode()));
        }
        //repaint();
    }

    public static void main(String args[]) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("input.txt"));
        int x, y;
        double a, b, c;
        size = scanner.nextInt();
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            points.add(new Coord(a * size, b * size, c * size));
        }
        while (scanner.hasNextInt()) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            ribs.add(new Pair(x, y));
        }



        GUI app = new GUI();
        app.addKeyListener(app);

    }
}