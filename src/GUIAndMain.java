/**@author i7648171 Adam James Williams
 * ID 4626194 
 * Programming Assignment Semester 2 Coursework
 * Started 29th of March, finished 26th of April
 * This is my assignment submission, a first person Sci Fi dungeon crawler.
 * The code uses encapsulation for classes as variables are passed and changed using getter and setter methods.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Random;

/**
 * Establish GUI buttons, labels, Panels, frame, ETC
 */
public class GUIAndMain {			
	private JLabel LblPlayerView;
	private JLabel LblSideView;
	private JLabel LblPlayerWeapon;
	private JLabel LblCompass;
	private JLabel LblPlayerHealthImg;
	private JLabel LblEnemy;
	private JLabel LblMiniMap;
	private JLabel LblPlayerIcon;
	private JLabel LblWinLose;
	private JLabel LblItem;
	private JLabel LblLogin;
	private JButton BtnTurnLeft;
	private JButton BtnTurnRight;
	private JButton BtnForward;
	private JButton BtnAttack;
	private JButton BtnSearch;
	private JButton BtnExit;
	private JRadioButton RdBtnStandardHP;
	private JRadioButton RdBtnOverPoweredHP;
	private ButtonGroup RdBtnGroup;
	private JTextField TxtFldName;
	private JTextArea TxtAreaMessages;
	private JTextArea TxtAreaGeneral;
	private JScrollPane ScrollPane;
	private JPanel GamePanel;
	private JPanel IntroOutroPanel;
	private JFrame GameFrame;
	private Player Play = new Player();
	private Rooms Room = new Rooms();
	private Enemy Ene = new Enemy();
	private Integer IntgrXAndYPos; 
	private Random RandomNum = new Random(); 
	private int ForwardPresses = 0;
	private int EnemiesDefeated = 0;
	private int MedpacksFound = 0; 
	private int EnemyImage;
	private String Name;

	/**
	 * Constructor
	 */
	public GUIAndMain () {			
		CreateFrame();
		AddActiveComponents();
		AddPassiveComponents();
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameFrame.add(IntroOutroPanel);
		GameFrame.setVisible(true);
		GameFrame.setResizable(false);
	}

