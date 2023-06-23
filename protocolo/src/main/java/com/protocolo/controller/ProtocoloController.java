package com.protocolo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.protocolo.model.Protocolo;
import com.protocolo.repository.ProtocoloRepository;

@Controller
@RequestMapping(path="/protocolo")
public class ProtocoloController {
	
	@Autowired
	private ProtocoloRepository protocoloRepo;
	
	@PutMapping(path="/novo")
	public @ResponseBody String addProtocolo(@RequestParam String doc, @RequestParam String obsProtocolo, @RequestParam String usuarioEnvio, @RequestParam String setor, @RequestParam String setorDestino, @RequestParam String dtEnvio) {
		
		Protocolo p = new Protocolo();
		p.setDoc("prontuário");
		p.setObsProtocolo("Referente à segunda parcial");
		p.setUsuarioEnvio("gustavo.diaz");
		p.setSetor("auditoria");
		p.setSetorDestino("faturamento");
		p.setDtEnvio("22/06/2023");
		protocoloRepo.save(p);
		return "Salvo no banco";
		
	}
	
	 @GetMapping(path="/todos")
	  public @ResponseBody Iterable<Protocolo> Protocolos() {
	    return protocoloRepo.findAll();
	 }
	

}
