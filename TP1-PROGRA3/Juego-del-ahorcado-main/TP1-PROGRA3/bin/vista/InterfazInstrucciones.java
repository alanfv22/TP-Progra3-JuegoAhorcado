package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfazInstrucciones {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInstrucciones window = new InterfazInstrucciones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazInstrucciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("JUEGO AHORCADO");
		frame.setBounds(20, 100, 600, 600);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		agregarImagen();
		
	}
	public void agregarImagen() {
		/* agrego imagen */

		JLabel lbl_imagen = new JLabel("");

		ImageIcon img = new ImageIcon(getClass().getResource("/mult/instrucciones.jpg"));// ruta o imagen q quiero
																							// guardar grande
		// este codigo es para escalar la imagen
		Image i = img.getImage();// guardo la imagen original en i(convierto ImageIcon en Image)
		Image new_img = i.getScaledInstance(600, 578, Image.SCALE_SMOOTH);// escalo imagen (al JLabel-cuadro1)y la
																			// guardo en new_img
		img = new ImageIcon(new_img);// guardo la imagen escalada a la img (del principio, el JLabel)

		lbl_imagen.setIcon(img);
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_imagen, BorderLayout.CENTER);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);

	}
}
