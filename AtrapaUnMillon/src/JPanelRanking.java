import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class JPanelRanking extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane PanelScrollDineroTotal;
	private JScrollPane panelScrollMejorPartida;
	private JTable TablaDineroTotal;

	/**
	 * Create the panel.
	 */
	public JPanelRanking(MongoCollection<Document> collectionUsuarios) {
		
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		rellenarUsuarios(users,collectionUsuarios);
		
		List<Usuario> ordenadosDineroUsuario = users.stream()
					.sorted(Comparator.comparingInt(Usuario::getDineroUsuario)).toList();
		
		List<Usuario> ordenadosDineroPartido = users.stream()
				.sorted(Comparator.comparingInt(Usuario::getDineroMejorPartida)).toList();
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBounds(0, 30, 1200, 770);
		
		PanelScrollDineroTotal = new JScrollPane();
		PanelScrollDineroTotal.setBounds(150, 135, 300,500);
		add(PanelScrollDineroTotal);
		
		panelScrollMejorPartida = new JScrollPane();
		panelScrollMejorPartida.setBounds(750, 135, 300, 500);
		add(panelScrollMejorPartida);
		
		TablaDineroTotal = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posición", "Nombre", "Total Recaudado"
				}
			);
		model.setRowCount(0);
		for (int i = 0 ; i < users.size() ; i++) {
			Object[] fila = new Object[3];
			fila[0] = i+1;
			fila[1] = users.get(i).getNombre();
			fila[2] = users.get(i).getDineroUsuario();
			model.addRow(fila);
		}
		TablaDineroTotal.setModel(model);
		panelScrollMejorPartida.setViewportView(TablaDineroTotal);
		
		

	}

	private void rellenarUsuarios(ArrayList<Usuario> users,MongoCollection<Document> collectionUsuarios) {
		users.clear();
		FindIterable<Document> resultadoUsuarios = collectionUsuarios.find();
		for (Document u : resultadoUsuarios) {
			Usuario usuario = new Usuario (u.getString("usuario"), u.getString("contraseña"),
					u.getInteger("dineroUsuario"),u.getInteger("dineroMejorPartida"));
			users.add(usuario);
		}
		
	}
}
