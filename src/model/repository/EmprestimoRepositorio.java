package model.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.Emprestimo;

public class EmprestimoRepositorio {

	private static String path = "emprestimos.txt";
	private static File file = new File(path);
	private BufferedReader br;

//-------------------------Cadastrar novo emprestimo---------------------------
	
	public void cadastrarEmprestimo(Emprestimo emprestimo) {

		if (emprestimo.getId() == null)
			emprestimo.setId(setId());

		try {
			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file, true);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(emprestimo.toString());
			bw.write("");
			bw.newLine();

			bw.flush();
			bw.close();
			fw.close();

		} catch (IOException e) {
			System.out.println("Erro ao cadastrar: " + e.getMessage());
		}

	}
	
//------------------Metodo auxiliar para alteração e exclusão de emprestimos----------------------
	
	private void cadastrarEmprestimo(Emprestimo emprestimo, boolean manterDados) {

		try {

			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file, manterDados);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(emprestimo.toString());
			bw.write("");
			bw.newLine();

			bw.close();
			fw.close();
		} catch (IOException e) {

			System.out.println("Erro ao cadastrar: " + e.getMessage());

		}

	}

//------------------------listar todos os registros-------------------------------------
	
	public List<Emprestimo> listarTodos() {
		List<Emprestimo> list = new ArrayList<Emprestimo>();
		try {
			br = new BufferedReader(new FileReader(file));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String results = br.readLine();
			while (results != null) {
				String campos[] = results.split(",");
				int id = Integer.parseInt(campos[0]);
				String objeto = campos[1];
				String pessoa = campos[2];
				String contato = campos[3];
				Date dtEmprestimo = sdf.parse(campos[4]);
				Date dtDevolucao = sdf.parse(campos[5]);
				String descricao = campos[6];

				Emprestimo e = new Emprestimo(objeto, pessoa, contato, dtEmprestimo, dtDevolucao, descricao);

				e.setId(id); // seta id que está no arquivo txt

				list.add(e);
				results = br.readLine();
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}
	
//----------------------Buscar emprestimo pelo Id----------------------------

	public Emprestimo serchId(int id) {
		List<Emprestimo> list = listarTodos();
		
		for (Emprestimo e : list) {
			
			if (e.getId() == id) {
				
				return e;
			}
		}
		
		return null;
	}
	
//-----------------------Alterar Emprestimo--------------------------------------
	
	public boolean alterarEmprestimo(int id, String obj, String nome, String contato, Date dtEmp, Date dtDev, String desc) {
		
		List<Emprestimo> list = listarTodos();

		if (list == null) return false;
		
		boolean manterDados = false;
		
		for (Emprestimo e : list) {
			if (e.getId() == id) {
				e.setObjeto(obj);
				e.setPessoa(nome);
				e.setContato(contato);
				e.setDtEmprestimo(dtEmp);
				e.setDtDevolucao(dtDev);
				e.setDescricao(desc);
			}
			
			cadastrarEmprestimo(e, manterDados);
			manterDados = true;
		}

		return true;
	}

//-------------------------Excluir emprestimo pelo ID---------------------------------------
	
	public boolean excluirEmprestimo(int id) {

		List<Emprestimo> list = listarTodos();

		if (list == null)
			return false;

		boolean manterDados = false;

		for (Emprestimo e : list) {

			if (e.getId() != id) {
				cadastrarEmprestimo(e, manterDados);
				manterDados = true;
			}

		}

		return true;
	}
	
//-------------------Metodo auxiliar para criação de Id's para emprestimos------------------------

	private int setId() {

		List<Emprestimo> list = listarTodos();

		if (list == null) {
			return 1;
		}

		Emprestimo e = list.get(list.size() - 1);

		return e.getId() + 1;

	}

}
