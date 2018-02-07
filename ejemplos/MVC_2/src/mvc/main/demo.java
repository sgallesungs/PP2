package mvc.main;
import mvc.model.Model;
import mvc.view.BinaryObserver;
import mvc.view.HexaObserver;
import mvc.view.OctalObserver;

public class demo {

	public static void main(String[] args) {
	      Model subject = new Model();

	      new HexaObserver(subject);
	      new OctalObserver(subject);
	      new BinaryObserver(subject);

	      System.out.println("Se setea el valor en 15");	
	      subject.setValor(15);
	      System.out.println("Se setea el valor en 10");	
	      subject.setValor(10);
	      System.out.println("Se setea el valor en 100");	
	      subject.setValor(100);
	   }
	
}



