import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/Fondo JFrame Pregunta.png")).getImage();

    private JButton btnOpcionA, btnOpcionB, btnOpcionC, btnOpcionD;
    private JLabel lblPregunta, lblResultado; // Añadimos lblResultado
    private Pregunta preguntaActual; // Para guardar la pregunta que está en pantalla
    private JButton btnVolverMenu;

    public JPanelPregunta() {
        setLayout(null);
        setSize(1202, 802);

        // --- LABEL RESULTADO (¡CORRECTO!) ---
        lblResultado = new JLabel("");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblResultado.setBounds(300, 250, 600, 100);
        lblResultado.setVisible(false); // Empieza oculto
        add(lblResultado);

        // --- BOTONES CON LÓGICA ---
        btnOpcionA = new JButton("");
        estiloBoton(btnOpcionA);
        btnOpcionA.setBounds(275, 421, 250, 40);
        btnOpcionA.addActionListener(e -> comprobarRespuesta(btnOpcionA.getText()));
        add(btnOpcionA);

        btnOpcionB = new JButton("");
        estiloBoton(btnOpcionB);
        btnOpcionB.setBounds(763, 421, 250, 40);
        btnOpcionB.addActionListener(e -> comprobarRespuesta(btnOpcionB.getText()));
        add(btnOpcionB);

        btnOpcionC = new JButton("");
        estiloBoton(btnOpcionC);
        btnOpcionC.setBounds(275, 679, 250, 40);
        btnOpcionC.addActionListener(e -> comprobarRespuesta(btnOpcionC.getText()));
        add(btnOpcionC);

        btnOpcionD = new JButton("");
        estiloBoton(btnOpcionD);
        btnOpcionD.setBounds(763, 679, 250, 40);
        btnOpcionD.addActionListener(e -> comprobarRespuesta(btnOpcionD.getText()));
        add(btnOpcionD);

        // --- LABEL PREGUNTA ---
        lblPregunta = new JLabel("CARGANDO PREGUNTA...");
        lblPregunta.setBackground(Color.BLACK);
        lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
        lblPregunta.setForeground(Color.WHITE);
        lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblPregunta.setBounds(200, 519, 800, 60);
        add(lblPregunta);
        
        btnVolverMenu = new JButton("Volver al Menú");
        btnVolverMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnVolverMenu.setEnabled(true);
        btnVolverMenu.setBounds(882, 33, 250, 40);
        add(btnVolverMenu);
        rellenarPreguntas();
    }

    // Método para ver si el usuario ha acertado
    private void comprobarRespuesta(String textoBoton) {
        if (textoBoton.equals(preguntaActual.getRespuestaCorrecta())) {
            lblResultado.setText("¡CORRECTO!");
            lblResultado.setForeground(Color.GREEN);
        } else {
            lblResultado.setText("¡FALLASTE!");
            lblResultado.setForeground(Color.RED);
        }
        lblResultado.setVisible(true);
        
        // Opcional: Desactivar botones para que no sigan pulsando
        btnOpcionA.setEnabled(false);
        btnOpcionB.setEnabled(false);
        btnOpcionC.setEnabled(false);
        btnOpcionD.setEnabled(false);
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/FondoPreguntas.png")));
        lblNewLabel_1.setBounds(-59, -84, 1331, 886);
        add(lblNewLabel_1);
    }

    private void estiloBoton(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(Color.CYAN);
        btn.setFocusPainted(false);
        btn.setBorder(new LineBorder(Color.CYAN, 2, true));
        btn.setFont(new Font("Tahoma", Font.BOLD, 14));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void rellenarPreguntas() {
        ArrayList<Pregunta> bancoPreguntas = new ArrayList<>();
        // Aquí meterías tus 40 preguntas...
        bancoPreguntas.add(new Pregunta("¿Qué órgano del cuerpo humano bombea sangre?", "Corazón", new ArrayList<>(Arrays.asList("Pulmón", "Hígado", "Corazón", "Riñón")), 1));
        bancoPreguntas.add(new Pregunta("¿Cuál es la moneda oficial de España?", "Euro", new ArrayList<>(Arrays.asList("Peseta", "Dólar", "Euro", "Libra")), 1));

        Collections.shuffle(bancoPreguntas);
        preguntaActual = bancoPreguntas.get(0); // Guardamos la elegida

        lblPregunta.setText(preguntaActual.getPregunta());
        lblResultado.setVisible(false); // Ocultamos el mensaje de acierto anterior
        
        ArrayList<String> opciones = new ArrayList<>(preguntaActual.getRespuestas());
        Collections.shuffle(opciones);

        btnOpcionA.setText(opciones.get(0)); btnOpcionA.setEnabled(true);
        btnOpcionB.setText(opciones.get(1)); btnOpcionB.setEnabled(true);
        btnOpcionC.setText(opciones.get(2)); btnOpcionC.setEnabled(true);
        btnOpcionD.setText(opciones.get(3)); btnOpcionD.setEnabled(true);
    }
    private void colorBoton(JButton btn) {
        btn.setOpaque(true); // ¡IMPORTANTE! Activamos que sea opaco para que se vea el fondo negro
        btn.setContentAreaFilled(true); // Permitimos que Java pinte el fondo del botón
        
        btn.setBackground(Color.BLACK);  // Fondo negro
        btn.setForeground(Color.WHITE);  // Texto blanco (para que contraste)
        
        btn.setFocusPainted(false); // Quita el recuadro feo al hacer clic
        btn.setBorder(new LineBorder(Color.CYAN, 2, true)); // Borde cian redondeado para que "brille"
        
        btn.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente un poco más grande y en negrita
    }
}
