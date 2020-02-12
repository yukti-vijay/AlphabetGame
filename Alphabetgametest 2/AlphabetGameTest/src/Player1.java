/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: This is the class that is used to get the users name and the total score after playing the 
*game and then uses a toString method to print them out.
**************************************************************************************************************** */ 

public class Player1 {

		protected String name;
		protected int score;
		
		Player1 (String name, int score){   // Constructor
			this.name = name;
			this.score = score;
		}
			
		public String getName(){						// getters
			return name;
		}
		
		public int getTotalScore(){
			return score;
		}
		
		public String toString(){                      // override toString()
			String message = name + "     \tHigh Score: " + score;
			return message;
		}

	

}
