package views.main_frame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControlAutomata;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CanvasFA canvas;
	private NorthPanel menuBarr;

	public MainFrame(ActionListener actionListener) {
		this.canvas = new CanvasFA(300, 300, (ControlAutomata) actionListener);
		this.menuBarr = new NorthPanel(actionListener);
		this.setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource("/img/ico.jpg")).getImage());		
		setTitle("NFA");
		setLocationRelativeTo(null);
		this.setSize(800, 800);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		this.add(canvas, BorderLayout.CENTER);
		this.add(menuBarr, BorderLayout.NORTH);
	}

	public void restartAutomaton() {
		canvas.restartAutomaton();
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}