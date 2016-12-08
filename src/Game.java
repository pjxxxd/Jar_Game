import java.util.Random;

public class Game{
	private Prompter mPromp;
	private Jar mJar;
	private int mNumOfGuess = 0;
	private int MAX_NUM;
	private Random random = new Random();
	private boolean gameOver = false;

	public Game(){
		mPromp = new Prompter();

	}

	public void newGame(){
		String itemName = mPromp.setUpName();
		MAX_NUM = mPromp.setUpNum();
		mJar = new Jar(itemName,random.nextInt(MAX_NUM) + 1);
		mPromp.prompt(mJar.getNumInJar());
		System.out.println(mJar.getNumInJar());
		gameStart();
	}
	
	public void gameStart(){
		while(!gameOver){
			mPromp.guessResult(compare());
		}
		mPromp.printNumOfGuess(mNumOfGuess);
		if(mPromp.askForNewGame()){
			gameOver = false;
			newGame();
		}else{
			mPromp.gameOver();
		}
	}
	
	public boolean validateInput(int guess){
		if(guess > MAX_NUM || guess < 1){
			mPromp.announceInvalidInput();
			return false;
		}
		return true;
	}
	
	public boolean[] compare(){
		mNumOfGuess++;
		boolean[] res = new boolean[2];
		int guess = mPromp.makeGuess();
		if(validateInput(guess)){
			if(guess == mJar.getNumInJar()){
				gameOver = true;
				res[0] = true;
				res[1] = false;
			}else{
				if(guess > mJar.getNumInJar()){
					res[0] = false;
					res[1] = false;
				}else{
					res[0] = false;
					res[1] = true;
				}
			}
		}else{
			res[0] = true;
			res[1] = true;
		}
		return res;
	}
}