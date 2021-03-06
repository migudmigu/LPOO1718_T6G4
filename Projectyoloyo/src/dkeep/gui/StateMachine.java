package dkeep.gui;

import javax.swing.JPanel;

public class StateMachine {

	public State state;
	private JPanel gamepanel;
	private JPanel menupanel;
	private JPanel mappanel;

	public enum State {
		MENU, GAME, CREATE_MAP
	}

	public enum Action {
		NEW_GAME, CREATE_MAP_E, GAME_OVER,  CLOSE_CUSTOM, EXIT_GAME
	}

	/**
	 * 
	 */
	public StateMachine() { // POR OS STATES NUMA FUNÇAO SETSTATES se nao n da
		this.state = State.MENU;
	}

	/**
	 * @param action
	 */
	public void updateState(Action action) {
		switch (action) {
		case NEW_GAME:
			this.state=State.GAME;
			menupanel.setVisible(false);
			menupanel.setFocusable(false);
			gamepanel.setVisible(true);
			gamepanel.requestFocus();
			break;
		case CREATE_MAP_E:
			this.state=State.CREATE_MAP;
			menupanel.setVisible(false);
			menupanel.setFocusable(false);
			mappanel.setVisible(true);
			mappanel.requestFocus();
			break;
		case CLOSE_CUSTOM:
			this.state=State.MENU;
			mappanel.setVisible(false);
			menupanel.setVisible(true);
			menupanel.setFocusable(true);
			menupanel.requestFocus();
			break;
		case EXIT_GAME:
			this.state=State.MENU;
			gamepanel.setVisible(false);
			menupanel.setVisible(true);
			menupanel.setFocusable(true);
			menupanel.requestFocus();
			break;
		}
	}

	/**
	 * @param gamepanel
	 * @param menupanel
	 * @param mappanel
	 */
	public void setStates(JPanel gamepanel, JPanel menupanel, JPanel mappanel) {
		this.gamepanel=gamepanel;
		this.menupanel=menupanel;
		this.mappanel=mappanel;
	}
	
	/**
	 * @return
	 */
	public JPanel getGamePanel() {
		return this.gamepanel;
	}
}
