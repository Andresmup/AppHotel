package com.alura.igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.alura.logica.modelo.Reserva;
import com.alura.persistencia.Controladora;
import com.alura.utils.ToolPaises;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	
	private ToolPaises toolPaises = new ToolPaises();
	private Controladora controladora = new Controladora();


	public RegistroHuesped(Reserva reserva) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registro Huesped");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(246, 0, 267, 41);
		panel.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 62, 200, 25);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 91, 200, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(10, 127, 200, 25);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(10, 158, 200, 25);
		panel.add(txtApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeNacimiento.setBounds(10, 194, 200, 25);
		panel.add(lblFechaDeNacimiento);	

		JDateChooser dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(10, 230, 200, 30);
		dateNacimiento.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(dateNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNacionalidad.setBounds(10, 271, 200, 25);
		panel.add(lblNacionalidad);
		
		
		String[] paisesOrdenados = toolPaises.GetPaisesOrdenados();

        final JComboBox cmbPaises = new JComboBox();
        cmbPaises.setModel(new DefaultComboBoxModel(paisesOrdenados));
        cmbPaises.setBounds(10, 307, 200, 22);
		panel.add(cmbPaises);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(10, 350, 200, 25);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(10, 386, 200, 25);
		panel.add(txtTelefono);
		
		JLabel lblNumeroReserva = new JLabel("Numero reserva");
		lblNumeroReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroReserva.setBounds(10, 422, 200, 25);
		panel.add(lblNumeroReserva);
		
		JLabel labelNumeroReserva = new JLabel(reserva.getId().toString());
		labelNumeroReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNumeroReserva.setBackground(Color.WHITE);
		labelNumeroReserva.setBounds(10, 454, 200, 30);
		panel.add(labelNumeroReserva);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setBounds(409, 454, 80, 80);
		btnGuardar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Accept-icon.png")));
		panel.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				Date fechaNacimiento = dateNacimiento.getDate();
				String nacionalidad = (String) cmbPaises.getSelectedItem();
				String telefono = txtTelefono.getText();
				if(controladora.completarDatosHuesped(nombre,apellido,fechaNacimiento, nacionalidad, telefono, reserva)) {
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Guardado correctamente","Guardado exitoso",JOptionPane.INFORMATION_MESSAGE);
					optionPane.setVisible(true);
					Principal pantalla = new Principal();
					pantalla.setVisible(true);
					pantalla.setLocationRelativeTo(null);	
					dispose();
				} else {
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Guardado incorrecto","Guardado fallido",JOptionPane.ERROR_MESSAGE);
					optionPane.setVisible(true);
				}
				
				
				

			}
		});
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setBounds(532, 455, 80, 80);
		btnLimpiar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/delete-1-icon.png")));
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtApellido.setText("");
				dateNacimiento.setDate(null);
				cmbPaises.setSelectedIndex(0);
			}
		});
		
		JButton btnSalir = new JButton("");
		btnSalir.setBounds(655, 455, 80, 80);
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Users-Exit-icon.png")));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        System.exit(0);
			}
		});
		


		
		
	}
}
