package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerDolarCombo;
import model.Model;

public class DolarComboView extends View {
	JLabel btcLabel;
	private JTextField montoTextField;
	private JTextField dolarTextField;

	private JComboBox<String> comboBox;

	private ControllerDolarCombo controller;

	public DolarComboView(Model model) {
		System.out.println("Se crea la vista DolarComboView");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		controller = new ControllerDolarCombo();
		controller.addView(this);
		controller.addModel(model);
		inicializarVentana();

	}

	private void inicializarVentana() {

		JFrame ventanaM = new JFrame("DolarCombo");
		ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaM.setTitle("Dolar Combo");
		Dimension d = new Dimension();
		ventanaM.setResizable(false);
		ventanaM.setLocation((int) ((d.getWidth() / 2) + 700), 250);																	// ventana (x, y)
		ventanaM.setSize(446, 233);
		ventanaM.setVisible(true);
		ventanaM.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 416, 148);
		ventanaM.getContentPane().add(panel);
		panel.setLayout(null);
		btcLabel = new JLabel("USD");
		btcLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		btcLabel.setHorizontalAlignment(SwingConstants.CENTER);
		btcLabel.setBounds(22, 12, 87, 41);
		panel.add(btcLabel);

		dolarTextField = new JTextField();
		dolarTextField.setEditable(false);
		dolarTextField.setBounds(135, 24, 257, 19);
		dolarTextField.setColumns(10);
		panel.add(dolarTextField);

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(157, 105, 117, 25);
		btnConvertir.addActionListener(controller);
		panel.add(btnConvertir);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(32, 71, 87, 25);
		panel.add(comboBox);

		montoTextField = new JTextField();
		montoTextField.setColumns(10);
		montoTextField.setBounds(147, 74, 257, 19);
		panel.add(montoTextField);
		comboBox.addItem("AR");
		comboBox.addItem("U$S");
		comboBox.addItem("BTC");

	}

	@Override
	public void update(Observable o, Object arg) {
		Double valor = ((Double) arg).doubleValue();
		System.out.println("La vista DolarComboView obtiene el valor " + valor + " , actual del modelo.");
		System.out.println("La pantalla DolarComboView se actualiza.");
		dolarTextField.setText("" + valor);
	}

	public JTextField getMontoTextField() {
		return montoTextField;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
}
