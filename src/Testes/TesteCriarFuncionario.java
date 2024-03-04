package Testes;

import java.util.ArrayList;

import javax.swing.UIManager;

import Controller.CriarInterface;
import Model.Funcionario;

public class TesteCriarFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    /*try { 
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	    } catch(Exception ignored){}*/
		
		try {
		    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception ex) {
		    //Handle Exception
		}

		CriarInterface j1 = new CriarInterface();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		Funcionario f1 = new Funcionario(1,"Lucas", "999.999.999-99", 1000.00);
		Funcionario f2 = new Funcionario(2,"João", "999.999.999-99", 1500.00);
		Funcionario f3 = new Funcionario(3,"Pedro", "999.999.999-99", 1300.00);

		lista.add(f1);
		lista.add(f2);
		lista.add(f3);
		
		j1.Menu(lista);

		lista.forEach(valor -> System.out.println(valor.getNome()));

	}

}
