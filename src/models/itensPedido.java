package models;

/**
 *
 * @author Juliana Oliveira
 */
public class itensPedido {

    private int pedido;
    private int quantidade;
    private String descricao;
    private Double preco;

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public itensPedido() {
    }

    public itensPedido(int pedido, int quantidade, String descricao, Double preco) {
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
