/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: This is an operational class that builds a two panels, two labels, and four choices buttons.
* The question label prints the question and the choice button implements ImageIcon to display images. 
* We use actionEvent and actionListener for the right and wrong choice option.
**************************************************************************************************************** */ 

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLetterN extends JPanel{

	
	// had to change all variables to static so this method can be referenced by ALFrame.java :(
	
	protected static JPanel panel;
	private static JLabel question;
	private static JLabel ninja;
	static JButton hint;
	static JButton choice1;
	static JButton choice2;
	static JButton choice3;
	static JButton choice4;
	static JPanel choicesPanel;
	
	static JPanel build(){
		
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		ninja = new JLabel();
		
       ninja.setIcon(new ImageIcon(new ImageIcon("image/ninja.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choicesPanel = new JPanel();
		choice1 = new JButton( new ImageIcon("image/m.gif"));
		//JLabel.setIcon(new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));

		choice2 = new JButton(new ImageIcon("image/n.gif"));
		choice3 = new JButton(new ImageIcon("image/d.gif"));
		choice4 = new JButton(new ImageIcon("image/p.gif"));
		hint = new JButton("HINT");
		
        choice1.setPreferredSize(new java.awt.Dimension(150, 150));
		choice2.setPreferredSize(new java.awt.Dimension(150, 150));
		choice3.setPreferredSize(new java.awt.Dimension(150, 150));
	    choice4.setPreferredSize(new java.awt.Dimension(150, 150));
		
		choicesPanel.add(choice1);
		choicesPanel.add(choice2);
		choicesPanel.add(choice3);
		choicesPanel.add(choice4);
		
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBackground(Color.MAGENTA );

		panel.add(question);
		panel.add(ninja);
		panel.add(choicesPanel);
		panel.add(hint);
		choice1.addActionListener(new WrongListener());
		choice2.addActionListener(new RightListener());
		choice3.addActionListener(new WrongListener());
		choice4.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		
		return panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "Hint:Someone who has star like metal weapons");
		}
	}
	
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null, "Correct!");
		ALFrame.count++;
		ALFrame.totalScore += 1;
		ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
		ALFrame.questionPanel.remove(panel);
		ALFrame.PickQuestion();
			
	}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(panel);
	ALFrame.PickQuestion();
	}
	}

}

