package view;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerTodasLasMonedas;
import conversor.Conversor;
import model.Model;

public class TodasLasMonedasView extends View {

	private JTextField dolarTextField;
	private JTextField bitcoinTextField;
	private JTextField pesoTextField;
	private ControllerTodasLasMonedas controller;

	public TodasLasMonedasView(Model model) {
		System.out.println("Se crea la vista TodasLasMonedasView");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		controller = new ControllerTodasLasMonedas();
		controller.addView(this);
		controller.addModel(model);
		inicializarVentana();
	}

	private void inicializarVentana() {

		JFrame ventanaM = new JFrame("Todas las Monedas");
		Dimension d = new Dimension();
		ventanaM.setResizable(false);
		ventanaM.setLocation((int) ((d.getWidth() / 2) + 290), 50);																	// ventana (x, y)
		ventanaM.setSize(400, 151);
		ventanaM.setVisible(true);
		ventanaM.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 370, 98);
		ventanaM.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Dolar:");
		lblNewLabel_2.setBounds(20, 5, 70, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Bitcoin:");
		lblNewLabel_1.setBounds(20, 32, 70, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Peso:");
		lblNewLabel.setBounds(20, 59, 70, 15);
		panel.add(lblNewLabel);

		dolarTextField = new JTextField();
		dolarTextField.addActionListener(controller);
		dolarTextField.setBounds(100, 3, 258, 19);
		panel.add(dolarTextField);
		dolarTextField.setColumns(10);
		dolarTextField.setName("dolarTextField");

		bitcoinTextField = new JTextField();
		bitcoinTextField.setBounds(100, 30, 258, 19);
		panel.add(bitcoinTextField);
		bitcoinTextField.setColumns(10);
		bitcoinTextField.setName("bitcoinTextField");
		bitcoinTextField.addActionListener(controller);

		pesoTextField = new JTextField();
		pesoTextField.addActionListener(controller);
		pesoTextField.setBounds(100, 57, 258, 19);
		panel.add(pesoTextField);
		pesoTextField.setColumns(10);
		pesoTextField.setName("pesoTextField");

	}

	@Override
	public void update(Observable o, Object arg) {
		Double valor = ((Double) arg).doubleValue();
		System.out.println("La vista TodasLasMonedasView obtiene el valor " + valor + " , actual del modelo.");
		System.out.println("El campo Bitcoin se actualiza.");
		Double bitcoin = Conversor.convertirDolarABitcoin(valor);
		System.out.println("El campo Pesos se actualiza.");
		Double peso = Conversor.convertirDolarAPeso(valor);
		System.out.println("El campo Dolares se actualiza.");
		Double dolar = valor;
		pesoTextField.setText(peso.toString());
		bitcoinTextField.setText(bitcoin.toString());
		dolarTextField.setText(dolar.toString());

	}

}
