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
    private JPanel jpnPID, jpnPENAME, jpnPAVIALIABLE, jpnPrice, jpnProductRa;
    private JLabel jlbPID, jlbPENAME, jlbPAVIALIABLE, jlbPrice, jlbProductRa;
    private JTextField jtfPID, jtfPENAME, jtfPAVIALIABLE, jtfPrice, jtfProductRa;

    int[] pidMain, pavailability;
    String[] pnameMain;
    double[] priceMain;
    float[] ratingMain;
    int size = 10;
    
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
    private void addElements (int pid[],String pname[], int pavailability[], double pprice[],float prating[]){
        ArrayList<Product>arraylist = new ArrayList<>();
        for (int i = 0; i<size; i++){
            arraylist.add(new Product (pid[i],pname[i],pavailability[i],pprice[i],prating[i]));
        }
        
    }
    private void configurarPainelCliente(){
        this.jpnPID = new JPanel(new FlowLayout());
        this.jpnPID.setPreferredSize(new Dimension(250, 50));
        
        this.jpnPENAME = new JPanel(new FlowLayout());
        this.jpnPENAME.setPreferredSize(new Dimension(250, 50));
        
        this.jpnPAVIALIABLE = new JPanel(new FlowLayout());
        this.jpnPAVIALIABLE.setPreferredSize(new Dimension(250, 50));
        
        this.jpnPrice = new JPanel(new FlowLayout());
        this.jpnPrice.setPreferredSize(new Dimension(250, 50));
        
        this.jpnProductRa = new JPanel(new FlowLayout());
        this.jpnProductRa.setPreferredSize(new Dimension(250, 50));
        
        
        this.configurarDadosCliente();
       
        this.jpnPID.add(this.jlbPID);
        this.jpnPID.add(this.jtfPID);
        
        this.jpnPENAME.add(this.jlbPENAME);
        this.jpnPENAME.add(this.jtfPENAME);
        
        this.jpnPAVIALIABLE.add(this.jlbPAVIALIABLE);
        this.jpnPAVIALIABLE.add(this.jtfPAVIALIABLE);
        
        this.jpnPrice.add(this.jlbPrice);
        this.jpnPrice.add(this.jtfPrice);
        
        this.jpnProductRa.add(this.jlbProductRa);
        this.jpnProductRa.add(this.jtfProductRa);
        
        
    }
    private void configurarDadosCliente(){
        this.jlbPID = new JLabel("Nome cliente");
        this.jtfPID = new JTextField();
        this.jtfPID.setPreferredSize(new Dimension(300,25));
        
        this.jlbPENAME = new JLabel("Nome cliente");
        this.jtfPENAME = new JTextField();
        this.jtfPENAME.setPreferredSize(new Dimension(300,25));
        
        this.jlbPAVIALIABLE = new JLabel("Nome cliente");
        this.jtfPAVIALIABLE = new JTextField();
        this.jtfPAVIALIABLE.setPreferredSize(new Dimension(300,25));
        
        this.jlbPrice = new JLabel("Nome cliente");
        this.jtfPrice = new JTextField();
        this.jtfPrice.setPreferredSize(new Dimension(300,25));
        
        this.jlbProductRa = new JLabel("Nome cliente");
        this.jtfProductRa = new JTextField();
        this.jtfProductRa.setPreferredSize(new Dimension(300,25));
        
        //int pid = Integer.parseInt(jtfPID.getText());
        //String pname = jtfPENAME.getText();
        //int pavi = Integer.parseInt(jtfPAVIALIABLE.getText());
        //double price = Double.parseDouble(jtfPrice.getText());
        //float rating = Float.parseFloat(jtfProductRa.getText());
        
        
    }
    private void configurarFrame(){
        this.setTitle("JAnela com paineis");
        this.setSize(1000,1000);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton Enter = new JButton("Adicionar");
        Enter.setPreferredSize(new Dimension(300,25));
        Enter.setLayout(new FlowLayout());
        Enter.setLocation(100, 900);
        Enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        add(Enter);
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
