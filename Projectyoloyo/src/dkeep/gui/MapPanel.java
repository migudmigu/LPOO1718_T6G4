package dkeep.gui;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.print.attribute.standard.PrinterLocation;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dkeep.gui.StateMachine.Action;
import dkeep.logic.Level;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.Color;

/**	
 * MapPanel Class
 * Class where the user is able to create his own new Map.
 */
public class MapPanel extends JPanel implements MouseListener {
	private JTextField textField;
	private JTextField textField_1;
	private int dim = 10;
	private GameData gamedata;
	// Level level;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JSlider slider;
	private JSlider slider_1;
	private Level tlevel;
	private Level[] tlevels = new Level[10];
	private int tlvlcount = 2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private char[] icons = { 'X', 'I', 'H', 'O', 'K' , ' '};
	private int currentIcon;
	private int xClicked;
	private int yClicked;
	private JLabel label_7;

	class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			dim = slider.getValue();
			updateMapDim();
		}
	}

	class SliderListener2 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			dim = slider_1.getValue();
			updateMapDim();
		}
	}

	/**
	 * Create the panel.
	 * 
	 * @param gamedata
	 * @param statemachine
	 */
	public MapPanel(StateMachine statemachine, GameData gamedata) {
		setLayout(null);
		this.gamedata = gamedata;
		tlevels[0] = gamedata.levels[0];
		tlevels[1] = gamedata.levels[1];
		tlevel = tlevels[0];

		addMouseListener(this);

		// JLabel lblDimension = new JLabel("Dimension: x");
		// lblDimension.setBounds(12, 351, 162, 15);
		// add(lblDimension);

		// textField = new JTextField();
		// textField.setBounds(99, 347, 24, 19);
		// add(textField);
		// textField.setColumns(10);
		// textField.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// dimy= Integer.parseInt(textField.getText());
		// }
		// });

		// textField_1 = new JTextField();
		// textField_1.setColumns(10);
		// textField_1.setBounds(150, 347, 24, 19);
		// add(textField_1);
		// textField_1.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// dimx = Integer.parseInt(textField_1.getText());
		// }
		// });

		// JButton btnEn = new JButton("Gen");
		// btnEn.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		//// dimy = Integer.parseInt(textField.getText());
		////// dimx = Integer.parseInt(textField_1.getText());
		//// if(dimy != 0 && dimy != 0)
		//// btnNewButton.setEnabled(true);
		//
		//
		// }
		// });
		// btnEn.setBounds(186, 346, 62, 25);
		// add(btnEn);

		comboBox = new JComboBox();
		comboBox.setBounds(378, 32, 44, 24);
		add(comboBox);

		comboBox.addItem(1);
		comboBox.addItem(2);

		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(318, 37, 70, 15);
		add(lblLevel);

		btnNewButton = new JButton("Create Level");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addLevelBox(tlevels[tlvlcount]);
				btnNewButton.setEnabled(false);
			}
		});

		btnNewButton.setBounds(328, 68, 123, 25);
		add(btnNewButton);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statemachine.updateState(Action.CLOSE_CUSTOM);
				// gamedata.game.addLevel(level.getMap());
			}
		});
		btnDone.setBounds(358, 366, 79, 25);
		add(btnDone);

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setValue(5);
		slider.setMinimum(5);
		slider.setMaximum(10);
		slider.setBounds(27, 318, 270, 40);
		add(slider);
		slider.addChangeListener(new SliderListener());
		slider.setEnabled(false);

		slider_1 = new JSlider(JSlider.VERTICAL);
		slider_1.setMaximum(10);
		slider_1.setValue(5);
		slider_1.setMinimum(5);
		slider_1.setBounds(299, 108, 21, 186);
		add(slider_1);
		slider_1.addChangeListener(new SliderListener2());
		slider_1.setEnabled(false);

		JButton btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setEnabled(true);
//				if(checkValidMap())
				gamedata.levels = tlevels;
