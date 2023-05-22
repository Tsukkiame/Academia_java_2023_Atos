package br.com.entidades;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ManyToOne {

	public static void main( String[ ] args ) throws IOException 
	   {		
		  
		//LOGGER
		Log meuLogger = new Log("Log.txt");
		try {
			//Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");
			

		} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();//escrever no console o erro

		}
	   
				
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ManyToOne" ); //criar o gerenciador da fábrica de entidades
        EntityManager em = emf.createEntityManager(); //criar uma entidade
        meuLogger.logger.info("\nA entidade manager factory ManyToOne foi criada!!");//escrever no log
	      
        em.getTransaction().begin(); //abre a conexão para o bd com a entidade criada

        //Criando a entidade departamento
        Department department = new Department();
        //department.setId(1); //setar o nome do departamento desenvolvedor
        department.setName("Desenvolvimento"); //Definimos o nome do departamento desenvolvimento
        
        //Persist no nome definido no método set
        em.persist(department); //salvar o departamento do bd
        
        //Criando a entidade do empregado 1
        Employee emp1 = new Employee();
        emp1.setEname("Anderson");
        emp1.setSalary(1760.87);
        emp1.setDeg("Assistente Administrativo");
        emp1.setDepartment(department);

        //Criando a entidade do empregado 2
        Employee emp2 = new Employee();
        emp2.setEname("Doraci");
        emp2.setSalary(5500.0);
        emp2.setDeg("Analista Sênior");
        emp2.setDepartment(department);

        //Criando a entidade do empregado 3
        Employee emp3 = new Employee();
        emp3.setEname("Caio");
        emp3.setSalary(1345.0);
        emp3.setDeg("Estagiário");
        emp3.setDepartment(department);
        
      //Criando a entidade do empregado 4
        Employee emp4 = new Employee();
        emp4.setEname("Guilherme");
        emp4.setSalary(6450.0);
        emp4.setDeg("Médico Intensivista");
        department.setName("UTI");
        emp4.setDepartment(department);

        //Armazenando no bd os empregados 1,2 e 3 
        em.persist(emp1);
        em.persist(emp2);
        em.persist(emp3);
        em.persist(emp4);

        em.getTransaction().commit();//fechar a conexão com o bd
        em.close(); //Encerrar o gerenciador da entidade
        emf.close(); //fechar a fábrica de entidades
   }
}
