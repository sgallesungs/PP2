package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import conversor.Conversor;
import model.Model;

public class BitcoinView extends View {
	JLabel btcLabel;

	public BitcoinView(Model model) {
		System.out.println("Se crea la vista BitcoinView");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		inicializarVentana();
	}

	private void inicializarVentana() {

		JFrame ventanaM = new JFrame("Bitcoin");
		ventanaM.setTitle("Bitcoin");
		Dimension d = new Dimension();
		ventanaM.setResizable(false);
		ventanaM.setLocation((int) ((d.getWidth() / 2) + 290), 250); // ventana (x, y)
		ventanaM.setSize(400, 151);
		ventanaM.setVisible(true);
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
		System.out.println("La vista Bitcoin obtiene el valor " + valor + " , actual del modelo.");
		System.out.println("La pantalla Bitcoin se actualiza.");
		Double bitcoin = Conversor.convertirDolarABitcoin(valor);
		btcLabel.setText("BTC " + bitcoin);

	}
}