	/**
	 * Make labels, scollpane and text areas.
	 */
	public void AddPassiveComponents() {			
		TxtAreaMessages = new JTextArea();						//Text area for messages relating to player actions, cannot move through a wall, nothing to attack etc.
		TxtAreaMessages.setBounds(725, 140, 270, 85);
		GamePanel.add(TxtAreaMessages);
		TxtAreaMessages.setEditable(false);
		TxtAreaMessages.setForeground(Color.CYAN);
		TxtAreaMessages.setBackground(Color.BLACK);
		TxtAreaMessages.setFont(new Font("Consolas", Font.BOLD, 16));

		ScrollPane = new JScrollPane(TxtAreaMessages);			//Scrollbar for txtAreaMessages.
		ScrollPane.setBounds(725, 140, 270, 85);
		GamePanel.add(ScrollPane);

		TxtAreaGeneral = new JTextArea("The year is 2235 and interstellar travel has become common place throughout  known space. \n"   //Intro text
				+ "You are an engineer aboard the Galatic Union exploration ship the Tenebrosa, \n"
				+ "exploring the uncharted eastern edges of the galaxy. \n"
				+ "But during this exploration a hole in space appeared causing your ship to be damaged, \n"
				+ "and sucked into an unknown area, where only the strongest life can live with others dead,\n"
				+ "a deceased quadrant. \n"
				+ "With deranged life forms and bizzare entities from this quadrant on the ship, \n"
				+ "you must find your way to an escape pod and go back through the hole in space. \n"
				+"\n"
				+ "Controls and mechanics: \n"
				+ "Use the buttons on the right side of the screen to move forward, turn, \n"
				+ "attack when there is an enemy and search in the current room.\n"
				+ "You can find tool cupboards to get better weapons and medpacks to increase your health.\n"
				+ "If you think there is something of value in the current room press the Interact button.\n"
				+ "Messages with information will appear in a text area on the right above the buttons.\n"
				+ "You cannot run from enemies but there may be signs in the rooms on where they will be.\n"
				+"\n"
				+ "Enter a name in the text box then press the enter key to begin:\n"
				+ "\n"
				+ "\n"
				+ "Starting health?");
		TxtAreaGeneral.setBounds(50, 150, 890, 600);
		TxtAreaGeneral.setForeground(Color.CYAN);
		TxtAreaGeneral.setFont(new Font("Consolas", Font.BOLD, 18));
		TxtAreaGeneral.setOpaque(false);
		TxtAreaGeneral.setEditable(false);
		IntroOutroPanel.add(TxtAreaGeneral);

		ImageIcon Img = new ImageIcon("Images/Lose.jpg");							//JLabel for the background when you lose.
		LblWinLose = new JLabel(Img);
		LblWinLose.setBounds(0, 0, 1000, 700);

		ImageIcon login = new ImageIcon("Images/Login.jpg");						//JLabel for intro image.
		LblLogin = new JLabel(login);
		LblLogin.setBounds(0, 0, 1000, 700);
		IntroOutroPanel.add(LblLogin);

		ImageIcon playerIcon = new ImageIcon("Images/minimap/playerIcon1.jpg");		//JLabel for player icon on minimap.
		LblPlayerIcon = new JLabel(playerIcon);
		LblPlayerIcon.setBounds(13, 13, 7, 7);
		GamePanel.add(LblPlayerIcon);

		ImageIcon item = new ImageIcon("Images/rooms/item.png");					//JLabel for the item image.
		LblItem = new JLabel(item);
		LblItem.setBounds(80, 400, 280, 181);
		GamePanel.add(LblItem);
		LblItem.setVisible(false);

		LblEnemy = new JLabel();													//JLabel for enemy image.
		LblEnemy.setBounds(180, 150, 420, 420);
		GamePanel.add(LblEnemy);

		ImageIcon minimap = new ImageIcon("Images/minimap/miniMap.png");			//JLabel for minimap image.
		LblMiniMap = new JLabel(minimap);
		LblMiniMap.setBounds(0, 0, 145, 144);
		GamePanel.add(LblMiniMap);

		ImageIcon compass = new ImageIcon("Images/compass/compass1.jpg");			//JLabel for compass image.
		LblCompass = new JLabel(compass);
		LblCompass.setBounds(726, 1, 135, 135);
		GamePanel.add(LblCompass);

		ImageIcon health = new ImageIcon("Images/player/health.jpg");				//JLabel for player health image and text.
		LblPlayerHealthImg = new JLabel(health);
		LblPlayerHealthImg.setText("Health: "+Play.GetPlayerHealth());
		LblPlayerHealthImg.setHorizontalTextPosition(JLabel.CENTER);
		LblPlayerHealthImg.setVerticalTextPosition(JLabel.CENTER);
		LblPlayerHealthImg.setBounds(862, 1, 135, 135);
		LblPlayerHealthImg.setForeground(Color.CYAN);
		LblPlayerHealthImg.setFont(new Font("Consolas", Font.BOLD, 20));
		GamePanel.add(LblPlayerHealthImg);

		ImageIcon playerWeapon = new ImageIcon("Images/player/Quantum wrench.jpg");	//JLabel for player weapon and text.
		LblPlayerWeapon = new JLabel(playerWeapon);
		LblPlayerWeapon.setText("<html>"+Play.GetWeapon()+"<br>Attack: "+Play.GetWeaponAttack()+"</html>");
		LblPlayerWeapon.setHorizontalTextPosition(JLabel.CENTER);
		LblPlayerWeapon.setVerticalTextPosition(JLabel.TOP);
		LblPlayerWeapon.setBounds(726, 545, 268, 120);
		LblPlayerWeapon.setForeground(Color.CYAN);
		LblPlayerWeapon.setFont(new Font("Consolas", Font.BOLD, 17));
		GamePanel.add(LblPlayerWeapon);

		ImageIcon playerView = new ImageIcon("Images/rooms/hallway.jpg");			//JLabel for the players view of room.
		LblPlayerView = new JLabel(playerView);
		LblPlayerView.setBounds(0, 0, 726, 700);
		GamePanel.add(LblPlayerView);

		ImageIcon SideView = new ImageIcon("Images/player/sideView.jpg");			//JLabel for the background of the side view.
		LblSideView = new JLabel(SideView);
		LblSideView.setBounds(726, 0, 275, 700);
		GamePanel.add(LblSideView);
	}

