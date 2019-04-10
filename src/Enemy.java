/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import java.util.Random;

public class Enemy {
	private int EnemyHealth = 3;
	private int EnemyAttackMax = 3;
	private int EnemyAttackMin = 1;
	private Random RandomNum = new Random(); 

	/**
	 * Method that reduces the enemies health and returns the damage number taken.
	 */
	public int DamageEnemy(int Damage) {	
		EnemyHealth = EnemyHealth - Damage; 
		return Damage;
	}
	
	/**
	 * Method that generates a random number between enemy attack min and max then returns that number.
	 */
	public int EnemyAttack() {		
		return RandomNum.nextInt(EnemyAttackMax - EnemyAttackMin) + EnemyAttackMin;
	}
	
	/**
	 * Method that sets the tier of the current enemy to 1, change its health and attack to reflect that.	
	 */
	public void SetEnemyTier1() {
		EnemyHealth = 3;
		EnemyAttackMin = 1;
		EnemyAttackMax = 3;
	}
	
	/**
	 * Method that sets the tier of the current enemy to 2, change its health and attack to reflect that.	
	 */
	public void SetEnemyTier2() {			//Set the tier of the current enemy to 2, change its health and attack to reflect that.	
		EnemyHealth = 7;
		EnemyAttackMin = 2;
		EnemyAttackMax = 5;
	}
	
	/**
	 * Method that sets the tier of the current enemy to 3, change its health and attack to reflect that.	
	 */
	public void SetEnemyTier3() {			//Set the tier of the current enemy to 3, change its health and attack to reflect that.	
		EnemyHealth = 12;
		EnemyAttackMin = 4;
		EnemyAttackMax = 7;
	}
	
	/**
	 * Method that returns the value of the enemies health.
	 */
	public int GetEnemyHealth() {			
		return EnemyHealth;}
}