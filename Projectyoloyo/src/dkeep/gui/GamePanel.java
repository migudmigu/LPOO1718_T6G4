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

import dkeep.logic.Game;

public class GamePanel extends JPanel implements KeyListener{
	GameData gamedata;
	Game game;
	char[][] map;
	private JTextField textField;

	public GamePanel(GameData gamedata) {
		this.gamedata=gamedata;
//		this.game = null;
//		this.map = null;
		addKeyListener(this);
		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g); // limpa fundo ...
//		paintBackground(g, Color.white);
		boolean doorflag = false;
		
		if (game != null) {
			System.out.println("cocoxixi");
			for (int i = 0; i < game.getMapArray().length; i++) {
				for (int j = 0; j < game.getMapArray()[i].length; j++) {
					if (game.getMapArray()[j][i] == 'X') {
						g.drawImage(gamedata.wall, i * 30, j * 30, 30, 30, this);
						continue;
					}

					for (int k = 0; k < 20; k++) {
						if (game.doors[k] != null) {
							if (j == game.doors[k].getX() && i == game.doors[k].getY()) {
								g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
								if (game.doors[k].getOpened()) {
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
					
					if (game.getKey() != null) {
						if (j == game.getKey().getX() && i == game.getKey().getY()) {
							g.drawImage(gamedata.floor, i * 30, j * 30, 30, 30, this);
							g.drawImage(gamedata.lever, i * 30, j * 30, 30, 30, this);
							if (j == game.getHero().getX() && i == game.getHero().getY()) {
								g.drawImage(gamedata.hero, i * 30, j * 30, 30, 30, this);
							}
							continue;
						}
					}
					if (j == game.getHero().getX() && i == game.getHero().getY()) {
						g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
						g.drawImage(gamedata.hero,i * 30, j * 30, 30, 30, this);
						continue;
					}
					if (game.getGuard() != null) {
						if (j == game.getGuard().getX() && i == game.getGuard().getY()) {
							g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
							g.drawImage(gamedata.guard,i * 30, j * 30, 30, 30, this);
							continue;
						}
					}
					for (int o = 0; o < game.getOgres().length; o++) {
						if (game.getOgres()[o] != null) {
							System.out.print("test1" + j + i);
							System.out.print("test2" + game.getOgres()[o].getX() + game.getOgres()[o].getY());
							if (j == game.getOgres()[o].getX() && i == game.getOgres()[o].getY()) {
								g.drawImage(gamedata.floor,i * 30, j * 30, 30, 30, this);
								g.drawImage(gamedata.ogre, i * 30, j * 30, 30, 30, this);
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
		if (game.gameOver != 1) {
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
	
	public void setGame() {
		game = gamedata.game;
		this.map = gamedata.game.getMapArray();
//		game.setGuard(comboBox.getSelectedItem().toString());
		repaint();
	}
	
	public void checkButtons(char key) throws IOException {
		game.handler(key);
		gamedata.setHeroDirection(key);
		if(game.getGuard()!=null)										// OTHER WAY?
		gamedata.setGuardDirection(game.getGuard().getDirection());
		gamedata.setLeverDirection();
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
