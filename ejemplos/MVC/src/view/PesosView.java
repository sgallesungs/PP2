package view;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.util.Observable;

import model.Model;

public class PesosView extends DolaresView {

	public PesosView(Model model) {
		// ** Inicialializacion MVC **
		System.out.println("Se crea la vista Pesos");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		// ** Inicialializacion MVC **
		// ** EJEMPLO **
		inicializarVentana();

	}

	@Override
	protected void inicializarVentana() {
		Frame frame = new Frame("PESOS");
		frame.add("North", new Label("Cantidad"));

		cantDineroTextField = new TextField();
		frame.add("Center", cantDineroTextField);
		frame.addWindowListener(new CloseListener());
		frame.setSize(200, 100);
		frame.setLocation(300, 300);
		frame.setVisible(true);
	}

	// Invocado por el modelo
	public void update(Observable obs, Object obj) {
		System.out.println("La vista Pesos se actualiza por que se modifico el modelo");
		// 19.9 valor en pesos de los dolares
		Double cantidad = ((Double) obj).doubleValue() / 19.90;
		cantDineroTextField.setText("" + cantidad);
	}

}