package Controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Model.Funcionario;

public class CriarInterface extends JFrame implements ActionListener {

    JTable tabela; //Inicializa a tabela

	public void Menu(ArrayList<Funcionario> lista) {
		
		//Criar dados iniciais
		
	    Object [][] dados = {
	            {lista.get(0).getIdFuncionario(), lista.get(0).getNome(), lista.get(0).getCpf(), lista.get(0).getSalario()},
	            {lista.get(1).getIdFuncionario(), lista.get(1).getNome(), lista.get(1).getCpf(), lista.get(1).getSalario()},
	            {lista.get(2).getIdFuncionario(), lista.get(2).getNome(), lista.get(2).getCpf(), lista.get(2).getSalario()}
	        };

	    String [] colunas = {"Id Funcionário","Nome", "Cpf", "Salário"};
	    
	    //Criar o tableModel
	    
	    DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);

	    //Criar os componentes 
	    
		JFrame meuFrame = new JFrame();
		JTextField cadastrarNome = new JTextField();
		JTextField cadastrarSalario = new JTextField();
		JTextField excluirFuncionario = new JTextField();
		JLabel excluirFuncionarioLabel = new JLabel();
		JLabel cadastrarNomeLabel = new JLabel();
		JLabel cadastrarCpfLabel = new JLabel();
		JLabel cadastrarSalarioLabel = new JLabel();
		MaskFormatter mascaraCampo1 = null;
		try {
		    mascaraCampo1= new MaskFormatter("###.###.###-##");
		}catch (ParseException e) {
		}
		JFormattedTextField cadastrarCpf = new JFormattedTextField(mascaraCampo1);
	    JScrollPane barraRolagem;
		Container c = new Container();
		Container c1 = new Container();
		Container cadastrarNomeContainer = new Container();
		Container cadastrarCpfContainer = new Container();
		Container cadastrarSalarioContainer = new Container();
		Container excluirFuncionarioContainer = new Container();
		JButton btn1 = new JButton("Adicionar");
		JButton btn2 = new JButton("Excluir");
		
		//Mudar o modelo da tabela
		
		tabela = new JTable(tableModel);
		
		//Adicionando barra de rolagem
		
        barraRolagem = new JScrollPane(tabela);      
        
        //Adicionando o campo Nome
        
        cadastrarNomeLabel.setText("     Digite o Nome");
        cadastrarNomeContainer.add(cadastrarNomeLabel);
        cadastrarNomeContainer.add(cadastrarNome);
        cadastrarNomeContainer.setLayout(new GridLayout(1,1));
        
        //Adicionando o campo Cpf
        
        cadastrarCpfLabel.setText("     Digite o Cpf");
        cadastrarCpfContainer.add(cadastrarCpfLabel);
        cadastrarCpfContainer.add(cadastrarCpf);
        cadastrarCpfContainer.setLayout(new GridLayout(1,1));
        
        //Adicionando o campo Salario
        
        cadastrarSalarioLabel.setText("     Digite o Salário");
        cadastrarSalarioContainer.add(cadastrarSalarioLabel);
        cadastrarSalarioContainer.add(cadastrarSalario);
        cadastrarSalarioContainer.setLayout(new GridLayout(1,1));
        
        //Adicionando o campo Excluir Funcionário

        excluirFuncionarioLabel.setText("     Digite o id do funcionário");
        excluirFuncionarioContainer.add(excluirFuncionarioLabel);
        excluirFuncionarioContainer.add(excluirFuncionario);
        excluirFuncionarioContainer.setLayout(new GridLayout(1,1));
        
        //Organizando os elementos na janela
        
        cadastrarNomeContainer.setBounds(30, 10, 400, 50);
        cadastrarCpfContainer.setBounds(30, 70, 400, 50);
        cadastrarSalarioContainer.setBounds(30, 130, 400, 50);
        excluirFuncionarioContainer.setBounds(520, 10, 400, 50);
        btn1.setBounds(30, 220, 250, 50);
        btn2.setBounds(520, 220, 250, 50);
        
        //Adicionando os elementos ao container
        
        c.add(cadastrarNomeContainer);
        c.add(cadastrarCpfContainer);
        c.add(cadastrarSalarioContainer);
        c.add(excluirFuncionarioContainer);
        c.add(btn1);
        c.add(btn2);
        c1.add(barraRolagem);
        
        //Definindo Layout dos containers e da janela
        
		meuFrame.setLayout(new GridLayout(2, 2));
		c.setLayout(null);
		c1.setLayout(new GridLayout(1,2));
		
		//Configurando a janela
		
		meuFrame.add(c);
		meuFrame.add(c1);
		meuFrame.setTitle("Gerenciador Funcionarios");
		meuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meuFrame.setSize(1000, 700);
		meuFrame.setVisible(true);
		
		//Criando o ActionListener para adicionar o Funcionário
		
        btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				DefaultTableModel model = new DefaultTableModel();
				
				model = (DefaultTableModel) tabela.getModel();
				
				String nome = cadastrarNome.getText();
				String cpf = cadastrarCpf.getText();
				double salario = Double.parseDouble(cadastrarSalario.getText());
		
				
				Object[] linha = {
					 	 (lista.size() + 1 ),nome, cpf, salario
				};
				
				
				
				lista.add(new Funcionario((lista.size() + 1 ),nome, cpf, salario));
				 
				model.addRow(linha);

			}
        	
        });
        
        btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				DefaultTableModel model = new DefaultTableModel();
				
				model = (DefaultTableModel) tabela.getModel();
				
				int idFuncionario = Integer.parseInt(excluirFuncionario.getText()) - 1;
				
				model.removeRow(idFuncionario);
				
			}
        	
        });
        

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}




	
