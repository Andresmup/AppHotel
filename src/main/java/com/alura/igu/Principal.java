package com.alura.igu;

import java.awt.EventQueue;
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

public class Principal extends JFrame {

	private JPanel contentPane;


	public Principal() {
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
		
		
		JLabel lblTitulo = new JLabel("Menu");
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
		
		JButton btnReservas = new JButton("Reservas");
		btnReservas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReservas.setHorizontalAlignment(SwingConstants.LEFT);
		btnReservas.setVerticalAlignment(SwingConstants.BOTTOM);
		btnReservas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReservas.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Calendar-icon.png")));
		btnReservas.setBounds(664, 70, 100, 120);
		panel.add(btnReservas);
		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroReservas pantalla = new RegistroReservas();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);		
				dispose();
			}
		});
		

		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/search-icon.png")));
		btnBusqueda.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBusqueda.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBusqueda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBusqueda.setBounds(664, 262, 100, 120);
		panel.add(btnBusqueda);
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda pantalla = new Busqueda();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);		
		        dispose();
			}
		});

		
		JLabel ImagenHotel = new JLabel("");
		ImagenHotel.setHorizontalAlignment(SwingConstants.CENTER);
		ImagenHotel.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/hotel.png")));
		ImagenHotel.setBounds(0, 49, 512, 512);
		panel.add(ImagenHotel);	
		
	}
}
