/* Miranda Trejo Jesús Fernando
 * Sánchez Jurado Andrea Jaqueline
 * Talavera Rivera Luis Fernando
 * 
 * Esta clase contiene la GUI y la implementación de la clase banquero.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textR1;
	private JTextField textR2;
	private JTextField textR3;
	private JTextField R1a;
	private JTextField R2a;
	private JTextField R3a;
	private JTable tableM;
	private JTextField R1sis;
	private JTextField R2sis;
	private JTextField R3sis;
	private JTable tablaA;
	JScrollPane scrollPane = new JScrollPane();
	private Banquero banquero = new Banquero();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz() {
		setTitle("Algoritmo del Banquero");
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Agregar Proceso");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1 = new JLabel("Recurso1");
		lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Recurso2");
		lblNewLabel_1_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Recurso3");
		lblNewLabel_1_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		JButton agregarFila = new JButton("Agregar");
		agregarFila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r1Max = Integer.parseInt(textR1.getText());
				int r2Max = Integer.parseInt(textR2.getText());
				int r3Max = Integer.parseInt(textR3.getText());
				
				int maximos[] = {r1Max,r2Max,r3Max};
				Object[] fila = {textId.getText(),textR1.getText(),textR2.getText(),textR3.getText()};
				
				DefaultTableModel model = (DefaultTableModel)tableM.getModel();
				model.addRow(fila);
				
				int r1A = Integer.parseInt(R1a.getText());
				int r2A = Integer.parseInt(R2a.getText());
				int r3A = Integer.parseInt(R3a.getText());
				
				int asignados[] = {r1A,r2A,r3A};
				
				banquero.agregar(textId.getText(), maximos, asignados);
				
				Object[] fila1 = {textId.getText(),R1a.getText(),R2a.getText(),R3a.getText()};
				
				DefaultTableModel modelo = (DefaultTableModel)tablaA.getModel();
				modelo.addRow(fila1);
			}

		});
		
		textId = new JTextField();
		textId.setColumns(10);
		
		textR1 = new JTextField();
		textR1.setColumns(10);
		
		textR2 = new JTextField();
		textR2.setColumns(10);
		
		textR3 = new JTextField();
		textR3.setColumns(10);
		
		R1a = new JTextField();
		R1a.setColumns(10);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Recurso1");
		lblNewLabel_1_1_3.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		R2a = new JTextField();
		R2a.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Recurso2");
		lblNewLabel_1_1_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Recurso3");
		lblNewLabel_1_1_2_1.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		R3a = new JTextField();
		R3a.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Recursos asignados");
		
		JLabel lblNewLabel_2_1 = new JLabel("Recursos m\u00E1ximos");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableM = new JTable();
		tableM.setSurrendersFocusOnKeystroke(true);
		tableM.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "R1", "R2", "R3"},
			},
			new String[] {
				"ID", "R1", "R2", "R3"
			}
		));
		tableM.setColumnSelectionAllowed(true);
		tableM.setFillsViewportHeight(true);
		tableM.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		JLabel lblRecursosDelSistema = new JLabel("Recursos del sistema");
		lblRecursosDelSistema.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(tableM);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Recurso1");
		lblNewLabel_1_1_3_2.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		R1sis = new JTextField();
		R1sis.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Recurso2");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		R2sis = new JTextField();
		R2sis.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Recurso3");
		lblNewLabel_1_1_2_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		
		R3sis = new JTextField();
		R3sis.setColumns(10);
		
		JButton BotonVerificar = new JButton("Verificar");
		
		BotonVerificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {							
				int r1 = Integer.parseInt(R1sis.getText());
				int r2 = Integer.parseInt(R2sis.getText());
				int r3 = Integer.parseInt(R3sis.getText());
				int totales[] = {r1,r2,r3};
				banquero.recursosTotales(totales);
				banquero.calcularDisponibles();
				int procesos = banquero.procesar();
				
				if(procesos == banquero.cantP)
				{
					JOptionPane.showMessageDialog(null, "Si se garantiza un estado seguro\nOrden de salida: P"+banquero.terminados[0].iD+", P"
							+banquero.terminados[1].iD+", P"+banquero.terminados[2].iD+", P"+banquero.terminados[3].iD);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No se garantiza un estado seguro con esa asignacion de recursos");
				}
				
				
			}

		});
		
		tablaA = new JTable();
		tablaA.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "R1", "R2", "R3"},
			},
			new String[] {
				"ID", "R1", "R2", "R3"
			}
		));
				
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_1)
									.addGap(23)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(10)
											.addComponent(textR1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(10)
											.addComponent(textR2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textId, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(textR3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(67)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(58)
									.addComponent(agregarFila))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_1_1_3_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(1)
											.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(8)
											.addComponent(lblNewLabel_1_1_2_1_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(10)
											.addComponent(R1sis, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
											.addGap(33)
											.addComponent(R2sis, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
											.addGap(40)
											.addComponent(R3sis, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(58)
											.addComponent(BotonVerificar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(22)
											.addComponent(lblRecursosDelSistema, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(R1a, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
											.addGap(33)
											.addComponent(R2a, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
											.addGap(40)
											.addComponent(R3a, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(tablaA, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableM, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(9)
							.addComponent(lblNewLabel_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
									.addGap(2)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textR1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
									.addGap(2)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textR2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textR3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(R1a, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(R2a, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(R3a, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(agregarFila)
							.addGap(34)
							.addComponent(lblRecursosDelSistema, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_3_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(R1sis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(R2sis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(R3sis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(BotonVerificar))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(tableM, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(tablaA, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(91)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(34))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
	}
}
