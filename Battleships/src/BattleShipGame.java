import java.util.*;


public class BattleShipGame {
	
	//declare and initializing needed variables
	private GameHelper helper = new GameHelper();
	private ArrayList<BattleShip> BattleShipList = new ArrayList<BattleShip>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		//make BattleShips, give them locations and add them to the List.
		BattleShip one = new BattleShip();
		one.setName("Bismarck");
		
		BattleShip two = new BattleShip();
		two.setName("U.S.S Arizona");
		
		BattleShip three = new BattleShip();
		three.setName("Calypso");
		
		BattleShipList.add(one);
		BattleShipList.add(two);
		BattleShipList.add(three);
		
		//print Instructions for the User/Player
		System.out.println("Your goal is to sink three Battleships in as few guesses as possible");
		System.out.println("Bismarck, U.S.S Arizona, Calypso");
		System.out.println("Good Luck!");
		
		
		//repeat for all Battleships in BattleShipList
		for (BattleShip BattleShiptoToSet : BattleShipList) {
			
			//ask helper for a location
			ArrayList<String> newLocation = helper.placeBattleShip(3);
			
			//use the helper given Location to set Location of a battleship
			BattleShiptoToSet.setLocationCells(newLocation);
		}
	}//end of setUpGame Method
	
	private void startPlaying() {
		while (!BattleShipList.isEmpty()) {
			
			//get User Input
			String userGuess = helper.getUserInput("Enter a guess");
			
			//check if hit.
			checkUserGuess(userGuess);
		}
		//END GAME
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		//Increase Number of guesses
		numOfGuesses++;
		
		//default result 
		String result = "miss";
		
		
		for (BattleShip BattleShipTest : BattleShipList) {
			
			//Checking if hit
			result = BattleShipTest.checkHit(userGuess);
			
			if (result.equals("hit")) {
				break;
			}
			
			if (result.equals("kill")) {
				BattleShipList.remove(BattleShipTest);
				break;
			}
						
		}
		
		//print result for the User/Player
		System.out.println(result);
		
	}//end checkUserGuess method
	
	//End Game message telling the user how "well" he did.
	private void finishGame() {
		System.out.println("All Battleships have been destroyed !!");
		
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + "guesses ! Well done!");
		}
		else {
			System.out.println("Well ... you got there in the end ! It took you " + numOfGuesses + "guesses");
		}
	}//end of finishGame method
	
	
	public static void main (String[] args) {
		
		//creating game object
		BattleShipGame game = new BattleShipGame();
		
		//setting up the Game
		game.setUpGame();
		
		//telling Game Object to start the CGPL(Core GamePlay Loop)
		game.startPlaying();
	}//end of main method
	
	
}
