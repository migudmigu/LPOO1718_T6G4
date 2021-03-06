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
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;

public class Window {
	
	public GameData gamedata;
	
	public JPanel panelstate;
	private StateMachine statemachine;
	private JFrame JanelaMenu;
	private JPanel gamepanel;
	private JPanel menupanel;
	private JPanel mappanel;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnUp;
	private JButton btnRight;
	private JButton btnLeft;
	private JButton btnDown;
//	JTextArea textArea;
//	private Game game;

	/**
	 * Launch the application.
	 */
	/**
	 * @param args
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
	 * @throws IOException 
	 */
	public Window() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		gamedata = new GameData();
		statemachine = new StateMachine();

		JanelaMenu = new JFrame();
		JanelaMenu.setBounds(100, 100, 600, 450);
		JanelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JanelaMenu.getContentPane().setLayout(null);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		gamepanel = new GamePanel(gamedata,statemachine);
		gamepanel.setBounds(12, 108, 426, 330);
		JanelaMenu.getContentPane().add(gamepanel);
		gamepanel.setVisible(false);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		menupanel = new MenuPanel(statemachine,gamedata);
		menupanel.setBounds(12, 30, 700, 600);
		JanelaMenu.getContentPane().add(menupanel);
		menupanel.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		mappanel = new MapPanel(statemachine,gamedata);
		mappanel.setBounds(12, 30, 588, 410);
		JanelaMenu.getContentPane().add(mappanel);
		mappanel.setVisible(false);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		statemachine.setStates(gamepanel, menupanel,mappanel);
	}
	
	/**
	 * @param key
	 */
	public void checkButtons(char key) {

		gamedata.updateGame(key);
		gamepanel.repaint();
	}
}
