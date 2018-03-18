package main;

import model.Model;
import view.BitcoinView;
import view.DolarView;
import view.PesoView;
import view.PrincipalView;

public class RunMVC {

	private Double valor_inicial = 1000.0;

	public RunMVC() {
		// Se crea el modelo
		Model myModel = new Model(valor_inicial);
		// Se crea la vista
		DolarView view = new DolarView(myModel);
		BitcoinView bitcoinView = new BitcoinView(myModel);
		PesoView pesosView = new PesoView(myModel);
		PrincipalView principalView = new PrincipalView(myModel);
	}

}