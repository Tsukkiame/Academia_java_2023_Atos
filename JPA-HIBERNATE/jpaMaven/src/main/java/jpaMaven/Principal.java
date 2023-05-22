package jpaMaven;

import java.io.IOException;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import br.com.loggin.Log;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		//LOGGER
		Log meuLogger = new Log("Log.txt");
		try {
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");
			} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();//escrever no console o erro

		}
		Pessoa p;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_jpa");//exemplo_jpa01 tem q ser o mesmo nome 'persistence-unit name 'usado no 'persistence.xml
		EntityManager em = emf.createEntityManager();
		meuLogger.logger.info("\nA entidade manager factory exemplo_jpa foi criada!!");//escrever no log
		
		em.getTransaction().begin(); //abrir transacao com o db e criar as tabelas
        
        //para inserir dados na tabela (objetos criados acima 3 pessoas)
		Pessoa p1 = new Pessoa(null, "Joseane", "46782155912", "jose@gmail.com", "Professor");
		Pessoa p2 = new Pessoa(null, "Perseu", "56489763210", "percy@gmail.com", "Aluno");
		Pessoa p3 = new Pessoa(null, "Polidore", "01240028922", "polidore@gmail.com", "Funcionário");
		Pessoa p4 = new Pessoa(null, "Guillermo", "03456478921", "guille.owns@gmail.com", "Intercambista");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		//após criar as pessoas, usamos o persist para criar a pessoa na tabela
        em.persist(p1);  //persist serve para uma criar pessoa na tabela
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        
        //usando o find com o ID conseguimos fazer a seleção dos registros para UPDATE
        p = em.find(Pessoa.class, 1); //(poderia utilizar um get de nome/cpf para usar no find)
        System.out.println("Pessoa: "+p);
        p.setNome("Andre");  //O set serve para alterarmos o campo que desejamos como se fosse um UPDATE
        
        //utilizando "DELETE" com o remove
        p = em.find(Pessoa.class, 4); //'find' serve para pesquisar nesse caso obter pelo id
        System.out.println("Pessoa: "+p);
        em.remove(p);
        
      //fechamos transacao com o db
		em.getTransaction().commit(); 
		em.close();
		emf.close();
	}

}
