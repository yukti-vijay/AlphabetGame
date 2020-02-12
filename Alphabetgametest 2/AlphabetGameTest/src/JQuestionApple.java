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
import java.net.*;
//delcare variable
public class JQuestionApple {
	protected static JPanel q2Panel;
	private static JLabel question;
	private static JLabel AppleIcon;
	static JButton hint;
	static JButton choiceF;
	static JButton choiceZ;
	static JButton choiceN;
	static JButton choiceA;
	static JPanel choicesPanel;
	

	//build panels
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		AppleIcon = new JLabel();
		AppleIcon.setIcon(new ImageIcon(new ImageIcon("image/apple.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

		choicesPanel = new JPanel();
		
		choiceF = new JButton(new ImageIcon("image/f.gif"));
		choiceZ = new JButton(new ImageIcon("image/z.gif"));
		choiceN = new JButton(new ImageIcon("image/n.gif"));
		choiceA = new JButton(new ImageIcon("image/a.gif"));
		hint = new JButton("HINT");
		choiceF.setPreferredSize(new java.awt.Dimension(150,150));
		choiceZ.setPreferredSize(new java.awt.Dimension(150,150));
		choiceN.setPreferredSize(new java.awt.Dimension(150,150));
		choiceA.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));

		//choiceF.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceZ.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceN.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceF);
		choicesPanel.add(choiceZ);
		choicesPanel.add(choiceN);
		choicesPanel.add(choiceA);
		
		q2Panel = new JPanel();
		q2Panel.setPreferredSize(new Dimension(600, 600));
		q2Panel.setBackground(Color.MAGENTA );
		q2Panel.add(question);
		q2Panel.add(AppleIcon);
		q2Panel.add(choicesPanel);
		q2Panel.add(hint);
		
		choiceZ.addActionListener(new WrongListener());
		choiceF.addActionListener(new WrongListener());
		choiceN.addActionListener(new WrongListener());
		choiceA.addActionListener(new RightListener());
		hint.addActionListener(new HintListener());
		return q2Panel;
		
	}
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "_____ a day keeps the doctor away!");
		}
	}
	
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			ALFrame.totalScore += 1;
			ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
			ALFrame.count++;
			ALFrame.questionPanel.remove(q2Panel);
			ALFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(q2Panel);
	ALFrame.PickQuestion();
	}
	}

}
