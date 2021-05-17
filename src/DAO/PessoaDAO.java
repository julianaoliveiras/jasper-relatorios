package DAO;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Pessoa;

/**
 *
 * @author Juliana Oliveira
 */
public class PessoaDAO {

    //INSERE DADOS
    public void create(Pessoa p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pessoa (nome,endereco,cpf,telefone,sexo) VALUES(?,?,?,?,?)");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getTelefone());
            stmt.setString(5, p.getSexo());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar, CPF já cadastrado..");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Ler valores que constam no BD
    public ArrayList<Pessoa> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<Pessoa> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                Pessoa cliente = new Pessoa();

                cliente.setId_pessoa(rs.getInt("id_pessoa"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSexo(rs.getString("sexo"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    //Ler valores que constam no BD
    public ArrayList<Pessoa> readForClient(String client) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<Pessoa> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE nome LIKE ?");
            stmt.setString(1, "%" + client + "%");

            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                Pessoa cliente = new Pessoa();

                cliente.setId_pessoa(rs.getInt("id_pessoa"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSexo(rs.getString("sexo"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    //Atualiza a tabela com os dados editados
    public void update(Pessoa p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE pessoa SET nome = ?, endereco = ?, telefone = ? WHERE id_pessoa = ?");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getTelefone());
            stmt.setInt(4, p.getId_pessoa());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro na atualização.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Exclui dados da tabela
    public void delete(Pessoa p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE id_pessoa = ?");

            stmt.setInt(1, p.getId_pessoa());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao excluir, cliente possui pedidos, dados não podem ser excluidos do banco de dados central.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
