package mvc.model;

import java.util.Observable;

public class Model extends Observable {

	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
		setChanged();
		notifyObservers(this.valor);
	}
}