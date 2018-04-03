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
		paintBackground(g, Color.white);
		if (game != null) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[j][i] == 'X') {
						g.setColor(Color.black);
						g.fillRect(i * 30, j * 30, 30, 30);
						continue;
					}
					if (map[j][i] == 'I') {
						g.setColor(Color.yellow);
						g.fillRect(i * 30, j * 30, 30, 30);
						continue;
					}
					if (j == game.getKeyX() && i == game.getKeyY()) {
						g.setColor(Color.green);
						g.fillRect(i * 30, j * 30, 30, 30);
						if (j == game.getHero().getX() && i == game.getHero().getY()) {
							g.drawImage(gamedata.hero,i * 30, j * 30, 30, 30, this);
						}
						continue;
					}
					if (j == game.getHero().getX() && i == game.getHero().getY()) {
						g.setColor(Color.cyan);
						g.fillRect(i * 30, j * 30, 30, 30);
						g.drawImage(gamedata.hero,i * 30, j * 30, 30, 30, this);
						continue;
					}
					if (game.getGuard() != null) {
						if (j == game.getGuard().getX() && i == game.getGuard().getY()) {
							g.setColor(Color.blue);
							g.fillRect(i * 30, j * 30, 30, 30);
							continue;
						}
					}
					g.setColor(Color.cyan);
					g.fillRect(i * 30, j * 30, 30, 30);
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
