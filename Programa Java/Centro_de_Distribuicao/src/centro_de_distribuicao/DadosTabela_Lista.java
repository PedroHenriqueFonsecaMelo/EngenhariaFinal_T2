/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro_de_distribuicao;

/**
 *
 * @author desen
 */
public class DadosTabela_Lista {
       public int pid;   
        public String pname;   
        public int pavailability;   
        public float pprice;   
        public float prating;  
        public DadosTabela_Lista (int pid, String pname, int pavailability, float pprice, float prating){   
            //initializing the variables from main   
            //function to the global variable of the class   
            this.pid = pid;   
            this.pname = pname;   
            this.pavailability = pavailability;   
            this.pprice = pprice;   
            this.prating = prating; 
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

    public double getPprice() {
        return pprice;
    }

    public void setPprice(float pprice) {
        this.pprice = pprice;
    }

    public float getPrating() {
        return prating;
    }

    public void setPrating(float prating) {
        this.prating = prating;
    }
    
}
