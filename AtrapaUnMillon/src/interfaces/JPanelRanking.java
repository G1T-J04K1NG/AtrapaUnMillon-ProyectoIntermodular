package interfaces;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Usuario;
import mongo.MongoDBColecciones;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelRanking extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane PanelScrollDineroTotal;
	private JScrollPane panelScrollMejorPartida;
	private JTable TablaDineroTotal;
	private JTable TablaDineroPartida;
	private JLabel lblMejoresPuntuaciones;
	private JLabel lblMáximosGanadores;
	private ArrayList<Usuario> users;
	private List<Usuario> ordenadosDineroUsuario,ordenadosDineroPartido;
	
	/**
	 * Create the panel.
	 */
	public JPanelRanking() {
		
		ArrayList<Usuario> users = MongoDBColecciones.getInstance().getUsuarios();
		
		ordenadosDineroUsuario = users.stream()
					.sorted(Comparator.comparingInt(Usuario::getDineroUsuario)).toList();
		ordenadosDineroUsuario=ordenadosDineroUsuario.reversed();
		ordenadosDineroPartido = users.stream()
				.sorted(Comparator.comparingInt(Usuario::getDineroMejorPartida)).toList();
		ordenadosDineroPartido=ordenadosDineroPartido.reversed();
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBounds(0, 30, 1200, 770);
		
		PanelScrollDineroTotal = new JScrollPane();
		PanelScrollDineroTotal.setBounds(192, 110, 300,500);
		PanelScrollDineroTotal.getViewport().setBackground(new Color(45, 45, 45));
		PanelScrollDineroTotal.setBackground(new Color(35, 35, 35));
		add(PanelScrollDineroTotal);
		
		TablaDineroPartida = new JTable();
		TablaDineroPartida.getTableHeader().setReorderingAllowed(false);
		TablaDineroPartida.getTableHeader().setResizingAllowed(false);
	
		TablaDineroPartida.setBackground(new Color(60,60,60));
		TablaDineroPartida.setForeground(Color.WHITE);
		TablaDineroPartida.setGridColor(Color.GRAY);
		TablaDineroPartida.getTableHeader().setBackground(new Color(30,30,30));
		TablaDineroPartida.getTableHeader().setForeground(Color.WHITE);
		
		TablaDineroPartida.setSelectionBackground(new Color(90,90,90));
		PanelScrollDineroTotal.setViewportView(TablaDineroPartida);
		
		DefaultTableModel modeloDineroPartida = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posición", "Nombre", "DineroPartida"
				}
			);
		modeloDineroPartida.setRowCount(0);
		for (int i = 0 ; i < users.size() ; i++) {
			Object[] fila = new Object[3];
			fila[0] = i+1;
			fila[1] = ordenadosDineroPartido.get(i).getNombre();
			fila[2] = ordenadosDineroPartido.get(i).getDineroMejorPartida();
			modeloDineroPartida.addRow(fila);
		}
		TablaDineroPartida.setModel(modeloDineroPartida);
		
		
		
		
		panelScrollMejorPartida = new JScrollPane();
		panelScrollMejorPartida.setBounds(798, 110, 300, 500);
		panelScrollMejorPartida.getViewport().setBackground(new Color(45, 45, 45));
		panelScrollMejorPartida.setBackground(new Color(35, 35, 35));
		add(panelScrollMejorPartida);
		
		TablaDineroTotal = new JTable();
		TablaDineroTotal.getTableHeader().setReorderingAllowed(false);
		TablaDineroTotal.getTableHeader().setResizingAllowed(false);
		TablaDineroTotal.setBackground(new Color(60,60,60));
		TablaDineroTotal.setForeground(Color.WHITE);
		TablaDineroTotal.setGridColor(Color.GRAY);
		TablaDineroTotal.getTableHeader().setBackground(new Color(30,30,30));
		TablaDineroTotal.getTableHeader().setForeground(Color.WHITE);
		
		DefaultTableModel modeloDineroTotal = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posición", "Nombre", "Total Recaudado"
				}
			);
		modeloDineroTotal.setRowCount(0);
		for (int i = 0 ; i < ordenadosDineroUsuario.size() ; i++) {
			Object[] fila = new Object[3];
			fila[0] = i+1;
			fila[1] = ordenadosDineroUsuario.get(i).getNombre();
			fila[2] = ordenadosDineroUsuario.get(i).getDineroUsuario();
			modeloDineroTotal.addRow(fila);
		}
		TablaDineroTotal.setModel(modeloDineroTotal);
		panelScrollMejorPartida.setViewportView(TablaDineroTotal);
		
		lblMejoresPuntuaciones = new JLabel("MEJORES PUNTUACIONES UNICAS");
		lblMejoresPuntuaciones.setForeground(Color.WHITE);
		lblMejoresPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMejoresPuntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejoresPuntuaciones.setBounds(175, 50, 339, 67);
		add(lblMejoresPuntuaciones);
		
		lblMáximosGanadores = new JLabel("MAXIMOS PUNTAJES");
		lblMáximosGanadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMáximosGanadores.setForeground(Color.WHITE);
		lblMáximosGanadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMáximosGanadores.setBounds(798, 50, 300, 67);
		add(lblMáximosGanadores);

		
		JButton btnVolverMenu = new JButton("Volver al Menú Principal");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo)getParent();
				setVisible(false);
				p.getpMenu().setVisible(true);
			}
		});
		btnVolverMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolverMenu.setBounds(525, 650, 150, 60);
		add(btnVolverMenu);
		
		//LABEL E IMAGEN DE FONDO
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1200, 770);
		add(lblFondo);
		
		ImageIcon fondo = new ImageIcon("src/img/imagenFondoRankin.png");
		lblFondo.setIcon(new ImageIcon(JPanelRanking.class.getResource("/resources/ImagenFondoRankin.png")));
		
		
}
	
	
	void reiniciarSituacionInicial() {
		if (users != null) {
			users.clear();
		}
		users = MongoDBColecciones.getInstance().getUsuarios();
		
		ordenadosDineroUsuario = users.stream()
					.sorted(Comparator.comparingInt(Usuario::getDineroUsuario)).toList();
		ordenadosDineroUsuario=ordenadosDineroUsuario.reversed();
		ordenadosDineroPartido = users.stream()
				.sorted(Comparator.comparingInt(Usuario::getDineroMejorPartida)).toList();
		ordenadosDineroPartido=ordenadosDineroPartido.reversed();
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBounds(0, 30, 1200, 770);
		
		PanelScrollDineroTotal = new JScrollPane();
		PanelScrollDineroTotal.setBounds(150, 135, 300,500);
		add(PanelScrollDineroTotal);
		
		TablaDineroPartida = new JTable();
		TablaDineroPartida.getTableHeader().setReorderingAllowed(false);
		TablaDineroPartida.getTableHeader().setResizingAllowed(false);
		PanelScrollDineroTotal.setViewportView(TablaDineroPartida);
		
		DefaultTableModel modeloDineroPartida = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posición", "Nombre", "DineroPartida"
				}
			);
		modeloDineroPartida.setRowCount(0);
		for (int i = 0 ; i < users.size() ; i++) {
			Object[] fila = new Object[3];
			fila[0] = i+1;
			fila[1] = ordenadosDineroPartido.get(i).getNombre();
			fila[2] = ordenadosDineroPartido.get(i).getDineroMejorPartida();
			modeloDineroPartida.addRow(fila);
		}
		TablaDineroPartida.setModel(modeloDineroPartida);
		
		
		
		
		panelScrollMejorPartida = new JScrollPane();
		panelScrollMejorPartida.setBounds(750, 135, 300, 500);
		add(panelScrollMejorPartida);
		
		TablaDineroTotal = new JTable();
		TablaDineroTotal.getTableHeader().setReorderingAllowed(false);
		TablaDineroTotal.getTableHeader().setResizingAllowed(false);
		
		DefaultTableModel modeloDineroTotal = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posición", "Nombre", "Total Recaudado"
				}
			);
		modeloDineroTotal.setRowCount(0);
		for (int i = 0 ; i < ordenadosDineroUsuario.size() ; i++) {
			Object[] fila = new Object[3];
			fila[0] = i+1;
			fila[1] = ordenadosDineroUsuario.get(i).getNombre();
			fila[2] = ordenadosDineroUsuario.get(i).getDineroUsuario();
			modeloDineroTotal.addRow(fila);
		}
		TablaDineroTotal.setModel(modeloDineroTotal);
		panelScrollMejorPartida.setViewportView(TablaDineroTotal);
		repaint();
	}
}
