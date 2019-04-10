/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import java.util.Random;

public class Player {							//Establish variable to be used.
	private int CurrentXPos = 1;
	private int CurrentYPos = 1;
	private int LastXPos = 1; 
	private int LastYPos = 1;
	private int MiniMapXPos = 1;
	private int MiniMapYPos = 1;
	private int MiniMapXChange = -3;
	private int MiniMapYChange = -3;
	private int LastXChange;
	private int LastYChange;
	private int LastMapXPos = 1;
	private int LastMapYPos = 1;
	private int CurrentDirection = 1;
	private int CurrentWeaponAttackMin = 1;
	private int CurrentWeaponAttackMax = 3; 
	private int CurrentweaponLevel = 0;
	private int PlayerHealth = 20;
	private Integer ForwardTile;
	private String CurrentWeapon = "Quantum wrench";
	private boolean NotInWall = true;
	private boolean FacingBoundry = false;
	private Random RandomNum = new Random(); 


	/**
	 * This method handles the player turning right.
	 * Direction is determined by an int with 1 being south, 2 east, 3 north and 4 west.
	 */
	public void TurnRight() {					//Once turn left button is pressed the direction is checked,
		if (CurrentDirection == 1) 			
		{CurrentDirection = 4;}					//if it is 1 then it is set to 4,
		else
		{CurrentDirection=CurrentDirection-1;}	//if no then the direction is decreased by one.
	}
	
	/**
	 * This method handles the player turning left.
	 */
	public void TurnLeft() {					//Once turn right button is pressed the direction is checked,
		if (CurrentDirection == 4) 			
		{CurrentDirection = 1;}					//if it is 4 then it is set to 1,
		else
		{CurrentDirection=CurrentDirection+1;}	//if no then the direction is increased by one.				
	}	
	
	/**
	 * This method handles the player going forward when the forward button is pressed.
	 * Player position is determined by coordinates stored as ints.
	 */
	public boolean GoForward() {											
		NotInWall = true;													
		if (BoundryCheck() == true) {		
			NotInWall = false;							//If at and facing a boundary then notInWall is false and player does not move.
		}
		else{											//If not then current position for player and minimap is recorded and player's position is changed		
			LastYPos = CurrentYPos;						//depending on what direction they are facing.
			LastXPos = CurrentXPos;
			LastXChange = MiniMapXChange;
			LastYChange = MiniMapYChange;
			LastMapYPos = MiniMapYPos;
			LastMapXPos = MiniMapXPos;
			switch (CurrentDirection) {
			case 1:  CurrentYPos++;	
			MiniMapYChange = MiniMapYChange+4;
			break;
			case 2:  CurrentXPos++;	
			MiniMapXChange = MiniMapXChange+4;
			break;
			case 3:  CurrentYPos--;
			MiniMapYChange = MiniMapYChange-4;	
			break;
			case 4:  CurrentXPos--;	
			MiniMapXChange = MiniMapXChange-4;	
			}
		}
		MiniMapYPos = (CurrentYPos*4)+12+MiniMapYChange;	//Timesing the players current X and Y positions by 4 then adding 12 + the minimap change
		MiniMapXPos = (CurrentXPos*4)+12+MiniMapXChange;	//makes the player icon on the minimap moves across the minimap proportionally to the player.
		return NotInWall;									//Minimap change must change by 4 each time depending if the players X and Y coordinates increase or decrease for this to work.
	}
	
	/**
	 * This method returns the player current X and Y positions concatenated.
	 */
	public int GetXAndYPos(){										
		int CurrentXAndYPos = Integer.valueOf(String.valueOf(CurrentXPos) + String.valueOf(CurrentYPos));	//Integer and string .valueOf is used to concatenate the ints together.
		return CurrentXAndYPos;
	}
	
	/**
	 * This method returns the player current direction, X and Y positions concatenated.
	 */
	public int GetDirXAndYPos(){									
		int CurrentDirXAndYPos = Integer.valueOf(String.valueOf(CurrentDirection) + String.valueOf(CurrentXPos) + String.valueOf(CurrentYPos));
		return CurrentDirXAndYPos;
	}
	
	/**
	 * This method returns the player current direction.
	 */
	public int GetDirection() {										
		return CurrentDirection;
	}
	
	/**
	 * This method returns the name of the player's current weapon.
	 */
	public String GetWeapon() {										
		return CurrentWeapon;
	}
	
