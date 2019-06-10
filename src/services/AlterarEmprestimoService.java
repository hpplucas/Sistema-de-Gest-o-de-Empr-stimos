package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Emprestimo;
import model.repository.EmprestimoRepositorio;

public class AlterarEmprestimoService {

	public static void alterarEmprestimo() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o codigo do emprestimo que deseja alterar: ");
		int cod = sc.nextInt();
		sc.nextLine();
		
		EmprestimoRepositorio r = new EmprestimoRepositorio();
		
		if (r.serchId(cod) == null) {
			System.out.println("Emprestimo não encontrado");
			return;
		}
		Emprestimo e = r.serchId(cod);
		
		System.out.print("Informe os novos dados: ");
		System.out.print("Objeto (" + e.getObjeto() + "):" );
		String obj = sc.nextLine();
		System.out.print("Pessoa ("+e.getPessoa()+"):");
		String pessoa = sc.nextLine();
		System.out.print("Contato ("+e.getContato()+"):");
		String contato = sc.nextLine();
		System.out.print("Data do Emprestimo ("+sdf.format(e.getDtEmprestimo())+"):");
		Date dtEmp = sdf.parse(sc.nextLine());
		System.out.print("Data da Devolução ("+sdf.format(e.getDtDevolucao())+"):");
		Date dtDev = sdf.parse(sc.nextLine());
		
		
		System.out.println("Descrição ("+e.getDescricao()+"):");
		String desc = sc.nextLine();
		
		r.alterarEmprestimo(cod, obj, pessoa, contato, dtEmp, dtDev, desc);
		System.out.println("Emprestimo alterado com sucesso");
		
	}
}
