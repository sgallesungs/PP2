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

public class PesoView extends View {
	JLabel arLabel;

	public PesoView(Model model) {
		System.out.println("Se crea la vista Pesos");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		inicializarVentana();
	}

	private void inicializarVentana() {

		JFrame ventanaM = new JFrame("Pesos");
		ventanaM.setTitle("Pesos");
		Dimension d = new Dimension();
		ventanaM.setResizable(false);
		ventanaM.setLocation((int) ((d.getWidth() / 2) + 290), 450);																	// ventana (x, y)
		ventanaM.setSize(400, 151);
		ventanaM.setVisible(true);
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
		System.out.println("La vista Pesos obtiene el valor " + valor + " , actual del modelo.");
		System.out.println("La pantalla en Pesos se actualiza.");
		Double peso = Conversor.convertirDolarAPeso(valor);
		arLabel.setText("AR " + peso);

	}
}
