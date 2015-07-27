package br.com.testedsl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Model Livro
 * @author Jaime
 *
 */
@Table(name = "livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	@Size(max = 100, message = "O nome do livro deve conter no máximo 100 caracteres.")
	private String nome;

	@Column(name = "escritor")
	@Size(max = 100, message = "O nome do escritor deve conter no máximo 100 caracteres.")
	private String escritor;

	@Column(name = "anoedicao")
	private Integer anoEdicao;

	@Column(name = "classificacao")
	private Integer classificacao;

	public Livro() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the escritor
	 */
	public String getEscritor() {
		return escritor;
	}

	/**
	 * @param escritor
	 *            the escritor to set
	 */
	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	/**
	 * @return the anoEdicao
	 */
	public Integer getAnoEdicao() {
		return anoEdicao;
	}

	/**
	 * @param anoEdicao
	 *            the anoEdicao to set
	 */
	public void setAnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	/**
	 * @return the classificacao
	 */
	public Integer getClassificacao() {
		return classificacao;
	}

	/**
	 * @param classificacao
	 *            the classificacao to set
	 */
	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

}
