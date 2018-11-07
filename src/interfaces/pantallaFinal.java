package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaFinal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String resumen, Integer precioFinal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaFinal frame = new pantallaFinal(resumen,precioFinal);
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
	public pantallaFinal(String resumen, Integer precioFinal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWidths = new int[]{38, 0, 40, 39, 40, 39, 39, 43, 37, 0};
//		gbl_contentPane.rowHeights = new int[]{38, 0, 36, 0, 25, 37, 37, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		contentPane.setLayout(gbl_contentPane);
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel lblNewLabel = new JLabel("Resultado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		contentPane.add(lblNewLabel, constraints);
		
		JTextArea lblNewLabel_1 = new JTextArea(10,30);
		lblNewLabel_1.setText(resumen);
		lblNewLabel_1.setLineWrap(true);
		constraints.gridwidth = 2;
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		contentPane.add(lblNewLabel_1, constraints);
		
		JLabel lblNewLabel_2 = new JLabel(precioFinal.toString());
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.gridx = 3;
		constraints.gridy = 1;
		contentPane.add(lblNewLabel_2, constraints);
		
//		JButton btnNewButton = new JButton("Anterior");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
//		gbc_btnNewButton.gridwidth = 2;
//		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
//		gbc_btnNewButton.gridx = 1;
//		gbc_btnNewButton.gridy = 7;
//		contentPane.add(btnNewButton, gbc_btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Finalizar");
//		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
//		gbc_btnNewButton_1.gridwidth = 2;
//		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
//		gbc_btnNewButton_1.gridx = 6;
//		gbc_btnNewButton_1.gridy = 7;
//		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
