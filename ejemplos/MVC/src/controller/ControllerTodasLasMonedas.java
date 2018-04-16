package controller;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import conversor.Conversor;
import model.Model;
import view.View;

public class ControllerTodasLasMonedas implements ActionListener, Observer {

	private Model model;
	@SuppressWarnings("unused")
	private View view;

	public ControllerTodasLasMonedas() {
		System.out.println("Se crea el controlador");
	}

	public void addModel(Model m) {
		System.out.println("Se agrega el modelo al controlador");
		this.model = m;
		System.out.println("El controlador realiza Attach al modelo ");
		this.model.addObserver(this);
	}

	public void addView(View v) {
		System.out.println("Se agrega la vista al controlador");
		this.view = v;
	}

	@Override
	public void update(Observable o, Object arg) {
		// El controlador podria deshabilitar o habilitar funciones, en este ejemplo no
		// va a realizar cambios

	}

	// Se invoca al precionar el boton
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JTextField campo = (JTextField) e.getSource();
		System.out.println("El controlador cambia el modelo por que se modifico el campo " + campo.getName()
				+ " en la pantalla principal.");
		String text = campo.getText();
		if (!text.isEmpty()) {
			Double valor = Double.valueOf(text);
			//ESTO ES FEO!!, como se podria resolver?
			if (campo.getName().equalsIgnoreCase("pesoTextField")) {
				valor = Conversor.convertirPesoADolar(valor);
			}
			if (campo.getName().equalsIgnoreCase("bitcoinTextField")) {
				valor = Conversor.convertirBitcoinADolar(valor);

			}
			model.fijarValor(valor);
		} else {
			System.out.println("Falta el valor para poder modificar el dominio.");

		}

	}

}