package contateste;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class consultarConta extends JFrame{
    
    
    private JLabel label1; //JLabel apenas com texto
    private JTextField texto1;
    private JButton button1;
    private JButton button2;
    
    public consultarConta(){
        
        super("Sistema Bancario");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Consultar Conta");
        add(label1);
        
        texto1 = new JTextField("Digite o numero da conta", 15);
        add(texto1);
        
        button1 = new JButton("Imprimir Saldo");
        add(button1);
        
        button2 = new JButton("Voltar");
        add(button2);
        
        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);

    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == button1){
                Conta conta;
                String numConta;
                try {
                        numConta = texto1.getText();
                    } 
                catch (NullPointerException e) {
                        numConta = null;
                }
                Banco banco = Banco.getInstance();

                conta = banco.buscaConta(Integer.parseInt(numConta));

                if (conta == null) {
                    JOptionPane.showMessageDialog(null, "Conta nao cadastrada!"); 
                }
                else{
                    JOptionPane.showMessageDialog(null, "R$: " + conta.getSaldo());
                }
            }
            menuGUI frame2 = new menuGUI();
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(200, 200);
            frame2.setVisible(true);
                
            if(event.getSource() == button2){
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 200);
                frame1.setVisible(true);
            }
            consultarConta.this.dispose();
        }
    }
    
    
}

