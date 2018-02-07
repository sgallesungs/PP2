package view;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.util.Observable;

import model.Model;


public class BitcoinView extends DolaresView{
	
	public BitcoinView (Model model) {
		// ** Inicialializacion MVC **
		System.out.println("Se crea la vista Bitcoin");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		// ** Inicialializacion MVC **
		// ** EJEMPLO **
		inicializarVentana();

	}
	
	@Override
	protected void inicializarVentana() {
		Frame frame 		= new Frame("BITCOIN");
		frame.add("North", new Label("Cantidad"));
		cantDineroTextField 		= new TextField();
		frame.add("Center", cantDineroTextField);
		frame.addWindowListener(new CloseListener());	
		frame.setSize(200,100);
		frame.setLocation(500,500);
		frame.setVisible(true);
	}
	
	// Invocado por el modelo
	public void update(Observable obs, Object obj) {
	System.out.println("La vista Bitcoin se actualiza por que se modifico el modelo");
	//8187 valor en bitcoin de los dolares	
	Double cantidad= ((Double)obj).doubleValue()/8187.0;
	cantDineroTextField.setText("" + cantidad);
	}


	
	
}