package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LectorXML.LectorCastellano;
import LectorXML.LectorCochesConfig;
import datos.Cliente;
import idao.ICoches;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class CompraAccesoris extends JFrame {

	private JPanel contentPane;
	private JTextField textField = new JTextField();
	static ICoches gestorCars = new LectorCochesConfig();
	static int suma = 0;
	String accesoriesSelecteds = "";
	Model model = null;
	Engine engine = null;

	/**
	 * Launch the application.
	 * @param cliente 
	 */
	public static void main(String args, String engineId, String user, Cliente cliente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraAccesoris frame = new CompraAccesoris(args, engineId, user, cliente);
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
	public CompraAccesoris(String modelId, String engineId, String user,Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));

		ArrayList<Accesory> accesories = gestorCars.getAccesoryAll();

		for (Model modelAux : gestorCars.getModelAll()) {
			if (modelAux.getId().equals(modelId))
				model = modelAux;
		}

		for (Engine engineAux : gestorCars.getEngineAll()) {
			if (engineAux.getId().equals(engineId))
				engine = engineAux;
		}
		suma = Integer.parseInt(model.getPrice()) + Integer.parseInt(engine.getPrice());
		textField.setText(String.valueOf(suma));
		textField.setEditable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 37, 0, 0, 0, 37, 0, 6, 0, 141, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 32, 20, 0, 0, 0, 37, 0, 38, 0, 26, 0, 38, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Compra de Accesorios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 7;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ACCESORIOS");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 8;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		ICoches configcoches = new LectorCochesConfig();

		JCheckBox chckbxNewCheckBox = new JCheckBox(accesories.get(0).getName());
		chckbxNewCheckBox.setEnabled(((isEnabled(accesories.get(0).getId(), modelId))));
		chckbxNewCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suma = chckbxNewCheckBox.isSelected() ? suma + Integer.parseInt(accesories.get(0).getPrice())
						: suma - Integer.parseInt(accesories.get(0).getPrice());
				textField.setText(String.valueOf(suma));
				accesoriesSelecteds = accesoriesSelecteds.concat(accesories.get(0).getDescript());
			}
		});
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.gridwidth = 2;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 4;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JCheckBox chckbxNavegador = new JCheckBox(accesories.get(1).getName());
		chckbxNavegador.setEnabled(((isEnabled(accesories.get(1).getId(), modelId))));
		chckbxNavegador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suma = chckbxNavegador.isSelected() ? suma + Integer.parseInt(accesories.get(1).getPrice())
						: suma - Integer.parseInt(accesories.get(1).getPrice());
				textField.setText(String.valueOf(suma));
				accesoriesSelecteds = accesoriesSelecteds.concat(accesories.get(0).getDescript());
			}
		});
		chckbxNavegador.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNavegador = new GridBagConstraints();
		gbc_chckbxNavegador.gridwidth = 2;
		gbc_chckbxNavegador.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNavegador.gridx = 7;
		gbc_chckbxNavegador.gridy = 4;
		contentPane.add(chckbxNavegador, gbc_chckbxNavegador);

		JCheckBox chckbxYantasDeAleacin = new JCheckBox(accesories.get(2).getName());
		chckbxYantasDeAleacin.setEnabled(((isEnabled(accesories.get(2).getId(), modelId))));
		chckbxYantasDeAleacin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suma = chckbxYantasDeAleacin.isSelected() ? suma + Integer.parseInt(accesories.get(2).getPrice())
						: suma - Integer.parseInt(accesories.get(2).getPrice());
				textField.setText(String.valueOf(suma));
				accesoriesSelecteds = accesoriesSelecteds.concat(accesories.get(0).getDescript());
			}
		});
		chckbxYantasDeAleacin.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxYantasDeAleacin = new GridBagConstraints();
		gbc_chckbxYantasDeAleacin.gridwidth = 2;
		gbc_chckbxYantasDeAleacin.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxYantasDeAleacin.gridx = 1;
		gbc_chckbxYantasDeAleacin.gridy = 6;
		contentPane.add(chckbxYantasDeAleacin, gbc_chckbxYantasDeAleacin);

		JCheckBox chckbxAsientosCalfectados = new JCheckBox(accesories.get(3).getName());
		chckbxAsientosCalfectados.setEnabled(((isEnabled(accesories.get(3).getId(), modelId))));
		chckbxAsientosCalfectados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suma = chckbxAsientosCalfectados.isSelected() ? suma + Integer.parseInt(accesories.get(3).getPrice())
						: suma - Integer.parseInt(accesories.get(3).getPrice());
				textField.setText(String.valueOf(suma));
				accesoriesSelecteds = accesoriesSelecteds.concat(accesories.get(0).getDescript());
			}
		});
		chckbxAsientosCalfectados.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxAsientosCalfectados = new GridBagConstraints();
		gbc_chckbxAsientosCalfectados.gridwidth = 2;
		gbc_chckbxAsientosCalfectados.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAsientosCalfectados.gridx = 7;
		gbc_chckbxAsientosCalfectados.gridy = 6;
		contentPane.add(chckbxAsientosCalfectados, gbc_chckbxAsientosCalfectados);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox(accesories.get(4).getName());
		chckbxNewCheckBox_1.setEnabled(((isEnabled(accesories.get(4).getId(), modelId))));
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suma = chckbxNewCheckBox_1.isSelected() ? suma + Integer.parseInt(accesories.get(4).getPrice())
						: suma - Integer.parseInt(accesories.get(4).getPrice());
				textField.setText(String.valueOf(suma));
				accesoriesSelecteds = accesoriesSelecteds.concat(accesories.get(0).getDescript());

			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.gridwidth = 2;
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 1;
		gbc_chckbxNewCheckBox_1.gridy = 8;
		contentPane.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);

		JCheckBox chckbxAparcamientoAutotico = new JCheckBox(accesories.get(5).getName());
		chckbxAparcamientoAutotico.setEnabled(((isEnabled(accesories.get(5).getId(), modelId))));
		chckbxAparcamientoAutotico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suma = chckbxAparcamientoAutotico.isSelected() ? suma + Integer.parseInt(accesories.get(5).getPrice())
						: suma - Integer.parseInt(accesories.get(5).getPrice());
				textField.setText(String.valueOf(suma));
				accesoriesSelecteds = accesoriesSelecteds.concat(accesories.get(0).getDescript());

			}
		});
		chckbxAparcamientoAutotico.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxAparcamientoAutotico = new GridBagConstraints();
		gbc_chckbxAparcamientoAutotico.gridwidth = 2;
		gbc_chckbxAparcamientoAutotico.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAparcamientoAutotico.gridx = 7;
		gbc_chckbxAparcamientoAutotico.gridy = 8;
		contentPane.add(chckbxAparcamientoAutotico, gbc_chckbxAparcamientoAutotico);

		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 12;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Anterior");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fichero_temporal_borrar();
				selec_model.main(modelId, user, cliente);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 14;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fichero_temporal(obtener_accesorios(chckbxYantasDeAleacin, chckbxNavegador, chckbxNewCheckBox,
						chckbxAparcamientoAutotico, chckbxNewCheckBox_1, chckbxAsientosCalfectados));
				pantalla_final.main(model.getName() + engine.getName() + accesoriesSelecteds, suma, user);
				setVisible(false);

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 14;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

	public boolean isEnabled(String accesoryId, String modelId) {
		Accesory acc = null;
		for (Accesory accesory : gestorCars.getAccesoryAll()) {
			if (accesory.getId().equals(accesoryId)) {
				acc = accesory;
			}
		}
		String models = acc.getModel_available()[0];

		return models.contains(modelId);
	}

	private String obtener_accesorios(JCheckBox chckbxYantasDeAleacin, JCheckBox chckbxNavegador,
			JCheckBox chckbxNewCheckBox, JCheckBox chckbxAparcamientoAutotico, JCheckBox chckbxNewCheckBox_1,
			JCheckBox chckbxAsientosCalfectados) {
		String accesorios = "[ACCESORIOS] ";

		if (chckbxYantasDeAleacin.isSelected()) {
			accesorios = accesorios + chckbxYantasDeAleacin.getLabel() + " ";
		}

		if (chckbxNavegador.isSelected()) {
			accesorios = accesorios + chckbxNavegador.getLabel() + " ";
		}

		if (chckbxNewCheckBox.isSelected()) {
			accesorios = accesorios + chckbxNewCheckBox.getLabel() + " ";
		}

		if (chckbxAparcamientoAutotico.isSelected()) {
			accesorios = accesorios + chckbxAparcamientoAutotico.getLabel() + " ";
		}

		if (chckbxNewCheckBox_1.isSelected()) {
			accesorios = accesorios + chckbxNewCheckBox_1.getLabel() + " ";
		}

		if (chckbxAsientosCalfectados.isSelected()) {
			accesorios = accesorios + chckbxAsientosCalfectados.getLabel() + " ";
		}
		return accesorios;
	}

	private void fichero_temporal(String accesori) {
		File fichero = new File("fs_employee.txt");
		try {
			FileWriter fw = new FileWriter(fichero, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(accesori);
			bw.newLine();
			bw.write("[PRECIO FINAL] " + suma);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fichero_temporal_borrar() {
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
}
