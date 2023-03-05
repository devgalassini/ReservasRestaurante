package br.com.puglia.galassini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.puglia.galassini.dao.ClientesDao;
import br.com.puglia.galassini.models.Clientes;

@Controller
public class ClienteController {

	
	

	@Autowired
		private ClientesDao clientesDao; 


	@GetMapping("/reserva/inicio")
		public ModelAndView iniciar () {
			return new ModelAndView("reserva/index"); 
		}

	@GetMapping("/reserva/listar") 
		public ModelAndView listar (Model model) {
			try {
				List<Clientes> clientes = clientesDao.listarClientes();
				model.addAttribute("clientes", clientes);
				return new ModelAndView("reserva/listaClientes");
			} catch (Exception e) {
				model.addAttribute("mensagem", e.getMessage());
				return new ModelAndView("erro");
			}
		}

	@GetMapping("/reserva/incluir")
		public String incluir (Model model) {
			try {
				return "eventos/novo";
			} catch (Exception e) {
				model.addAttribute("mensagem", e.getMessage());
				return "erro";
			}
		}

	@PostMapping("/cadevento")
		public String incluir (Evento evento, @RequestParam("dataEvento") String dataEvento, Model model) {
			try {
				Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataEvento);
				evento.setData(data);
				eventosDao.incluiEvento(evento);
				return "redirect:/eventos/listar";
			} catch (Exception e) {
				model.addAttribute("mensagem", e.getMessage());
				return "erro";
			}
		}

	
	@GetMapping("/eventos/alterar/{idEvento}")
			public String alterar (@PathVariable("idEvento") int id, Model model) {
				try {
					Evento evento = eventosDao.buscarEvento(id);
					if (evento == null) {
						throw new Exception("Nenhum evento com ID informado.");
					}
					model.addAttribute("evt", evento);
					return "eventos/alterarEvento";
				} catch (Exception e) {
					model.addAttribute("mensagem", e.getMessage());
					return "erro";
				}
			}

	@PostMapping("/alteraevento")
			public String alterar (Evento evento, @RequestParam("dataEvento") String dataEvento, Model model) {
				try {
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataEvento);
					evento.setData(data);
					eventosDao.alterarEvento(evento);
					return "redirect:/eventos/listar";
				} catch (Exception e) {
					model.addAttribute("mensagem", e.getMessage());
					return "erro";
				}
			}

	@GetMapping("/eventos/excluirEvento/{id}")
			public String excluir(@PathVariable("id") int id, Model model) {
			try {
			eventosDao.excluirEvento(id);
			return "redirect:/eventos/listar";
			} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
					}
				}
}
