/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: This is the submit score class. THis class creates a submit score button. When the user is done 
*with the game it then calls this class which gives the user the option to store thier score or paly again. IF they 
*choose to store the score it calls the array list and saves the user name and score.
**************************************************************************************************************** */ 
import javax.swing.*;
import java.io.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;


public class SubmitScore1 {
	protected static JPanel q1Panel;
	private static JLabel endingLabel;
	static JButton submitScoreButton;
	static JButton playAgainButton;
	static FileWriter filewriter;
	static PrintWriter writeToFile;
	
	static JPanel build(){
		endingLabel = new JLabel("You are done!  Click the button to submit your score.");
		
		submitScoreButton = new JButton("Submit Score");
		playAgainButton = new JButton("Play Again");
		
		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 300));
		
		q1Panel.add(endingLabel);
		q1Panel.add(submitScoreButton);
		q1Panel.add(playAgainButton);

		
		submitScoreButton.addActionListener(new submitScoreListener());
		
		playAgainButton.addActionListener(new playAgainListener());

		
		return q1Panel;
		
	}
	
	static void WriteScore() throws IOException  {
		filewriter = new FileWriter("scores1file.txt", true);
		writeToFile = new PrintWriter(filewriter);
	}
	
	static class submitScoreListener implements ActionListener  // nested class
	{
	public void actionPerformed(ActionEvent e){
			try {
				WriteScore();
				writeToFile.print(GetName1.name + " ");
				writeToFile.println(ALFrame.totalScore);
				writeToFile.close();
				JOptionPane.showMessageDialog(null, "You have submitted your score.");
				}	
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "An error occured when submitting your score.");
			}

		}
	}
		
	static class playAgainListener implements ActionListener
		{
		public void actionPerformed(ActionEvent e){
				GetName1.name = null;
				ALFrame.totalScore = 0;
				ALFrame.count = 0;
				ALFrame.questionPanel.remove(q1Panel);
				ALFrame.PickQuestion();
			}
			
		}
	}
	


