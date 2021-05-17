package models;

/**
 *
 * @author Juliana Oliveira
 */
public class Produto {

    private int id_produto;
    private String descricao;
    private double preco_unitario;
    private String marca;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Produto() {
    }

    public Produto(int id_produto, String descricao, double preco_unitario, String marca) {
        this.id_produto = id_produto;
        this.descricao = descricao;
        this.preco_unitario = preco_unitario;
        this.marca = marca;
    }

}
