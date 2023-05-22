package Services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Produto;
import Repository.Repository;

public class Services {
	Repository repository = new Repository();
	
    public String nome;

    public Services() throws IOException {

    }

    public List<Produto> buscarTodosProduto() throws SQLException {
    	
        List<Produto> listaProdutos = new ArrayList<Produto>();
        final String db_query = "SELECT * FROM produto";
        ResultSet resultSet = this.repository.consultar(db_query);

        while (resultSet.next()) {
        	Produto produto = new Produto();
        	produto.setId(resultSet.getInt("id"));
        	produto.setCodigo(resultSet.getString("codigo"));
        	produto.setNome(resultSet.getString("nome"));
        	produto.setCategoria(resultSet.getString("categoria"));
        	produto.setValor(resultSet.getFloat("valor"));
        	produto.setQuantidade(resultSet.getInt("quantidade"));
        	listaProdutos.add(produto);     
        }
        return listaProdutos;
    }

    public Produto buscarProduto(String id) throws SQLException {
    	Produto produto = new Produto();
        final String db_query = "SELECT * FROM produto WHERE id ="+id ;
        ResultSet resultSet = this.repository.consultar(db_query);
        while (resultSet.next()) {
        	produto.setId(resultSet.getInt("id"));
        	produto.setCodigo(resultSet.getString("codigo"));
        	produto.setNome(resultSet.getString("nome"));
        	produto.setCategoria(resultSet.getString("categoria"));
        	produto.setValor(resultSet.getFloat("valor"));
        	produto.setQuantidade(resultSet.getInt("quantidade"));

        }
        return produto;
    }

    public void novoProduto(String codigo, String nome, String categoria, float valor, int quantidade) throws SQLException {
        String db_query = " INSERT INTO produto (codigo, nome, categoria, valor, quantidade) VALUES ('" + codigo + "', '" + nome + "', '" + categoria + "', " + valor + ", " + quantidade + " )";
        System.out.println(db_query);
        this.repository.inserirAlterarExcluir(db_query);
    }

    public void attProduto(int id, String codigo, String nome, String categoria, float valor, int quantidade) throws SQLException {
        String db_query = " UPDATE produto SET  codigo= '"+codigo+"', nome= '"+nome+"', categoria='"+categoria+"', valor='"+valor+"', quantidade='"+quantidade+"' WHERE ID ="+ id;
        this.repository.inserirAlterarExcluir(db_query);
    }
    
    public void excluirProduto(int id) throws SQLException {
        String db_query = "DELETE FROM produto WHERE ID =" + id;
        this.repository.inserirAlterarExcluir(db_query);
    }

}
