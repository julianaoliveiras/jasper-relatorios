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
import models.Produto;

/**
 *
 * @author Juliana Oliveira
 */
public class ProdutoDAO {

    //INSERE DADOS
    public void create(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao,preco_unitario,marca) VALUES(?,?,?)");

            stmt.setString(1, p.getDescricao());
            stmt.setDouble(2, p.getPreco_unitario());
            stmt.setString(3, p.getMarca());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Ler valores que constam no BD
    public ArrayList<Produto> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId_produto(rs.getInt("id_produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_unitario(rs.getDouble("preco_unitario"));
                produto.setMarca(rs.getString("marca"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    //Ler valores que constam no BD
    public ArrayList<Produto> readForDescr(String descr) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //Listar os itens

        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%" + descr + "%");

            rs = stmt.executeQuery();

            //Mostrar valores dentro da tabela
            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId_produto(rs.getInt("id_produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_unitario(rs.getDouble("preco_unitario"));
                produto.setMarca(rs.getString("marca"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao salvar.");

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    //Atualiza a tabela com os dados editados (Para o Botão EDITAR)
    public void update(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ?, preco_unitario = ?, marca = ? WHERE id_produto = ?");

            stmt.setString(1, p.getDescricao());
            stmt.setDouble(2, p.getPreco_unitario());
            stmt.setString(3, p.getMarca());
            stmt.setInt(4, p.getId_produto());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro na atualização.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Exclui dados da tabela
    public void delete(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id_produto = ?");

            stmt.setInt(1, p.getId_produto());

            //Executa a SQL
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Erro ao excluir.");

        } finally { //fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
