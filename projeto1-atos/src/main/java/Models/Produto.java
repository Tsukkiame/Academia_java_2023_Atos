package Models;

import java.text.NumberFormat;

public class Produto {
	private int id;
	private String codigo;
	private String nome;
	private String categoria;
	private float valor;
	private int quantidade;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", categoria=" + categoria + ", valor="
				+ valor + ", quantidade=" + quantidade + "]";
	}

	public Produto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getValor() {
		
		return NumberFormat.getCurrencyInstance().format(this.valor);
	}
	public Float getValorEdicao() {
		
		return this.valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
