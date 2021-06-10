package centro_de_distribuicao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author BLSoft
 */
public class Painel extends JFrame{
    private JPanel jpnPID, jpnPENAME, jpnPAVIALIABLE, jpnPrice, jpnProductRa, Display;
    private JLabel jlbPID, jlbPENAME, jlbPAVIALIABLE, jlbPrice, jlbProductRa;
    private JTextField jtfPID, jtfPENAME, jtfPAVIALIABLE, jtfPrice, jtfProductRa;

    int[] pidMain, pavailability;
    String[] pnameMain;
    double[] priceMain;
    float[] ratingMain;
    int size = 10;
    ArrayList<Product>arraylist = new ArrayList<>();
    
    class Product {
        int pid;   
        String pname;   
        int pavailability;   
        double pprice;   
        float prating;  
        Product(int pid, String pname, int pavailability, double pprice, float prating){   
            //initializing the variables from main   
            //function to the global variable of the class   
            this.pid = pid;   
            this.pname = pname;   
            this.pavailability = pavailability;   
            this.pprice = pprice;   
            this.prating = prating;  
        }
    }

    public Painel() {
        this.configurarFrame();
        this.configurarPainelCliente();
        this.add(this.jpnPID);
        this.add(this.jpnPENAME);
        this.add(this.jpnPAVIALIABLE);
        this.add(this.jpnPrice);
        this.add(this.jpnProductRa);
        
        //Painel LISTA = new Painel();
        //LISTA.addElements(pid , pname, pavi, price, rating);
    }
    private void addElements (int pid,String pname, int pavailability, double pprice,float prating){
        
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
        
        this.jpnProductRa.add(this.jlbProductRa);
        this.add(this.jtfProductRa);
        
        
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
        
        this.jlbPrice = new JLabel("Preco Produto");
        this.jtfPrice = new JTextField();
        this.jtfPrice.setBounds(615,100,150,25);
        
        this.jlbProductRa = new JLabel("Produto Avaliacao");
        this.jtfProductRa = new JTextField();
        this.jtfProductRa.setBounds(815,100,150,25);
        
        //int pid = Integer.parseInt(jtfPID.getText());
        //String pname = ;
        //int pavi = Integer.parseInt(jtfPAVIALIABLE.getText());
        //double price = Double.parseDouble(jtfPrice.getText());
        //float rating = Float.parseFloat(jtfProductRa.getText());
        
        
    }
    private void configurarFrame(){
        this.setTitle("JAnela com paineis");
        this.setSize(1050,700);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton Enter = new JButton("Adicionar");
        
        Enter.setBounds(50,600,100,50);
        Enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Adicionar_ButtonActionPerformed(e);
            }
        });
        this.add(Enter);
    }
    private void Adicionar_ButtonActionPerformed (java.awt.event.ActionEvent e){
        arraylist.add(new Product(Integer.parseInt(jtfPID.getText()),jtfPENAME.getText(),Integer.parseInt(jtfPAVIALIABLE.getText()),Double.parseDouble(jtfPrice.getText()),Float.parseFloat(jtfProductRa.getText())));
        Tabela(arraylist);
        
    }
    
    public void Tabela(ArrayList<Product> arraylist){
        this.Display = new JPanel();
        this.Display.setBounds(400,300,600,300);
        
        String[] header = {"Product ID", "Product Name","Product Quantidade", "Product Price", "Product Rating"};
        String[][] value = new String[arraylist.size()/header.length][header.length];
        
        JTable table = new JTable(value, header);
        this.Display.add(new JScrollPane(table));
        this.add(this.Display);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void displayElements(ArrayList<Product> arraylist){   
        System.out.println("Product ID" + "   Product Name" + "     Product Availability" + "    Product Price" + "   Product Rating");   
        System.out.println("-------------------------------------------------------------------------------------");      
        //iteration over the ArrayList for accessing the elements  
        for (int i = 0; i < size; i++)   
        {   
            //invoking the get() method of the ArrayList class to get the elements    
            Product product = arraylist.get(i);   
            //printing the elemnts to the console  
            System.out.println(   product.pid+"    "+  "    "  +product.pname+"               "+"  "+product.pavailability+"                "+product.pprice+ "           "+String.format("%.01f", product.prating));   
        }   
    }   
    
}
