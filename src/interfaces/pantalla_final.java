package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JButton;

public class pantalla_final extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String resumen, Integer precioFinal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_final frame = new pantalla_final(resumen,precioFinal);
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
	public pantalla_final(String resumen, Integer precioFinal) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Car_Configurator/icono.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 186, 102, 65, 64, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblResultado = new JLabel("RESULTADO");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.insets = new Insets(0, 0, 5, 5);
		gbc_lblResultado.gridx = 1;
		gbc_lblResultado.gridy = 0;
		contentPane.add(lblResultado, gbc_lblResultado);
		
		JTextArea textArea = new JTextArea(resumen);
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		contentPane.add(textArea, gbc_textArea);
		
		JLabel label = new JLabel(precioFinal.toString());
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 2;
		contentPane.add(label, gbc_label);
		
		JButton btnNewButton = new JButton("NUEVO");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Datos_Cliente.main("??");
				setVisible(false);
			}
		});
	}

}
