package Testes;

import java.util.ArrayList;

import Controller.CriarInterface;
import Model.Funcionario;

public class TesteCriarFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CriarInterface j1 = new CriarInterface();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		Funcionario f1 = new Funcionario("Lucas", "999.999.999-99", 1000.00);
		Funcionario f2 = new Funcionario("João", "999.999.999-99", 1500.00);
		Funcionario f3 = new Funcionario("Pedro", "999.999.999-99", 1300.00);

		lista.add(f1);
		lista.add(f2);
		lista.add(f3);
		
		j1.Menu(lista);

		lista.forEach(valor -> System.out.println(valor.getNome()));

	}

}
