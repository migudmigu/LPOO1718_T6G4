package dkeep.logic;

/**	
 * Door Class
 * Has functions related to all the doors presented in the game.
 */
public class Door extends Object{

	boolean opened;
	boolean openable;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Door(int x, int y, char symbol) {
		super(x, y, symbol);
		opened=false;}
	
	/**
	 * 
	 */
	public void setOpenable() {
		this.openable=true;}
	
	/**
	 * 
	 */
	public void openDoor() {
		opened=!opened;
		System.out.println(opened + "test");}
	
	/**
	 * @return
	 */
	public boolean getOpened() {
		return this.opened;}
}
