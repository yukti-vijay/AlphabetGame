/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: THis is one of the most important classes of the program. It creates and adds all the panles 
*into the main frame. It contains the method to design the menu panel. It has the method to play the background 
*music. It also contains the methods to start the game by using switch statements. It also gets the users name
*and high scores and then stores it in an array list by calling the appropriate class that it can use to perform 
*the needed action.It also allows the user the option to submit scores, play again, and gives the quit button 
*to exit the application.
**************************************************************************************************************** */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.plaf.FontUIResource;
import java.io.FileNotFoundException;
import java.io.File;
import java.applet.*;
import java.net.*;

public class ALFrame extends JFrame {
	//Variable declaration
	final int FRAME_WIDTH = 800;
	final int FRAME_HEIGHT = 800;
	AudioClip audioClip;
	URL audioUrl;
	static JPanel welcomePanel;
	JPanel menuPanel;
	JPanel bottomPanel;
	static JTextField totalScoreField;
	JLabel totalScoreLabel;
	static JPanel questionPanel;
	static int count = 0;
	static int indivScore = 0;
	static int totalScore = 0;
	static ArrayList<Player1> sortedList;;
	static JButton quitButton;

public ALFrame() {						// method to establish JFrame
		
	super("Alphabet Learning Game:");
	setSize(FRAME_WIDTH, FRAME_HEIGHT);
	//create a method to close on exit button
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	//create panels methods
	WelcomePanel();			// methods to build the panels
	MenuPanel();
	BottomPanel();
	//add the panel border layouts
	add(welcomePanel, BorderLayout.NORTH);
	add(menuPanel, BorderLayout.EAST);//WEST);
	add(bottomPanel, BorderLayout.SOUTH);
	//create a question panel
	QuestionPanel(); 
	//add question panel border layout
	add(questionPanel, BorderLayout.CENTER);
	
	
	//background music
		try{
			audioUrl = new URL("file:" + new File(".").getCanonicalPath() + "//audio//bgmusic.wav"); 
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(audioUrl);
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			audioClip = Applet.newAudioClip(audioUrl);
			audioClip.play();
			//audioClip.loop();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

// panel to hold the question.  Center position.
void QuestionPanel(){
	
	questionPanel = new JPanel();
	questionPanel.setBackground(Color.CYAN);
	questionPanel.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));	
	}

//menu panel.  West position.
private void MenuPanel(){
	JLabel menuLabel = new JLabel("MENU");
	JButton scoresButton = new JButton("High Scores");
	scoresButton.addActionListener(new highScoresListener());

	JButton learnButton = new JButton("How to Play");
	
	learnButton.addActionListener(new learnButtonListener());
	JButton quitButton = new JButton("QUIT");
	quitButton.addActionListener(new quitButtonListener());

	menuPanel = new JPanel();
	menuPanel.setBackground(Color.GREEN);
	menuPanel.setPreferredSize(new Dimension(200,600));
	menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));			// make box layout vertical
	menuPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	menuPanel.add(menuLabel);
	menuPanel.add(Box.createVerticalStrut(25));
	menuPanel.add(learnButton);

	menuPanel.add(Box.createVerticalStrut(25));
	menuPanel.add(scoresButton);
	menuPanel.add(quitButton);
	}
	
// welcome message panel. North position.
private void WelcomePanel(){
	JLabel welcomeMessage = new JLabel("Welcome!");
	welcomePanel = new JPanel();
	welcomePanel.setBackground(Color.CYAN);
	welcomePanel.add(welcomeMessage);			
	}
