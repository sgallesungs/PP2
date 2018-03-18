package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PesoView implements Observer {
	JLabel arLabel ;

	public PesoView(Model model) {
		System.out.println("Se crea la vista Pesos");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		inicializarVentana();
	}
		
		private void inicializarVentana() {

			JFrame ventanaM = new JFrame("Principal");
			ventanaM.setTitle("PESO");
			Dimension d = new Dimension();
			ventanaM.setResizable(false);// para configurar si se redimensiona la ventana
			ventanaM.setLocation((int) ((d.getWidth() / 2) + 290), 450);// para ubicar inicialmente donde se muestra la
																		// ventana (x, y)
			ventanaM.setSize(400, 151);// configurando tamaño de la ventana (ancho, alto)
			ventanaM.setVisible(true);// configurando visualización de la ventana
			ventanaM.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 12, 370, 99);
			ventanaM.getContentPane().add(panel);
			panel.setLayout(null);
			arLabel = new JLabel("AR");
			arLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			arLabel.setHorizontalAlignment(SwingConstants.CENTER);
			arLabel.setBounds(12, 32, 346, 41);
			panel.add(arLabel);
		
	}

	

	@Override
	public void update(Observable o, Object arg) {
		Double valor = ((Double) arg).doubleValue();
		System.out.println("La vista Pesos obtiene el valor "+valor + " , actual del modelo.");
		System.out.println("La pantalla en Pesos se actualiza por que se modifico el modelo");
		// 8187 valor en bitcoin de los dolares
		Double peso = valor * 20.50;
		arLabel.setText("AR "+peso);
		

	}
}