//				else label_6.setText("Map not valid");
			}
		});
		btnSaveLevel.setBounds(338, 329, 113, 25);
		add(btnSaveLevel);

		label = new JLabel("");
		label.setBackground(Color.BLACK);
		label.setBounds(337, 155, 30, 30);
		add(label);
		label.setVisible(true);

		label_1 = new JLabel("");
		label_1.setBackground(Color.GRAY);
		label_1.setBounds(379, 155, 30, 30);
		add(label_1);

		label_2 = new JLabel("");
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(421, 155, 30, 30);
		add(label_2);

		label_3 = new JLabel("");
		label_3.setBackground(Color.GRAY);
		label_3.setBounds(338, 217, 30, 30);
		add(label_3);

		label_4 = new JLabel("");
		label_4.setBackground(Color.GRAY);
		label_4.setBounds(378, 217, 30, 30);
		add(label_4);

		label_5 = new JLabel("");
		label_5.setBackground(Color.GRAY);
		label_5.setBounds(421, 217, 30, 30);
		add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(378, 259, 30, 30);
		add(label_6);

		loadIcons();

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() > 1) {
					slider.setEnabled(true);
//					slider_1.setEnabled(true);		NOT WORKING
				} else {
					slider.setEnabled(false);
					slider_1.setEnabled(false);
				}
				tlevel = tlevels[comboBox.getSelectedIndex()];
				// level=gamedata.levels[comboBox.getSelectedIndex()];
				repaint();
			}
		});

		// level = gamedata.levels[0];
		// this.repaint();
	}

	/**
	 * @param level
	 */
	public void addLevelBox(Level level) {

		level = new Level();
		level.setMap(generateMap(dim, dim));
		System.out.println("generated map");
		for (int i = 0; i < level.getMap().length; i++) {
			for (int j = 0; j < level.getMap()[i].length; j++) {
				System.out.print(level.getMap()[i][j]);
			}
			System.out.println();
		}
		addLevel(level);
		comboBox.addItem(tlvlcount);
		// gamedata.addLevel(level);
		// comboBox.addItem(gamedata.getLevelCount());
		repaint();

	}

	/**
	 * 
	 */
	public void updateMapDim() {
		tlevel.setMap(generateMap(dim, dim));
		repaint();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintLevel(g, tlevel);

	}

	/**
	 * @param g
	 * @param level
	 */
	public void paintLevel(Graphics g, Level level) {

		boolean doorflag = false;
		
		System.out.println("generated map:");
		for (int i = 0; i < level.getMap().length; i++) {
			for (int j = 0; j < level.getMap()[i].length; j++) {
				System.out.print(level.getMap()[i][j]);
			}
			System.out.println();
		}
		
		if (level != null) {
			System.out.println("test");
			if (level.getMap() != null)
				System.out.println("test4");
			for (int i = 0; i < level.getMap().length; i++) {
				for (int j = 0; j < level.getMap()[i].length; j++) {
					System.out.println(i + "  " + j);
					if (level.getMap()[j][i] == 'X') {

						g.drawImage(gamedata.wall, i * 30, j * 30, 30, 30, this);
						continue;
					}

					if (level.getMap()[j][i] == 'I') {
						g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.VDoor, i * 30, j * 30, 30, 30, this);
						continue;
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
						g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
						continue;
					}
					
					if (level.getMap()[j][i] == 'K') {
						g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.key, i * 30, j * 30, 30, 30, this);
						continue;
					}
					
					if (level.getMap()[j][i] == 'H') {
						g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.hero, i * 30, j * 30, 30, 30, this);
						continue;
					}
					
					if (level.getMap()[j][i] == 'O') {
						g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.ogre, i * 30, j * 30, 30, 30, this);
						continue;
					}

					g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);

				}
			}
		}
	}

	/**
	 * 
	 */
	public void loadIcons() {
		label.setIcon(gamedata.wallicon);
		label_1.setIcon(gamedata.dooricon);
		label_2.setIcon(gamedata.heroicon);
		label_3.setIcon(gamedata.ogreicon);
		label_4.setIcon(gamedata.keyicon);
		label_5.setIcon(gamedata.flooricon);

		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		// g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
		//
		// BufferedImage hero;
		// BufferedImage wall;
		// BufferedImage floor;
		// BufferedImage VDoor;
		// BufferedImage HDoor;
		// BufferedImage guard;
		// BufferedImage lever;
	}

	/**
	 * @param level
	 */
	public void addLevel(Level level) {
		this.tlevels[tlvlcount] = level;
		this.tlvlcount++;
	}

	/**
	 * 
	 */
	public void drawMap() {
		int x;
		int y;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {

				x = j * 30;
				y = i * 30;

				if (xClicked > x && xClicked < x + 30 && yClicked > y && yClicked < y + 30) {
					tlevel.getMap()[i][j] = icons[currentIcon];
					repaint();
					// if (canPaintMap(i, j)) {
					// map[i][j] = symbolchosenPicture;
					// repaint();
					// }
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (comboBox.getSelectedIndex() > 1) {
			xClicked = e.getX();
			yClicked = e.getY();
			if (e.getX() > label.getX() && e.getX() < label.getX() + label.getWidth() && e.getY() > label.getY()
					&& e.getY() < label.getY() + label.getHeight()) {
				currentIcon = 0;
			} else if (e.getX() > label_1.getX() && e.getX() < label_1.getX() + label_1.getWidth() && e.getY() > label_1.getY()
					&& e.getY() < label_1.getY() + label_1.getHeight()) {
				currentIcon = 1;
			} else if (e.getX() > label_2.getX() && e.getX() < label_2.getX() + label_2.getWidth() && e.getY() > label_2.getY()
					&& e.getY() < label_2.getY() + label_2.getHeight()) {
				currentIcon = 2;
			} else if (e.getX() > label_3.getX() && e.getX() < label_3.getX() + label_3.getWidth() && e.getY() > label_3.getY()
					&& e.getY() < label_3.getY() + label_3.getHeight()) {
				currentIcon = 3;
			} else if (e.getX() > label_4.getX() && e.getX() < label_4.getX() + label_4.getWidth() && e.getY() > label_4.getY()
					&& e.getY() < label_4.getY() + label_4.getHeight()) {
				currentIcon = 4;
			} else if (e.getX() > label_5.getX() && e.getX() < label_5.getX() + label_5.getWidth() && e.getY() > label_5.getY()
					&& e.getY() < label_5.getY() + label_5.getHeight()) {
				currentIcon = 5;
			}
			drawMap();
			for(int i = 0 ; i < tlevel.getMap().length; i++) {
				for(int j = 0 ; j < tlevel.getMap()[i].length; j++) {
					System.out.print(tlevel.getMap()[i][j]);
				}
				System.out.println();
			}
		}
	}

	/**
	 * @param dimx
	 * @param dimy
	 * @return
	 */
	public char[][] generateMap(int dimx, int dimy) {
		char[][] mapa = new char[dimy][dimx];
		
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(i==0||j==0||i==mapa.length-1||j==mapa[i].length-1)
				mapa[i][j] = 'X';
				else mapa[i][j] = ' ';
//				System.out.println(dimy + " dim" + dimx);
//				System.out.println(mapa[i][j]);
			}
		}
		
//		for (int i = 0; i < dimx; i++) {							
//			for (int j = 0; j < dimy; j++) {
//				System.out.print(mapa[i][j]);
//			}
//			System.out.println();
//		 }
		
		return mapa;
	}
	
	// public boolean inside
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
