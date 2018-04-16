package main;

import model.Model;
import view.BitcoinView;
import view.DolarComboView;
import view.PesoView;
import view.TodasLasMonedasView;

public class RunMVC {

	private Double valor_inicial = 0.0;

	@SuppressWarnings("unused")
	public RunMVC() {
		// Se crea el modelo
		Model myModel = new Model(valor_inicial);
		// Se crea la vista
		DolarComboView view = new DolarComboView(myModel);
		BitcoinView bitcoinView = new BitcoinView(myModel);
		PesoView pesosView = new PesoView(myModel);
		TodasLasMonedasView principalView = new TodasLasMonedasView(myModel);
	}

}