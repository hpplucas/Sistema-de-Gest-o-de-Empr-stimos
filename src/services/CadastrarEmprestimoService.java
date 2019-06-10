package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Emprestimo;
import model.repository.EmprestimoRepositorio;

public class CadastrarEmprestimoService {

	public static void cadastarEmprestimo() throws ParseException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Infome os dados do emprestimo: ");
		System.out.print("Objeto: ");
		String objeto = sc.nextLine();
		System.out.print("Pessoa: ");
		String pessoa = sc.nextLine();
		System.out.print("Contato: ");
		String contato = sc.nextLine();
		System.out.print("Data do emprestimo (DD/MM/AAAA): ");
		Date dtEmprestimo = sdf.parse(sc.nextLine());
		System.out.print("Data de devolução (DD/MM/AAAA): ");
		Date dtDevolucao = sdf.parse(sc.nextLine());
		System.out.println("Descrição: ");
		String descricao = sc.nextLine();
		
		Emprestimo emprestimo = new Emprestimo(objeto, pessoa, contato, dtEmprestimo, dtDevolucao, descricao);
		
		EmprestimoRepositorio r = new EmprestimoRepositorio();
		
		r.cadastrarEmprestimo(emprestimo);
		
		System.out.println("");
		System.out.println("Emprestimo cadastrado com sucesso !");
		
	}
}
