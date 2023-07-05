package com.alura.igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.alura.logica.modelo.Reserva;
import com.alura.persistencia.Controladora;
import com.toedter.calendar.JDateChooser;

public class RegistroReservas extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JDateChooser dateFechaIngreso;
	private JDateChooser dateFechaSalida;
	private JLabel labelValorReserva;
	private JLabel lblValorReserva;
	private double valorReserva;
	private Date fechaIngreso;
	private Date fechaSalida;
	final JComboBox cmbMedioPago;
	
	private Controladora controladora = new Controladora();
	

	public RegistroReservas() {
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
		
		JLabel lblTitulo = new JLabel("Registro reserva");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(246, 0, 267, 41);
		panel.add(lblTitulo);
		
		JLabel lblFechaIngreso = new JLabel("Fecha de check-in");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaIngreso.setBounds(10, 55, 200, 25);
		panel.add(lblFechaIngreso);
		

		dateFechaIngreso = new JDateChooser();
		dateFechaIngreso.setBounds(10, 90, 200, 30);
		dateFechaIngreso.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        fechaIngreso = dateFechaIngreso.getDate();
		        fechaSalida = dateFechaSalida.getDate(); 
		        if (fechaIngreso != null && fechaSalida != null && fechaSalida.compareTo(fechaIngreso) > 0) {
		            actualizarValorReserva(fechaIngreso, fechaSalida);
		        }
			}
		});
		panel.add(dateFechaIngreso);

		JLabel lblFechaSalida = new JLabel("Fecha de check-out");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaSalida.setBounds(10, 130, 200, 25);
		panel.add(lblFechaSalida);
		

		dateFechaSalida = new JDateChooser();
		dateFechaSalida.setBounds(10, 165, 200, 30);
		dateFechaSalida.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        fechaIngreso = dateFechaIngreso.getDate();
		        fechaSalida = dateFechaSalida.getDate();
		        if (fechaIngreso != null && fechaSalida != null && fechaSalida.compareTo(fechaIngreso) > 0) {
		            actualizarValorReserva(fechaIngreso, fechaSalida);
		        }
			}
		});
		panel.add(dateFechaSalida);
		
	
		lblValorReserva = new JLabel("Valor Reserva");
		lblValorReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorReserva.setBounds(10, 205, 200, 25);
		panel.add(lblValorReserva);
		
		labelValorReserva = new JLabel("");
		labelValorReserva.setBackground(new Color(255, 255, 255));
		labelValorReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelValorReserva.setBounds(10, 240, 200, 30);
		panel.add(labelValorReserva);
		
		JLabel lbMedioPago = new JLabel("Medio de pago");
		lbMedioPago.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMedioPago.setBounds(10, 280, 200, 25);
		panel.add(lbMedioPago);
		
		cmbMedioPago = new JComboBox();
		cmbMedioPago.setModel(new DefaultComboBoxModel(new String[] {"-", "Tarjeta de credito", "Tarjeta de debito", "Efectivo"}));
		cmbMedioPago.setBounds(10, 316, 200, 25);
		panel.add(cmbMedioPago);
		
		JButton btnIngresar = new JButton("");
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/Arrow-next-3-icon.png")));
		btnIngresar.setBounds(130, 458, 80, 80);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaIngreso = dateFechaIngreso.getDate();
				Date fechaSalida = dateFechaSalida.getDate();
				String medioPago = (String) cmbMedioPago.getSelectedItem();
				
				if(valorReserva > 0 && !medioPago.equals("-")) {
					Reserva reserva = controladora.crearReserva(fechaIngreso, fechaSalida, valorReserva, medioPago);
					System.out.println("--------------");
					System.out.println(reserva.getFechaIngreso());
					System.out.println("--------------");
					RegistroHuesped pantalla = new RegistroHuesped(reserva);
					pantalla.setVisible(true);
					pantalla.setLocationRelativeTo(null);	
					dispose();
					
				}


			}
		});
		panel.add(btnIngresar);
		
		JLabel ImagenHotel = new JLabel("");
		ImagenHotel.setHorizontalAlignment(SwingConstants.CENTER);
		ImagenHotel.setIcon(new ImageIcon(Login.class.getResource("/IMAGENES/hotel.png")));
		ImagenHotel.setBounds(300, 150, 300, 300);
		panel.add(ImagenHotel);	
		

	}
	
	private void actualizarValorReserva(Date fechaIngreso, Date fechaSalida) {
	    valorReserva = calcularValorReserva(fechaIngreso, fechaSalida);

	    labelValorReserva.setText("Valor de la reserva: " + valorReserva);
	    if (!panel.isAncestorOf(labelValorReserva)) {
	        panel.getRootPane().add(labelValorReserva);
	    }
	    panel.revalidate();
	    panel.repaint();
	}
	
	private double calcularValorReserva(Date fechaIngreso, Date fechaSalida) {

	    long duracionEstadiaMillis = fechaSalida.getTime() - fechaIngreso.getTime();
	    int duracionEstadiaDias = (int) TimeUnit.DAYS.convert(duracionEstadiaMillis, TimeUnit.MILLISECONDS);
	    double tarifaNoche = 100.0;
	    return tarifaNoche * duracionEstadiaDias;
	}
}