	/**
	 * This method returns the int number of the player's current weapon level.
	 */
	public int GetCurrentweaponLevel() {							
		return CurrentweaponLevel;
	}
	
	/**
	 * This method returns the int numbers for the player's current weapon minimum and maximum attack.
	 */
	public String GetWeaponAttack()	{								
		return CurrentWeaponAttackMin+" - "+(CurrentWeaponAttackMax-1);
	}
	
	/**
	 * This method changes the weapon level, name and attack value depending on the number passed into it.
	 */
	public String SetWeaponLevel(int level) {	
		switch (level) {
		case 0:
			CurrentWeapon = "Quantum wrench";
			CurrentWeaponAttackMax = 3;
			CurrentWeaponAttackMin = 1;
			CurrentweaponLevel = 0;
			break;
		case 1:
			CurrentWeapon = "Ion welder";
			CurrentWeaponAttackMax = 5;
			CurrentWeaponAttackMin = 1;
			CurrentweaponLevel = 1;
			break;
		case 2:
			CurrentWeapon = "Plasma saw";
			CurrentWeaponAttackMax = 6;
			CurrentWeaponAttackMin = 4;
			CurrentweaponLevel = 2;
			break;
		case 3:
			CurrentWeapon = "Superposition cutter";
			CurrentWeaponAttackMax = 8;
			CurrentWeaponAttackMin = 6;
			CurrentweaponLevel = 3;
			break;
		}
		return CurrentWeapon;
	}
	
	/**
	 * Method for getting a random damage number from the player based on the attack minimum and maximum.
	 */
	public int PlayerAttacks()	{		
		return RandomNum.nextInt(CurrentWeaponAttackMax - CurrentWeaponAttackMin) + CurrentWeaponAttackMin;
	}
	
	/**
	 * Method for getting the value for the player's current health.
	 */
	public int GetPlayerHealth() {		
		return PlayerHealth;
	}
	
	/**
	 * Method for reducing players health by a passed value and returning that same value.
	 */
	public int ReducePlayerHealth(int change) {					
		PlayerHealth = PlayerHealth - change;
		return change;
	}
	
	/**
	 * Method for setting the players health to a passed value.
	 */
	public void SetPlayerHealth(int value) {
		PlayerHealth = value;
	}
	
	/**
	 * Method for getting players current X position on minimap.
	 */
	public int GetMiniMapXPos()	{	
		return MiniMapXPos;
	}
	
	/**
	 * Method for getting players current Y position on minimap.
	 */
	public int GetMiniMapYPos()	{		
		return MiniMapYPos;
	}
	
	/**
	 * Method that sends the player and minimap back to last recorded position.
	 */
	public void LastPosition() {									
		CurrentXPos = LastXPos;
		CurrentYPos = LastYPos;	
		MiniMapXChange = LastXChange;
		MiniMapYChange = LastYChange;
		MiniMapXPos = LastMapXPos;
		MiniMapYPos = LastMapYPos;
	}
	
	/**
	 * Method that checks the tile infront of the player to see if there is a wall there and returns the results.
	 * Works by current direction then X or Y +1 to check the tile in front of the player.
	 */
	public Integer ForwardTile() {
		switch (CurrentDirection) {		
		case 1: ForwardTile = Integer.valueOf(String.valueOf(CurrentXPos) + String.valueOf(CurrentYPos+1));		//Is wall south
		break;
		case 2:	ForwardTile = Integer.valueOf(String.valueOf(CurrentXPos+1) + String.valueOf(CurrentYPos));		//Is wall east
		break;
		case 3:	ForwardTile = Integer.valueOf(String.valueOf(CurrentXPos) + String.valueOf(CurrentYPos-1));		//Is wall north
		break;
		case 4:	ForwardTile = Integer.valueOf(String.valueOf(CurrentXPos-1) + String.valueOf(CurrentYPos));		//Is wall west
		}								
		return ForwardTile;
	}
	
	/**
	 * Method that checks if player is facing a boundary of the game, X or Y at 1 or 15 and return true of false.
	 */
	public boolean BoundryCheck() {
		FacingBoundry = false;		
		if (CurrentXPos == 1 && CurrentDirection == 4 || CurrentYPos == 1 && CurrentDirection == 3 || CurrentXPos == 15 && CurrentDirection == 2 || CurrentYPos == 15 && CurrentDirection == 1 ) {		
			FacingBoundry = true;
		}
		return FacingBoundry;
	}
}