//listens to the higscore button to print the user high scores
class highScoresListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Player1ArrayList.scanData();	// reads the data from the file and puts it in ArrayList playerlist
			Player1ArrayList.sortScores();	// sorts playerList
			//Player1ArrayList.printArrayList(Player1ArrayList.playerList);
			System.out.println();
			sortedList = new ArrayList<Player1>();
			String sortedListStr = "Top 5 Scores!\n";
			
			for (int i = 0; i <=4; i++){
				sortedList.add(Player1ArrayList.playerList.get(i));
			}
			sortedListStr += Player1ArrayList.printArrayList(sortedList);
			System.out.println(sortedListStr);
			JOptionPane.showMessageDialog(null, sortedListStr);
			} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "File not found");
		}		
		
		catch (IndexOutOfBoundsException e2){
			String playerListStr = "There are currently fewer than 5 scores in our records, "
					+ "so we do not have 5 scores to display.  Here are the scores currently "
					+ "in the records.\n";
			// prints the currently available scores (fewer than 5)
			playerListStr += Player1ArrayList.printArrayList(Player1ArrayList.playerList);
			JOptionPane.showMessageDialog(null, playerListStr);
			System.out.println(playerListStr);

		}
		
	}

}
//prints the how to play  when the user clicks the how to play button
static class learnButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e){
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Arial", Font.BOLD, 20)));
		JOptionPane.showMessageDialog(null, "Welcome to the Alphabet learning game!" 
		          + " \n" + "Directions: Match the letters to the pictures."
		          		+ "\nFor example, if the picture was a cat, then the answer would be \"C\"." + 
		          "\nChoose the correct option for that picture and if you get stuck use the help button for a hint"+
		 "\n Every question you get correct earns you points and at the end, you can see how many point you got!"+ 
		          "\n Have fun learning!");
		
	}
	
}

static class quitButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e){
		//questionPanel.add(SubmitScore1.build());
		System.exit(0);

	}
	
}

// panel to hold other things, e.g. volume.  South position.
private void BottomPanel(){
	totalScoreLabel = new JLabel("Total Score:");
	totalScoreField = new JTextField(3);
	totalScoreField.setText("0");
	bottomPanel = new JPanel();
	bottomPanel.setBackground(Color.ORANGE);
	bottomPanel.setPreferredSize(new Dimension(800, 100));
	bottomPanel.add(totalScoreLabel);
	bottomPanel.add(totalScoreField);
}
//function that is called to get the user the questions of the game
static void PickQuestion(){
	//switch statement that is used to cycle through to each of the question panels
	switch(count){
	case 0:
		questionPanel.add(GetName1.build());
		questionPanel.repaint();
		questionPanel.revalidate();
		totalScore = 0;
		break;
	case 1:
		questionPanel.add(JQuestionLion.build());
		questionPanel.repaint();
		questionPanel.revalidate();
		totalScore = 0;
		break;
	case 2:
		questionPanel.add(JQuestionKangaroo.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 3:
		questionPanel.add(JQuestionApple.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 4:
		questionPanel.add(JQuestionIgloo.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 5:
		questionPanel.add(JQuestionBat.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 6:
		questionPanel.add(QLetterY.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 7:
		questionPanel.add(QLetterH.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 8:
		questionPanel.add(QLetterM.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 9:
		questionPanel.add(QLetterN.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 10:
		questionPanel.add(QLetterO.build());
		questionPanel.repaint();
		questionPanel.validate();
		break; 
	case 11:
		questionPanel.add(QLetterP.build()); 
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 12:
		questionPanel.add(QLetterQ.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;	
	case 13:
		questionPanel.add(QLetterU.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 14:
		questionPanel.add(QLetterV.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 15:
		questionPanel.add(QLetterW.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 16: 
		questionPanel.add(QLetterX.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 17:
		questionPanel.add(JQuestionCat.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 18:
		questionPanel.add(JQuestionJar.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 19:
		questionPanel.add(JQuestionFish.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 20:
		questionPanel.add(JQuestionDog.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 21:
		questionPanel.add(JQuestionGiraffe.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 22:
		questionPanel.add(JQuestionElephant.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 23:
		questionPanel.add(JQuestionRainbow.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 24: 
		questionPanel.add(JQuestionSun.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 25:
		questionPanel.add(JQuestionTurtle.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
		
	case 26:
		questionPanel.add(JQuestionZebra.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 27 :
		questionPanel.add(SubmitScore1.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;	
		
	}
	
}

}


