package br.com.testedsl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.testedsl.model.Pessoa;

/**
 * será responsável por realizar as operações que dizem respeito as pessoas no
 * banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
@Repository
public class PessoaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Salva a pessoa no banco de dados.
	 * 
	 * @param pessoa
	 */
	@Transactional
	public void salvar(Pessoa pessoa) {
		entityManager.persist(pessoa);

	}

	/**
	 * Exclui a pessoa do banco de dados.
	 * 
	 * @param id
	 */
	@Transactional
	public void excluir(Integer id) {
		Pessoa pessoa = entityManager.find(Pessoa.class, id);
		entityManager.remove(pessoa);
	}

	/**
	 * Lista todas as pessoas do banco de dados.
	 * 
	 * @return lista de pessoas
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		Query query = entityManager
				.createQuery("SELECT p FROM pessoa p ORDER BY p.id ");

		return query.getResultList();
	}
}
