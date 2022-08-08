package views.main_frame;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Commands;
import views.models.JModelButton;

public class NorthPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JModelButton restartAutomaton, validateWord;
	public static final Font FONT_ARIAL_ROUNDER_15 = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);

	public NorthPanel(ActionListener listener) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.decode("#BBD1EA"));
		this.initComponents(listener);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		restartAutomaton = new JModelButton(15,15,"Reiniciar","/img/restart.png",FONT_ARIAL_ROUNDER_15,30,30,Color.BLUE,Color.WHITE);
		restartAutomaton.setBackground(Color.decode("#507DBC"));
		restartAutomaton.setFocusable(false);
		restartAutomaton.setForeground(Color.decode("#000000"));
		restartAutomaton.addActionListener(actionListener);
		restartAutomaton.setActionCommand(Commands.C_RESTART.toString());
		restartAutomaton.setColorPaint(Color.BLUE);
		this.add(restartAutomaton);

		this.add(Box.createRigidArea(new Dimension(40,0)));
		
		validateWord = new JModelButton(15,15,"Validar Palabra","/img/validate.png",FONT_ARIAL_ROUNDER_15,30,30,Color.BLUE,Color.WHITE);
		validateWord.setBackground(Color.decode("#507DBC"));
		validateWord.setFocusable(false);
		validateWord.setForeground(Color.decode("#000000"));
		validateWord.addActionListener(actionListener);
		validateWord.setActionCommand(Commands.C_VALIDATE_WORD.toString());
		validateWord.setColorPaint(Color.BLUE);
		this.add(validateWord);
	}

}
