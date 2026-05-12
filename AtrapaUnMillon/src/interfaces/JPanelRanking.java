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
		
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		users = MongoDBColecciones.rellenarArrayListUsuarios(users);
		
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
		
		lblMejoresPuntuaciones = new JLabel("Mejores Puntuaciones Únicas");
		lblMejoresPuntuaciones.setForeground(Color.WHITE);
		lblMejoresPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMejoresPuntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejoresPuntuaciones.setBounds(150, 58, 300, 67);
		add(lblMejoresPuntuaciones);
		
		lblMáximosGanadores = new JLabel("Máximos Puntajes");
		lblMáximosGanadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMáximosGanadores.setForeground(Color.WHITE);
		lblMáximosGanadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMáximosGanadores.setBounds(750, 45, 300, 67);
		add(lblMáximosGanadores);
		
		
}
	
	
	private void reiniciarSituacionInicial() {
		users = MongoDBColecciones.rellenarArrayListUsuarios(users);
		
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
		
		lblMejoresPuntuaciones = new JLabel("Mejores Puntuaciones Únicas");
		lblMejoresPuntuaciones.setForeground(Color.WHITE);
		lblMejoresPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMejoresPuntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejoresPuntuaciones.setBounds(150, 58, 300, 67);
		add(lblMejoresPuntuaciones);
		
		lblMáximosGanadores = new JLabel("Máximos Puntajes");
		lblMáximosGanadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMáximosGanadores.setForeground(Color.WHITE);
		lblMáximosGanadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMáximosGanadores.setBounds(750, 45, 300, 67);
		add(lblMáximosGanadores);
	}

	
	
	
	
}
