import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Inserir extends JFrame{

    private JLabel jlnome = new JLabel("Nome do Convidado: ");
    private JTextField jtnome = new JTextField(20);
    private JButton jb = new JButton("Cadastrar");

    public Inserir(ConvidadosGUI c) {
        setTitle("Inserir Convidados");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        add(jlnome);
        add(jtnome);
        add(jb);

        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jtnome.getText().matches("^[a-zA-Zà-üÀ-Ü]+( [a-zA-Zà-üÀ-Ü]+)*$") && !jtnome.getText().trim().isEmpty()) {
                    c.adicionaNome(jtnome.getText());
                    Inserir.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(Inserir.this, "Somente letras são aceitas!");
                }
            }
        });

        pack();
    }
    
}
