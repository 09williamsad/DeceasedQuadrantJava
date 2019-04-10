/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class RoomsTest {
	private Rooms TestRoom = new Rooms();

	@Test
	public void TestGetWallInWay() {
		//Tests that pass
		assertTrue(TestRoom.GetWallInWay(121));		//Coordinate for a wall
		assertFalse(TestRoom.GetWallInWay(100));	//Coordinate that does not have a wall	

		//Tests that fail
		assertTrue(TestRoom.GetWallInWay(100));		//Fails as there is a wall, no reason to change code as wall coordinates are determined at runtime, cannot be changed mid operation.
		assertFalse(TestRoom.GetWallInWay(121));	//Fails as there is not a wall, no reason to change code as wall coordinates are determined at runtime, cannot be changed mid operation.
	}
	
	@Test
	public void TestIsEnemyInRoom() {
		//Tests that pass
		assertTrue(TestRoom.IsEnemyInRoom(31));		//Coordinate for enemy
		assertFalse(TestRoom.IsEnemyInRoom(111));	//Coordinate that does contain an enemy
		
		//Tests that fail
		assertTrue(TestRoom.IsEnemyInRoom(10));		//Fails as there no enemy here, no reason to change code as enemy coordinates are added at runtime, cannot be added mid operation.
		assertFalse(TestRoom.IsEnemyInRoom(1514));	//Fails as there is an enemy here, no reason to change code as enemy coordinates are added at runtime, cannot be added mid operation.
	}
	
	@Test
	public void TestIsEnemyInNewRoom() {
		//Tests that pass
		assertEquals("enemyt1", TestRoom.IsEnemyInNewRoom(31));		//Coordinate for t1 enemy
		assertEquals("enemyt2", TestRoom.IsEnemyInNewRoom(96));		//Coordinate for t2 enemy
		assertEquals("enemyt3", TestRoom.IsEnemyInNewRoom(1514));	//Coordinate for t3 enemy
		assertEquals("none", TestRoom.IsEnemyInNewRoom(111));		//Coordinate that does contain an enemy
		
		//Tests that fail
		assertEquals("enemyt1", TestRoom.IsEnemyInNewRoom(96));		//Fails as no tier 1 enemy, no need to change as enemy coordinates are added at runtime, cannot be added mid operation.
		assertEquals("enemyt2", TestRoom.IsEnemyInNewRoom(1514));	//Fails as no tier 2 enemy, no need to change as enemy coordinates are added at runtime, cannot be added mid operation.
		assertEquals("enemyt3", TestRoom.IsEnemyInNewRoom(31));		//Fails as no tier 3 enemy, no need to change as enemy coordinates are added at runtime, cannot be added mid operation.
		assertEquals("none", TestRoom.IsEnemyInNewRoom(1514));		//Fails as there is an enemy, no need to change as enemy coordinates are added at runtime, cannot be added mid operation.
	}
	
	@Test
	public void TestIsItemInNewRoom() {
		//Tests that pass
		assertEquals("medpack", TestRoom.IsItemInNewRoom(911));		//Coordinate for medpack 
		assertEquals("upgrade", TestRoom.IsItemInNewRoom(15));		//Coordinate for upgrade 
		assertEquals("none", TestRoom.IsItemInNewRoom(1115));		//Coordinate that does contain an item
		
		//Tests that fail
		assertEquals("medpack", TestRoom.IsItemInNewRoom(1115));	//Fails as no medpack here, no need to change as item coordinates are added at runtime, cannot be added mid operation.
		assertEquals("upgrade", TestRoom.IsItemInNewRoom(911));		//Fails as no upgrade here, no need to change as item coordinates are added at runtime, cannot be added mid operation.
		assertEquals("none", TestRoom.IsItemInNewRoom(15));			//Fails as there is an item here, no need to change as item coordinates are added at runtime, cannot be added mid operation.
	}
}