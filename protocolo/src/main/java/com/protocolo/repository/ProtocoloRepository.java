package com.protocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.protocolo.model.Protocolo;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long>{

}
