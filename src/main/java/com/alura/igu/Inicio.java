package com.alura.igu;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame {

	private JPanel contentPane;


	public Inicio() {
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
		
		
		JLabel lblTitulo = new JLabel("Inicio");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(350, 0, 98, 41);
		panel.add(lblTitulo);
		
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
		ImagenHotel.setHorizontalAlignment(SwingConstants.CENTER);
		ImagenHotel.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/hotel.png")));
		ImagenHotel.setBounds(0, 49, 512, 512);
		panel.add(ImagenHotel);	
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Apps-Computer-Login-icon.png")));
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(664, 49, 100, 120);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login pantalla = new Login();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				dispose();
			}
		});
		
	}
}
