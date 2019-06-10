package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer id;
	private String objeto;
	private String pessoa;
	private String contato;
	private Date dtEmprestimo;
	private Date dtDevolucao;
	private String descricao;
	
	public Emprestimo(String objeto, String pessoa, String contato, Date dtEmprestimo, Date dtDevolucao,
			String descricao) {
		
		this.objeto = objeto;
		this.pessoa = pessoa;
		this.contato = contato;
		this.dtEmprestimo = dtEmprestimo;
		this.dtDevolucao = dtDevolucao;
		this.descricao = descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Date dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id+",");
		sb.append(this.objeto+",");
		sb.append(this.pessoa+",");
		sb.append(this.contato+",");
		sb.append(sdf.format(this.dtEmprestimo)+ ",");
		sb.append(sdf.format(this.dtDevolucao)+ ",");
		sb.append(this.descricao);
		
		return sb.toString();
	}
	
	
}
