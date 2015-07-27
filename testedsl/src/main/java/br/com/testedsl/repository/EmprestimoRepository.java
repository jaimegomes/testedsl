package br.com.testedsl.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.testedsl.model.Emprestimo;

/**
 * será responsável por realizar as operações que dizem respeito aos emprestimos
 * no banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
@Repository
public class EmprestimoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Verifica se a pessoa tem algum livro emprestado.
	 * 
	 * @param idPessoa
	 * @return
	 */
	public boolean PessoaHasEmprestimo(Integer idPessoa) {
		Query query = entityManager
				.createQuery("SELECT l FROM livro l WHERE l.pessoa.id=:idPessoa AND l.datahoradevolucao=:dataAtual");
		query.setParameter("idPessoa", idPessoa);
		query.setParameter("dataAtual", new Date());

		if (query.getResultList().size() > 0)
			return true;

		else
			return false;
	}

	/**
	 * Verifica se o livro está emprestado.
	 * 
	 * @param idPessoa
	 * @return
	 */
	public boolean LivroHasEmprestimo(Integer idLivro) {
		Query query = entityManager
				.createQuery("SELECT l FROM livro l WHERE l.id=:idLivro AND l.datahoradevolucao=:dataAtual");
		query.setParameter("idLivro", idLivro);
		query.setParameter("dataAtual", new Date());

		if (query.getResultList().size() > 0)
			return true;

		else
			return false;
	}

	/**
	 * Salva o emprestimo no banco de dados.
	 * 
	 * @param emprestimo
	 */
	@Transactional
	public void salvar(Emprestimo emprestimo) {
		entityManager.persist(emprestimo);
	}

	/**
	 * Exclui o emprestimo do banco de dados.
	 * 
	 * @param id
	 */
	@Transactional
	public void excluir(Integer id) {
		Emprestimo emprestimo = entityManager.find(Emprestimo.class, id);
		entityManager.remove(emprestimo);
	}

	/**
	 * Lista todos os emprestimos do banco de dados.
	 * 
	 * @return lista emprestimos
	 */
	@SuppressWarnings("unchecked")
	public List<Emprestimo> listar() {
		Query query = entityManager
				.createQuery("SELECT e FROM emprestimo e ORDER BY e.id ");

		return query.getResultList();
	}

}
