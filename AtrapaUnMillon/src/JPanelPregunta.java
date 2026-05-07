import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JPanelPregunta extends JPanel {

    private static final long serialVersionUID = 1L;
    // Cargamos la imagen directamente para el método paintComponent
    private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/Captura de pantalla 2026-05-07 125829.png")).getImage();

    public JPanelPregunta() {
        // Configuramos el panel
        setLayout(null);
        setSize(1202, 802);

        // --- BOTÓN A ---
        JButton btnNewButton = new JButton("Opcion A: + respuesta");
        estiloBoton(btnNewButton); // Aplicamos estilo guapo
        btnNewButton.setBounds(275, 421, 160, 30);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción aquí
            }
        });
        add(btnNewButton);

        // --- BOTÓN B ---
        JButton btnNewButton_1 = new JButton("Opcion B: + respuesta");
        estiloBoton(btnNewButton_1);
        btnNewButton_1.setBounds(763, 421, 160, 30);
        add(btnNewButton_1);

        // --- BOTÓN C ---
        JButton btnNewButton_2 = new JButton("Opcion C: + respuesta");
        estiloBoton(btnNewButton_2);
        btnNewButton_2.setBounds(275, 679, 160, 30);
        add(btnNewButton_2);

        // --- BOTÓN D ---
        JButton btnNewButton_3 = new JButton("Opcion D: + respuesta");
        estiloBoton(btnNewButton_3);
        btnNewButton_3.setBounds(763, 679, 160, 30);
        add(btnNewButton_3);

        // --- LABEL PREGUNTA ---
        JLabel lblNewLabel = new JLabel("PREGUNTA");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.WHITE); // Texto en blanco para que se vea
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16)); // Más grande y en negrita
        lblNewLabel.setBounds(431, 519, 350, 40);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/Captura de pantalla 2026-05-07 125829.png")));
        lblNewLabel_1.setBounds(-19, -39, 1331, 886);
        add(lblNewLabel_1);
    }

    // Método para dejar los botones "de locos"
    private void estiloBoton(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false); // Hace el botón transparente
        btn.setForeground(Color.CYAN);   // Color de texto estilo neón
        btn.setFocusPainted(false);
        btn.setBorder(new LineBorder(Color.CYAN, 1, true)); // Borde fino redondeado
        btn.setFont(new Font("Tahoma", Font.BOLD, 11));
    }

    // Este método dibuja el fondo y hace que se vea PERFECTO (Escalado)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            // Dibuja la imagen estirándola al tamaño exacto del panel actual
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
