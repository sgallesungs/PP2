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

public class BitcoinView implements Observer {
	JLabel btcLabel ;

	public BitcoinView(Model model) {
		System.out.println("Se crea la vista BitcoinView");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		inicializarVentana();
	}
		
		private void inicializarVentana() {

			JFrame ventanaM = new JFrame("Principal");
			ventanaM.setTitle("BITCOIN");
			Dimension d = new Dimension();
			ventanaM.setResizable(false);// para configurar si se redimensiona la ventana
			ventanaM.setLocation((int) ((d.getWidth() / 2) + 290), 250);// para ubicar inicialmente donde se muestra la
																		// ventana (x, y)
			ventanaM.setSize(400, 151);// configurando tamaño de la ventana (ancho, alto)
			ventanaM.setVisible(true);// configurando visualización de la ventana
			ventanaM.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 12, 370, 99);
			ventanaM.getContentPane().add(panel);
			panel.setLayout(null);
			btcLabel = new JLabel("BTC");
			btcLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			btcLabel.setHorizontalAlignment(SwingConstants.CENTER);
			btcLabel.setBounds(12, 32, 346, 41);
			panel.add(btcLabel);
		
	}

	

	@Override
	public void update(Observable o, Object arg) {
		Double valor = ((Double) arg).doubleValue();
		System.out.println("La vista Bitcoin obtiene el valor "+valor + " , actual del modelo.");
		System.out.println("La pantalla Bitcoin se actualiza por que se modifico el modelo");
		// 8187 valor en bitcoin de los dolares
		Double bitcoin = valor / 8187.0;
		btcLabel.setText("BTC "+bitcoin);
		

	}
}
