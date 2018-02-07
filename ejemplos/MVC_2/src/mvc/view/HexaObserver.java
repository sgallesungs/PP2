package mvc.view;

import java.util.Observable;
import java.util.Observer;

import mvc.model.Model;

public class HexaObserver implements Observer {

	public HexaObserver(Model model) {
		model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Integer valor=(Integer) arg;
	      System.out.println( "Hex String: " + Integer.toHexString( valor).toUpperCase() ); 	}
}