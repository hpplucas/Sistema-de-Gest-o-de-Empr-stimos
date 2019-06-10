package services;

import java.util.Scanner;

import model.repository.EmprestimoRepositorio;

public class ExcluirEmprestimoService {
	
	public static void excluirEmprestimo() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o codigo do emprestimo: ");
		int id = sc.nextInt();
		
		EmprestimoRepositorio r = new EmprestimoRepositorio();
		
		if (r.serchId(id) == null) {
			System.out.println("Emprestimo não encontrado");
			return;
		}
			r.excluirEmprestimo(id);
			System.out.println("Emprestimo excluido com sucesso");
	}
}
