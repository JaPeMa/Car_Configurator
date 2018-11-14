package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LectorXML.LectorCastellano;
import configuration.Configuration;
import configuration.ConfigurationLoader;
import datos.Cliente;
import interfaces.Datos_Cliente;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String[] texts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		// setTitle();
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
		texts = LectorCastellano.leer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 49, 64, 45, 38, 184, 54, 0 };
		gbl_contentPane.rowHeights = new int[] { 38, 38, 32, 0, 30, 41, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblLogin = new JLabel(texts[0]);
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 2;
		contentPane.add(lblLogin, gbc_lblLogin);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel(texts[1]);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		contentPane.add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		contentPane.add(passwordField, gbc_passwordField);

		passwordField.setFocusable(true);
		passwordField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {

			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					comprobacion();
				}
			}

			public void keyReleased(KeyEvent e) {

			}
		});

		JButton btnEntrar = new JButton(texts[2]);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobacion();

			}
		});

		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEntrar.gridx = 4;
		gbc_btnEntrar.gridy = 6;
		contentPane.add(btnEntrar, gbc_btnEntrar);
	}

	private void comprobacion() {
		String user = textField.getText();
		ConfigurationLoader confi = ConfigurationLoader.getConfiguration();
		String[] personas = confi.getEmployee_list();
		String[] pass = confi.getEmployee_password();
		boolean correcto = false, empVersion = false;

		for (int i = 0; i < personas.length; i++) {
			if (personas[i].equals(user) && pass[i].equals(new String(passwordField.getPassword()))) {

				if (confi.isEmployee_version()) {
					empVersion = true;
					JOptionPane.showMessageDialog(null, "Has entrado en la versión de empleado");
				} else {
					JOptionPane.showMessageDialog(null, "No has entrado en la versión de empleado");
				}
				correcto = true;
				if (cargaDatosTemp(user) == true) {
					Datos_Cliente.main(user);
				}
				setVisible(false);
			}
		}
		if (!correcto) {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña introducida no es válida");
		}
	}

	private boolean cargaDatosTemp(String user) {
		File fichero = new File("fs_employee.txt");
		boolean noPuedeCargar = true;
		if (fichero.exists()) {
			try {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				ArrayList<String> datos = new ArrayList<String>();
				String linea;

				while ((linea = br.readLine()) != null) {
					datos.add(linea);
				}

				fr.close();
				br.close();
				if (!datos.isEmpty()) {
					if (datos.get(1).equals(user)) {
						noPuedeCargar = false;

						if (confirmarCarga()) {
							switch (datos.size()) {
							case 3:
								Datos_Cliente pantalla_datos = new Datos_Cliente(obtenerCliente(datos), user);
								break;

							case 4:
								fichero_temporal_borrar();
								ModeloCoche.main(user, obtenerCliente(datos));
								break;

							case 5:
								fichero_temporal_borrar();
								selec_model.main(idCoche(datos));
								break;

							case 7:
								fichero_temporal_borrar();
								fichero_temporal_borrar();
								String[] dc = datos.get(4).split("] ");
								CompraAccesoris.main(idCoche(datos), dc[1].substring(0, dc[1].indexOf(" -")));
								break;

							default:
								break;
							}
						} else {
							noPuedeCargar = true;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return noPuedeCargar;
	}

	private boolean confirmarCarga() {
		int seleccion = JOptionPane.showOptionDialog(null, "Quieres cargar los datos temporales disponibles?", " ",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, " ");

		if (seleccion == 0) {
			return true;
		}
		return false;
	}

	private static String idCoche(ArrayList<String> datos) {
		String[] dc = datos.get(3).split("] ");
		return dc[1];
	}

	private static void fichero_temporal_borrar() {
		File fichero = new File("fs_employee.txt");
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> datos = new ArrayList<String>();
			String linea;

			while ((linea = br.readLine()) != null) {
				datos.add(linea);
			}

			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < datos.size() - 1; i++) {
				bw.write(datos.get(i));
				if (i != datos.size() - 2) {
					bw.newLine();
				}
			}
			bw.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Cliente obtenerCliente(ArrayList<String> datos) {
		Cliente cliente = null;
		String[] dc = datos.get(2).split(",");
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
		Date date;
		try {
			date = formatter.parse(dc[6]);
			cliente = new Cliente(dc[0].substring(dc[0].indexOf("]") + 2), dc[1], dc[2], dc[3], dc[4], dc[5], date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cliente;
	}
}
