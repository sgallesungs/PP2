package main;

import model.Model;
import view.BitcoinView;
import view.DolaresView;
import view.PesosView;

public class RunMVC {

	private Double valor_inicial = 1000.0;

	public RunMVC() {
		// Se crea el modelo
		Model myModel = new Model(valor_inicial);
		// Se crea la vista
		DolaresView view = new DolaresView(myModel);
		BitcoinView bitcoinView= new BitcoinView(myModel);
		PesosView pesosView= new PesosView(myModel);
	}

}