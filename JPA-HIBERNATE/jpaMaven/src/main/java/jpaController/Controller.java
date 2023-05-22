package jpaController;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMaven.Pessoa;

//CLASSE INUTILIZADA
public class Controller {
	EntityManagerFactory emf;
	protected EntityManager em;
	
	public void criaBd () {
		emf = Persistence.createEntityManagerFactory("exemplo_jpa");//exemplo_jpa01 tem q ser o mesmo nome 'persistence-unit name 'usado no 'persistence.xml		
		emf.createEntityManager();
	}
	
	public void criaTabelaPessoa() {
		em.getTransaction().begin(); //abrir transacao com o db e criar as tabelas
	}
}
