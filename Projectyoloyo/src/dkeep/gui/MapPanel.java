package dkeep.gui;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.print.attribute.standard.PrinterLocation;
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

public class MapPanel extends JPanel implements MouseListener{
	private JTextField textField;
	private JTextField textField_1;
	private int dimx = 5;
	private int dimy = 5;
	private GameData gamedata;
//	Level level;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JSlider slider;
	private JSlider slider_1;
	private Level tlevel;
	private Level[] tlevels = new Level[10];
	private int tlvlcount = 2;
	
	class SliderListener implements ChangeListener {
	    public void stateChanged(ChangeEvent e) {
	    	dimy = slider.getValue();
	    	updateMapDim();
	    }
	}
	
	class SliderListener2 implements ChangeListener {
	    public void stateChanged(ChangeEvent e) {
	    	dimx = slider_1.getValue();
	    	updateMapDim();
	        }    
	}
	
	/**
	 * Create the panel.
	 * @param gamedata 
	 * @param statemachine 
	 */
	public MapPanel(StateMachine statemachine, GameData gamedata) {
		setLayout(null);
		this.gamedata=gamedata;
		tlevels[0] = gamedata.levels[0];
		tlevels[1] = gamedata.levels[1];
		tlevel = tlevels[0];
		
		
//		JLabel lblDimension = new JLabel("Dimension:          x");
//		lblDimension.setBounds(12, 351, 162, 15);
//		add(lblDimension);
		
//		textField = new JTextField();
//		textField.setBounds(99, 347, 24, 19);
//		add(textField);
//		textField.setColumns(10);
//		textField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dimy= Integer.parseInt(textField.getText());
//			}
//		});
		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10);
//		textField_1.setBounds(150, 347, 24, 19);
//		add(textField_1);
//		textField_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dimx = Integer.parseInt(textField_1.getText());
//			}
//		});
		
//		JButton btnEn = new JButton("Gen");
//		btnEn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
////				dimy = Integer.parseInt(textField.getText());
//////				dimx = Integer.parseInt(textField_1.getText());
////				if(dimy != 0 && dimy != 0)
////					btnNewButton.setEnabled(true);
//					
//				
//			}
//		});
//		btnEn.setBounds(186, 346, 62, 25);
//		add(btnEn);
		
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
				gamedata.levels=tlevels;
//				gamedata.game.addLevel(level.getMap());
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
			}
		});
		btnSaveLevel.setBounds(338, 329, 113, 25);
		add(btnSaveLevel);

		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if(comboBox.getSelectedIndex() > 1) {
		    		slider.setEnabled(true);
		    		slider_1.setEnabled(true);
		    		} else {
			    		slider.setEnabled(false);
			    		slider_1.setEnabled(false);
		    		}
		    	tlevel = tlevels[comboBox.getSelectedIndex()];
//		    	level=gamedata.levels[comboBox.getSelectedIndex()];
		    	repaint();
		    }
		});
		
//		level = gamedata.levels[0];
//		this.repaint();
	}

	public void addLevelBox(Level level) {
		
		level = new Level();
		level.setMap(gamedata.generateMap(dimx, dimy));
		addLevel(level);
		comboBox.addItem(tlvlcount);
//		gamedata.addLevel(level);
//		comboBox.addItem(gamedata.getLevelCount());
		repaint();
		
	}
	
	public void updateMapDim() {
		tlevel.setMap(gamedata.generateMap(dimx, dimy));
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		paintTools(g);
		paintLevel(g,tlevel);
		
	}

	public void paintLevel(Graphics g, Level level) {

		
		boolean doorflag = false;
		
		if (level != null) {
			if(level.getMap() != null)

			
			for (int i=0; i < level.getMap().length; i++) {
				for (int j = 0; j < level.getMap()[i].length; j++) {
					if (level.getMap()[i][j] == 'X') {
						
						g.drawImage(gamedata.wall, i * 30, j * 30, 30, 30, this);
						continue;
					}

					if (level.getMap()[i][j] == 'I') {
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

					if (level.getMap()[i][j] == 'k') {
						g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
					}
					
					g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);

				}
			}
		}
	}
	
	public void paintTools(Graphics g) {
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//		g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
//
//		BufferedImage hero;
//		BufferedImage wall;
//		BufferedImage floor;
//		BufferedImage VDoor;
//		BufferedImage HDoor;
//		BufferedImage guard;
//		BufferedImage lever;
	}
	
	public void addLevel(Level level) {
		this.tlevels[tlvlcount]=level;
		this.tlvlcount++;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

