package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Toolkit;

public class JframeInterfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPanel;

	// CrearJFRAME
	public JframeInterfaz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JframeInterfaz.class.getResource("/resources/logo_atrapa_millon.png")));
		setFont(new Font("Guttman Frank", Font.BOLD, 13));
		setTitle("Atrapa Un Millón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1200, 800);
		contentPanel = new JPanel() {
		    private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/interfaz.png")).getImage();

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        if (imagenFondo != null) {
		            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		        }
		    }
		};
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRegistrarse.setBounds(800, 470, 250, 150);
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setContentAreaFilled(false); 
		btnRegistrarse.setFocusPainted(false); 
		btnRegistrarse.setBorder(new LineBorder(Color.WHITE, 3)); 
		btnRegistrarse.setForeground(Color.WHITE); 
		contentPanel.add(btnRegistrarse); 

		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameLogIn frameLogIn = new JFrameLogIn(JframeInterfaz.this);
							frameLogIn.setVisible(true);
							frameLogIn.setResizable(false); 
							} catch (Exception e) {
									e.printStackTrace();
							}
					}
				});
			}
		});

				
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnIniciarSesion.setBounds(150, 470, 250, 150);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setContentAreaFilled(false); 
		btnIniciarSesion.setFocusPainted(false); 
		btnIniciarSesion.setBorder(new LineBorder(Color.WHITE, 3)); 
		btnIniciarSesion.setForeground(Color.WHITE); 
		contentPanel.add(btnIniciarSesion);

	
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameRegistro frameRegistro = new JFrameRegistro(JframeInterfaz.this);
							frameRegistro.setVisible(true);
							frameRegistro.setResizable(false); 
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}
}
