package application;

import java.text.ParseException;
import java.util.Scanner;

import services.AlterarEmprestimoService;
import services.CadastrarEmprestimoService;
import services.ExcluirEmprestimoService;
import services.ListarEmprestimosService;

public class App {

	public static void main (String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("");
			System.out.println("-----Sistema de Gestão de Emprestimos------");
			System.out.println("-------------------Menu--------------------");
			System.out.println("1. Cadastrar Emprestimo");
			System.out.println("2. Alterar Emprestimo");
			System.out.println("3. Excluir Emprestimo");
			System.out.println("4. Listar todos os emprestimos");
			System.out.println("5. Sair");
			int res = sc.nextInt();
			
			if (res == 5) {
				sc.close();
				System.out.println("Aplicação encerrada");
				break;
			}
			
			switch (res) {
				case 1:
					CadastrarEmprestimoService.cadastarEmprestimo();
					break;
				case 2:
					AlterarEmprestimoService.alterarEmprestimo();
					break;
				case 3: 
					ExcluirEmprestimoService.excluirEmprestimo();
					break;
				case 4:
					ListarEmprestimosService.listarTodos();
					break;
				default:
					System.out.println("Opção inválida. Selecione uma opção válida");
			}
		}
	}
}
