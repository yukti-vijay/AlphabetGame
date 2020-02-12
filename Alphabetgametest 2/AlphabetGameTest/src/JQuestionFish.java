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

public class JQuestionFish {
	protected static JPanel q5Panel;
	private static JLabel question;
	private static JLabel FishIcon;
	static JButton hint;
	static JButton choiceF;
	static JButton choiceK;
	static JButton choiceP;
	static JButton choiceM;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		FishIcon = new JLabel();
		FishIcon.setIcon(new ImageIcon(new ImageIcon("image/download.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choiceF = new JButton(new ImageIcon("image/f.gif"));
		choiceK = new JButton(new ImageIcon("image/k.gif"));
		choiceP = new JButton(new ImageIcon("image/p.gif"));
		choiceM = new JButton(new ImageIcon("image/m.gif"));
		hint = new JButton("HINT");
		choiceF.setPreferredSize(new java.awt.Dimension(150,150));
		choiceK.setPreferredSize(new java.awt.Dimension(150,150));
		choiceP.setPreferredSize(new java.awt.Dimension(150,150));
		choiceM.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceX.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceP);
		choicesPanel.add(choiceK);
		choicesPanel.add(choiceF);
		choicesPanel.add(choiceM);
		
		q5Panel = new JPanel();
		q5Panel.setPreferredSize(new Dimension(600,600));
		
		q5Panel.add(question);
		q5Panel.add(FishIcon);
		q5Panel.add(choicesPanel);
		q5Panel.setBackground(Color.MAGENTA );
		q5Panel.add(hint);
		
		choiceF.addActionListener(new RightListener());
		choiceK.addActionListener(new WrongListener());
		choiceP.addActionListener(new WrongListener());
		choiceM.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q5Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "It lives in water");
		}
	}
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			ALFrame.totalScore += 1;
			ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
			ALFrame.count++;
			ALFrame.questionPanel.remove(q5Panel);
			ALFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(q5Panel);
	ALFrame.PickQuestion();
	}
	}
	
	

}


