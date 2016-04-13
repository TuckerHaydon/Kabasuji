
package playerBoundary;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import playerController.BullpenController;
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
	
	public void initView(){
		this.setBackground(Color.BLUE);
		this.setBounds(0, 0, 4000, 120);
	}
	
	public void initControllers(){
		setMouseAdapter(new BullpenController());
	}
	
	public void keyPressed(KeyEvent k) {
		controlKeyPressed = k.isControlDown();
		shiftKeyPressed = k.isShiftDown();
	}
	
	public void keyReleased(KeyEvent k) {
		//TODO fill in method
	}
	
	public void keyTyped(KeyEvent k){
		//TODO fill in method
	}
	
	public boolean isControlPressed (){
		return controlKeyPressed;
	}
	
	public boolean isShiftPressed (){
		return shiftKeyPressed;
	}
}

