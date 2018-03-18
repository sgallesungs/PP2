package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class PrincipalView implements Observer {

	private JTextField dolarTextField;
	private JTextField bitcoinTextField;
	private JTextField pesoTextField;

	public PrincipalView(Model model) {
		System.out.println("Se crea la vista PrincipalView");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		inicializarVentana();
	}
		
		private void inicializarVentana() {

			JFrame ventanaM = new JFrame("Principal");
			Dimension d = new Dimension();
			ventanaM.setResizable(false);// para configurar si se redimensiona la ventana
			ventanaM.setLocation((int) ((d.getWidth() / 2) + 290), 50);// para ubicar inicialmente donde se muestra la
																		// ventana (x, y)
			ventanaM.setSize(400, 151);// configurando tamaño de la ventana (ancho, alto)
			ventanaM.setVisible(true);// configurando visualización de la ventana
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
			dolarTextField.setBounds(100, 3, 258, 19);
			panel.add(dolarTextField);
			dolarTextField.setColumns(10);
			dolarTextField.setEditable(false);
			bitcoinTextField = new JTextField();
			bitcoinTextField.setBounds(100, 30, 258, 19);
			panel.add(bitcoinTextField);
			bitcoinTextField.setColumns(10);
			bitcoinTextField.setEditable(false);
			pesoTextField = new JTextField();
			pesoTextField.setBounds(100, 57, 258, 19);
			panel.add(pesoTextField);
			pesoTextField.setColumns(10);
			pesoTextField.setEditable(false);
		
	}

	

	@Override
	public void update(Observable o, Object arg) {
		Double valor = ((Double) arg).doubleValue();
		System.out.println("La vista PrincipalView obtiene el valor "+valor + " , actual del modelo.");
		System.out.println("El campo Bitcoin se actualiza por que se modifico el modelo");
		// 8187 valor en bitcoin de los dolares
		Double bitcoin = valor / 8187.0;
		System.out.println("El campo Pesos se actualiza por que se modifico el modelo");
		// 19.9 valor en pesos de los dolares
		Double peso = valor * 20.50;
		System.out.println("El campo en Dolares se actualiza por que se modifico el modelo");
		// 19.9 valor en pesos de los dolares
		Double dolar = valor;
		pesoTextField.setText("AR "+peso);
		bitcoinTextField.setText("BTC "+bitcoin);
		dolarTextField.setText("USD "+dolar);
		
		

	}
}
