package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LectorXML.LectorCochesConfig;
import idao.ICoches;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JList;

public class selec_model extends JFrame {

	private JPanel contentPane;
	ICoches gestorCars = new LectorCochesConfig();
	String submodel = "";
	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selec_model frame = new selec_model(args);
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
	public selec_model(String id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{39, 17, 160, 141, 0, 0, 34, 0};
		gbl_contentPane.rowHeights = new int[]{0, 38, 0, 0, 0, 0, 38, 37, 0, 32, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Selecci\u00F3n de caracteristicas del model");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Anterior");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModeloCoche.main(null, null);
			}
		});
		ICoches configcoches = new LectorCochesConfig();
		
		
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
	    JList<String> list = new JList<>(dlm);
	
	    for(Model model : gestorCars.getModelAll()) {
	    	if(model.getId().equals(id)) {
	    		submodel = model.getName();
	    	}
	    }
	    for(Engine engine: gestorCars.getEngineAll()) {
			dlm.addElement(submodel + " - " + engine.getDescript());
		}
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.gridwidth = 5;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		contentPane.add(list, gbc_list);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String engineId = "";
				for(Engine engine: gestorCars.getEngineAll()) {
					if (list.getSelectedValue().equals(submodel + " - " + engine.getDescript())) {
						engineId = engine.getId();
					}
				}
				
				CompraAccesoris.main(id, engineId);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 8;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
