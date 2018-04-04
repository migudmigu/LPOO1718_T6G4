package dkeep.gui;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dkeep.logic.Level;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MapPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private int dimx;
	private int dimy;
	private GameData gamedata;
	private Level level;
	private JComboBox comboBox;
	
	/**
	 * Create the panel.
	 * @param gamedata 
	 * @param statemachine 
	 */
	public MapPanel(StateMachine statemachine, GameData gamedata) {
		setLayout(null);
		this.gamedata=gamedata;
		
		JLabel lblDimension = new JLabel("Dimension:          x");
		lblDimension.setBounds(12, 37, 162, 15);
		add(lblDimension);
		
		textField = new JTextField();
		textField.setBounds(99, 35, 24, 19);
		add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dimx = Integer.parseInt(textField.getText());
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 35, 24, 19);
		add(textField_1);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dimy = Integer.parseInt(textField_1.getText());
			}
		});
		
		JButton btnEn = new JButton("Gen");
		btnEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dimx = Integer.parseInt(textField.getText());
				dimy = Integer.parseInt(textField_1.getText());
			}
		});
		btnEn.setBounds(186, 32, 62, 25);
		add(btnEn);
		
		comboBox = new JComboBox();
		comboBox.setBounds(378, 32, 32, 24);
		add(comboBox);
		
		comboBox.addItem(1);
		comboBox.addItem(2);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(318, 37, 70, 15);
		add(lblLevel);
		
		JButton btnNewButton = new JButton("Create Level");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addLevelBox(level);
			}
		});
		
		btnNewButton.setBounds(328, 68, 123, 25);
		add(btnNewButton);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamedata.game.addLevel(level.getMap());
			}
		});
		btnDone.setBounds(355, 296, 82, 25);
		add(btnDone);
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	level=gamedata.levels[comboBox.getSelectedIndex()];
		    }
		});
		
	}

	public void addLevelBox(Level level) {
		
		level = new Level();
		System.out.println("sososo");
		gamedata.addLevel(level);

		System.out.println(gamedata.getLevelCount());
		comboBox.addItem(gamedata.getLevelCount());
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		paintLevel(g,level);
		
	}

	public void paintLevel(Graphics g, Level level) {

		System.out.println("test2");
		
		boolean doorflag = false;
		
		if (level != null) {
			System.out.println("test");
			
			for (int i = 0; i < level.getMap().length; i++) {
				for (int j = 0; j < level.getMap()[i].length; j++) {
					if (level.getMap()[j][i] == 'X') {
						g.drawImage(gamedata.wall, i * 30, j * 30, 30, 30, this);
						continue;
					}

					if (level.getMap()[j][i] == 'I') {
						g.drawImage(gamedata.VDoor, i * 30, j * 30, 30, 30, this);
					}

					// if (level.getMap()[j][i] == 'I') {
					// try {
					// gamedata.checkDoors();
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
					// g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
					// g.drawImage(gamedata.VDoor,i * 30, j * 30, 30, 30, this);
					// continue;
					// }

					if (level.getMap()[j][i] == 'k') {
						g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
					}
				}
			}
		}
	}
	
}
