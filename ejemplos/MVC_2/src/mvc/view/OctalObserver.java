package mvc.view;

import java.util.Observable;
import java.util.Observer;

import mvc.model.Model;

public class OctalObserver implements Observer {

	public OctalObserver(Model model) {
		model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Integer valor=(Integer) arg;
        System.out.println( "Octal String: " + Integer.toOctalString( valor) ); 
	}
}