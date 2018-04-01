package dkeep.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import dkeep.logic.Game;

public class GamePanel extends JPanel implements KeyListener{
	Game game;
	char[][] map;

	public GamePanel() {
		this.game = null;
		this.map = null;
		addKeyListener(this);
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
						g.fillRect(i * 30, j * 30, 30 + i * 30, 30 + j * 30);
						continue;
					}
					if (map[j][i] == 'I') {
						g.setColor(Color.yellow);
						g.fillRect(i * 30, j * 30, 30 + i * 30, 30 + j * 30);
						continue;
					}
					if (j == game.getKeyX() && i == game.getKeyY()) {
						g.setColor(Color.green);
						g.fillRect(i * 30, j * 30, 30 + i * 30, 30 + j * 30);
						continue;
					}
					if (j == game.getHero().getX() && i == game.getHero().getY()) {
						g.setColor(Color.red);
						g.fillRect(i * 30, j * 30, 30 + i * 30, 30 + j * 30);
						continue;
					}
					if (game.getGuard() != null) {
						if (j == game.getGuard().getX() && i == game.getGuard().getY()) {
							g.setColor(Color.blue);
							g.fillRect(i * 30, j * 30, 30 + i * 30, 30 + j * 30);
							continue;
						}
					}
					g.setColor(Color.white);
					g.fillRect(i * 30, j * 30, 30 + i * 30, 30 + j * 30);
				}
			}
		}
	}

	public void setGame(Game game) {
		this.game= game;
		this.map = game.getMapArray();
		requestFocusInWindow();
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
				checkButtons('a');
				break;
			case KeyEvent.VK_RIGHT:
				checkButtons('d');
				break;
			case KeyEvent.VK_UP:
				checkButtons('w');
				break;
			case KeyEvent.VK_DOWN:
				checkButtons('s');
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}
	
	public void checkButtons(char key) {

		game.handler(key);
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void requestFocus() {
		this.requestFocusInWindow();
	}
}
