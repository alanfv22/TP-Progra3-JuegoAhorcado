package vista;

import modelo.Sonido;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Component;

public class InterfazFinal {

	private JFrame frame;

	private boolean ganador;
	private boolean perdedor;

	private Sonido sonidoFinal;

	private JLabel lblimg;
	private ImageIcon imgs;
	private ImageIcon ico;
	private int musica;

	public InterfazFinal(int musica) {
		this.musica = musica;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		createJFrame();

		perdedor = false;
		ganador = false;

		createButtonJugar();

		createButtonSalir();

		cerrar();
	}

	private void createJFrame() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Gothic Medium", Font.PLAIN, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(890, 680));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	// Muestra una imagen dependiendo si el usuario perdio o gano el juego //

	public void juegoPerdedor(boolean perdiste) {
		if (perdiste) {
			JLabel gameOver = new JLabel();
			gameOver.setIcon(new ImageIcon(InterfazFinal.class.getResource("/mult/gameOver.png")));
			gameOver.setBounds(280, 255, 295, 147);
			frame.getContentPane().add(gameOver);
			perdedor = true;
			imagenDeFondoPerdedor();

		}
	}

	public void juegoGanador(boolean ganaste) {
		if (ganaste) {
			JLabel win = new JLabel();
			win.setIcon(new ImageIcon(InterfazFinal.class.getResource("/mult/winner.png")));
			win.setBounds(280, 255, 360, 150);
			frame.getContentPane().add(win);
			ganador = true;
			imagenDeFondoGanador();
		}
	}

	private void imagenDeFondoGanador() {
		lblimg = new JLabel();
		lblimg.setBounds(0, 0, 874, 642);
		imgs = new ImageIcon(getClass().getResource("/mult/ahorcadoFinalGanador.jpeg"));
		ico = new ImageIcon(
				imgs.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH));
		lblimg.setIcon(ico);
		frame.getContentPane().add(lblimg);

	}

	private void imagenDeFondoPerdedor() {
		lblimg = new JLabel();
		lblimg.setBounds(0, 0, 874, 642);
		imgs = new ImageIcon(getClass().getResource("/mult/ahorcadoFinalPerdedor.jpg"));
		ico = new ImageIcon(
				imgs.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH));
		lblimg.setIcon(ico);
		frame.getContentPane().add(lblimg);

	}

	/*
	 * Chequea si el usuario presiono el evento del boton jugar de nuevo para poder
	 * ir a la interfazInicial
	 */

	private void createButtonJugar() {
		JButton btnJugarDeNuevo = new JButton("Jugar De Nuevo");
		btnJugarDeNuevo.setBounds(217, 443, 430, 83);
		frame.getContentPane().add(btnJugarDeNuevo);
		btnJugarDeNuevo.setForeground(Color.WHITE);
		btnJugarDeNuevo.setBackground(Color.BLACK);
		btnJugarDeNuevo.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 15));
        comportamientoButtonJugar(btnJugarDeNuevo);
	}

	private void comportamientoButtonJugar(JButton btnJugarDeNuevo) {
		btnJugarDeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazInicial ventanaInicio = new InterfazInicial();
				ventanaInicio.setVisible(true);
				frame.dispose();
			}
		});
	}

	/*
	 * Chequea si el usuario presiono el evento del boton salir para cerrar la
	 * interfaz
	 */

	private void createButtonSalir() {
		JButton btn_salir = new JButton("Salir");
		btn_salir.setBounds(217, 522, 430, 83);
		frame.getContentPane().add(btn_salir);
		btn_salir.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_salir.setForeground(Color.WHITE);
		btn_salir.setBackground(Color.BLACK);
		btn_salir.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 15));
		comportamientoButtonSalir(btn_salir);
	}
	
	private void comportamientoButtonSalir(JButton btn_salir) {

		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void setVisible(boolean valor) {
		frame.setVisible(valor);
	}

	// Detiene el sonido de la interfaz si esta misma es cerrada //

	private void cerrar() {
		try {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frame.dispose();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
