package dkeep.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dkeep.logic.Game;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**	
 * SettingsDialog Class
 * Class where the user can find the options to the game itself. The user can choose the number of ogres and the guard personality.
 */
public class SettingsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBox;
	private Game game;
	private JTextField textField;
	private JLabel label;
	private JButton okButton;

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
	/**
	 * @param gamedata
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
		
		class MyDocumentListener implements DocumentListener {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (textField.getText().equals("")) {
					okButton.setEnabled(false);
				} else {
					okButton.setEnabled(true);
				}

			}
		}
		
//			  public void changed() {
//			     if (textField.getText().equals("")){
//			       okButton.setEnabled(false);
//			     }
//			     else {
//			       okButton.setEnabled(true);
//			    }
//
//			  }
//			});
		
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
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!textField.getText().isEmpty() &&  Integer.parseInt(textField.getText())>0 && Integer.parseInt(textField.getText())<4) {
				gamedata.savePersonality((String)comboBox.getSelectedItem());
				gamedata.saveNumOgres(textField.getText());
				setVisible(false);
				} else {
					label.setText("Ogres must be 1 to 3");
				}
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

		textField = new JTextField();
		textField.setBounds(181, 28, 37, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new MyDocumentListener());

		JLabel lblGuardPersonality = new JLabel("Guard personality");
		lblGuardPersonality.setBounds(12, 96, 161, 38);
		getContentPane().add(lblGuardPersonality);
		
		label = new JLabel("");
		label.setBounds(244, 31, 180, 15);
		getContentPane().add(label);


	}
}
