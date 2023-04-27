package com.ExcJDBC;

import java.sql.*;

public class BancoDados implements InterfaceBancoDados {

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		bd.conectar("jdbc:mysql://localhost:3312/reuniao", "root", "");
		bd.consultar("select * from pessoa");
		
		bd.inserirAlterarExcluir("insert into pessoa (nome, email, cargo) values ('Ruan Guimarães','ruanzito@hotmail.com','Professor')");
		
		bd.inserirAlterarExcluir("insert into pessoa (nome, email, cargo) values ('Alex Sandro do Carmo','ascarmo@gmail.com','Aluno')");
		
		bd.inserirAlterarExcluir("insert into pessoa (nome, email, cargo) values ('Helena Bueno Silva','helena.silva@ufn.edu.br','Diretor')");
		
		bd.consultar("select * from pessoa");
		
		bd.desconectar();
	}

	@Override
	public void conectar(String db_url, String db_user, String db_password) {
		try (Connection c = DriverManager.getConnection(db_url, db_user, db_password);) {
			System.out.println("Conectando ao BD...");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível conectar ao BD: "+e);
		}
	}

	@Override
	public void desconectar() {
		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3312/reuniao", "root", "");) {
			c.close();
			System.out.println("Conexão com o Banco encerrada.");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sem conexão ao Banco de Dados: "+e);
			}
		
	}

	@Override
	public void consultar(String db_query) {
		
		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3312/reuniao", "root", "");) {
			Statement ps = c.createStatement();
			ResultSet rs = ps.executeQuery(db_query);
		
			while(rs.next()) {
				System.out.println(rs.getString(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+" \t"+rs.getString(4));
				}
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sem conexão ao Banco de Dados: "+e);
			}
	}

	@Override
	public void inserirAlterarExcluir(String db_query) {
		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3312/reuniao", "root", "");) {
			PreparedStatement ps = c.prepareStatement(db_query);
			System.out.println("Linhas modificadas: "+ps.executeUpdate());
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sem conexão ao Banco de Dados: "+e);
			}
		
	}
}
