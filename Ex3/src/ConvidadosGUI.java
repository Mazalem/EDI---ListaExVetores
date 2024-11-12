import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvidadosGUI extends JFrame {
    private JTable tabela = new JTable();
    private String[] nomes = new String[10];
    private JLabel jl1 = new JLabel("0");
    private JLabel jl2 = new JLabel("/");
    private JLabel jl3 = new JLabel("10");
    private JMenuBar barra = new JMenuBar();
    private JMenuItem inserir = new JMenuItem("Inserir");
    private JMenuItem excluir = new JMenuItem("Excluir");
    private Container ct1 = new Container();
    private Container ct2 = new Container();

    public ConvidadosGUI() {
        setTitle("Lista de Convidados");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        inserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inserir(ConvidadosGUI.this).setVisible(true);
            }
        });

        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excluir(ConvidadosGUI.this).setVisible(true);
            }

        });
        barra.add(inserir);
        barra.add(excluir);
        setJMenuBar(barra);

        ct2.setLayout(new FlowLayout());
        ct2.add(jl1);
        ct2.add(jl2);
        ct2.add(jl3);

        preencheTabela();
        tabela.setEnabled(false);

        ct1.setLayout(new BorderLayout());
        ct1.add(tabela, BorderLayout.CENTER);
        ct1.add(ct2, BorderLayout.SOUTH);

        add(ct1);

        setVisible(true);
    }

    public void adicionaNome(String dado) {
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] == null || nomes[i].isEmpty()) {
                nomes[i] = dado;
                preencheTabela();
                break;
            } else if (i == nomes.length - 1) {
                JOptionPane.showMessageDialog(ConvidadosGUI.this, "Lista cheia");
            }
        }
    }

    public void excluiNome(int index) {
        int ultimo = 0;
        for (int i = nomes.length - 1; i >= 0; i--) {
            if (nomes[i] != null) {
                ultimo = i;
                break;
            }
        }
        for (int j = index; j < ultimo; j++) {
            nomes[j] = nomes[j + 1];
        }
        nomes[ultimo] = null;
        preencheTabela();
    }

    public void preencheTabela() {
        DefaultTableModel modelo = new DefaultTableModel(0, 1);
        for (int i = 0; i < nomes.length; i++) {
            Object[] linha = { nomes[i] != null ? nomes[i] : "" };
            modelo.addRow(linha);
        }
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
        atualizaQuantidade();
        ligaFuncionalidades();
    }

    public void atualizaQuantidade() {
        if (nomes[0] == null) {
            jl1.setText(String.valueOf(0));
        } else {
            for (int i = nomes.length - 1; i >= 0; i--) {
                if (nomes[i] != null) {
                    jl1.setText(String.valueOf(i + 1));
                    break;
                }
            }
        }
    }

    public void ligaFuncionalidades() {
        if(nomes[0] == null) {
            excluir.setEnabled(false);
        }
        else {
            excluir.setEnabled(true);
        }

        if(nomes[9] != null) {
            inserir.setEnabled(false);
        }
        else {
            inserir.setEnabled(true);
        }
    }

    public String[] getNomes() {
        return nomes;
    }

}
