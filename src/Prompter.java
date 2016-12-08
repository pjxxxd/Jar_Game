import java.util.Scanner;

public class Prompter{
	private Scanner sc = new Scanner(System.in);
	private String mItemName;
	private int mMaxNum;
	private int mAnswer;

	public Prompter(){

	}

	public String setUpName(){
		System.out.println("ADMINISTRATOR SETUP");
		System.out.println("=====================");
		System.out.println("Name of items in the jar:");
		mItemName = sc.nextLine();
		System.out.println("Maximum number of " + mItemName + " in the jar:");
		return mItemName;
	}  

	public int setUpNum(){
		mMaxNum = sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.println("PLAYER");
		System.out.println("=====================");
		return mMaxNum;
	}

	public void prompt(int answer){
		mAnswer = answer;
		System.out.println("Your goal is to guess how many " + mItemName + " are in the jar. Your guess should be between 1 and " + mMaxNum);
	}

	public void guessResult(boolean[] res){
		boolean isCorrect = res[0];
		boolean isGuessTooSmall = res[1];

		if(isCorrect){
			if(!isGuessTooSmall){
				System.out.println("Congratulations - you guessed that there are " + mAnswer + " " + mItemName + " in the jar.");
			}
		}else{
			if(isGuessTooSmall){
				System.out.println("The answer is larger than your guess");
			}else{
				System.out.println("The answer is smaller than your guess");
			}
		}
	}
	
	public boolean askForNewGame(){
		System.out.println("Type y to play again");
		if(sc.nextLine().equals("y")){
			return true;
		}else{
			return false;
		}
	}
	
	public void announceInvalidInput(){
		System.out.println("Your guess must be less than " + mMaxNum + " and greater than 0.");
	}
	
	public void printNumOfGuess(int numOfGuess){
		System.out.println("You guessed " + numOfGuess +" times");
	}
	
	public void gameOver(){
		System.out.println("Game Over");
	}

	public int makeGuess(){
		System.out.print("Guess:");
		int guess = sc.nextInt();
		sc.nextLine();
		return guess;
	}



}