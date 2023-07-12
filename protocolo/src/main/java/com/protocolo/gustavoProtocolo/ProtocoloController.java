package com.protocolo.gustavoProtocolo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.protocolo.gustavoProtocolo.repository.ProtocoloRepository;
import com.protocolo.gustavoProtocolo.service.ProtocoloService;

@Controller
@RequestMapping(path = "/")
public class ProtocoloController {

	@Autowired
	private ProtocoloRepository protocoloRepo;
	
	@Autowired
  	private ProtocoloService protocoloService;

	@GetMapping(path = "protocolo") // mapeamento para get de novos protocolos
	public String getAddProtocolo(Model model) {

		Protocolo p = new Protocolo();
		model.addAttribute("protocolo", p);
		return "protocolo";

	}

	@PostMapping(path = "protocolo") // mapeamento para post novos protocolos
	public String addProtocolo(@RequestParam String doc, @RequestParam String obsProtocolo,
			@RequestParam String usuarioEnvio, @RequestParam String setor, @RequestParam String setorDestino,
			@RequestParam String dtEnvio) {

		Protocolo p = new Protocolo();
		p.setDoc(doc);
		p.setObsProtocolo(obsProtocolo);
		p.setUsuarioEnvio(usuarioEnvio);
		p.setSetor(setor);
		p.setSetorDestino(setorDestino);
		p.setDtEnvio(dtEnvio);
		protocoloRepo.save(p);
		return "redirect:/listar";

	}

	@GetMapping("/") // adicionar @ResponseBody ao método
	public String index() {
		return "index";
	}

	 /*@GetMapping(path="/listar") public @ResponseBody Iterable<Protocolo>
	 Protocolos() { return protocoloRepo.findAll(); }*/

	/*@GetMapping(path="/listar")
	public String getListarProtocolo(Model model) {
			Protocolo p = new Protocolo();
			return "listar";
	 }*/
	
	@GetMapping("/listar")
	   public String listarProtocolo(Model model){
		
		List<Protocolo> protocoloList = protocoloService.listaProtocolo();	
		model.addAttribute("protocolo", protocoloList);
		
	      return "listar";
	  	}

	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Protocolo> buscaDoc(@PathVariable Long id) {
		// Retorna um JSON ou XML com o documento
		return protocoloRepo.findById(id);
	}

	@GetMapping("/excluir/{id}")
	public @ResponseBody String excluirDoc(@PathVariable Long id) {
		protocoloRepo.deleteById(id);
		return "Movimentação xcluída.";
	}

	@PutMapping("/atualiza/{id}")
	public @ResponseBody String atualizaDoc(@PathVariable Long id, @RequestParam String doc,
			@RequestParam String obsProtocolo, @RequestParam String usuarioEnvio, @RequestParam String setor,
			@RequestParam String setorDestino) {
		Optional<Protocolo> optionalProtocolo = protocoloRepo.findById(id);
		if (optionalProtocolo.isPresent()) {
			Protocolo p = optionalProtocolo.get();
			p.setDoc(doc);
			p.setObsProtocolo(obsProtocolo);
			p.setUsuarioEnvio(usuarioEnvio);
			p.setSetor(setor);
			p.setSetorDestino(setorDestino);
			protocoloRepo.save(p);
			return "Documento atualizado";
		} else {
			return "Documento não encontrado";
		}
	}

}
