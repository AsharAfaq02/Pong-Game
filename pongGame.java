import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;

public class pongGame extends JPanel implements ActionListener {
    Timer tm = new Timer(7, this);
    keyboard kybrd = new keyboard();
    static boolean loseTitle = false;
    static boolean loseTitle2 = false;
    int indexXcrd = 2;
    int indexYcrd = 1;
    int x;

    int ovalXcrd = 50, ovalYcrd = 200, ovalWidth = 30, ovalHeight = 30;
    int rect1Xcrd = 5, rect1Ycrd = 180, rect1Height = 80, rect1Width = 10;
    int rect2Xcrd = 380, rect2Ycrd = 180, rect2Height = 80, rect2Width = 10;


    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillOval(ovalXcrd, ovalYcrd, ovalWidth, ovalHeight);
        g.setColor(Color.red);
        g.fillRect(rect1Xcrd, rect1Ycrd, rect1Width, rect1Height);
        g.setColor(Color.blue);
        g.fillRect(rect2Xcrd, rect2Ycrd, rect2Width, rect2Height);
        if (loseTitle == true) {
            g.setColor(Color.blue);
            g.drawString("BLUE PLAYER LOST", 135, 180);
        }
        if (loseTitle2 == true) {
            g.setColor(Color.red);
            g.drawString("RED PLAYER LOST", 135, 180);
        }

        tm.start();
    }

    public void actionPerformed(ActionEvent e) {
        //statements which maneuver and execute the movements of ball & "you lose" titles
        if ((ovalYcrd + (ovalHeight / 2) >= rect1Ycrd + (rect1Height / 2) - 6 && ovalYcrd +
                (ovalHeight / 2) <= rect1Ycrd + (rect1Height / 2) + 6) &&
            (ovalXcrd == 4) ||
            (ovalYcrd + (ovalHeight / 2) >= rect2Ycrd + (rect2Height / 2) - 6 && ovalYcrd +
                (ovalHeight / 2) <= rect2Ycrd + (rect2Height / 2) + 6) &&
            (ovalXcrd + ovalWidth == 382)) {
            x = 0;
            indexXcrd = -indexXcrd;

        }
        if (ovalYcrd > 450 || ovalYcrd < 0) {
            indexYcrd = -indexYcrd;
        }


        if (ovalYcrd + (ovalHeight / 2) >= rect1Ycrd && ovalYcrd +
            (ovalHeight / 2) < rect1Ycrd + (rect1Height / 2) - 6 &&
            (ovalXcrd == 4) ||
            (ovalYcrd + (ovalHeight / 2) >= rect2Ycrd &&
                ovalYcrd + (ovalHeight / 2) < rect2Ycrd + (rect2Height / 2) - 6 &&
                (ovalXcrd + ovalWidth == 382))) {

            x = 1;
            indexYcrd = -indexYcrd;
            indexXcrd = -indexXcrd;


        }
        if (ovalYcrd + (ovalHeight / 2) > rect1Ycrd + (rect1Height / 2) + 6 && ovalYcrd +
            (ovalHeight / 2) < rect1Ycrd + rect1Height &&
            (ovalXcrd == 4) ||
            ovalYcrd + (ovalHeight / 2) > rect2Ycrd + (rect2Height / 2) + 6 &&
            ovalYcrd + (ovalHeight / 2) < rect2Ycrd + rect2Height &&
            ovalXcrd + ovalWidth == 382) {

            x = 1;
            indexXcrd = -indexXcrd;
        }
        if (ovalXcrd + ovalWidth > 400) {
            loseTitle = true;
            loseTitle2 = false;
        }
        if (ovalXcrd < -1) {
            loseTitle = false;
            loseTitle2 = true;
        }


        ovalXcrd += indexXcrd;
        ovalYcrd += indexYcrd * x;
        rect2Ycrd += kybrd.value();
        rect1Ycrd += kybrd.value2();


        repaint();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("PongFrame");
        frame.setVisible(true);
        frame.add(new pongGame());
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
