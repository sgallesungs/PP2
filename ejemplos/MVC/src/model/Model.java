package model;

import java.util.Observable;

public class Model extends Observable {

	private Double cantidadDeDinero;

	public Model(Double val) {
		super();
		this.cantidadDeDinero = val;
		System.out.println("Se crea el MODELO con el valor "+val);
	}

	public void fijarValor(Double value) {
		this.cantidadDeDinero = value;
		System.out.println("Se fija la cantidad de dinero en " + this.cantidadDeDinero);
		//Se marca como modificado
		setChanged();
		//Se notifica a los observadores
		notifyObservers(this.cantidadDeDinero);
	}

}
