package contateste;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;


public class ContaTeste {

    public static void main(String[] args){
        Banco banco = Banco.getInstance();
        banco.leArquivo();
        
	menuGUI frame1 = new menuGUI();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(200, 200);
        frame1.setVisible(true); 
    }
}
