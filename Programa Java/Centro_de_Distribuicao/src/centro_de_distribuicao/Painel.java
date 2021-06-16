package centro_de_distribuicao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import administrativo.*;

/**
 *
 * @author BLSoft
 */
public class Painel extends JFrame{
    private JPanel jpnPID, jpnPENAME, jpnPAVIALIABLE, jpnPrice, jpnProductRa, Display;
    private JLabel jlbPID, jlbPENAME, jlbPAVIALIABLE, jlbPrice, jlbProductRa;
    private JTextField jtfPID, jtfPENAME, jtfPAVIALIABLE, jtfPrice, jtfProductRa;
    private JTable tabela;
    private JScrollPane scrollPainel;
    

    int pidMain, pavailability;
    String pnameMain;
    String priceMain;
    float ratingMain;
    int size = 10;
    //private String[] colunas = {"PID", "Nome Produto", "Quantidade Produto","Data de Entrega"};
    ArrayList<DadosTabela_Lista> arraylist = new ArrayList<>();
    TabelaModel model = new TabelaModel(arraylist);
    
    ArrayList<Protocolo> protc_desap_produtos = new ArrayList<>();
    public Painel() {
        this.configurarFrame();
        this.configurarPainelCliente();
        this.add(this.jpnPID);
        this.add(this.jpnPENAME);
        this.add(this.jpnPAVIALIABLE);
        this.add(this.jpnPrice);
    }
   
