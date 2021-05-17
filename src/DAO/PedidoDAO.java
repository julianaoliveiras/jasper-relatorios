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
import models.Pedido;
import models.Pessoa;

/**
 *
 * @author Juliana Oliveira
 */
public class PedidoDAO {

    //INSERE DADOS
    public void create(Pedido p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pedido (numero_pedido,data_pedido,id_pessoa) VALUES(?,?,?)");

            stmt.setInt(1, p.getNumero_pedido());
            stmt.setString(2, p.getData_pedido());
            stmt.setInt(3, p.getPessoa().getId_pessoa());                 //Composição de chave estrangeira

            //Executa a SQL
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Ler valores que constam no BD
    public ArrayList<Pedido> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pedido");
            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                Pedido pedido = new Pedido();

                pedido.setNF(rs.getInt("NF"));
                pedido.setNumero_pedido(rs.getInt("numero_pedido"));
                pedido.setData_pedido(rs.getString("data_pedido"));

                //Chama a classe Pessoa;
                Pessoa pessoa = new Pessoa();
                pessoa.setId_pessoa(rs.getInt("id_pessoa"));

                pedido.setPessoa(pessoa);

                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
    }

    //Atualiza a tabela com os dados editados
    public void update(Pedido p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE pedido SET numero_pedido = ?, data_pedido = ?, id_pessoa = ? WHERE NF = ?");

            stmt.setInt(1, p.getNumero_pedido());
            stmt.setString(2, p.getData_pedido());
            stmt.setInt(3, p.getPessoa().getId_pessoa());                 //Composição de chave estrangeira

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Exclui dados da tabela
    public void delete(int n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pedido WHERE numero_pedido = ?");

            stmt.setInt(1, n);

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Voltando ao Menu Principal");

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao excluir.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //teste para pegar o ultimo numero de pedido
    public int numero() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        int num = 0;

        try {
            stmt = con.prepareStatement("SELECT * FROM pedido ORDER BY numero_pedido DESC LIMIT 1");
            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                num = rs.getInt("numero_pedido");

            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return num;
    }

    //Buscar o nome do cliente para a lista de pedidos
    public String ProcuraNome(Pedido p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        String nome = null;

        ArrayList<Pessoa> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa where id_pessoa = ?");
            stmt.setInt(1, p.getPessoa().getId_pessoa());

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

                nome = cliente.getNome();

            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nome;
    }

    public ArrayList<Pedido> excluirpegarpedidos(Pessoa p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pedido where id_pessoa = ?");
            stmt.setInt(1, p.getId_pessoa());
            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                Pedido pedido = new Pedido();

                pedido.setNF(rs.getInt("NF"));
                pedido.setNumero_pedido(rs.getInt("numero_pedido"));
                pedido.setData_pedido(rs.getString("data_pedido"));

                //Chama a classe Pessoa;
                Pessoa pessoa = new Pessoa();
                pessoa.setId_pessoa(rs.getInt("id_pessoa"));

                pedido.setPessoa(pessoa);

                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro no FOR.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
    }

    public void deletenovo(int n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pedido WHERE numero_pedido = ?");

            stmt.setInt(1, n);

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Voltando ao Menu Principal");

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao excluir.PEDIDODAOOOOOOOO");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
