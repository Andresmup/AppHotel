package com.alura.igu;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.alura.persistencia.Controladora;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordClave;
	private Controladora controladora = new Controladora();


	public Login() {
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
		
		
		
		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(348, 11, 98, 41);
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(410, 82, 364, 273);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(0, 0, 200, 25);
		panel_1.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(0, 72, 200, 25);
		panel_1.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(0, 36, 200, 25);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordClave = new JPasswordField();
		passwordClave.setBounds(0, 108, 200, 25);
		panel_1.add(passwordClave);
		passwordClave.setColumns(10);
		
		JButton btnIngresar = new JButton("");
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Accept-icon.png")));
		btnIngresar.setBounds(54, 189, 88, 73);
		panel_1.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String clave = passwordClave.getText();
				if(controladora.login(usuario,clave)) {
					Principal pantalla = new Principal();
					pantalla.setVisible(true);
					pantalla.setLocationRelativeTo(null);		
					dispose();
				}else {
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Usuario y/o clave no validos","Credenciales invalidas",JOptionPane.ERROR_MESSAGE);
					optionPane.setVisible(true);
					txtUsuario.setText("");
					passwordClave.setText("");
				}
				
				
			}
		});
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/delete-1-icon.png")));
		btnLimpiar.setBounds(245, 189, 88, 73);
		panel_1.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				passwordClave.setText("");
			}
		});
		
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Users-Exit-icon.png")));
		btnSalir.setBounds(684, 453, 80, 80);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        System.exit(0);
			}
		});
		
		
		JLabel ImagenHotel = new JLabel("");
		ImagenHotel.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/hotel.png")));
		ImagenHotel.setHorizontalAlignment(SwingConstants.CENTER);
		ImagenHotel.setBounds(0, 82, 400, 479);
		panel.add(ImagenHotel);

		
	}
}

