package controller;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.DolarView;

public class Controller implements java.awt.event.ActionListener, Observer {

	private Model model;
	private DolarView view;

	public Controller() {
		System.out.println("Se crea el controlador");
	}

	public void addModel(Model m) {
		System.out.println("Se agrega el modelo al controlador");
		this.model = m;
		System.out.println("El controlador realiza Attach al modelo ");
		this.model.addObserver(this);
	}

	public void addView(DolarView v) {
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
		System.out.println("El controlador cambia el modelo");
		String text = view.getDolarTextField().getText();
		if (!text.isEmpty()) {
			Double valor = Double.valueOf(text);
			model.fijarValor(valor);
		} else {
			System.out.println("Falta el valor en dolares.");

		}

	}

}