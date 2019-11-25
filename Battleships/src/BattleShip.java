import java.util.*;

public class BattleShip {
	
	//needed instance Variables
	private ArrayList<String> locationCells;
	private String name;
	
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}//end of setLocationCells
	
	public void setName(String n) {
		name = n;
	}//end of setName
	
	public String checkHit (String UserInput) {
		String result = "miss";
		
		int index = locationCells.indexOf(UserInput);
		
		//if returned number of .indexof is not -1 then its either hit or kill
		if(index >= 0) {
			locationCells.remove(index);
			
			if(locationCells.isEmpty()) {
				result = "kill";
				
				System.out.println("You sunk " + name + "!");
			}
			else {
				result = "hit";
			}
			
		}//end of
		
		return result;
		
	}// end checkHit method
}
