// This class initializes operatable key movements into the game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class keyboard extends Frame implements KeyListener {

	public keyboard() {

		JFrame frame = new JFrame("keyFrame");
		JLabel newlabel = new JLabel("Red Player = keys 'A' and 'D'"
				                   + "  Blue Player = left & right arrow	");
		
		newlabel.setBounds(20, 10, 500, 20);
		frame.setSize(400, 20);
		frame.addKeyListener(this);
		frame.add(newlabel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private int num;
	private int num2;

	public int value2() {
		return num2;
	}

	public int value() {

		return num;
	}
//overridden methods of KeyListener class
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37) {

			num = -2;
		} else {
			if (e.getKeyCode() == 39) {

				num = 2;
			}
			if (e.getKeyCode() == 65) {
				num2 = 2;
			} else {
				if (e.getKeyCode() == 68) {
					num2 = -2;
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37 || e.getKeyCode() == 39) {

			num = 0;
		} else {
			if (e.getKeyCode() == 39) {

				num = 0;
			}
		}
		if (e.getKeyCode() == 65) {
			num2 = 0;

		} else {
			if (e.getKeyCode() == 68) {
				num2 = 0;
			}
		}
	}


	public void keyTyped(KeyEvent e) {
		//method unnecessary
		
	}
}
