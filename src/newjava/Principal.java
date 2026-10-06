package newjava;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	public static void editarPessoa(ArrayList<Pessoa> pessoas) {
		String nomeEditar = JOptionPane.showInputDialog("Digite a pessoa que deseja editar: ");
		Pessoa pessoaEditar = null;
		
		for (Pessoa pessoa : pessoas) {
			
			if (pessoa.getNome().equals(nomeEditar)) {
				pessoaEditar = pessoa;
			}
		}
		
		if (pessoaEditar != null) {
		pessoaEditar.setNome(JOptionPane.showInputDialog("Digite o novo nome: "));
		pessoaEditar.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a nova idade: ")));
		pessoaEditar.setEmail(JOptionPane.showInputDialog("Digite o novo E-mail: "));
		pessoaEditar.setCpf(JOptionPane.showInputDialog("Digite o novo CPF: ")); 
		} else {
			JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
		}
	}	
	public static void removerPessoa(ArrayList<Pessoa> pessoas) {
		String remover = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja remover: ");
		Pessoa pessoaRemover = null;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().equals(remover)) {
				pessoaRemover = pessoa;
			}
		}
		
		if (pessoaRemover != null) {
			pessoas.remove(pessoaRemover);
		} else {
			JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
		}
	}
	public static void buscarPessoa(ArrayList<Pessoa> pessoas, String nomeBusca) {	
		
		boolean encontrada = false;
		
		for (Pessoa pessoa : pessoas) {
			
			if (pessoa.getNome().equals(nomeBusca)) {
				System.out.println("Pessoa Encontrada!");
				
				System.out.println("Nome: " + pessoa.getNome());
				System.out.println("Idade: " + pessoa.getIdade());
				System.out.println("E-mail: " + pessoa.getEmail());
				System.out.println("Cpf: " + pessoa.getCpf());
				encontrada = true;
			}
		}
		if (!encontrada) {
			System.out.println("Pessoa não encontrada!");
		}
	}
	public static void listarPessoas(ArrayList<Pessoa> pessoas) {
			for (Pessoa pessoa : pessoas) {
				
					System.out.println("Nome: " + pessoa.getNome());
					System.out.println("Idade: " + pessoa.getIdade());
					System.out.println("E-mail: " + pessoa.getEmail());
					System.out.println("Cpf: " + pessoa.getCpf());
		}
	}
	public static void cadastrarPessoa(ArrayList<Pessoa> pessoas) {
		
		String nome = JOptionPane.showInputDialog("Digite um Nome: ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite uma idade: "));
		String email = JOptionPane.showInputDialog("Digite um e-mail: ");
		String cpf = JOptionPane.showInputDialog("Digite um CPF: ");
		
		Pessoa pessoa = new Pessoa(nome, idade, email, cpf);
		
		pessoas.add(pessoa);
		
	}
	public static void contarPessoa(ArrayList<Pessoa> pessoas) {
		JOptionPane.showMessageDialog(null, pessoas.size());
		
	}
	public static void main(String[]args) {
		
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"========= SISTEMA DE CADASTRO ========== \n" +
					"1 - Cadastrar pessoa \n" +
					"2 - Listar pessoas \n"	+
					"3 - Buscar pessoa \n" +
					"4 - Remover pessoa \n" +
					"5 - Editar pessoa \n" +
					"6 - Contar pessoas \n" +
					"7 - Sair"
					));
			if (opcao == 1) {
				cadastrarPessoa(pessoas);
			}
			if (opcao == 2) {
				listarPessoas(pessoas);
			}
			if (opcao == 3) {
				String nomeBusca = JOptionPane.showInputDialog("Digite o nome que deseja buscar: ");
				buscarPessoa(pessoas, nomeBusca);
			}
			if (opcao == 4) {
				removerPessoa(pessoas);
			}
			if (opcao == 5) {
				editarPessoa(pessoas);
			}
			if (opcao == 6) {
				contarPessoa(pessoas);
			}
			
		} while (opcao != 7);
	}	
}