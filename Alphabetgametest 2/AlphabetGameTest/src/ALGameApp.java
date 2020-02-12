/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: This is a driver class that is used to call on the ALFrame class that calls the rest of the 
*class that is used to run the entire game. This class simple calls the PickQuestion function to get the game 
*stated and sets the visibility of the frame true.
**************************************************************************************************************** */ 

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class ALGameApp {

	public static void main(String[] args) throws IOException {
		
		//declare the JFrame called Frame
		//JFrame frame = new ALFrame();	
		ALFrame frame = new ALFrame();
		//calls the functions in the ALFrame that calls the pick questions 
		((ALFrame) frame).PickQuestion();
			
		frame.setVisible(true);			// sets frame to visible
		
		
	}

}
	
	


