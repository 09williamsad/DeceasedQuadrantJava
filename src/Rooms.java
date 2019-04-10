/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import java.util.HashSet;

public class Rooms {
	private boolean EnemyInRoom = false;
	private boolean WallInWay = false;
	private HashSet<Integer> T1EnemyLocations = new HashSet<>(); //HashSet to contain the coordinates for tier 1 enemies.
	private HashSet<Integer> T2EnemyLocations = new HashSet<>(); //HashSet to contain the coordinates for tier 2 enemies.
	private HashSet<Integer> T3EnemyLocations = new HashSet<>(); //HashSet to contain the coordinates for tier 3 enemies.
	private HashSet<Integer> Walls = new HashSet<>(); //HashSet to contain the coordinates for walls in the boundaries of the game.
	private HashSet<Integer> HealthItems = new HashSet<>(); //HashSet to contain the coordinates for health packs.
	private HashSet<Integer> WeaponUpgrade = new HashSet<>(); //HashSet to contain the coordinates for weapons upgrades.
	
/**
 * Put the locations of enemies, medpacks, upgrades and walls into their HashSets.
 */
	public Rooms () {								
		T1EnemyLocations.add(31); 
		T1EnemyLocations.add(13);
		T1EnemyLocations.add(45);
		T1EnemyLocations.add(92); 
		T2EnemyLocations.add(96);
		T2EnemyLocations.add(410);
		T2EnemyLocations.add(146); 
		T3EnemyLocations.add(1514);
		T3EnemyLocations.add(815);
		T3EnemyLocations.add(212);
		HealthItems.add(53);
		HealthItems.add(38);
		HealthItems.add(154);
		HealthItems.add(115); 
		HealthItems.add(111);
		HealthItems.add(911); 
		HealthItems.add(1215); 
		HealthItems.add(1413); 
		HealthItems.add(514);
		WeaponUpgrade.add(15); 
		WeaponUpgrade.add(127); 
		WeaponUpgrade.add(1213);
		Walls.add(101); 
		Walls.add(121); 
		Walls.add(131); 
		Walls.add(151);
		Walls.add(22); 
		Walls.add(32); 
		Walls.add(42); 
		Walls.add(62); 
		Walls.add(72); 
		Walls.add(82); 
		Walls.add(152);
		Walls.add(103); 
		Walls.add(113); 
		Walls.add(123); 
		Walls.add(133); 
		Walls.add(153);  
		Walls.add(14);
		Walls.add(24); 
		Walls.add(34); 
		Walls.add(44); 
		Walls.add(64);
		Walls.add(74);
		Walls.add(84); 
		Walls.add(104); 
		Walls.add(124);
		Walls.add(134); 
		Walls.add(65);
		Walls.add(155); 
		Walls.add(16);
		Walls.add(26);
		Walls.add(36);
		Walls.add(46); 
		Walls.add(66);
		Walls.add(86);
		Walls.add(106); 
		Walls.add(116); 
		Walls.add(126); 
		Walls.add(136); 
		Walls.add(17); 
		Walls.add(27); 
		Walls.add(67); 
		Walls.add(107); 
		Walls.add(117); 
		Walls.add(137); 
		Walls.add(157); 
		Walls.add(48); 
		Walls.add(58); 
		Walls.add(68); 
		Walls.add(88); 
		Walls.add(158);
		Walls.add(19); 
		Walls.add(29); 
		Walls.add(49); 
		Walls.add(109);
		Walls.add(119);
		Walls.add(129); 
		Walls.add(139); 
		Walls.add(610);
		Walls.add(810); 
		Walls.add(1010); 
		Walls.add(1210); 
		Walls.add(1310); 
		Walls.add(1510); 
		Walls.add(211); 
		Walls.add(411); 
		Walls.add(611); 
		Walls.add(811); 
		Walls.add(1511); 
		Walls.add(412); 
		Walls.add(612); 
		Walls.add(812); 
		Walls.add(912); 
		Walls.add(1112); 
		Walls.add(1212); 
		Walls.add(1312); 
		Walls.add(1412); 
		Walls.add(1512); 
		Walls.add(213); 
		Walls.add(413); 
		Walls.add(613); 
		Walls.add(813); 
		Walls.add(913); 
		Walls.add(114); 
		Walls.add(214); 
		Walls.add(1114); 
		Walls.add(1314); 
		Walls.add(1414); 
		Walls.add(415); 
		Walls.add(615); 
		Walls.add(715); 
		Walls.add(915); 
		Walls.add(1015); 
		Walls.add(1115); 
		Walls.add(1315); 
		Walls.add(1415);  
	}
	
	/**
	 * Method that checks if the integer passed to it is the same as a coordinate for a wall and return if true or false.
	 */
	public boolean GetWallInWay(Integer value) {					
		WallInWay = Walls.contains(value);				//Check if the passed value is the same as a wall coordinate HashSet,
		return WallInWay;								//return true or false.
	}
	
	/**
	 * Method that checks if the integer passed to it is the same as a coordinate for an enemy and return if true or false.
	 */
	public boolean IsEnemyInRoom(Integer value) {		//Check if passed value is same as enemy coordinate or any tier then return the result.
		EnemyInRoom = T1EnemyLocations.contains(value)  || T2EnemyLocations.contains(value)  || T3EnemyLocations.contains(value);
		return EnemyInRoom;	
	}
	
	/**
	 * Method that checks if the integer passed to it is the same as a coordinate for an enemy and return what tier of enemy or "none" if no enemy.
	 */
	public String IsEnemyInNewRoom(Integer value) {	
		if(T1EnemyLocations.contains(value) == true) {
			return "enemyt1";					//tier 1 is in room.
		}
		else if (T2EnemyLocations.contains(value) == true) {
			return "enemyt2";					//tier 2 is in room.
		}
		else if (T3EnemyLocations.contains(value) == true) {
			return "enemyt3";					//tier 3 is in room.
		}
		else {
			return "none";						//No enemy in room.
		}
	}
	
	/**
	 * Method that checks if the integer passed to it is the same as a coordinate for a medpack or upgrade and return "medpack", "upgrade" or "none" if neither.
	 */
	public String IsItemInNewRoom(Integer value) {				//Is passed value same as coordinates of upgrade or medpack?
		if(HealthItems.contains(value) == true) {				//If same as medpack then return "medpack",
			return "medpack";
		}
		else if (WeaponUpgrade.contains(value) == true){
			return "upgrade";									//If same as medpack then return "upgrade".
		}
		else { 
			return "none";										//If neither then return "none".
		}
	}
	
	/**
	 * Method that removes the passed value from the enemy HashSets, removing the enemy.
	 */
	public void RemoveEnemy(int i) {   					
		EnemyInRoom = false;							//Set enemy in room to false as enemy is gone.
		T1EnemyLocations.remove(i);
		T2EnemyLocations.remove(i);						//Remove enemy from HashSets.
		T3EnemyLocations.remove(i);
	}
	
	/**
	 * Method that removes the passed value from the item HashSets, removing the item.
	 */
	public void RemoveItem(int i) {   
		WeaponUpgrade.remove(i);
		HealthItems.remove(i);
	}
}