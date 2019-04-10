/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {
	private Player TestPlay = new Player();
	@Test
	public void TestSetWeaponLevel() {
		
		//Tests that pass
		assertEquals("Ion welder", TestPlay.SetWeaponLevel(1));				//Player gets the 1st upgrade.
		assertEquals("Plasma saw", TestPlay.SetWeaponLevel(2));				//Player gets the 2st upgrade.
		assertEquals("Superposition cutter", TestPlay.SetWeaponLevel(3));	//Player gets the 3st upgrade.
		
		//Tests that fail
		assertEquals("Quantum wrench", TestPlay.SetWeaponLevel(0));	//Weapon cannot be returned to the starting weapon, no code or reason for this so this test fails.
		assertEquals("Gun", TestPlay.SetWeaponLevel(4));			//No weapon called Gun or at level 4, no need to implement a fix for this as there are only 3 upgrades on map which is the only way to upgrade.
		assertEquals(124, TestPlay.SetWeaponLevel(3));				//Weapon name must be a String, no need to fix as all the weapons have String names and the player cannot change weapon names.
	}
	@Test
	public void TestReducePlayerHealth() {
		
		//Tests that pass
		assertSame(1, TestPlay.ReducePlayerHealth(1));	//Returns the value that is passed to it.
		assertSame(2, TestPlay.ReducePlayerHealth(2));	//Returns the value that is passed to it.
		
		//Test that fail
		assertSame(1, TestPlay.ReducePlayerHealth(2));	//Value is not same, no need to make something to prevent this as it would not happen, nothing in method to change the value.
	}
}