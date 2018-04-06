package dkeep.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dkeep.gui.StateMachine.Action;
import dkeep.logic.Game;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**	
 * GamePanel Class
 * Class which is the whole panel where the game is displayed.
 */
public class GamePanel extends JPanel implements KeyListener{
	GameData gamedata;
	private JTextField textField;

	/**
	 * kj
	 * @param gamedata 
	 * @param statemachine
	 */
	/**
	 * @param gamedata
	 * @param statemachine
	 */
	public GamePanel(GameData gamedata, StateMachine statemachine) {
		this.gamedata=gamedata;
		addKeyListener(this);
		setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {
				statemachine.updateState(Action.EXIT_GAME);
				
			}
		});
		btnExit.setBounds(308, 259, 59, 25);
		add(btnExit);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		boolean doorflag = false;
		
		if (gamedata.game != null) {
			for (int i = 0; i < gamedata.game.getMapArray().length; i++) {
				for (int j = 0; j < gamedata.game.getMapArray()[i].length; j++) {
					System.out.println("test j:"+ j);
					System.out.println("test i:"+ i);
					if (gamedata.game.getMapArray()[j][i] == 'X') {
						g.drawImage(gamedata.wall, i * 30, j * 30, 30, 30, this);
						continue;
					}

					for (int k = 0; k < 20; k++) {
						if (gamedata.game.doors[k] != null) {
							if (j == gamedata.game.doors[k].getX() && i == gamedata.game.doors[k].getY()) {
								g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
								if (gamedata.game.doors[k].getOpened()) {
									g.drawImage(gamedata.HDoor, i * 30, j * 30, 30, 30, this);
								} else {
									g.drawImage(gamedata.VDoor, i * 30, j * 30, 30, 30, this);
								}
								doorflag=true;
							}
						}
					}

					if(!doorflag) {
					g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
					}
//					if (game.getMapArray()[j][i] == 'I') {
//						try {
//							gamedata.checkDoors();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//						g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
//						g.drawImage(gamedata.VDoor,i * 30, j * 30, 30, 30, this);
//						continue;
//					}
					
					if (gamedata.game.getLever() != null) {
						if (j == gamedata.game.getLever().getX() && i == gamedata.game.getLever().getY()) {
							g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
							g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
							if (j == gamedata.game.getHero().getX() && i == gamedata.game.getHero().getY()) {
								g.drawImage(gamedata.hero, i * 30, j * 30, 30, 30, this);
							}
							continue;
						}
					}
						if (gamedata.game.getMapArray()[j][i]=='K') {
							g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
							g.drawImage(gamedata.key, i * 30, j * 30, 30, 30, this);
							continue;
						}
					if (j == gamedata.game.getHero().getX() && i == gamedata.game.getHero().getY()) {
						g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.hero,i * 30, j * 30, 30, 30, this);
						continue;
					}
					if (gamedata.game.getGuard() != null) {
						if (j == gamedata.game.getGuard().getX() && i == gamedata.game.getGuard().getY()) {
							g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
							g.drawImage(gamedata.guard,i * 30, j * 30, 30, 30, this);
							continue;
						}
					}
					for (int o = 0; o < gamedata.game.getOgres().length; o++) {
						if (gamedata.game.getOgres()[o] != null) {
							if (j == gamedata.game.getOgres()[o].getX() && i == gamedata.game.getOgres()[o].getY()) {
								if(gamedata.game.getOgres()[o].getStunned()) {
									g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
									g.drawImage(gamedata.ogrestunned, i * 30, j * 30, 30, 30, this);
								} else {
								g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
								g.drawImage(gamedata.ogre, i * 30, j * 30, 30, 30, this);
								}
							}
							if (j == gamedata.game.getOgres()[o].getClubX() && i == gamedata.game.getOgres()[o].getClubY()) {
								g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
								g.drawImage(gamedata.club, i * 30, j * 30, 30, 30, this);
							}
						}
					}
					doorflag=false;
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (gamedata.game.gameOver != 1) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				try {
					checkButtons('a');
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_RIGHT:
				try {
					checkButtons('d');
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_UP:
				try {
					checkButtons('w');
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_DOWN:
				try {
					checkButtons('s');
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}
	
//	public void setGame() {
//		game = gamedata.game;
////		this.map = gamedata.game.getMapArray();
////		game.setGuard(comboBox.getSelectedItem().toString());
//		repaint();
//	}
	
	/**
	 * @param key
	 * @throws IOException
	 */
	/**
	 * @param key
	 * @throws IOException
	 */
	public void checkButtons(char key) throws IOException {
		gamedata.game.handler(key);
		gamedata.setHeroDirection(key);
		if(gamedata.game.getGuard()!=null)										// OTHER WAY?
		gamedata.setGuardDirection(gamedata.game.getGuard().getDirection());
		gamedata.setLeverDirection();
//		gamedata.setOgreStun();
//		if(game.getHero().checkLevelEnd(game.getMapArray()));
		
		
		repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#requestFocus()
	 */
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#requestFocus()
	 */
	public void requestFocus() {
		this.requestFocusInWindow();
	}
}
