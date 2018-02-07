package view;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;	//for CloseListener()
import java.awt.event.WindowEvent;	//for CloseListener()
import java.util.Observable;		//for update();

import controller.Controller;
import model.Model;

public class DolaresView implements java.util.Observer {

	//attributes as must be visible within class
	public TextField cantDineroTextField;
	protected Button button; 
	private Controller controlador;
	
		
	public DolaresView() {
		super();
	}

	public DolaresView (Model model) {
		//** Inicialializacion MVC **
		System.out.println("Se crea la vista");
		System.out.println("La vista realiza Attach al modelo ");
		model.addObserver(this);
		this.controlador=new Controller();
		this.controlador.addModel(model);
		this.controlador.addView(this);
		//** Inicialializacion MVC **
		//** EJEMPLO **
		inicializarVentana();
		//Agrego el controlador al boton
		button.addActionListener(controlador);
	}
	
	protected void inicializarVentana() {
		Frame frame 		= new Frame("DOLARES");
		frame.add("North", new Label("Cantidad"));

		cantDineroTextField 		= new TextField();
		frame.add("Center", cantDineroTextField);

		Panel panel 		= new Panel();
		button	 		= new Button("Evaluar");
		panel.add(button);
		frame.add("South", panel);		

		frame.addWindowListener(new CloseListener());	
		frame.setSize(200,100);
		frame.setLocation(100,100);
		frame.setVisible(true);
	}
	
	// Invocado por el modelo
	public void update(Observable obs, Object obj) {
	System.out.println("La vista se actualiza por que se modifico el modelo");
	//System.out.println ("Vista      : Observable is " + obs.getClass() + ", el objeto pasado es " + obj.getClass());
	Double cantidad= ((Double)obj).doubleValue();
	
	cantDineroTextField.setText("" + cantidad);
	}

	
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} //windowClosing()
	}


} 
