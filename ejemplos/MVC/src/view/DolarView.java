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

import controller.Controller;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class DolarView implements Observer {
	JLabel btcLabel ;
	private JTextField dolarTextField;
	private Controller controller;
	
	public DolarView(Model model) {
		System.out.println("Se crea la vista BitcoinView");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		controller= new Controller();
		controller.addView(this);
		controller.addModel(model);
		inicializarVentana();
		
	}
		
		private void inicializarVentana() {

			JFrame ventanaM = new JFrame("Principal");
			ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaM.setTitle("Dolar");
			Dimension d = new Dimension();
			ventanaM.setResizable(false);// para configurar si se redimensiona la ventana
			ventanaM.setLocation((int) ((d.getWidth() / 2)+700 ), 250);// para ubicar inicialmente donde se muestra la
																		// ventana (x, y)
			ventanaM.setSize(400, 151);// configurando tamaño de la ventana (ancho, alto)
			ventanaM.setVisible(true);// configurando visualización de la ventana
			ventanaM.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 12, 370, 99);
			ventanaM.getContentPane().add(panel);
			panel.setLayout(null);
			btcLabel = new JLabel("USD");
			btcLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			btcLabel.setHorizontalAlignment(SwingConstants.CENTER);
			btcLabel.setBounds(12, 32, 87, 41);
			panel.add(btcLabel);
			
			dolarTextField = new JTextField();
			dolarTextField.setBounds(117, 44, 107, 19);
			panel.add(dolarTextField);
			dolarTextField.setColumns(10);
			
			JButton btnConvertir = new JButton("Convertir");
			btnConvertir.setBounds(236, 41, 117, 25);
			btnConvertir.addActionListener(controller);
			panel.add(btnConvertir);
			
			
	}

	

	@Override
	public void update(Observable o, Object arg) {
		Double valor = ((Double) arg).doubleValue();
		System.out.println("La vista DolarView obtiene el valor "+valor + " , actual del modelo.");
		System.out.println("La pantalla DolarView se actualiza por que se modifico el modelo");
		dolarTextField.setText(""+valor);

	}

	public JTextField getDolarTextField() {
		return dolarTextField;
	}

	public void setDolarTextField(JTextField dolarTextField) {
		this.dolarTextField = dolarTextField;
	}
	
	
}
