package dkeep.gui;

import javax.swing.JPanel;

public class StateMachine {

	public State state;
	private JPanel gamepanel;
	private JPanel menupanel;
//	private JPanel mappanel;

	public enum State {
		MENU, GAME, CREATE_MAP
	}

	public enum Action {
		NEW_GAME, CREATE_MAP_E, GAME_OVER
	}

	public StateMachine() { // POR OS STATES NUMA FUNÇAO SETSTATES se nao n da
		this.state = State.MENU;
	}

	public void updateState(Action action) {
		switch (action) {
		case NEW_GAME:
			menupanel.setVisible(false);
			menupanel.setFocusable(false);
			gamepanel.setVisible(true);
			gamepanel.requestFocus();
		}
	}

	public void setStates(JPanel gamepanel, JPanel menupanel) {
		this.gamepanel=gamepanel;
		this.menupanel=menupanel;
	}
	
	public JPanel getGamePanel() {
		return this.gamepanel;
	}
}
