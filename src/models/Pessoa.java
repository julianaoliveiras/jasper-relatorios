package models;

/**
 *
 * @author Juliana Oliveira
 */
public class Pessoa {

    private int id_pessoa;
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
    private String sexo;

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    public Pessoa(int id_pessoa, String nome, String endereco, String cpf, String telefone, String sexo) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
    }

}
