package administrativo;

import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class Protocolo_Desaparecimento {
    public static Protocolo novoProtocolo(){
        String temp;
        int id_funcionario = 0, id_produto = 0;

        temp = JOptionPane.showInputDialog("Insira o id do funcionario");
        id_funcionario = Integer.parseInt(temp);

        temp = JOptionPane.showInputDialog("Insira o id do produto desaparecido");
        id_produto = Integer.parseInt(temp);

        Date hoje = new Date();
        Protocolo aux = new Protocolo(id_funcionario, id_produto, hoje);
        return aux;
    }
}
