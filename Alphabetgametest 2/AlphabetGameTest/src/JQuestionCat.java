import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JQuestionCat {
	protected static JPanel q5Panel;
	private static JLabel question;
	private static JLabel CatIcon;
	static JButton hint;
	static JButton choiceB;
	static JButton choiceA;
	static JButton choiceZ;
	static JButton choiceC;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		CatIcon = new JLabel();
		CatIcon.setIcon(new ImageIcon(new ImageIcon("image/cute-orange-cat.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choiceB = new JButton(new ImageIcon("image/b.gif"));
		choiceA = new JButton(new ImageIcon("image/a.gif"));
		choiceZ = new JButton(new ImageIcon("image/z.gif"));
		choiceC = new JButton(new ImageIcon("image/c.gif"));
		hint = new JButton("HINT");
		
		choiceB.setPreferredSize(new java.awt.Dimension(150,150));
		choiceA.setPreferredSize(new java.awt.Dimension(150,150));
		choiceZ.setPreferredSize(new java.awt.Dimension(150,150));
		choiceC.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceX.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceB);
		choicesPanel.add(choiceA);
		choicesPanel.add(choiceZ);
		choicesPanel.add(choiceC);
		
		q5Panel = new JPanel();
		q5Panel.setPreferredSize(new Dimension(600,600));
		
		q5Panel.add(question);
		q5Panel.add(CatIcon);
		q5Panel.add(choicesPanel);
		q5Panel.setBackground(Color.MAGENTA );
		q5Panel.add(hint);
		
		choiceC.addActionListener(new RightListener());
		choiceB.addActionListener(new WrongListener());
		choiceA.addActionListener(new WrongListener());
		choiceZ.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q5Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "It makes a meow sound");
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

