package views.main_frame;

import javax.swing.JOptionPane;

public class MyJOption {

	public MyJOption() {
		// TODO Auto-generated constructor stub
	}

	public int myMenu() {
		String[] opciones = {"Inicial","Final"};
		int data = JOptionPane.showOptionDialog(null, "Seleciona una opci�n","Opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		return data;
	}

	public String myWord(String text) {
		String dataWord = JOptionPane.showInputDialog(null,text);
		if(dataWord.isBlank())
			return "λ";
		else
			return String.valueOf(dataWord.charAt(0));
	}

}
