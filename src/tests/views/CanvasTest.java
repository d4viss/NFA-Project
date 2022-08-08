package tests.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import views.main_frame.CanvasFA;
import views.main_frame.MyJOption;
import views.main_frame.NorthPanel;
import views.main_frame.NorthValidate;

public class CanvasTest {
	CanvasFA canvas ;
	NorthPanel menuBarr ;
	JFrame f;
	NorthValidate validate;
	public CanvasTest() {
		validate = new NorthValidate();
		menuBarr = new NorthPanel(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Reiniciar")) {
					removeData();
				}
				if(e.getActionCommand().equals("Palabra")) {
					MyJOption o = new MyJOption();
					String palabra= o.myWord("Ingresa una palbra");
					if(!palabra.equals("")) {
						validate.validateData(true,palabra+" EJECUTADO CON EXITO");
					}else {
						validate.validateData(false,palabra+" EJECUCION FALLIDA");
					}
				}
			}
		});
		f = new JFrame("Paint Demo"); 
		f.setLayout(new BorderLayout()); 
		f.setSize(800,800);
		f.add(canvas, BorderLayout.CENTER);  
		f.add(menuBarr, BorderLayout.NORTH);
		f.add(validate, BorderLayout.PAGE_END);
		f.setVisible(true);  
	}

	public void removeData(){
		f.remove(canvas);
		f.add(canvas, BorderLayout.CENTER);  
		f.revalidate();
		f.repaint();
	}

	public static void main(String[] args) {

		new CanvasTest();	
	}
}
