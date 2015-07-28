package br.com.testedsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.testedsl.model.Emprestimo;
import br.com.testedsl.repository.EmprestimoRepository;
import br.com.testedsl.util.Mensagem;
import br.com.testedsl.util.Mensagem.TipoMensagem;

/**
 * Classe de controle de Emprestimo
 * 
 * @author Jaime
 *
 */
@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@RequestMapping(value = "/cadastrar.do", method = RequestMethod.POST)
	public String cadastrar(Emprestimo emprestimo, Model model) {

		boolean emprestado = emprestimoRepository.getLivroPorId(emprestimo
				.getLivro().getId());

		if (emprestado) {
			model.addAttribute("mensagem", new Mensagem(
					"O livro selecionado j� est� emprestado.",
					TipoMensagem.ERRO));
		}

		emprestimoRepository.salvar(emprestimo);
		model.addAttribute("emprestimo", new Emprestimo());
		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao cadastrar empr�stimo.", TipoMensagem.SUCESSO));
		return "cadastrarEmprestimo";
	}

}
