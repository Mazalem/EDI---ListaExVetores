import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Excluir extends JFrame {
    private JLabel jlnome = new JLabel("Nome do Convidado: ");
    private JTextField jtnome = new JTextField(20);
    private JButton jbexcluir = new JButton("Excluir");
    private JButton jbproximo = new JButton(">");
    private JButton jbanterior = new JButton("<");
    private Container ct1 = new Container();
    private Container ct2 = new Container();
    private String[] nomes;
    private int posicao = 0;

    public Excluir(ConvidadosGUI c) {
        setTitle("Excluir Convidados");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        ct1.setLayout(new FlowLayout());
        ct1.add(jlnome);
        ct1.add(jtnome);
        jtnome.setEnabled(false);
        jtnome.setDisabledTextColor(Color.BLACK);

        ct2.setLayout(new BoxLayout(ct2, BoxLayout.X_AXIS));
        ct2.add(Box.createGlue());
        ct2.add(jbanterior);
        ct2.add(Box.createRigidArea(new Dimension(10, 1)));
        ct2.add(jbexcluir);
        ct2.add(Box.createRigidArea(new Dimension(10, 1)));
        ct2.add(jbproximo);
        ct2.add(Box.createGlue());

        add(ct1, BorderLayout.CENTER);
        add(ct2, BorderLayout.SOUTH);

        nomes = c.getNomes();
        exibeNome();

        jbexcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.excluiNome(posicao);
                Excluir.this.dispose();
            }
        });
        jbproximo.addActionListener(new Handler());
        jbanterior.addActionListener(new Handler());

        pack();

    }
    
    public void exibeNome() {
        jtnome.setText(nomes[posicao]);
    }

    public class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbanterior) {
                if(posicao > 0) {
                    posicao--;
                }
            }
            if (e.getSource() == jbproximo) {
                if(posicao < 9 && nomes[posicao+1] != null) {
                    posicao++;
                }
            }
            exibeNome();
        }
    }
}