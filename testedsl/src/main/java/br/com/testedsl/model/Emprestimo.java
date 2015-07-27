package br.com.testedsl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model Emprestimo
 * 
 * @author Jaime
 *
 */

@Entity
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 7064809078222302493L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dataemprestimo")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataEmprestimo;

	@Column(name = "idpessoa")
	private Integer idPessoa;

	@Column(name = "idlivro")
	private Integer idLivro;

	@Column(name = "datahoradevolucao")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraDevolucao;

	public Emprestimo() {
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
	 * @return the dataEmprestimo
	 */
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * @param dataEmprestimo
	 *            the dataEmprestimo to set
	 */
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * @return the idPessoa
	 */
	public Integer getIdPessoa() {
		return idPessoa;
	}

	/**
	 * @param idPessoa
	 *            the idPessoa to set
	 */
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	/**
	 * @return the idLivro
	 */
	public Integer getIdLivro() {
		return idLivro;
	}

	/**
	 * @param idLivro
	 *            the idLivro to set
	 */
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	/**
	 * @return the dataHoraDevolucao
	 */
	public Date getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}

	/**
	 * @param dataHoraDevolucao
	 *            the dataHoraDevolucao to set
	 */
	public void setDataHoraDevolucao(Date dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