	/**
	 * Make buttons and text field.
	 */
	private void AddActiveComponents() {											//
		BtnExit = new JButton("Exit");												//JButton for exit button when player wins or looses.
		BtnExit.setBounds(420, 500, 100, 20);
		BtnExit.addActionListener(new ExitHandler());
		BtnExit.setForeground(Color.CYAN);
		BtnExit.setFont(new Font("Consolas", Font.BOLD, 18));
		BtnExit.setContentAreaFilled(false);  

		TxtFldName = new JTextField();												//JTextField for the player to enter a name in the intro.
		TxtFldName.setBounds(690, 522, 150, 25);
		TxtFldName.addActionListener(new EnterName());
		TxtFldName.setFont(new Font("Consolas", Font.BOLD, 18));
		TxtFldName.setForeground(Color.CYAN);
		TxtFldName.setBackground(Color.BLACK);
		IntroOutroPanel.add(TxtFldName);

		RdBtnStandardHP = new JRadioButton("Standard 20");					//JRadioButton for setting the players health to the 20.
		RdBtnStandardHP.setActionCommand("20");
		RdBtnStandardHP.addActionListener(new HealthHandler(20));
		RdBtnStandardHP.setFont(new Font("Consolas", Font.BOLD, 20));
		RdBtnStandardHP.setSelected(true);
		RdBtnStandardHP.setBounds(300, 587, 200, 21);
		RdBtnStandardHP.setForeground(Color.CYAN);
		RdBtnStandardHP.setOpaque(false);
		IntroOutroPanel.add(RdBtnStandardHP);

		RdBtnOverPoweredHP = new JRadioButton("Over powered 999");			//JRadioButton for setting the players health to 999.
		RdBtnOverPoweredHP.setActionCommand("999");
		RdBtnOverPoweredHP.setFont(new Font("Consolas", Font.BOLD, 20));
		RdBtnOverPoweredHP.addActionListener(new HealthHandler(999));
		RdBtnOverPoweredHP.setBounds(500, 587, 280, 21);
		RdBtnOverPoweredHP.setForeground(Color.CYAN);
		RdBtnOverPoweredHP.setOpaque(false);
		IntroOutroPanel.add(RdBtnOverPoweredHP);

		RdBtnGroup = new ButtonGroup();										//Group the 2 JRadioButtons together.
		RdBtnGroup.add(RdBtnStandardHP);
		RdBtnGroup.add(RdBtnOverPoweredHP);

		ImageIcon attackBtnIcon = new ImageIcon("Images/player/attackReticle.jpg");	//JButton for attacking an enemy.
		BtnAttack = new JButton(attackBtnIcon);
		BtnAttack.setText("Attack");
		BtnAttack.setHorizontalTextPosition(JLabel.CENTER);
		BtnAttack.setVerticalTextPosition(JLabel.TOP);
		BtnAttack.setForeground(Color.CYAN);
		BtnAttack.setFont(new Font("Consolas", Font.BOLD, 20));
		BtnAttack.setBounds(750, 230, 100, 125);
		BtnAttack.addActionListener(new AttackHandler());
		BtnAttack.setContentAreaFilled(false);  
		GamePanel.add(BtnAttack);

		ImageIcon searchIcon = new ImageIcon("Images/player/interact.jpg");	 //JButton for searching a room.
		BtnSearch = new JButton(searchIcon);
		BtnSearch.setText("Search");
		BtnSearch.setHorizontalTextPosition(JLabel.CENTER);
		BtnSearch.setVerticalTextPosition(JLabel.TOP);
		BtnSearch.setForeground(Color.CYAN);
		BtnSearch.setFont(new Font("Consolas", Font.BOLD, 20));
		BtnSearch.setBounds(875, 230, 100, 125);
		BtnSearch.addActionListener(new SearchHandler());
		BtnSearch.setContentAreaFilled(false);  
		GamePanel.add(BtnSearch);

		ImageIcon leftIcon = new ImageIcon("Images/player/Left.jpg");		 //JButton for turning left.
		BtnTurnLeft = new JButton(leftIcon);
		BtnTurnLeft.setText("Turn left");
		BtnTurnLeft.setActionCommand("turnLeft");
		BtnTurnLeft.setHorizontalTextPosition(JLabel.CENTER);
		BtnTurnLeft.setVerticalTextPosition(JLabel.TOP);
		BtnTurnLeft.setForeground(Color.CYAN);
		BtnTurnLeft.setFont(new Font("Consolas", Font.BOLD, 17));
		BtnTurnLeft.setBounds(730, 455, 120, 90);
		BtnTurnLeft.addActionListener(new TurnHandler("left"));
		BtnTurnLeft.setContentAreaFilled(false);  
		GamePanel.add(BtnTurnLeft);

		ImageIcon rightIcon = new ImageIcon("Images/player/Right.jpg");		 //JButton for turning right.
		BtnTurnRight = new JButton(rightIcon);
		BtnTurnRight.setText("Turn left");
		BtnTurnRight.setActionCommand("turnRight");
		BtnTurnRight.setHorizontalTextPosition(JLabel.CENTER);
		BtnTurnRight.setVerticalTextPosition(JLabel.TOP);
		BtnTurnRight.setForeground(Color.CYAN);
		BtnTurnRight.setFont(new Font("Consolas", Font.BOLD, 17));
		BtnTurnRight.setBounds(870, 455, 120, 90);
		BtnTurnRight.addActionListener(new TurnHandler("right"));
		BtnTurnRight.setContentAreaFilled(false);  
		GamePanel.add(BtnTurnRight);

		ImageIcon forwardIcon = new ImageIcon("Images/player/Forward.jpg");	 //JButton for going forward into a room.
		BtnForward = new JButton(forwardIcon);
		BtnForward.setText("Forward");
		BtnForward.setHorizontalTextPosition(JLabel.CENTER);
		BtnForward.setVerticalTextPosition(JLabel.TOP);
		BtnForward.setForeground(Color.CYAN);
		BtnForward.setFont(new Font("Consolas", Font.BOLD, 17));
		BtnForward.setBounds(730, 360, 260, 90);
		BtnForward.addActionListener(new BtnGoForwardHandler());
		BtnForward.setContentAreaFilled(false);  
		GamePanel.add(BtnForward);
	}

