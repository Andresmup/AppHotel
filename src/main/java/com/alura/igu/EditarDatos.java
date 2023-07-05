package com.alura.igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.alura.logica.modelo.Huesped;
import com.alura.logica.modelo.Reserva;
import com.alura.persistencia.Controladora;
import com.alura.utils.ToolPaises;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class EditarDatos extends JFrame {

	private JPanel contentPane;

	private JPanel panel;
	
	private JDateChooser dateFechaIngreso = new JDateChooser();
	private JDateChooser dateFechaSalida = new JDateChooser();
	private JTextField txtValorReserva = new JTextField();
	private JLabel lblValorReserva;
	private Integer indiceMedioPago;
	private String[] mediosPago = new String[] {"Tarjeta de credito", "Tarjeta de debito", "Efectivo"};
	final JComboBox cmbMedioPago = new JComboBox(new DefaultComboBoxModel(mediosPago));
	
	
	private JDateChooser dateFechaNacimiento = new JDateChooser();
	private JTextField txtNombre = new JTextField();
	private JTextField txtApellido = new JTextField();
	private JTextField txtTelefono = new JTextField();
	private ToolPaises toolPaises = new ToolPaises();
	private Integer indicePais;
	private String[] paisesOrdenados = toolPaises.GetPaisesOrdenados();
    final JComboBox cmbPaises = new JComboBox(new DefaultComboBoxModel(paisesOrdenados));
    
    

	private Controladora controladora = new Controladora();
	
	private Reserva reserva;
	private Huesped huesped;
	
	private void cargarDatos(int numeroReserva) {
		reserva = controladora.traerReservaPorId(numeroReserva);
		huesped = reserva.getHuesped();
		dateFechaIngreso.setDate(reserva.getFechaIngreso());
		dateFechaSalida.setDate(reserva.getFechaSalida());
		txtValorReserva.setText(String.valueOf(reserva.getValorReserva()));
		indiceMedioPago = Arrays.asList(mediosPago).indexOf(reserva.getMedioPago());
		if(indiceMedioPago>0) {
			cmbMedioPago.setSelectedIndex(indiceMedioPago);
		}
		txtNombre.setText(huesped.getNombre());
		txtApellido.setText(huesped.getApellido());
		txtTelefono.setText(huesped.getTelefono());
		dateFechaNacimiento.setDate(huesped.getFechaNacimiento());
		indicePais = Arrays.asList(paisesOrdenados).indexOf(huesped.getNacionalidad());
		if(indicePais>0) {
			cmbPaises.setSelectedIndex(indicePais);
		}
		
	}
	
	
	public void mostrarMensaje(String mensaje, String tipo, String titulo) {
		JOptionPane optionPane = new JOptionPane();

		if (tipo.equals("ERROR")) {
			optionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		} else {
			optionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		optionPane.setVisible(true);
	}
	

	public EditarDatos(int numeroReserva) {
		cargarDatos(numeroReserva);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Editar Datos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(246, 0, 267, 41);
		panel.add(lblTitulo);
		
		JLabel lblFechaIngreso = new JLabel("Fecha de check-in");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaIngreso.setBounds(10, 55, 200, 25);
		panel.add(lblFechaIngreso);
		

		dateFechaIngreso.setBounds(10, 90, 200, 30);
		panel.add(dateFechaIngreso);

		JLabel lblFechaSalida = new JLabel("Fecha de check-out");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaSalida.setBounds(10, 130, 200, 25);
		panel.add(lblFechaSalida);
		

		dateFechaSalida.setBounds(10, 165, 200, 30);
		panel.add(dateFechaSalida);
		
	
		lblValorReserva = new JLabel("Valor Reserva");
		lblValorReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorReserva.setBounds(10, 205, 200, 25);
		panel.add(lblValorReserva);
		
		
		
		txtValorReserva.setBackground(new Color(255, 255, 255));
		txtValorReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtValorReserva.setBounds(10, 240, 200, 30);
		panel.add(txtValorReserva);
		
		JLabel lbMedioPago = new JLabel("Medio de pago");
		lbMedioPago.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMedioPago.setBounds(10, 280, 200, 25);
		panel.add(lbMedioPago);
		
		

		cmbMedioPago.setBounds(10, 315, 200, 25);
		panel.add(cmbMedioPago);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(300, 55, 200, 25);
		panel.add(lblNombre);
		
		txtNombre.setBounds(300, 90, 200, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(300, 130, 200, 25);
		panel.add(lblApellido);
		
		txtApellido.setColumns(10);
		txtApellido.setBounds(300, 165, 200, 25);
		panel.add(txtApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeNacimiento.setBounds(300, 205, 200, 25);
		panel.add(lblFechaDeNacimiento);	


		dateFechaNacimiento.setBounds(300, 240, 200, 30);
		panel.add(dateFechaNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNacionalidad.setBounds(300, 280, 200, 25);
		panel.add(lblNacionalidad);
		
		
		String[] paisesOrdenados = toolPaises.GetPaisesOrdenados();


        cmbPaises.setBounds(300, 315, 200, 25);
		panel.add(cmbPaises);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(300, 360, 200, 25);
		panel.add(lblTelefono);
		
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(300, 395, 200, 25);
		panel.add(txtTelefono);
		
		JLabel lblNumeroReserva = new JLabel("Numero reserva");
		lblNumeroReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroReserva.setBounds(300, 430, 200, 25);
		panel.add(lblNumeroReserva);
		
		JLabel labelNumeroReserva = new JLabel(reserva.getId().toString());
		labelNumeroReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNumeroReserva.setBackground(Color.WHITE);
		labelNumeroReserva.setBounds(300, 465, 200, 30);
		panel.add(labelNumeroReserva);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Accept-icon.png")));
		btnGuardar.setBounds(549, 477, 88, 73);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserva.setFechaIngreso(dateFechaIngreso.getDate());
				reserva.setFechaSalida(dateFechaSalida.getDate());
				reserva.setValorReserva(Double.valueOf(txtValorReserva.getText()));
				reserva.setMedioPago((String) cmbMedioPago.getSelectedItem());
				huesped.setNombre(txtNombre.getText());
				huesped.setApellido(txtApellido.getText());
				huesped.setTelefono(txtTelefono.getText());
				huesped.setNacionalidad((String) cmbPaises.getSelectedItem());
				huesped.setFechaNacimiento(dateFechaNacimiento.getDate());
				if(controladora.actualizarReservaHuesped(reserva, huesped)) {
					mostrarMensaje("Actualizado correctamente", "Actualizado", "INFO");
					
				}else {
					mostrarMensaje("Error al actualizar datos", "Error", "ERROR");
				}
				
				Busqueda pantallaEditar = new Busqueda();
				pantallaEditar.setVisible(true);
				pantallaEditar.setLocationRelativeTo(null);	
				dispose();
			}
		});
		panel.add(btnGuardar);
		;
        JButton btnCancelar = new JButton("");
        btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/close-icon.png")));
        btnCancelar.setBounds(675, 477, 88, 73);
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Principal pantallaPrincipal = new Principal();
        		pantallaPrincipal.setVisible(true);
        		pantallaPrincipal.setLocationRelativeTo(null);	
        		dispose();
        	}
        });
	}
}
