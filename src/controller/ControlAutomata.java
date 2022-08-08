package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.NDFA;
import utils.StateType;

import javax.swing.JOptionPane;

import views.main_frame.MainFrame;

public class ControlAutomata implements ActionListener {

	private static final String VALIDATION_FAILED = "No se pudo validar Correctamente la palabra";
	private static final String VALIDATION_SUCESS = "Se valido Correctamente la palabra";
	private MainFrame frame; // instancia de la vista, frame principal
	private NDFA finiteAutomata = new NDFA();

	public ControlAutomata() {
		frame = new MainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case C_RESTART:
			// reiniciar el automata
			frame.restartAutomaton();
			break;
		case C_VALIDATE_WORD:
			// jOption para ingresar la palabra
			this.validateWord();
			break;
		default:
			break;

		}

	}

	public void validateWord() {
		String name = JOptionPane.showInputDialog("Ingresa la palabra a validar");
		boolean validation = finiteAutomata.validateWord(name);
		if (validation) {
			this.frame.showMessage(VALIDATION_SUCESS);
		} else {
			this.frame.showMessage(VALIDATION_FAILED);
		}
	}

	public void addState(String stateTag) {
		finiteAutomata.addState(stateTag, StateType.DEFAULT);
	}

	public void updateState(String stateTag, StateType type) {
		finiteAutomata.getStates().get(finiteAutomata.getStateIndex(stateTag)).setType(type);
	}

	public void addTransition(String startTag, String endTag, char condition) {
		finiteAutomata.addTransition(condition, finiteAutomata.getStates().get(finiteAutomata.getStateIndex(startTag)),
				finiteAutomata.getStates().get(finiteAutomata.getStateIndex(endTag)));
	}
}
