package com.alura.igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.alura.logica.modelo.Huesped;
import com.alura.logica.modelo.Reserva;
import com.alura.persistencia.Controladora;

public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JTabbedPane tabbedPane;
	private JPanel panelReserva = new JPanel();
	private JPanel panelHuesped = new JPanel();
	
	private JTextField txtParametroBusqueda;
	private Controladora controladora = new Controladora();

	

	private JTable tablaReservas = null;
	private JScrollPane scrollTablaReservas = null;
	private String titulosReservas[] = {"Numero de reserva", "Fecha ingreso", "Fecha salida", "Valor reserva", "Medio de pago"};
	
	

	private JTable tablaHuespedes = null;
	private JScrollPane scrollTablaHuespedes = null;
	private String titulosHuespedes[] = {"Numero de reserva", "Nombre", "Apellido", "Fecha de Nacimiento", "Nacionalidad", "Telefono"};
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	private DefaultTableModel modeloTablaReservas = new DefaultTableModel(titulosReservas, 0) {
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	};
	
	private DefaultTableModel modeloTablaHuspedes = new DefaultTableModel(titulosHuespedes, 0) {
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	};
	
	public void mostrarMensaje(String mensaje, String tipo, String titulo) {
		JOptionPane optionPane = new JOptionPane();

		if (tipo.equals("ERROR")) {
			optionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		} else {
			optionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		optionPane.setVisible(true);
	}
	
	private void cargarTabla(List<Huesped> listaHuespedes, List<Reserva> listaReservas) {
		tablaReservas = new JTable();
		scrollTablaReservas = new JScrollPane();
		
		tablaHuespedes = new JTable();
		scrollTablaHuespedes = new JScrollPane();
	
	    modeloTablaReservas.setRowCount(0);
	    modeloTablaHuspedes.setRowCount(0);
		
		
		if (listaReservas != null) {
			for (Reserva reserva : listaReservas) {
				Object[] objetoReserva = {reserva.getId(), dateFormat.format(reserva.getFechaIngreso()),dateFormat.format(reserva.getFechaSalida()),reserva.getValorReserva(),reserva.getMedioPago() };
				modeloTablaReservas.addRow(objetoReserva);
			}
		}
		
		modeloTablaReservas.fireTableDataChanged();
		tablaReservas.revalidate();
		
		tablaReservas.setModel(modeloTablaReservas);
		tablaReservas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollTablaReservas.setViewportView(tablaReservas);

		scrollTablaReservas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollTablaReservas.setBounds(0, 0, 780, 400);
		panelReserva.add(scrollTablaReservas);
		
		
		
		
		if (listaHuespedes != null) {
			for (Huesped huesped : listaHuespedes) {
				Object[] objetoHuesped = {huesped.getReserva().getId(), huesped.getNombre(), huesped.getApellido(),dateFormat.format(huesped.getFechaNacimiento()), huesped.getNacionalidad(), huesped.getTelefono()};
				modeloTablaHuspedes.addRow(objetoHuesped);
			}
		}
		
		modeloTablaHuspedes.fireTableDataChanged();
		tablaHuespedes.revalidate();
		
		tablaHuespedes.setModel(modeloTablaHuspedes);
		tablaHuespedes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollTablaHuespedes.setViewportView(tablaHuespedes);

		scrollTablaHuespedes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollTablaHuespedes.setBounds(0, 0, 780, 400);
		panelHuesped.add(scrollTablaHuespedes);

	}
	
	public Busqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(0, 0, 784, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
        tabbedPane = new JTabbedPane();
        tabbedPane.setLocation(0, 100);
        tabbedPane.setSize(780, 350);
        panel.add(tabbedPane);

        
        tabbedPane.addTab("Huespedes", panelHuesped);
        panelHuesped.setLayout(null);
        ImageIcon icono1 = new ImageIcon(Login.class.getResource("/IMAGENES/User-blue-icon.png"));
        tabbedPane.setIconAt(0, icono1);
        
        
        tabbedPane.addTab("Reservas", panelReserva);
        panelReserva.setLayout(null);
        ImageIcon icono2 = new ImageIcon(Login.class.getResource("/IMAGENES/Schedule-Folder-Blue-icon.png"));
        tabbedPane.setIconAt(1, icono2);
        
        JButton btnSalir = new JButton("");
        btnSalir.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Users-Exit-icon.png")));
        btnSalir.setBounds(704, 481, 80, 80);
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Login pantallaLogin = new Login();
				pantallaLogin.setVisible(true);
				pantallaLogin.setLocationRelativeTo(null);	
				dispose();
        	}
        });
        panel.add(btnSalir);
        
        JButton btnCancelar = new JButton("");
        btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/close-icon.png")));
        btnCancelar.setBounds(593, 481, 80, 80);
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Principal pantallaPrincipal = new Principal();
        		pantallaPrincipal.setVisible(true);
        		pantallaPrincipal.setLocationRelativeTo(null);	
        		dispose();
        	}
        });

        panel.add(btnCancelar);
        
        JButton btnEliminar = new JButton("");
        btnEliminar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/delete-icon.png")));
        btnEliminar.setBounds(479, 481, 80, 80);
        btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaHuespedes.getRowCount() > 0) {
					if (tablaHuespedes.getSelectedRow() != -1) {
						int numeroReservaAsociadaHuesped = Integer.parseInt(String.valueOf(tablaHuespedes.getValueAt(tablaHuespedes.getSelectedRow(),0)));
						controladora.borrarReserva(numeroReservaAsociadaHuesped);
						mostrarMensaje("Borrado correctamente", "Borrado", "INFO");
						
						Principal pantallaPrincipal = new Principal();
						pantallaPrincipal.setVisible(true);
						pantallaPrincipal.setLocationRelativeTo(null);	
						dispose();


				}else if (tablaReservas.getRowCount() > 0) {
					if (tablaReservas.getSelectedRow() != -1) {
						int numeroReserva = Integer.parseInt(String.valueOf(tablaReservas.getValueAt(tablaReservas.getSelectedRow(),0)));
						controladora.borrarReserva(numeroReserva);
						mostrarMensaje("Borrado correctamente", "Borrado", "INFO");
						
						Principal pantallaPrincipal = new Principal();
						pantallaPrincipal.setVisible(true);
						pantallaPrincipal.setLocationRelativeTo(null);	
						dispose();

					} else {
						mostrarMensaje("No selecciono nada", "Error", "ERROR");
					}

				}else {
					mostrarMensaje("No hay nada para borrar en la tabla", "Error", "ERROR");
					}
			
				}
			}
		});
        panel.add(btnEliminar);
        
        JButton btnEditar = new JButton("");
        btnEditar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/pencil-24-icon.png")));
        btnEditar.setBounds(366, 481, 80, 80);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaHuespedes.getRowCount() > 0) {
					if (tablaHuespedes.getSelectedRow() != -1) {
						int numeroReservaAsociadaHuesped = Integer.parseInt(String.valueOf(tablaHuespedes.getValueAt(tablaHuespedes.getSelectedRow(),0)));
						
						EditarDatos pantallaEditar = new EditarDatos(numeroReservaAsociadaHuesped);
						pantallaEditar.setVisible(true);
						pantallaEditar.setLocationRelativeTo(null);	
						dispose();


				}else if (tablaReservas.getRowCount() > 0) {
					if (tablaReservas.getSelectedRow() != -1) {
						int numeroReserva = Integer.parseInt(String.valueOf(tablaReservas.getValueAt(tablaReservas.getSelectedRow(),0)));
						
						EditarDatos pantallaEditar = new EditarDatos(numeroReserva);
						pantallaEditar.setVisible(true);
						pantallaEditar.setLocationRelativeTo(null);	
						dispose();

					} else {
						mostrarMensaje("No selecciono nada", "Error", "ERROR");
					}

				}else {
					mostrarMensaje("No hay nada para editar en la tabla", "Error", "ERROR");
					}
			
				}
			}
		});
		
		
		
        panel.add(btnEditar);
               
        txtParametroBusqueda = new JTextField();
        txtParametroBusqueda.setColumns(10);
        txtParametroBusqueda.setBounds(514, 50, 200, 50);
        panel.add(txtParametroBusqueda);
        
        JButton btnBuscar = new JButton("");
        btnBuscar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Magnifier-icon.png")));
        btnBuscar.setBounds(724, 50, 50, 50);
        panel.add(btnBuscar);      
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!txtParametroBusqueda.getText().equals("")) {
        			List<Reserva> listaReservas = controladora.traerReservasPorParametros(txtParametroBusqueda.getText());
        			List<Huesped> listaHuespedes = controladora.traerHuespedesPorParametros(txtParametroBusqueda.getText());
        			cargarTabla(listaHuespedes,listaReservas);	
        		}
        		
        		
        	}
        });
        
        JButton btnTodos = new JButton("Ver todo");
        btnTodos.setVerticalAlignment(SwingConstants.BOTTOM);
        btnTodos.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/people-group-icon.png")));
        btnTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnTodos.setBounds(336, 50, 140, 50);
        panel.add(btnTodos);
        btnTodos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Huesped> listaHuespedes = controladora.traerTodosHuespedes();
        		List<Reserva> listaReservas = controladora.traerTodosReservas();
        		cargarTabla(listaHuespedes,listaReservas);		
        	}
        });

	}
}
