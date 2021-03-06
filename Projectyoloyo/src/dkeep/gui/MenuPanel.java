package dkeep.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import dkeep.gui.StateMachine.Action;
import dkeep.logic.Game;

public class MenuPanel extends JPanel {

	private StateMachine statemachine;
	private SettingsDialog settingsdialog;
	private String personality;
	private Game game;

	/**
	 * Create the panel.
	 */
	/**
	 * @param statemachine
	 * @param gamedata
	 */
	public MenuPanel(StateMachine statemachine,GameData gamedata) {
		settingsdialog = new SettingsDialog(gamedata);
		this.statemachine = statemachine;
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(224, 53, 109, 25);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				statemachine.updateState(Action.NEW_GAME);
				gamedata.startGame();
//				((GamePanel)statemachine.getGamePanel()).setGame();
			}
		});
		btnNewGame.setEnabled(false);

		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(244, 211, 63, 25);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setLayout(null);
		add(btnExit);
		
		JButton btnNewMap = new JButton("New Map");
		btnNewMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statemachine.updateState(Action.CREATE_MAP_E);
			}
		});
		btnNewMap.setBounds(224, 104, 99, 25);
		add(btnNewMap);
		add(btnNewGame);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewGame.setEnabled(true);
				settingsdialog.setVisible(true);
				
			}
		});
		btnSettings.setBounds(224, 153, 99, 25);
		add(btnSettings);

	}
}
