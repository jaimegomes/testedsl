package br.com.testedsl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.testedsl.model.Livro;

/**
 * será responsável por realizar as operações que dizem respeito aos livros no
 * banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
@Repository
public class LivroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Salva o livro no banco de dados.
	 * 
	 * @param livro
	 */
	@Transactional
	public void salvar(Livro livro) {
		entityManager.persist(livro);
	}


	/**
	 * Exclui o livro do banco de dados.
	 * 
	 * @param id
	 */
	@Transactional
	public void excluir(Integer id) {
		Livro livro = entityManager.find(Livro.class, id);
		entityManager.remove(livro);
	}

	/**
	 * Lista todos os livros do banco de dados.
	 * 
	 * @return lista de livros
	 */
	@SuppressWarnings("unchecked")
	public List<Livro> listar() {
		Query query = entityManager
				.createQuery("SELECT l FROM Livro l ORDER BY l.idLivro ");

		return query.getResultList();
	}

}
