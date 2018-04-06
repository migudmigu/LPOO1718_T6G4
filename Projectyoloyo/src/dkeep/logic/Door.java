package dkeep.logic;

public class Door extends Object{

	boolean opened;
	boolean openable;

	public Door(int x, int y, char symbol) {
		super(x, y, symbol);
		opened=false;}
	
	public void setOpenable() {
		this.openable=true;}
	
	public void openDoor() {
		opened=!opened;
		System.out.println(opened + "test");}
	
	public boolean getOpened() {
		return this.opened;}
}
