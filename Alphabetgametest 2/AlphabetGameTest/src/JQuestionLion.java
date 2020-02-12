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

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.*;

public class JQuestionLion {
	protected static JPanel q5Panel;
	private static JLabel question;
	private static JLabel LionIcon;
	static JButton hint;
	static JButton choiceP;
	static JButton choiceL;
	static JButton choiceX;
	static JButton choiceS;
	static JPanel choicesPanel;
	
	private static AudioClip audioClip;
	static URL audioUrl;
	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		LionIcon = new JLabel();
		LionIcon.setIcon(new ImageIcon(new ImageIcon("image/lion.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choiceP = new JButton(new ImageIcon("image/p.gif"));
		choiceL = new JButton(new ImageIcon("image/l.gif"));
		choiceX = new JButton(new ImageIcon("image/x.gif"));
		choiceS = new JButton(new ImageIcon("image/s.gif"));
		hint = new JButton("HINT");
		choiceP.setPreferredSize(new java.awt.Dimension(150,150));
		choiceL.setPreferredSize(new java.awt.Dimension(150,150));
		choiceX.setPreferredSize(new java.awt.Dimension(150,150));
		choiceS.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceX.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceP);
		choicesPanel.add(choiceL);
		choicesPanel.add(choiceX);
		choicesPanel.add(choiceS);
		q5Panel = new JPanel();
		q5Panel.setPreferredSize(new Dimension(600,600));
		
		q5Panel.add(question);
		q5Panel.add(LionIcon);
		q5Panel.add(choicesPanel);
		q5Panel.setBackground(Color.YELLOW );
		q5Panel.add(hint);
		
		choiceL.addActionListener(new RightListener());
		choiceP.addActionListener(new WrongListener());
		choiceX.addActionListener(new WrongListener());
		choiceS.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q5Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "Its an animal known as the king of the jungle");
		}
	}
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
		try {
			   audioUrl=new URL("file:" + new File(".").getCanonicalPath()
			                                 + "//audio//correct.wav");

	           audioClip=Applet.newAudioClip(audioUrl);
	           audioClip.play();
		   }catch(Exception e1){
	            System.out.println(e1.toString());
	       }
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
