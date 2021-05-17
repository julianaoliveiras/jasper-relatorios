package models;

/**
 *
 * @author Juliana Oliveira
 */
public class Pedido {

    private int numero_pedido;
    private int NF;
    private String data_pedido;
    private Pessoa pessoa;

    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public int getNF() {
        return NF;
    }

    public void setNF(int NF) {
        this.NF = NF;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pedido() {
    }

    public Pedido(int numero_pedido, int NF, String data_pedido, Pessoa pessoa) {
        this.numero_pedido = numero_pedido;
        this.NF = NF;
        this.data_pedido = data_pedido;
        this.pessoa = pessoa;
    }

}
