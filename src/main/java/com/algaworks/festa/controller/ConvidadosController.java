package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;


@Controller
public class ConvidadosController {

	
	//Essa anotação injeta o repositório aqui no controller
	@Autowired
	private Convidados convidados;

	@GetMapping("/")
    public String teste() {
		/*Lembre-se de que a página no template tem que ter o 
		mesmo nome da string abaixo 
		(/gestao-festa/src/main/resources/templates/index.html).*/
        return "index";
    }	
	
	//responder requisição HTTP do tipo GET para /convidados com esse metodo listar.
	//Quando digitarem /convidados na url esse metodo será executado.
	@GetMapping("/convidados")
	/*Nesse metodo vamos usar ModelAndView para recuperar os dados do repositorio de convidados aqui no controlador. Pegar a lista
	 * de convidados aqui no controlador. 
	 * Essa lista é adicionada no ModelAndView
	 */
	public ModelAndView listar() {		
		ModelAndView mv = new ModelAndView("ListaConvidados");
		
		mv.addObject("convidados", convidados.findAll());
		
		//objeto que modela o formulário. É nele que colocaremos os valores que serão apanhados lá na página, na view.		
		mv.addObject(new Convidado());
		
		return mv;
		}
	
	/*Esse metodo salvar responderá especificamente as requisições do tipo Post feita para /convidados.
	 * Veja que recebemos um Convidado que é um objeto que virá da view com os dados do convidado preenchidos no form de lá.
	 */
	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {
		//Salva os dados vindos do form da view no repositorio, no BD.
		this.convidados.save(convidado);
		//Depois de salvar os dados no repositorio vai para /convidados, ou seja vai atualizar a página.
		return "redirect:/convidados";
		
	}

}
