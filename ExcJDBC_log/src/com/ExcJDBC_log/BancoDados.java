package com.ExcJDBC_log;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;

public class BancoDados implements InterfaceBancoDados {
	
	private Connection c;
	static Log log;

	public static void main(String[] args) throws IOException  {
		
		log = new Log("Log.txt");
		try {
			log.logger.setLevel(Level.INFO);
			/*não necessário já que são inserções exemplo
			 * log.logger.info("Log de informação");
			log.logger.warning("Log de Aviso");
			log.logger.severe("Log Severo");*/
		} catch (Exception e) {
			log.logger.severe("Aviso de exceção: "+e.getMessage());
			System.out.println("Falha: " + e);
		}
		
		BancoDados bd = new BancoDados();
		bd.conectar("jdbc:mysql://localhost:3312/reuniao", "root", "");
		
		bd.consultar("select * from pessoa");
		
		bd.inserirAlterarExcluir("insert into pessoa (nome, email, cargo) values ('Breno Josias','br3n0@hotmail.com','Professor')");
		
		bd.inserirAlterarExcluir("insert into pessoa (nome, email, cargo) values ('Diogo Freitas Madureira','dioguito.owns@gmail.com','Aluno')");
		
		bd.inserirAlterarExcluir("insert into pessoa (nome, email, cargo) values ('Lívia Khrone Luz','livia.luz@ufn.edu.br','Supervisor')");
		
		bd.consultar("select * from pessoa");
		
		bd.desconectar();
	}

	@Override
	public void conectar(String db_url, String db_user, String db_password) {
		try {
			c = DriverManager.getConnection(db_url, db_user, db_password);
			log.logger.info("Conexão com Banco iniciada");
			System.out.println("Conectando ao BD...");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível conectar ao BD: "+e);
			log.logger.severe("Falha de conexão com o Banco: "+e);
		}
	}

	@Override
	public void desconectar() {
			try {
				c.close();
				System.out.println("Conexão com o Banco encerrada.");
				log.logger.info("Conexão com Banco encerrada.");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sem conexão ao Banco de Dados: "+e);
			}
		
	}

	@Override
	public void consultar(String db_query) {
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3312/reuniao", "root", "");
			PreparedStatement ps = c.prepareStatement(db_query);
			ResultSet rs = ps.executeQuery();
			log.logger.info("Consulta realizada no banco: "+db_query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+" \t"+rs.getString(4));
				}
			log.logger.info(rs.getString(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+" \t"+rs.getString(4));
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sem conexão ao Banco de Dados: "+e);
			}
	}

	@Override
	public void inserirAlterarExcluir(String db_query) {
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3312/reuniao", "root", "");
			PreparedStatement ps = c.prepareStatement(db_query);
			System.out.println("Linhas modificadas: "+ps.executeUpdate());
			log.logger.info("Quantidade de modificações realizadas: "+ps.executeUpdate());
			log.logger.warning("Modificação realizada: "+db_query);
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sem conexão ao Banco de Dados: "+e);
			}
		
	}
}
