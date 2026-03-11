package swing;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;

public class SwingDemo1 implements ActionListener{
    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    SwingDemo1() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(new FlatDarkLaf());
        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Del sistema operativo
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // Por defecto de Java
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // Feo


        JFrame jfr = new JFrame("Usar un campo de texto.");
        jfr.setLayout(new FlowLayout());
        jfr.setSize(240, 180);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10); // 10 columnas de ancho.
        jtf.setActionCommand("myTF"); // Funciona igual sin esto pero mejor ponerlo.

        jbtnRev = new JButton("Reverse");
        jbtnRev.setToolTipText("Vamos a ver."); // Para mostrar mensajes al señalar con el mouse.

        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jlabPrompt = new JLabel("Texto de entrada");
        jlabContents = new JLabel("");

        jfr.add(jlabPrompt);
        jfr.add(jtf);
        jfr.add(jbtnRev);
        jfr.add(jlabContents);
        jfr.setLocationRelativeTo(null);
        jfr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reverse")) {
            // El ActionCommand por defecto del JTextField es lo que hay en el campo de texto.
            String orgStr = jtf.getText();
            String resStr = "";

            for (int i = orgStr.length()-1; i >= 0; i--) {
                resStr += orgStr.charAt(i);
            }
            jtf.setText(resStr);
        }   else {
            jlabContents.setText("Has presionado ENTER. El texto es: " + jtf.getText());
        }
        // ae.getSource(); // Retorna el objeto evento.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new SwingDemo1();
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}