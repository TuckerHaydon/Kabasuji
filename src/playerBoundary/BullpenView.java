
package playerBoundary;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import playerEntity.Bullpen;


/*
 * @Author: Damani
 */

public class BullpenView extends View implements KeyListener {
	Bullpen b;
	boolean controlKeyPressed;
	boolean shiftKeyPressed;
	
	public BullpenView(Bullpen b){
		this.b = b;
	}
	
	public void keyPressed(KeyEvent k) {
		//TODO fill in method
	}
	
	public void keyReleased(KeyEvent k) {
		//TODO fill in method
	}
	
	public void keyTyped(KeyEvent k){
		//TODO fill in method
	}
	
	public boolean isControlPressed (){
		//TODO fill in method
		
		return false;
	}
	
	public boolean isShiftPressed (){
		//TODO fill in method
		return false;
	}
}

