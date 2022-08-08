package views.main_frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Commands;

public class NorthPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton restartAutomaton, validateWord;

	public NorthPanel(ActionListener listener) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(Color.decode("#BBD1EA"));
		this.initComponents(listener);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		restartAutomaton = new JButton("Reiniciar");
		restartAutomaton.setBackground(Color.decode("#507DBC"));
		restartAutomaton.setFocusable(false);
		restartAutomaton.setForeground(Color.decode("#000000"));
		restartAutomaton.addActionListener(actionListener);
		restartAutomaton.setActionCommand(Commands.C_RESTART.toString());
		this.add(restartAutomaton);
		
		
		validateWord = new JButton("Ingresar palabra");
		validateWord.setBackground(Color.decode("#507DBC"));
		validateWord.setFocusable(false);
		validateWord.setForeground(Color.decode("#000000"));
		validateWord.addActionListener(actionListener);
		validateWord.setActionCommand(Commands.C_VALIDATE_WORD.toString());
		this.add(validateWord);
	}

}
