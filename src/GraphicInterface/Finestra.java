package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//Authors: Genís Aragonès Torralbo
/*Falta implementar la funció dels botons que ho farà pau
 */
public class Finestra extends JFrame {

    public Finestra(String titol) {
        this.setTitle(titol);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(500, 500);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel matriu = new JPanel();
        matriu.setLayout(new GridLayout(3, 5, 15, 10));

        JButton boto1 = new JButton(Integer.toString(1));
        JButton boto2 = new JButton(Integer.toString(2));
        JButton boto3 = new JButton(Integer.toString(3));
        JButton boto4 = new JButton(Integer.toString(4));
        JButton boto5 = new JButton(Integer.toString(5));
        JButton boto6 = new JButton(Integer.toString(6));
        JButton boto7 = new JButton(Integer.toString(7));
        JButton boto8 = new JButton(Integer.toString(8));
        JButton boto9 = new JButton(Integer.toString(9));
        JButton boto10 = new JButton(Integer.toString(10));

        JCheckBox checkBox1 = new JCheckBox("Opción 1");
        checkBox1.setOpaque(false);
        checkBox1.setText("Tallers");
        JCheckBox checkBox2 = new JCheckBox("Opción 2");
        checkBox2.setOpaque(false);
        checkBox2.setText("Visites");
        JCheckBox checkBox3 = new JCheckBox("Opción 3");
        checkBox3.setOpaque(false);
        checkBox3.setText("Xerrades");

        matriu.add(new JLabel("Filtrar: "));
        matriu.add(checkBox1);
        matriu.add(checkBox2);
        matriu.add(checkBox3);
        matriu.setBorder(new EmptyBorder(10, 8, 10, 8));

        JPanel partdebaix = new JPanel(new BorderLayout());

        JTextArea textsortida = new JTextArea();
        textsortida.setOpaque(false);
        textsortida.setEditable(false);
        textsortida.setBackground(new Color(173, 216, 230));
        textsortida.setBorder(null);

        JScrollPane scrollPane = new JScrollPane(textsortida);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getViewport().setBackground(new Color(173, 216, 230));
        scrollPane.setBorder(null);

        partdebaix.add(new JLabel("Activitats del dia:"), BorderLayout.NORTH);
        partdebaix.add(scrollPane, BorderLayout.CENTER); // Añadir scrollPane en la región CENTER

        partdebaix.setBackground(new Color(173, 216, 230));
        matriu.setBackground(new Color(255, 182, 193));

        this.add(matriu, BorderLayout.NORTH);
        this.add(partdebaix, BorderLayout.CENTER); // Añadir partdebaix en la región CENTER
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionament del botons
        ActionListener click = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }

        };

        boto.addActionListener(click);
    }
}
