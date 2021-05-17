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
import models.*;

/**
 *
 * @author Juliana Oliveira
 */
public class itensPedidoDAO {

    //INSERE DADOS
    public void create(itensPedido ip) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO itens_pedido (numero_pedido, preco_unitario, descricao, quantidade) VALUES(?,?,?,?)");

            stmt.setInt(1, ip.getPedido());
            stmt.setDouble(2, ip.getPreco());
            stmt.setString(3, ip.getDescricao());
            stmt.setInt(4, ip.getQuantidade());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado ao Carrinho");
        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar itens pedidos.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Ler valores que constam no BD
    public ArrayList<itensPedido> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<itensPedido> itensPedidos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM itens_pedido");
            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                itensPedido itensPedido = new itensPedido();

                //Classe Pedido;
                Pedido pedido = new Pedido();
                pedido.setNumero_pedido(rs.getInt("numero_pedido"));

                //itensPedido.setPedido(pedido);
                //Chama a classe Produto;
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setPreco_unitario(rs.getDouble("preco_unitario"));
                produto.setDescricao(rs.getString("descricao"));

                //itensPedido.setProduto(produto);
                //atributo de "Itens do Pedido"
                itensPedido.setQuantidade(rs.getInt("quantidade"));

                itensPedidos.add(itensPedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar (read).");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return itensPedidos;
    }

    //Atualiza a tabela com os dados editados
    public void update(itensPedido ip) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE itens_pedido SET id_produto = ?, preco_unitario = ?, descricao, quantidade WHERE numero_pedido = ?");

            // stmt.setInt(1, ip.getProduto().getId_produto());
            //  stmt.setDouble(2, ip.getProduto().getPreco_unitario());
            // stmt.setString(3, ip.getProduto().getDescricao());
            // stmt.setInt(4, ip.getQuantidade());
            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Exclui dados selecionados da tabela
    public void delete(itensPedido ip) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM `itens_pedido` WHERE numero_pedido = ? AND descricao = ?");

            stmt.setInt(1, ip.getPedido());
            stmt.setString(2, ip.getDescricao());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Item deletado com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao excluir.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Exclui tudo do pedido quando cancela
    public void delete(int n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM itens_pedido WHERE numero_pedido = ?");

            stmt.setInt(1, n);

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao excluir.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // pegar o ultimo numero de pedido
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

            JOptionPane.showMessageDialog(null, "Erro ao salvar numero do pedido.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return num;
    }

    // Pegar os itens do PEDIDO PRO CARRINHO/ consulta
    public ArrayList<itensPedido> carrinho(int n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<itensPedido> itensPedidos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM itens_pedido WHERE numero_pedido = ?");

            stmt.setInt(1, n);

            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                itensPedido itensPedido = new itensPedido();

                itensPedido.setQuantidade(rs.getInt("quantidade"));
                itensPedido.setDescricao(rs.getString("descricao"));
                itensPedido.setPreco(rs.getDouble("preco_unitario"));

                itensPedidos.add(itensPedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao verificar carrinho");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return itensPedidos;
    }

    
    public void deletenovo(int n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM itens_pedido WHERE numero_pedido = ?");

            stmt.setInt(1, n);

            //Executa a SQL
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(itensPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro no delete Novo!!!!");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
