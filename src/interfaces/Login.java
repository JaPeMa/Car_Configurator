package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LectorXML.LectorCastellano;
import configuration.Configuration;
import configuration.ConfigurationLoader;
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
import java.io.File;
import java.util.Arrays;
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
		//setTitle(); 
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Car_Configurator/icono.png"));
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
		boolean correcto=false, empVersion = false;

		for (int i = 0; i < personas.length; i++) {
			if (personas[i].equals(user) && pass[i].equals(new String(passwordField.getPassword()))) {
				
				if (confi.isEmployee_version()) {
					empVersion = true;
					JOptionPane.showMessageDialog(null, "Has entrado en la versión de empleado");
				}else {
					JOptionPane.showMessageDialog(null, "No has entrado en la versión de empleado");
				}
				
				correcto=true;
				Datos_Cliente.main(user);
				setVisible(false);
			}
		}
		if (!correcto) {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña introducida no es válida");
		}	
	}
}