    private void configurarPainelCliente(){
        this.jpnPID = new JPanel();
        this.jpnPID.setBounds(0,50,150,200);
        
        this.jpnPENAME = new JPanel();
        this.jpnPENAME.setBounds(200,50,150,25);
        
        this.jpnPAVIALIABLE = new JPanel();
        this.jpnPAVIALIABLE.setBounds(400,50,150,25);
        
        this.jpnPrice = new JPanel();
        this.jpnPrice.setBounds(600,50,150,25);
        
        this.jpnProductRa = new JPanel();
        this.jpnProductRa.setBounds(800,50,150,25);
        
        
        this.configurarDadosCliente();
       
        this.jpnPID.add(this.jlbPID);
        this.add(this.jtfPID);
        
        this.jpnPENAME.add(this.jlbPENAME);
        this.add(this.jtfPENAME);
        
        this.jpnPAVIALIABLE.add(this.jlbPAVIALIABLE);
        this.add(this.jtfPAVIALIABLE);
        
        this.jpnPrice.add(this.jlbPrice);
        this.add(this.jtfPrice);
    }
    private void configurarDadosCliente(){
        this.jlbPID = new JLabel("PID");
        this.jtfPID = new JTextField();
        this.jtfPID.setBounds(15,100,150,25);
        
        this.jlbPENAME = new JLabel("Nome Produto");
        this.jtfPENAME = new JTextField();
        this.jtfPENAME.setBounds(215,100,150,25);
        
        this.jlbPAVIALIABLE = new JLabel("Quantidade Produto");
        this.jtfPAVIALIABLE = new JTextField();
        this.jtfPAVIALIABLE.setBounds(415,100,150,25);
        
        this.jlbPrice = new JLabel("Data Maxima de Entrega");
        this.jtfPrice = new JTextField();
        this.jtfPrice.setBounds(615,100,150,25);
        
       
        
    }
    private void Dados(){
        pidMain = Integer.parseInt(jtfPID.getText());
        pnameMain = jtfPENAME.getText();
        pavailability = Integer.parseInt(jtfPAVIALIABLE.getText());
        priceMain = jtfPrice.getText();
        SwingUtilities.updateComponentTreeUI(this);
    }
    private void configurarFrame(){
        this.setTitle("JAnela com paineis");
        this.setSize(1050,700);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton Enter = new JButton("Registrar");
        JButton Deletar = new JButton("Deletar");
        JButton Pesquisar = new JButton("Pesquisar");
        JButton desaparecimento = new JButton("Desaparecimento de produto");
       
        Enter.setBounds(50,500,100,50);
        Deletar.setBounds(50,400,100,50);
        Pesquisar.setBounds(50,300,100,50);
        desaparecimento.setBounds(50,600,150,50);
        
        Enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Adicionar_ButtonActionPerformed(e);
                } catch (ParseException ex) {
                    Logger.getLogger(Painel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Deletar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Deletar_ButtonActionPerformed(e);
            }
        });
        Pesquisar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Pesquisar_ButtonActionPerformed(e);
            }
        });
        desaparecimento.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                protocol_desaparecimentoActionPerformed(e);
            }
        });
        this.add(Enter);
        this.add(Deletar);
        this.add(Pesquisar);
        this.add(desaparecimento);
    }
    private void protocol_desaparecimentoActionPerformed(ActionEvent e){
        boolean valido = false;
        Protocolo novo = null;
        boolean registrar = true;
        while(!valido){
            novo = Protocolo_Desaparecimento.novoProtocolo();
            if(produtoExiste(novo.getId_produto())){
                valido = true;
            }
            else{
                int opcao = JOptionPane.showConfirmDialog (null, "Produto não encontrado no sistema, deseja tentar novamente?","Aviso",JOptionPane.YES_NO_OPTION);
                if(opcao == JOptionPane.NO_OPTION){
                    valido = true;
                    registrar = false;
                }
            }
        }
        if(registrar){
            protc_desap_produtos.add(novo);
        }
    }
    private void Adicionar_ButtonActionPerformed (java.awt.event.ActionEvent e) throws ParseException{
        Dados();
        arraylist.add(new DadosTabela_Lista(pidMain, pnameMain,pavailability,priceMain));
        Tabela(arraylist);
    }
    private void Deletar_ButtonActionPerformed (java.awt.event.ActionEvent e){
        Dados();
        RemoverDaTabela(pidMain);
    }
    private void Pesquisar_ButtonActionPerformed (java.awt.event.ActionEvent e){
        Dados();
        PesquisarDaTabela(pidMain);
    }
    public void Tabela(ArrayList<DadosTabela_Lista> arraylist){
        
        this.tabela = new JTable(model);
        this.tabela.setBorder(BorderFactory.createEmptyBorder());
        this.scrollPainel = new JScrollPane(tabela);
        this.scrollPainel.setBounds(300,200,600,400);
        this.add(scrollPainel);
        SwingUtilities.updateComponentTreeUI(this);
    } 
    public void RemoverDaTabela(int alvo){
        for(int i = 0; i<arraylist.size(); i++){
            DadosTabela_Lista Rpid = arraylist.get(i);
            if(Rpid.getPid() == alvo){
                arraylist.remove(Rpid);
                if(arraylist.isEmpty()){
                    scrollPainel.setVisible(false);
                    break;
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void PesquisarDaTabela(int alvo) {
       for(int i = 0; i<arraylist.size(); i++){
            DadosTabela_Lista Rpid = arraylist.get(i);
            if(Rpid.getPid() == alvo){
                JOptionPane.showMessageDialog(this, dados(arraylist, i));
            }
        }
        SwingUtilities.updateComponentTreeUI(this);
   }
    public boolean produtoExiste(int id){
        for(int i = 0; i < arraylist.size(); i++){
            DadosTabela_Lista prod = arraylist.get(i);
            if(prod.getPid() == id){
                return true;
            }
        }
        return false;
    }
    private String dados (ArrayList<DadosTabela_Lista> arraylist, int i){
        String tudo;
        DadosTabela_Lista R = arraylist.get(i);
        tudo = "Indice: " + R.getPid() + "\nNome: " + R.getPname() + "\nData Max de Entrega: " + R.getData() + "\nQuantidade: " + R.getPavailability();
        return tudo;
    }
         
}