	/**
	 * Create frame and panels
	 */
	private void CreateFrame() { 				
		GameFrame = new JFrame();
		GameFrame.setTitle("Deceased Quadrant");
		GameFrame.setSize(1000,700);
		GamePanel = new JPanel();
		GamePanel.setBounds(1000,700, 0, 0);
		GamePanel.setLayout(null);
		IntroOutroPanel = new JPanel();
		IntroOutroPanel.setLayout(null);
		IntroOutroPanel.setBounds(1000,700, 0, 0);
	}

	/**
	 * ActionListener for the JRadioButton to change the players health.
	 */
	class HealthHandler implements ActionListener 	
	{
		private int Value;
		public HealthHandler (int Value) {
			this.Value = Value;
		}
		public void actionPerformed(ActionEvent event) {
			Play.SetPlayerHealth(Value);									 //Set the player health to 20 or 999 depending on which JRadioButton is selected.
		}
	}

	/**
	 * ActionListener for the exit button when player has won or lost.
	 */
	class ExitHandler implements ActionListener 							 
	{
		public void actionPerformed(ActionEvent event) {
			System.exit(0);															
		}
	}

	/**
	 * ActionListener for the player entering a name and switching to game panel.
	 */
	class EnterName implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)		
		{																	
			Name = TxtFldName.getText();									 //Name string = what the player enters,
			IntroOutroPanel.removeAll();									 //Clear the intro outro panel of content, 
			GameFrame.add(GamePanel);										 //Add the game panel to the frame,
			GameFrame.revalidate();											 //Revalidate the frame,
			UpdatePlayerHealth();											 //update the JLabel for player health so that it is 999 if it was changed in intro.
		}
	}

	/**
	 * ActionListener for the left and right buttons.
	 */
	class TurnHandler implements ActionListener 
	{
		private String Turn;												 //String that will be left or right.
		public TurnHandler (String Turn) {
			this.Turn = Turn;
		}
		public void actionPerformed(ActionEvent event)						
		{																	
			if (Room.IsEnemyInRoom(IntgrXAndYPos) == true) {				 //Check if an enemy is in the current room,		
				AddMessage("I cannot do that while an enemy is here");	     //If yes then a message is shown to indicate that you cannot turn when an enemy is in the room.
			}																
			else {															
				switch (Turn) {												 //If no then switch based on if String turn is left or right.
				case "left": Play.TurnLeft();	
				break;														 //Turn left or right depending on turn.
				case "right": Play.TurnRight();	
				}
				PlayerViewUpdate();											 //Update the players view.										 
			}
		}
	}

	/**
	 * ActionListener for the forward button so the player can move into a room.
	 */
	class BtnGoForwardHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)						//Player presses forward button on GUI.
		{	
			if (Room.IsEnemyInRoom(IntgrXAndYPos) == true) {				//If an enemy is in the room then the player cannot exit the room and 
				AddMessage("I cannot do that while an enemy is here");		//a message is shown to indicate that. 
			}
			else {															 
				if (Play.GoForward() == false) {							//Call Play.goForward, 
					AddMessage("I cannot move through a wall");				//If it returns false then display wall message, If not false then player moves into forward tile.
				}															
				else if (Play.GetXAndYPos() == 1515) {						//If players new tile is the win tile then 
					WinLose("win");											//call the winLose method with the text "win".
				}
				else {
					IntgrXAndYPos = new Integer(Play.GetXAndYPos());		//Has to convert int to Integer as the HashSet in Rooms class requires that for the function.
					if (Room.GetWallInWay(IntgrXAndYPos) == true){			//Check to see if the tile the player moves into is occupied by a wall.
						Play.LastPosition();								//If yes then player is sent to last position with wall message.
						AddMessage("I cannot move through a wall");
					}
					else {
						PlayerViewUpdate();									//If no then update what the player sees 
						LblPlayerIcon.setBounds(Play.GetMiniMapXPos(), Play.GetMiniMapYPos(), 7, 7);		//and update the player icon on minimap.
						ItemInRoomImg();																	//Check in the new room to see if there is an item.
						ForwardPresses++;																	//+1 to the number of rooms the player has moved into.
						switch (Room.IsEnemyInNewRoom(IntgrXAndYPos)) {										//Check if an enemy is in the room and if so what tier.
						case "none":;																		//No enemy, do not do anything.
						break;
						case "enemyt1": 																	//A tier 1 enemy.
							EnemyImage = RandomNum.nextInt(2);												//Random int is used for getting an image, each tier has 2 enemy images.
							Ene.SetEnemyTier1();															//Set current enemy to tier 1.	
							LblEnemy.setIcon (new ImageIcon ("Images/enemies/enemyt1"+EnemyImage+".png"));	//Set enemy image label to 1 of the 2 tier 1 enemy images. 
							break;
						case "enemyt2":  																	//A tier 2 enemy.
							EnemyImage = RandomNum.nextInt(2);
							Ene.SetEnemyTier2();															//Set current enemy to tier 2.	
							LblEnemy.setIcon (new ImageIcon ("Images/enemies/enemyt2"+EnemyImage+".png"));	//Set enemy image label to 1 of the 2 tier 2 enemy images. 
							break;
						case "enemyt3": 																	//A tier 3 enemy.
							EnemyImage = RandomNum.nextInt(2);
							Ene.SetEnemyTier3();															//Set current enemy to tier 3.	
							LblEnemy.setIcon (new ImageIcon ("Images/enemies/enemyt3"+EnemyImage+".png"));	//Set enemy image label to 1 of the 2 tier 3 enemy images. 
						}
					}
				}
			}
		}
	}

	/**
	 * ActionListener for the attack button.
	 */
	class AttackHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)			  //Player presses attack button,
		{
			if (Room.IsEnemyInRoom(IntgrXAndYPos) == false) {	  //Check player's position for an enemy.
				AddMessage("No enemies to attack");				  //If false then give message to indicate that.
			} 
			else {                                                
				AddMessage("Dealt "+Ene.DamageEnemy(Play.PlayerAttacks())+" damage!");	//If true then get value of PlayerAttacks,  call damageEnemy with it reducing the enemies health and putting a message to say how much damage was dealt.
				if (Ene.GetEnemyHealth() <= 0){                   //Check to see if enemy was killed in attack,
					AddMessage("Enemy defeated");				  //If enemy health is 0 or lower then message is show, 
					LblEnemy.setIcon (new ImageIcon ());		  //enemy image is removed          
					Room.RemoveEnemy(Play.GetXAndYPos());    	  //remove enemy from current position in HashSet.
					EnemiesDefeated++;							  //Increase number of enemies defeated by 1.
				}
				else {
					AddMessage("Took "+Play.ReducePlayerHealth(Ene.EnemyAttack())+" damage!");	//If no then enemy attacks player removing player's health with the value of enemyAttack and displaying a message of how much health was lost. 
					UpdatePlayerHealth();	 					  //JLabel for player's health is updated with new value.
					if(Play.GetPlayerHealth() <= 0 ) {			  //If player health 0 or less
						WinLose("lose");						  //Then player is dead and winLose method is called with the text lose.
					}
				}
			}
		}
	}

	/**
	 * ActionListener for the search button.
	 */
	class SearchHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)							//Player presses search button
		{
			if (Room.IsEnemyInRoom(IntgrXAndYPos) == true) {					//If an enemy is in the room 
				AddMessage("I cannot do that while an enemy is here");			//Then a message to indicate that is shown.
			}
			else {																//If no enemy in room then 
				switch (Room.IsItemInNewRoom(IntgrXAndYPos)) {					//Check player position with medpack and upgrade HashSets.
				case "none": AddMessage("Found nothing");						//If no matches then display message,
				break;
				case "medpack": Play.ReducePlayerHealth(-5);					//If matches value in medpack HashSet then increase player health by 5, it is -5 becuase the method it is calling is health = health - value.
				AddMessage("Found and used a medical pack, +5 health");			//Display message to indicate what was found and the health increase.
				UpdatePlayerHealth();											//Update player health with new value.																
				MedpacksFound++;												//Increase number of medpacks found by 1.
				break;	
				case "upgrade": AddMessage("Found a "+Play.SetWeaponLevel(Play.GetCurrentweaponLevel()+1));			//If matches value with upgrade HashSet then increase the players weapon level by the current weapon level +1.
				LblPlayerWeapon.setIcon (new ImageIcon ("Images/player/"+Play.GetWeapon()+".jpg"));					//Change weapon image to new weapon.		
				LblPlayerWeapon.setText("<html>"+Play.GetWeapon()+"<br>Attack: "+Play.GetWeaponAttack()+"</html>");	//Update weapon label text with new weapon name and attack values.
				}
				LblItem.setVisible(false);									//Set image for items to false.
				if (!(Room.IsItemInNewRoom(IntgrXAndYPos) == "none")) {		//If none then do not remove from HashSet, 
					Room.RemoveItem(IntgrXAndYPos);							//if medpack or upgrade then remove from HashSet.
				}	
			}
		}
	}

	/**
	 * Method for appending a passed String to the top of the text area.
	 */
	public void AddMessage(String message) {
		TxtAreaMessages.setText((message+"\n") + TxtAreaMessages.getText());	//Set the text content or the text area to message, new line then the content already in the area.
		TxtAreaMessages.setCaretPosition(0);									//Set scroll position to top.
	}

	/**
	 * Method for updating the set of the player health image with the current health value.
	 */
	public void UpdatePlayerHealth() {
		LblPlayerHealthImg.setText("Health: "+Play.GetPlayerHealth());			//Update the text of the player health JLabel.
	}

	/**
	 * Method that if the players current coordinates correspond to the coordinates of an item and if so set item image to visible..
	 */
	public void ItemInRoomImg() {
		switch (Room.IsItemInNewRoom(IntgrXAndYPos)) {							//Check the players current XY position with the HashSets that isItemInNewRoom calls to.
		case "none": LblItem.setVisible(false);									//If none is returned then set item JLabel image to not visible.
		break;
		case "medpack": LblItem.setVisible(true);
		break;																	//If medpack or upgrade is returned then make the image visible.
		case "upgrade": LblItem.setVisible(true);
		}
	}

	/**
	 * Method for when the player wins or loses, changes the panels in use based on the passed String to reflect this.
	 */
	public void WinLose(String state) {
		GamePanel.setVisible(false);											//Set the game panel to not visible.
		IntroOutroPanel.add(BtnExit);											//Add to the intro outro panel the exit button
		TxtAreaGeneral.setText("Player: "+String.valueOf(Name)+"\n"				//Set the stats for the text area.
				+"Times moved into a room: "+ForwardPresses+"\n"
				+"Enemies defeated: "+EnemiesDefeated+"/10\n"
				+"Medpacks found: "+MedpacksFound+"/9\n"
				+"Weapon upgrades found :"+Play.GetCurrentweaponLevel()+"/3");
		switch (state) {														//Switch for if the player won or lost.
		case "lose": TxtAreaGeneral.setBounds(330, 335, 500, 300);				//If lost player sees their stats and a you have died background image.
		break;
		case "win": 															//If won then player get text about escaping from the ship along with stats.
			TxtAreaGeneral.setText("You reach the escape pod and launch it as you hear a hissing behind you\n"
					+ "The pod propels away from the ship and to the hole in space, passing into it.\n"
					+ "You emerge to see a Galatic Union ship heading towards you,\n"
					+ "So you signal the SOS and await rescue.\n"
					+ "You win\n"
					+ "\n"
					+ TxtAreaGeneral.getText());
			LblWinLose.setIcon(new ImageIcon ("Images/Win.jpg"));				//Background image is changed to win image
		}
		IntroOutroPanel.add(TxtAreaGeneral);									//Text area is added to panel.
		IntroOutroPanel.add(LblWinLose);										//Background image label is added to panel.
		GameFrame.revalidate();
	}

	/**
	 * Method that updates the players view: view in room, position on minimap and compass
	 */
	public void PlayerViewUpdate() {
		LblCompass.setIcon (new ImageIcon ("Images/compass/compass"+Play.GetDirection()+".jpg"));		//Update the compass image using the players direction number.
		LblPlayerIcon.setIcon (new ImageIcon ("Images/minimap/playerIcon"+Play.GetDirection()+".jpg"));	//Update the player minimap icon using the players direction number.
		if (Room.GetWallInWay(Play.ForwardTile()) == true || Play.BoundryCheck() == true)  { 			//Check if the player is facing a wall or a room then display the appropriate image.
			LblPlayerView.setIcon (new ImageIcon ("Images/rooms/wall.jpg"));
		}
		else {
			LblPlayerView.setIcon (new ImageIcon ("Images/rooms/hallway.jpg"));
		}
	}

	public static void main(String[] args) {
		new GUIAndMain();
		new Rooms();
	}
}