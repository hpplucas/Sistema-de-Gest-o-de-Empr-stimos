package services;

import java.text.SimpleDateFormat;
import java.util.List;

import model.entities.Emprestimo;
import model.repository.EmprestimoRepositorio;

public class ListarEmprestimosService {

	public static void listarTodos() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		EmprestimoRepositorio r = new EmprestimoRepositorio();
		
		List<Emprestimo> list = r.listarTodos();
		
		for (Emprestimo e : list) {
			System.out.println("-------------------------");
			System.out.println("Id: " + e.getId());
			System.out.println("Objeto: "+ e.getObjeto());
			System.out.println("Pessoa: "+ e.getPessoa());
			System.out.println("Contato: "+ e.getContato());
			System.out.println("Data do emprestimo: "+ sdf.format(e.getDtEmprestimo()));
			System.out.println("Data da devolução: "+ sdf.format(e.getDtDevolucao()));
			System.out.println("Descrição: "+e.getDescricao());
			System.out.println("--------------------------");
			System.out.println("");

		}
	}
}
