package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Authors: Genís Aragonès Torralbo

public class Finestra extends JFrame {

    private String numero;

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

        matriu.add(boto1);
        matriu.add(boto2);
        matriu.add(boto3);
        matriu.add(boto4);
        matriu.add(boto5);
        matriu.add(boto6);
        matriu.add(boto7);
        matriu.add(boto8);
        matriu.add(boto9);
        matriu.add(boto10);

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

        // Authors: Pau Forés Prats
        // Part logica de la interficie gràfica

        ActionListener click = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                String rutaArchivo = "src/Llista_activitats.txt";

                try {

                    Scanner scanner = new Scanner(new File(rutaArchivo));

                    StringBuilder contenidoArchivo = new StringBuilder();

                    while (scanner.hasNextLine()) {
                        String linea = scanner.nextLine();
                        String[] datos = linea.split(";");

                        if (datos[2].equals(getNumero())) {
                            contenidoArchivo.append(transformarLinea(linea)).append("\n");
                        }
                    }

                    textsortida.setText(contenidoArchivo.toString());

                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.err.println("Error: Archivo no encontrado - " + e.getMessage());
                }

            }
        };

        ActionListener num1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("1");
            }
        };

        ActionListener num2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("2");
            }
        };

        ActionListener num3 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("3");
            }
        };

        ActionListener num4 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("4");
            }
        };

        ActionListener num5 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("5");
            }
        };

        ActionListener num6 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("6");
            }
        };

        ActionListener num7 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("7");
            }
        };

        ActionListener num8 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("8");
            }
        };

        ActionListener num9 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("9");
            }
        };

        ActionListener num10 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setNumero("10");
            }
        };

        boto1.addActionListener(num1);
        boto2.addActionListener(num2);
        boto3.addActionListener(num3);
        boto4.addActionListener(num4);
        boto5.addActionListener(num5);
        boto6.addActionListener(num6);
        boto7.addActionListener(num7);
        boto8.addActionListener(num8);
        boto9.addActionListener(num9);
        boto10.addActionListener(num10);

        boto1.addActionListener(click);
        boto2.addActionListener(click);
        boto3.addActionListener(click);
        boto4.addActionListener(click);
        boto5.addActionListener(click);
        boto6.addActionListener(click);
        boto7.addActionListener(click);
        boto8.addActionListener(click);
        boto9.addActionListener(click);
        boto10.addActionListener(click);

    }

    public void setNumero(String num) {
        this.numero = num;
    }

    public String getNumero() {
        return numero;
    }

    public String transformarLinea(String linea) {
        String[] datos = linea.split(";");

        if (datos.length >= 14) {
            // Realiza las correcciones que desees en los datos
            String actividad = "Actividad: " + datos[0];
            String ubicacion = "Ubicación: " + datos[1];
            String numero = "Número: " + datos[2];
            String organizacion = "Organización: " + datos[3];
            String codigoPostal = "Código postal: " + datos[4];
            String codigoInterno = "Código interno: " + datos[5];
            String precio = "Precio: " + datos[6];
            String descuento = "Descuento: " + datos[7];
            String duracion = "Duración: " + datos[8];
            String nivel = "Nivel: " + datos[9];
            String calificacion = "Calificación: " + datos[10];
            String inscritos = "Inscritos: " + datos[11];
            String observaciones = "Observaciones: " + datos[12];
            String otroDato = "Otro dato: " + datos[13];

            // Construye la cadena con el texto corregido
            return actividad + "\n" +
                    ubicacion + "\n" +
                    numero + "\n" +
                    organizacion + "\n" +
                    codigoPostal + "\n" +
                    codigoInterno + "\n" +
                    precio + "\n" +
                    descuento + "\n" +
                    duracion + "\n" +
                    nivel + "\n" +
                    calificacion + "\n" +
                    inscritos + "\n" +
                    observaciones + "\n" +
                    otroDato;
        }

        return linea;
    }

}
