package com.protocolo.gustavoProtocolo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolo.gustavoProtocolo.Protocolo;
import com.protocolo.gustavoProtocolo.repository.ProtocoloRepository;

@Service
public class ProtocoloService {

	@Autowired
	private ProtocoloRepository protocoloRepo;

	// Lista de Protocolos
	public List<Protocolo> listaProtocolo() {
		return protocoloRepo.findAll();
	}

}
