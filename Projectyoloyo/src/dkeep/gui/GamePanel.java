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

public class GamePanel extends JPanel implements KeyListener{
	GameData gamedata;
//	Game game;
//	char[][] map;
	private JTextField textField;

	public GamePanel(GameData gamedata, StateMachine statemachine) {
		this.gamedata=gamedata;
//		this.game = null;
//		this.map = null;
		addKeyListener(this);
		setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				statemachine.updateState(Action.EXIT_GAME);
				
			}
		});
		btnExit.setBounds(308, 259, 59, 25);
		add(btnExit);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g); // limpa fundo ...
//		paintBackground(g, Color.white);
		boolean doorflag = false;
		
		if (gamedata.game != null) {
			for (int i = 0; i < gamedata.game.getMapArray().length; i++) {
				for (int j = 0; j < gamedata.game.getMapArray()[i].length; j++) {
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
					
					if (gamedata.game.getKey() != null) {
						if (j == gamedata.game.getKey().getX() && i == gamedata.game.getKey().getY()) {
							g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
							g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
							if (j == gamedata.game.getHero().getX() && i == gamedata.game.getHero().getY()) {
								g.drawImage(gamedata.hero, i * 30, j * 30, 30, 30, this);
							}
							continue;
						}
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
	
	public void paintBackground(Graphics g,Color c) {
		g.setColor(c);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
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

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void requestFocus() {
		this.requestFocusInWindow();
	}
}
