package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import dkeep.logic.Game;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;

public class Window {
	private JFrame JanelaMenu;
	private JPanel gamepanel;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnUp;
	private JButton btnRight;
	private JButton btnLeft;
	private JButton btnDown;
//	JTextArea textArea;
	private Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.JanelaMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JanelaMenu = new JFrame();
		JanelaMenu.setBounds(100, 100, 600, 450);
		JanelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JanelaMenu.getContentPane().setLayout(null);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		gamepanel = new GamePanel();
		gamepanel.setBounds(12, 93, 346, 326);
		JanelaMenu.getContentPane().add(gamepanel);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setBounds(12, 13, 106, 16);
		JanelaMenu.getContentPane().add(lblNumberOfOgres);

//		textField = new JTextField();
//		textField.setBounds(130, 10, 37, 22);
//		JanelaMenu.getContentPane().add(textField);
//		textField.setColumns(10);

//		textArea = new JTextArea();
//		textArea.setFont(new Font("DialogInput", Font.PLAIN, 12));
//		textArea.setEditable(false);
//		textArea.setBounds(40, 104, 322, 278);
//		JanelaMenu.getContentPane().add(textArea);
		
		JLabel lblGuardPersonality = new JLabel("Guard personality");
		lblGuardPersonality.setBounds(12, 48, 106, 16);
		JanelaMenu.getContentPane().add(lblGuardPersonality);

		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(130, 45, 150, 22);
		JanelaMenu.getContentPane().add(comboBox);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game();
				((GamePanel)gamepanel).setGame(game);
				game.setGuard(comboBox.getSelectedItem().toString());
				gamepanel.repaint();
			}
		});
		btnNewGame.setBounds(406, 72, 117, 25);
		JanelaMenu.getContentPane().add(btnNewGame);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(406, 314, 117, 25);
		JanelaMenu.getContentPane().add(btnExitGame);
		
		btnUp = new JButton("UP");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkButtons('w');
				gamepanel.requestFocus();
			}
		});
		btnUp.setBounds(451, 138, 53, 25);
		JanelaMenu.getContentPane().add(btnUp);
		
		btnRight = new JButton("RIGHT");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkButtons('d');
				gamepanel.requestFocus();
			}
		});
		btnRight.setBounds(502, 175, 75, 25);
		JanelaMenu.getContentPane().add(btnRight);
		
		btnLeft = new JButton("LEFT");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkButtons('a');
				gamepanel.requestFocus();
			}
		});
		btnLeft.setBounds(374, 175, 75, 25);
		JanelaMenu.getContentPane().add(btnLeft);
		
		btnDown = new JButton("DOWN");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkButtons('s');
				gamepanel.requestFocus();
			}
		});
		btnDown.setBounds(437, 212, 86, 25);
		JanelaMenu.getContentPane().add(btnDown);
		

		

		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");
	}
	
	public void checkButtons(char key) {

		game.handler(key);
		gamepanel.repaint();
//		textArea.setText(game.getMapa());
		if(game.gameOver == 1) {
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
		}
	}
}
