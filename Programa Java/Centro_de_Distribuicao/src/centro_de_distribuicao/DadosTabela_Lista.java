/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro_de_distribuicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author desen
 */
public class DadosTabela_Lista {
       public int pid;   
       public String pname,dataEntrada;   
       public int pavailability;
       private Date data;
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        public DadosTabela_Lista (int pid, String pname, int pavailability, String Data) throws ParseException{   
            //initializing the variables from main   
            //function to the global variable of the class   
            this.pid = pid;   
            this.pname = pname;   
            this.pavailability = pavailability;   
            
            this.data = formato.parse(Data);
            
        }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPavailability() {
        return pavailability;
    }

    public void setPavailability(int pavailability) {
        this.pavailability = pavailability;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
