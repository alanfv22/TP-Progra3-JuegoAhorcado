package vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Juego;
import modelo.Sonido;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazAhorcado extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JLabel titulo;
	private JLabel muestraPalabra;
	private JLabel lblIntentosRestantes;
	private JLabel imagenAhorcado;

	private ImageIcon imgs[];

	private Sonido sonidoAhorcado;
	private Juego juego;

	private int cantImagenes;
	private int dificultad;
	private int idioma;
	private int musica;
	private char letraUsuario;
	private JLabel lblimg;
	private ImageIcon img;
	private ImageIcon ico;
	

	private InterfazFinal juegoFinal;

	// Constructor
	public InterfazAhorcado(int dificultad, int idioma, int musica) {
		this.dificultad = dificultad;
		this.idioma = idioma;
		this.musica = musica;

		initialize();

	}
//	  Inicializar la interfazAhorcado

	private void initialize() {
		setResizable(false);
		juego = new Juego(dificultad, idioma);
		createJFrame();
		createJPanel();
		createTitulo();
		createMenu();
		cargarImagenTitulo();
		muestraGuiones();
		crearIntentosJuego();
		cargarImagenesAhorcado();
		comportamientoBotones();
		imagenDeFondo();
		reproducirSonido();
		cerrar();
	}

	private void createJFrame() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}

	private void createJPanel() {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

	private void cargarImagenTitulo() {
		imagenAhorcado = new JLabel();
		imagenAhorcado.setBounds(600, 135, 262, 231);
		panel.add(imagenAhorcado);
	}

	private void createTitulo() {
		titulo = new JLabel("Juego Ahorcado");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setIcon(new ImageIcon(InterfazAhorcado.class.getResource("/mult/titulo.png")));
		titulo.setBounds(282, 35, 307, 420);
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));

		panel.add(titulo);
	}


	private void createMenu() {

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		// creacion del menu Archivo

		JMenu menu_archivo = new JMenu("Archivo");
		menuBar.add(menu_archivo);
		menu_archivo.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		menu_archivo.setForeground(Color.WHITE);
		menu_archivo.setBackground(Color.WHITE);

		// items de menu
		JMenuItem menu_archivo_nuevo = new JMenuItem("Nuevo");
		JMenuItem menu_archivo_nuevaPartida = new JMenuItem("Reiniciar Partida");
		JMenuItem menu_archivo_salir = new JMenuItem("Salir");

		menu_archivo_nuevo.setBackground(Color.white);
		menu_archivo_nuevaPartida.setBackground(Color.white);
		menu_archivo_salir.setBackground(Color.white);

		// nuevo. reinicia el juego desde la interfazAhorcado//
		menu_archivo_nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detenerSonido();
				cerrarVentana();
				InterfazAhorcado ventanaJuego = new InterfazAhorcado(dificultad, idioma, musica);
				ventanaJuego.setVisible(true);
				ventanaJuego.setSize(890, 680);
				ventanaJuego.setLocationRelativeTo(null);
				ventanaJuego.setVisible(true);

			}

		});

		// Reinicia el juego desde la interfazInicial//
		menu_archivo_nuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detenerSonido();
				cerrarVentana();
				InterfazInicial ventanaInicio = new InterfazInicial();
				ventanaInicio.setVisible(true);

			}
		});
		// Cierra la interfazAhorcado //
		menu_archivo_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detenerSonido();
				System.exit(0);

			}
		});
		menu_archivo.add(menu_archivo_nuevo);
		menu_archivo.add(menu_archivo_nuevaPartida);
		menu_archivo.add(menu_archivo_salir);

		// creacion del menu Ayuda
		JMenu menu_ayuda = new JMenu("Ayuda");
		menu_ayuda.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		menu_ayuda.setForeground(Color.WHITE);
		menu_ayuda.setBackground(Color.WHITE);
		menuBar.add(menu_ayuda);

		// Muestra la ventana InterfazInstrucciones //
		JMenuItem menu_ayuda_acercade = new JMenuItem("Acerca del juego");
		menu_ayuda_acercade.setBackground(Color.white);
		menu_ayuda_acercade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazInstrucciones ventanaInfo = new InterfazInstrucciones();
				ventanaInfo.setVisible(true);
			}
		});
		menu_ayuda.add(menu_ayuda_acercade);
	}

	// Detiene el sonido de la interfazAhorcado si esta misma es cerrada //

	private void cerrar() {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					detenerSonido();
					cerrarVentana();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cerrarVentana() {
		this.setVisible(false);
	}

	private void cargarImagenesAhorcado() {
		cantImagenes = juego.getDificultad();
		imgs = new ImageIcon[7];

		imgs[1] = new ImageIcon(getClass().getResource("/mult/Intento1.jpeg"));
		imgs[2] = new ImageIcon(getClass().getResource("/mult/Intento2.jpeg"));
		imgs[3] = new ImageIcon(getClass().getResource("/mult/Intento3.jpeg"));
		imgs[4] = new ImageIcon(getClass().getResource("/mult/Intento4.jpeg"));
		imgs[5] = new ImageIcon(getClass().getResource("/mult/Intento5.jpeg"));
		imgs[6] = new ImageIcon(getClass().getResource("/mult/Intento6.jpeg"));
	}

	// Muestra la imagen dependiendo si el usuario falla el intento //

	private void mostrarImagenAhorcado() {
		if (!juego.acertoLetraEnPalabra(letraUsuario) && cantImagenes >= 0 && juego.getIntentos() > 0) {
			imagenAhorcado.setIcon(imgs[cantImagenes]);
			cantImagenes++;
		}
	}

	private void imagenDeFondo() {
		lblimg = new JLabel();
		lblimg.setBounds(0, 0, 874, 642);
		img = new ImageIcon(getClass().getResource("/mult/ahorcadoFinalGanador.jpeg"));
		ico = new ImageIcon(
				img.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH));
		lblimg.setIcon(ico);
		frame.getContentPane().add(lblimg);
	}
	// Chequea si el juego esta perdido o ganado //

	private void chequearJuego() {
		if (juego.ganoPerdio()) {
			juegoFinal = new InterfazFinal(this.musica);
			if (juego.getJuegoGanador()) {
				juegoFinal.juegoGanador(juego.getJuegoGanador());
				detenerSonido();
			} else {
				juegoFinal.juegoPerdedor(juego.getJuegoPerdedor());
				detenerSonido();
				
				JOptionPane.showMessageDialog(null,
						"la palabra era: " + juego.getPalabra());
			}
			juegoFinal.setVisible(true);
			cerrarVentana();
		}

	}

	private void chequearIntentosRestantes() {
		lblIntentosRestantes.setText(juego.chequearIntentos(letraUsuario));
	}

	// Muestra la imagen de los intentos actuales del juego //

	private void crearIntentosJuego() {
		lblIntentosRestantes = new JLabel("" + juego.getIntentos());
		lblIntentosRestantes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 40));
		lblIntentosRestantes.setForeground(Color.RED);
		lblIntentosRestantes.setBounds(236, 71, 111, 50);
		panel.add(lblIntentosRestantes);

		JLabel imagenIntentos = new JLabel("");
		imagenIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		imagenIntentos.setIcon(new ImageIcon(InterfazAhorcado.class.getResource("/mult/Intentos.png")));
		imagenIntentos.setForeground(Color.WHITE);
		imagenIntentos.setBounds(28, 72, 203, 50);
		panel.add(imagenIntentos);

	}
	/*
	 * Muestra botones en pantalla y a su vez llama a un metodo que se encargará
	 * de verificar el evento de este boton para asi chequear lo que resta del juego
	 */  

	private void comportamientoBotones() {
		int x = 150;
		int y = 450;
		int amplitud = 60;
		int altura = 50;

		for (int i = 0; i < 26; i++) {
			String letra = "" + (char) (65 + i);
			JButton botonLetra = new JButton(letra.toLowerCase());
			comportamientoJuego(botonLetra);

			botonLetra.setBounds(x, y, amplitud, altura);
			botonLetra.setFont(new Font("Cooper Black", 2, 15));
			botonLetra.setBackground(Color.white);
			botonLetra.setBorder(BorderFactory.createLineBorder(Color.red, 1));

			x = x + 60;
			if (letra.equalsIgnoreCase("i") && y == 450) {
				x = 150;
				y = y + 50;
			}
			if (letra.equalsIgnoreCase("r") && y == 500) {
				x = 170;
				y = y + 50;
			}
			panel.add(botonLetra);
		}
	}
	
	
	private void comportamientoJuego(JButton botonLetra) {
		botonLetra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				letraUsuario = botonLetra.getText().charAt(0);
				mostrarLetraEnPalabra();
				chequearIntentosRestantes();
				botonLetra.setEnabled(false);
				mostrarImagenAhorcado();
				chequearJuego();
			}
		});
	}
	// muestra la palabra elegida al azar transformada en guiones //

	private void muestraGuiones() {
		muestraPalabra = new JLabel();
		muestraPalabra.setForeground(Color.WHITE);
		muestraPalabra.setFont(new Font("Tahoma", Font.PLAIN, 26));
		muestraPalabra.setBounds(77, 219, 426, 128);
		panel.add(muestraPalabra);
		muestraPalabra.setText(juego.mostrarPalabraGuiones());
	}

	// muestra la letra acertada por el usuario en los guiones //

	private void mostrarLetraEnPalabra() {
		if (juego.acertoLetraEnPalabra(letraUsuario)) {
			muestraPalabra.setText(juego.dibujarLetraAcertada(letraUsuario));
		}
	}

	private void cargarSonido() {
		sonidoAhorcado = new Sonido();
		sonidoAhorcado.ReproducirSonidoLoop("src/mult/sonidoAhorcado.wav");

	}

	private void detenerSonido() {
		if (this.musica == 1) {
			sonidoAhorcado.detenerSonido();
		}
	}

	private void reproducirSonido() {
		if (this.musica == 1) {
			cargarSonido();
		}
	}
}
