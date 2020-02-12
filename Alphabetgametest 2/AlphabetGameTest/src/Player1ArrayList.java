/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: THis is a class that is used to hold all the user information and store thier scores. 
*This class creates an array list that is used to store the people's name and thier score they get after playing the game
*it then uses those scores and svaes them in a text file.
**************************************************************************************************************** */ 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class Player1ArrayList {

static File scores1File = new File("scores1file.txt");
static Scanner scanScores;
static String fname;  // file name
static int fscore;		// file score
	
static ArrayList<Player1> playerList = new ArrayList<Player1>();
	
	
	static void scanData() throws FileNotFoundException{
	scanScores = new Scanner(scores1File);	
	playerList.clear();

	while (scanScores.hasNext()){
		fname = scanScores.next();
		fscore = scanScores.nextInt();
		playerList.add(new Player1(fname, fscore));
		}
	
	scanScores.close();			// closes file after Scanning
	}
	
	
	// Comparator
	static class CompareScores implements Comparator<Player1>{

		@Override
		public int compare(Player1 p1, Player1 p2) {
			if(p1.getTotalScore() < p2.getTotalScore())
				return 1;
			else return -1;
			}
		}
	
	static void sortScores(){
		Collections.sort(playerList, new CompareScores());
		//String sortedScoresStr = 
	}

	

		public static String printArrayList(ArrayList<Player1> playerList){	// method to print each object Player in the ArrayList	
		String scoresStr = "\n";
		for (Object Player : playerList){		// for each Object Player in playerList
			System.out.println(Player);	
			scoresStr += Player + "\n";
			}
		return scoresStr;
		}

	
	
}
