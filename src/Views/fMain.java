package Views;

import Connection.ConnectionFactory;
import DAO.PedidoDAO;
import DAO.PessoaDAO;
import DAO.ProdutoDAO;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import java.awt.Image;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import models.Pessoa;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Juliana Oliveira
 */
public class fMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public fMain() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        produtoDAO1 = new DAO.ProdutoDAO();
        ImageIcon Icon = new ImageIcon(getClass().getResource("/imagens/preto.jpg"));
        Image image = Icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto Programação Desktop");
        setExtendedState(6);

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jMenuBar1.setName(""); // NOI18N

        jMenu1.setText("Cadastro");

        jMenu7.setText("Cadastrar");

        jMenuItem4.setText("Cliente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem3.setText("Produto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenu1.add(jMenu7);

        jMenu6.setText("Editar/Excluir");

        jMenuItem12.setText("Cliente");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuItem11.setText("Produto");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Cliente");

        jMenuItem7.setText("Visualizar/ Procurar Clentes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Relatório de Cliente");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Produto");

        jMenuItem9.setText("Visualizar/ Procurar Produtos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("Relatório de Produto");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Venda");

        jMenuItem5.setText("Realizar Venda");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Visualizar Vendas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem13.setText("Relatório de Vendas");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // CADASTRAR PRODUTO

        fCadProduto f = new fCadProduto();
        boolean aberto = false;

        f.setLocation(jDesktopPane1.getWidth() / 3, jDesktopPane1.getHeight() / 3);

        for (JInternalFrame i : jDesktopPane1.getAllFrames()) {
            if (i instanceof fCadProduto) {
                aberto = true;
                f = (fCadProduto) i;

            }
        }
        if (!aberto) {
            jDesktopPane1.add(f);
            f.setVisible(true);
        } else {
            try {
                f.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(fMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // CAD CLiente

        fCadCliente f = new fCadCliente();
        boolean aberto = false;

        f.setLocation(jDesktopPane1.getWidth() / 3, jDesktopPane1.getHeight() / 3);

        for (JInternalFrame i : jDesktopPane1.getAllFrames()) {
            if (i instanceof fCadCliente) {
                aberto = true;
                f = (fCadCliente) i;

            }
        }
        if (!aberto) {
            jDesktopPane1.add(f);
            f.setVisible(true);
        } else {
            try {
                f.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(fMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        //  editar      excluir    cliente

        fListadeClientes f = new fListadeClientes(this, true);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        //  editar   excluir   produto

        fListadeProdutos f = new fListadeProdutos(this, true);
        f.setVisible(true);

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // listar Produtos

        fListadeProdutos f = new fListadeProdutos(this, true);
        f.setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // Mostrar Login

        fLoginCliente f = new fLoginCliente(this, true);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // Visualizar vendas
        fListaDePedidos f = new fListaDePedidos(this, true);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // listar Clientes

        fListadeClientes f = new fListadeClientes(this, true);
        f.setVisible(true);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        PessoaDAO cliente = new PessoaDAO();
        
        try {
            JasperReport relatorioCompilado 
                    = JasperCompileManager.compileReport("src/Jasper/RelatorioCliente.jrxml");
            JasperPrint relatorioPreenchido= JasperFillManager.fillReport(relatorioCompilado, null, 
                    new JRBeanCollectionDataSource(cliente.read()));
            JDialog tela= new JDialog(this, "Relatório de Clientes", true);
            tela.setSize(900, 800);
            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);
            tela.getContentPane().add(painelRelatorio);
            tela.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        ProdutoDAO produto = new ProdutoDAO();
        try {
            JasperReport relatorioCompilado 
                    = JasperCompileManager.compileReport("src/Jasper/RelatorioProduto.jrxml");
            JasperPrint relatorioPreenchido= JasperFillManager.fillReport(relatorioCompilado, null, 
                    new JRBeanCollectionDataSource(produto.read()));
            JDialog tela= new JDialog(this, "Relatório de Produtos", true);
            tela.setSize(900, 800);
            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);
            tela.getContentPane().add(painelRelatorio);
            tela.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        PedidoDAO pedido = new PedidoDAO();
        try {
            JasperReport relatorioCompilado 
                    = JasperCompileManager.compileReport("src/Jasper/RelatorioVendas.jrxml");
            JasperPrint relatorioPreenchido= JasperFillManager.fillReport(relatorioCompilado, 
                    constroiParametrosPedido(), 
                    new JRBeanCollectionDataSource(pedido.read()));
            JDialog tela= new JDialog(this, "Relatório de Vendas", true);
            tela.setSize(900, 800);
            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);
            tela.getContentPane().add(painelRelatorio);
            tela.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(fMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório");
        }
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed
private Map constroiParametrosPedido(){
    Map hash = new HashMap();
    int max = Integer.valueOf(
            JOptionPane.showInputDialog(
            this,
            "Digite o número da nota fical máxima para o relatório", 
            "Entrada de Dados",
            JOptionPane.QUESTION_MESSAGE));
    hash.put("$P{numPedido}", max);
    //
    return hash; 
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private DAO.ProdutoDAO produtoDAO1;
    // End of variables declaration//GEN-END:variables
}
