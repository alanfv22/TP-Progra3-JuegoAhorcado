package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

import modelo.Juego;
import modelo.Sonido;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazInicial {

	private JFrame frame;
	private ButtonGroup buttonGroup;
	private JRadioButton btnEspaniol;
	private JRadioButton btnIngles;
	private InterfazAhorcado interfazAhorcado;
	private int indiceDificultad;
	private int indiceIdioma;
	private int indiceMusica = 1;
	private JComboBox comboBox_Dificultad;
	private Juego juego;
	private Sonido sonidoInicio;

	private JLabel lblimg;
	private ImageIcon imgs;
	private ImageIcon ico;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInicial window = new InterfazInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazInicial() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(890, 680));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // no se podra expandir la pantalla queda estatica

		juego = new Juego(indiceDificultad, indiceIdioma);

		crearTituloJuego();

		crearDificultades();

		labelSeleccionDificultad();

		labelSeleccionIdioma();

		buttonGroupIdioma();

		creacionBtnJugar();

		labelSeleccionarConfiguracion();

		checkBoxMusica();

		imagenDeFondo();

		cargarSonido();

	}



	
	//Creacion de componentes
	
	private void creacionBtnJugar() {
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setForeground(Color.BLACK);
		btnJugar.setBounds(322, 514, 232, 59);
		validacionBtnJugar(btnJugar);
		btnJugar.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		frame.getContentPane().add(btnJugar);
	}
	
	private void labelSeleccionIdioma() {
		JLabel lblNewLabel_Idioma = new JLabel("Seleccione idioma del juego");
		lblNewLabel_Idioma.setForeground(Color.WHITE);
		lblNewLabel_Idioma.setBounds(10, 271, 284, 22);
		lblNewLabel_Idioma.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_Idioma);
	}

	private void labelSeleccionDificultad() {
		JLabel lblNewLabel_Dificultad = new JLabel("Seleccione dificultad del juego");
		lblNewLabel_Dificultad.setForeground(Color.WHITE);
		lblNewLabel_Dificultad.setBounds(10, 155, 297, 21);
		lblNewLabel_Dificultad.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_Dificultad);
	}

	

	private void crearDificultades() {
		comboBox_Dificultad = new JComboBox();
		comboBox_Dificultad.setBackground(Color.GRAY);
		comboBox_Dificultad.setBounds(322, 153, 196, 27);
		comboBox_Dificultad.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		frame.getContentPane().add(comboBox_Dificultad);
		comboBox_Dificultad.setModel(
				new DefaultComboBoxModel(new String[] { "Selecciona dificultad", "Facil", "Intermedio", "Dificil" }));
	}

	private void crearTituloJuego() {
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Juego del ahorcado");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(322, 38, 356, 34);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}



	private void buttonGroupIdioma() {

		buttonGroup = new ButtonGroup();

		btnEspaniol = new JRadioButton("Español");
		btnEspaniol.setForeground(Color.LIGHT_GRAY);
		btnEspaniol.setBounds(317, 248, 103, 21);
		btnEspaniol.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		btnEspaniol.setOpaque(false);
		btnEspaniol.setContentAreaFilled(false);
		btnEspaniol.setBorderPainted(false);
		buttonGroup.add(btnEspaniol);
		frame.getContentPane().add(btnEspaniol);

		btnIngles = new JRadioButton("Ingles");
		btnIngles.setForeground(Color.LIGHT_GRAY);
		btnIngles.setBounds(317, 292, 103, 21);
		btnIngles.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		btnIngles.setOpaque(false);
		btnIngles.setContentAreaFilled(false);
		btnIngles.setBorderPainted(false);
		buttonGroup.add(btnIngles);
		frame.getContentPane().add(btnIngles);

	}
	
	private void labelSeleccionarConfiguracion() {
		JLabel lblSelectConfig = new JLabel("Seleccione configuracion");
		lblSelectConfig.setForeground(Color.WHITE);
		lblSelectConfig.setBounds(10, 403, 271, 21);
		lblSelectConfig.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		frame.getContentPane().add(lblSelectConfig);
	}
	
	private void checkBoxMusica() {
		JCheckBox musica = new JCheckBox("Musica");
		musica.setSelected(true);
		configuracionMusica(musica);
		musica.setForeground(Color.LIGHT_GRAY);
		musica.setBackground(Color.GRAY);
		musica.setBounds(317, 405, 93, 21);
		musica.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		musica.setOpaque(false);
		musica.setContentAreaFilled(false);
		musica.setBorderPainted(false);
		frame.getContentPane().add(musica);
	}

	private void imagenDeFondo() {
		lblimg = new JLabel();
		lblimg.setBounds(0, 0, 874, 642);
		imgs = new ImageIcon(getClass().getResource("/mult/ahorcadoInicialFondo.jpg"));
		ico = new ImageIcon(
				imgs.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH));
		lblimg.setIcon(ico);
		frame.getContentPane().add(lblimg);
	}
	

	public void cargarSonido() {
		sonidoInicio = new Sonido();
		sonidoInicio.ReproducirSonidoLoop("src/mult/sonidoInicio.wav");
	}
	

	// Chequea si el usuario elige dificultad e idioma, en caso contrario no se podra jugar //
	private void validacionBtnJugar(JButton btnJugar) {
		btnJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		
				obtenerDificultadEIdioma();
				if (juego.invalidacionDelJuego(indiceDificultad, indiceIdioma)) { // se verifica que el usuario
																					// seleccione idioma y dificultad
																					// del juego
					JOptionPane.showMessageDialog(null,
					juego.invalidacionDelJuegoMensaje(indiceDificultad, indiceIdioma));
				
					setVisible(true);
				}
				else { // Si los datos son validos, paso a interfazAhorcado
					interfazAhorcado = new InterfazAhorcado(indiceDificultad, indiceIdioma, indiceMusica);
					interfazAhorcado.setVisible(true);
					interfazAhorcado.setSize(890, 680);
					interfazAhorcado.setLocationRelativeTo(null);
					sonidoInicio.detenerSonido();
					frame.setVisible(false);
					frame.dispose();
				}
			}

			
		});
	}
	
	private void obtenerDificultadEIdioma() {
		indiceDificultad = comboBox_Dificultad.getSelectedIndex();// obtengo dificultad ingresada por el usuario

		if (btnEspaniol.isSelected()) // obtengo idioma ingresado por el usuario
			indiceIdioma = 1;
		if (btnIngles.isSelected())
			indiceIdioma = 2;
	}
	
	// Chequea si el usuario elige la opcion de musica //
	
	private void configuracionMusica(JCheckBox musica) {
		musica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!musica.isSelected()) {
					sonidoInicio.detenerSonido();
					indiceMusica = 0;
				} else {
					sonidoInicio.ReproducirSonido("src/mult/sonidoInicio.wav");
					indiceMusica = 1;
				}
			}
		});
	}



}
