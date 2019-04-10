/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class EnemyTest {
	private Enemy TestEnemy = new Enemy();

	@Test
	public void TestDamageEnemy() {
		
		//Tests that pass
		assertSame(1, TestEnemy.DamageEnemy(1));	//Passes in a damage value and returns the same value.
		assertSame(3, TestEnemy.DamageEnemy(3));	//Passes in a damage value and returns the same value.
		assertSame(5, TestEnemy.DamageEnemy(5));	//Passes in a damage value and returns the same value.
		assertSame(-1, TestEnemy.DamageEnemy(-1));  //Passes in a damage value and returns the same value.
		
		//The damageEnemy method only accepts ints and there is nothing in the code to pass anything other than ints to it.
		//No need to put in something to make sure that same value is returned as there is nothing in method to change it.
	}
}