package controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import conversor.Conversor;
import model.Model;
import view.DolarComboView;

public class ControllerDolarCombo implements java.awt.event.ActionListener, Observer {

	private Model model;
	private DolarComboView view;

	public ControllerDolarCombo() {
		System.out.println("Se crea el controlador");
	}

	public void addModel(Model m) {
		System.out.println("Se agrega el modelo al controlador");
		this.model = m;
		System.out.println("El controlador realiza Attach al modelo ");
		this.model.addObserver(this);
	}

	public void addView(DolarComboView v) {
		System.out.println("Se agrega la vista al controlador");
		this.view = v;
	}

	@Override
	public void update(Observable o, Object arg) {
		// El controlador podria deshabilitar o habilitar funciones, en este ejemplo no
		// va a realizar cambios

	}

	// Se invoca al presionar el boton
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.out.println("El controlador cambia el modelo");
		JTextField campo = this.view.getMontoTextField();
		JComboBox<String> comboBox = this.view.getComboBox();
		String text = campo.getText();
		if (!text.isEmpty()) {
			Double valor = Double.valueOf(text);
			if (comboBox.getSelectedItem().equals("AR")) {
				valor = Conversor.convertirPesoADolar(valor);
			}
			if (comboBox.getSelectedItem().equals("BTC")) {
				valor = Conversor.convertirBitcoinADolar(valor);

			}
			model.fijarValor(valor);
		} else {
			System.out.println("Falta el valor en dolares.");

		}
	}

}