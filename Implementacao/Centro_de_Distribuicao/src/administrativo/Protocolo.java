package administrativo;

import java.util.Date;

public class Protocolo {
    private int id_funcionario;
    private int id_produto;
    private Date data;
    
    public Protocolo(int id_funcionario, int id_produto, Date data){
        this.id_funcionario = id_funcionario;
        this.id_produto = id_produto;
        this.data = data;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public int getId_produto() {
        return id_produto;
    }

    public Date getData() {
        return data;
    }
}
