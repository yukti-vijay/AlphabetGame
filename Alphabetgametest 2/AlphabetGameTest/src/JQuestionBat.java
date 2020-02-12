import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

public class JQuestionBat {
	protected static JPanel q3Panel;
	private static JLabel question;
	private static JLabel BatIcon;
	static JButton hint;
	static JButton choiceD;
	static JButton choiceB;
	static JButton choiceL;
	static JButton choiceU;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with? Hint: it's a pet.");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		BatIcon = new JLabel();
		BatIcon.setIcon(new ImageIcon(new ImageIcon("image/bat.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

		
		choicesPanel = new JPanel();
		
		choiceD = new JButton(new ImageIcon("image/d.gif"));
		choiceB = new JButton(new ImageIcon("image/b.gif"));
		choiceL = new JButton(new ImageIcon("image/l.gif"));
		choiceU = new JButton(new ImageIcon("image/u.gif"));
		hint = new JButton("HINT");
		choiceD.setPreferredSize(new java.awt.Dimension(150,150));
		choiceB.setPreferredSize(new java.awt.Dimension(150,150));
		choiceL.setPreferredSize(new java.awt.Dimension(150,150));
		choiceU.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));

		//choiceD.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceB.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceD);
		choicesPanel.add(choiceB);
		choicesPanel.add(choiceL);
		choicesPanel.add(choiceU);
		
		q3Panel = new JPanel();
		q3Panel.setPreferredSize(new Dimension(600, 600));
		
		q3Panel.add(question);
		q3Panel.add(BatIcon);
		q3Panel.add(choicesPanel);
		q3Panel.setBackground(Color.MAGENTA );
		q3Panel.add(hint);
		
		choiceB.addActionListener(new RightListener());
		choiceD.addActionListener(new WrongListener());
		choiceL.addActionListener(new WrongListener());
		choiceU.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());

		return q3Panel;
		
	}
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "It's a nocturnal animal, that sleeps upside down.");
		}
	}
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			ALFrame.totalScore += 1;
			ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
			ALFrame.count++;
			ALFrame.questionPanel.remove(q3Panel);
			ALFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(q3Panel);
	ALFrame.PickQuestion();
	}
	}

}
