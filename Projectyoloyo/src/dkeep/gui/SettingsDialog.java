package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dkeep.logic.Game;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBox;
	private Game game;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			SettingsDialog dialog = new SettingsDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public SettingsDialog(GameData gamedata) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{165, 117, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 50, 25, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 265, 450, 35);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(181, 103, 112, 24);
		getContentPane().add(comboBox);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gamedata.savePersonality((String)comboBox.getSelectedItem());
				setVisible(false);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setBounds(12, 30, 134, 16);
		getContentPane().add(lblNumberOfOgres);

		JTextField textField = new JTextField();
		textField.setBounds(181, 28, 37, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblGuardPersonality = new JLabel("Guard personality");
		lblGuardPersonality.setBounds(12, 96, 161, 38);
		getContentPane().add(lblGuardPersonality);


	}
	
//	public String getGuardPersonality() {
//		return ((String)this.comboBox.getSelectedItem());
//	}
}
