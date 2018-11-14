package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import LectorXML.LectorCastellano;
import configuration.Configuration;
import configuration.ConfigurationLoader;
import datos.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Datos_Cliente extends JFrame {

	private static JPanel contentPane;
	private static JTextField campo_Nombre;
	private static JTextField campo_PrimerApellido;
	private static JTextField campo_Correo;
	private static JTextField campo_Direccion;
	private static JTextField campo_SegundoApellido;
	private static JDateChooser dateChooser;
	private static JRadioButton rdbtnMujer, rdbtnHombre, rdbtnNewRadioButton;
	private static String[] texts;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datos_Cliente frame = new Datos_Cliente(args, null);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {

							int optionPaneSalir = JOptionPane.showConfirmDialog(null, "Quieres salir sin guardar??");

							if (optionPaneSalir == JOptionPane.YES_OPTION) {
								frame.dispose();
							} else if (optionPaneSalir == JOptionPane.NO_OPTION) {
								guardarDatos();
							} else if (optionPaneSalir == JOptionPane.CANCEL_OPTION) {
								frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

							}

						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void guardarDatos() {
		try {
			FileWriter fw = new FileWriter(new File("./src/datos/datosCliente.txt"));
			Cliente c1 = new Cliente(campo_Nombre.getText(), campo_PrimerApellido.getText(),
					campo_SegundoApellido.getText(), campo_Direccion.getText(), campo_Correo.getText(),
					genero(rdbtnHombre, rdbtnMujer, rdbtnNewRadioButton), dateChooser.getDate());
			fw.write(c1.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String genero(JRadioButton rdbtnHombre, JRadioButton rdbtnMujer, JRadioButton rdbtnNewRadioButton) {
		if (rdbtnHombre.isSelected()) {
			return rdbtnHombre.getLabel();
		} else if (rdbtnMujer.isSelected()) {
			return rdbtnMujer.getLabel();
		} else if (rdbtnNewRadioButton.isSelected()) {
			return rdbtnNewRadioButton.getLabel();
		}
		return null;
	}

	public Datos_Cliente(Cliente cliente, String userName) {
		Datos_Cliente frame = new Datos_Cliente(userName, cliente);
		frame.setVisible(true);
	}

	public Datos_Cliente(String userName, Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
		ConfigurationLoader conf = ConfigurationLoader.getConfiguration();
		texts = LectorCastellano.leer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 176, 112, 36, 12, 56, 42, 126, 0 };
		gbl_contentPane.rowHeights = new int[] { 39, 20, 20, 21, 20, 21, 23, 21, 34, 39, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel(texts[8]);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblUsuario = new JLabel(texts[13] + userName);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 4;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);

		JLabel lblNombre = new JLabel(texts[14]);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		campo_Nombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		contentPane.add(campo_Nombre, gbc_textField);
		campo_Nombre.setColumns(10);

		JLabel lblPrimerApellido = new JLabel(texts[15]);
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 1;
		gbc_lblPrimerApellido.gridy = 2;
		contentPane.add(lblPrimerApellido, gbc_lblPrimerApellido);

		campo_PrimerApellido = new JTextField();
		campo_PrimerApellido.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		contentPane.add(campo_PrimerApellido, gbc_textField_1);

		JLabel lblSegundoApellido = new JLabel(texts[16]);
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.fill = GridBagConstraints.BOTH;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 1;
		gbc_lblSegundoApellido.gridy = 3;
		contentPane.add(lblSegundoApellido, gbc_lblSegundoApellido);

		campo_SegundoApellido = new JTextField();
		campo_SegundoApellido.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 3;
		contentPane.add(campo_SegundoApellido, gbc_textField_4);

		JLabel lblDireccin = new JLabel(texts[17]);
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 1;
		gbc_lblDireccin.gridy = 4;
		contentPane.add(lblDireccin, gbc_lblDireccin);

		campo_Direccion = new JTextField();
		campo_Direccion.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 4;
		contentPane.add(campo_Direccion, gbc_textField_2);

		JLabel lblCorreoElectrnico = new JLabel(texts[18]);
		GridBagConstraints gbc_lblCorreoElectrnico = new GridBagConstraints();
		gbc_lblCorreoElectrnico.fill = GridBagConstraints.BOTH;
		gbc_lblCorreoElectrnico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectrnico.gridx = 1;
		gbc_lblCorreoElectrnico.gridy = 5;
		contentPane.add(lblCorreoElectrnico, gbc_lblCorreoElectrnico);

		campo_Correo = new JTextField();
		campo_Correo.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 5;
		contentPane.add(campo_Correo, gbc_textField_3);

		JLabel lblGnero = new JLabel(texts[19]);
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.WEST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 1;
		gbc_lblGnero.gridy = 6;
		contentPane.add(lblGnero, gbc_lblGnero);

		rdbtnHombre = new JRadioButton(texts[20]);
		GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
		gbc_rdbtnHombre.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnHombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHombre.gridx = 2;
		gbc_rdbtnHombre.gridy = 6;
		contentPane.add(rdbtnHombre, gbc_rdbtnHombre);

		rdbtnMujer = new JRadioButton(texts[21]);
		GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
		gbc_rdbtnMujer.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnMujer.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMujer.gridx = 3;
		gbc_rdbtnMujer.gridy = 6;
		contentPane.add(rdbtnMujer, gbc_rdbtnMujer);

		rdbtnNewRadioButton = new JRadioButton(texts[22]);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHombre.setSelected(false);
				rdbtnMujer.setSelected(false);
			}
		});

		rdbtnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHombre.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
			}
		});

		rdbtnHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMujer.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
			}
		});

		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 6;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		JLabel lblFechaNacimiento = new JLabel(texts[23]);
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();

		gbc_lblFechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 7;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);

		JButton btnGuardar = new JButton(texts[3]);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobar()) {
					JOptionPane.showMessageDialog(null, "La operación se ha realizado correctamente");
				}
			}
		});

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.anchor = GridBagConstraints.SOUTH;
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 7;
		contentPane.add(dateChooser, gbc_dateChooser);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.fill = GridBagConstraints.BOTH;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 9;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		JButton btnSiguiente = new JButton(texts[4]);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobar() && email()) {
					Cliente cliente = new Cliente(campo_Nombre.getText(), campo_PrimerApellido.getText(),
							campo_SegundoApellido.getText(), campo_Direccion.getText(), campo_Correo.getText(),
							genero(rdbtnHombre, rdbtnMujer, rdbtnNewRadioButton), dateChooser.getDate());
					fichero_temporal(cliente, userName);
					siguientePantalla(userName, cliente);
				}
			}
		});

		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.insets = new Insets(0, 0, 0, 5);
		gbc_btnSiguiente.anchor = GridBagConstraints.WEST;
		gbc_btnSiguiente.fill = GridBagConstraints.BOTH;
		gbc_btnSiguiente.gridx = 4;
		gbc_btnSiguiente.gridy = 9;
		contentPane.add(btnSiguiente, gbc_btnSiguiente);

		rellenar(cliente);
	}

	private boolean comprobar() {
		if (campo_Nombre.getText().isEmpty() || campo_PrimerApellido.getText().isEmpty()
				|| campo_Correo.getText().isEmpty() || campo_Direccion.getText().isEmpty()
				|| campo_SegundoApellido.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce todos los campos obligatorios");
			return false;
		}
		return true;
	}

	private boolean email() {
		String email = campo_Correo.getText();
		char arroba_char = '@';
		int ar_cont = 0;

		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == arroba_char) {
				ar_cont++;
			}
		}
		if (ar_cont == 1 && email.indexOf("@") != -1 && email.indexOf("@") != email.length() - 1) {
			return true;
		}

		JOptionPane.showMessageDialog(null, "Formanto email incorrecto");
		return false;
	}

	private void siguientePantalla(String userName, Cliente cliente) {
		ModeloCoche.main(userName, cliente);
		setVisible(false);
	}
 
	private void rellenar(Cliente cliente) {
		if (cliente != null) {
			campo_Nombre.setText(cliente.getNombre());
			campo_PrimerApellido.setText(cliente.getPrimer_apellido());
			campo_SegundoApellido.setText(cliente.getSegundo_apellido());
			campo_Direccion.setText(cliente.getDireccion());
			campo_Correo.setText(cliente.getEmail());
			dateChooser.setDate(cliente.getFecha());

			if (rdbtnMujer.getLabel().equals(cliente.getGenero())) {
				rdbtnMujer.setSelected(true);
			}

			if (rdbtnHombre.getLabel().equals(cliente.getGenero())) {
				rdbtnHombre.setSelected(true);
			}

			if (rdbtnNewRadioButton.getLabel().equals(cliente.getGenero())) {
				rdbtnNewRadioButton.setSelected(true);
			}
		}
	}

	private void fichero_temporal(Cliente cliente, String userName) {
		File fichero = new File("fs_employee.txt");
		try {
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Datos Temporales");
			bw.newLine();
			bw.write(userName);
			bw.newLine();
			bw.write(cliente.toString());

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
