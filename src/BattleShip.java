import java.util.Scanner;

public class BattleShip {
		// Initializes the scanner used to accept user input.
	static Scanner keyboard = new Scanner(System.in);
	static Player playerOne;
	static Player playerTwo;
	static int testing = 5;
	static boolean gameOver=false;
	
	public static void main(String[] args) {
		// Initializes the players, the boards, and sets the locations of the ships.
		initializeGame();
		// Loops through the player's turns.
		while (gameOver == false) {
			Turns(playerOne,playerTwo);
			if(!gameOver) {
				Turns(playerTwo,playerOne);
			}	
		}
		
	}
	
	public static void initializeGame() {
			// The lengths of the 5 ships in the actual Battleship game.
			int[] shipLengths = {2,3,3,4,5};
		
		// Collects player names
		System.out.println("Player 1, what would you like your name to be? ");
		String p1 = keyboard.next();
		System.out.println("Player 2, what would you like your name to be? ");
		String p2 = keyboard.next();
		
		// Initializes the players
		playerOne = new Player(p1,10,10);
		playerTwo = new Player(p2,10,10);
		
		// Initializes the ships of the players.
		String start,end;
		String name = "";
		Player temp = playerOne;
		Player temp2 = playerTwo;
		for (int k = 0; k < 2; k++) {
			if (k == 1) {
				temp = playerTwo;
				temp2=playerOne;
			}
			View1 view=new View1(10,10);
			View2 view2=new View2(10,10);
			// Sets the name of the ship.
			ArrayList<Ship> ships=new ArrayList<Ship>();
			for (int i = 0; i < testing; i++) {
				switch (i) { 
			        case 0: 
			            name = "Destroyer"; 
			            break; 
			        case 1: 
			            name = "Submarine"; 
			            break; 
			        case 2: 
			            name = "Cruiser"; 
			            break; 
			        case 3: 
			            name = "Battleship"; 
			            break; 
			        case 4: 
			            name = "Carrier"; 
			            break; 
					}
				// Takes in the ship's coordinates in the format "A1" for the starting and ending points of the ships.
				System.out.println(temp.name + " where would you like the starting location of your " + name + " to be (which has a length of "  + shipLengths[i] + ")? ");
				start = keyboard.next();
				System.out.println(temp.name + " where would you like the ending location of your ship to be (which has a length of "  + shipLengths[i] + ")? ");
				end = keyboard.next();
				
				// Makes sure that the starting and ending points provided equals the length of the ship.
				boolean test=true;
				while(test) {
				try {
					view.addShip(new Ship(name, start, end));
					view2.addShip(new Ship(name,start,end));
					test=false;
				} catch (Exception e) {
					System.out.println("Oh no, there was an error!");
					System.out.println(e.toString());
					System.out.println("Please enter a different starting location");
					start=keyboard.next();
					System.out.println("Please enter a different ending location");
					end=keyboard.next();
				}
				}
			}
			//View1 view1=new View1(10,10,ships);
			temp.myBoard=view;
			//View2 view2=new View2(10,10,ships);
			temp2.opponentBoard=view2;
		}
		
	}
	
	public static void Turns(Player p, Player o) {
		/*Player playerTemp = playerOne;
		if (p.name.equals(playerTwo.name)) {
			playerTemp = playerTwo;
		}*/
		int sunkCounter = 0;
		//Ship temp = (Ship) playerTemp.ships.get(0).getData();
		// Prints out the boards
		System.out.println(p.name+" board: ");
		//p.updateBoards();
		System.out.println(p.myBoard.print());
		System.out.println(p.opponentBoard.print());
		// Prints out the enemy ships which have been sunk.
		System.out.println(o.name+" ships which are currently sunk are: ");
			for (int i = 0; i < p.opponentBoard.sunkShips.size(); i++) {						
				System.out.print(p.opponentBoard.sunkShips.get(i)+" ");
			}
			System.out.println();
		
		System.out.println();
		System.out.println("Where would you like to shoot? ");
		String coordinate = keyboard.next();
		boolean hit=p.opponentBoard.playPoint(coordinate, keyboard);
		if(hit) {
			System.out.println("HIT!");
		}else {
			System.out.println("Miss");
		}
		o.myBoard.playPoint(coordinate);
		if (p.opponentBoard.sunkShips.size() == testing) {
			System.out.println(p.name+" won");
			gameOver=true;
			//System.exit(0);
		}
		/*String coordinate1 = "" + coordinate.charAt(0) + (Integer.parseInt(coordinate.substring(1))-1);
		// Boolean for whether the coordinate shot at was a hit or not.
		Boolean hit = false;
		// Loops through the opponent's ships and deletes the node if it matches the coordinate.
		for (int k = 0; k < testing; k++) {
			temp = playerTemp.ships.get(k).data;
			// Loops through the ships' points.
			for (int j = 0; j < temp.shipPoints.size; j++) {
				if (temp.shipPoints.getAt(j).data.equals(coordinate1)) {
					temp.shipPoints.remove(j);
					hit = true;
				}
			}
		}
		
		/*if (hit == true) {
			System.out.println("Hit!");
			p.opponentBoard.setValue(coordinate, 2);
		} else {
			System.out.println("That was a miss.");
			p.opponentBoard.setValue(coordinate, 1);
		}*/
		//p.opponentBoard.playPoint(coordinate, keyboard);
		
		// Update whether any ships are sunk.
		/*for (int m = 0; m < testing; m++) {
			playerTemp.ships.get(m).data.updateSunk();
		}*/
		
	}
	
	
	// Check to see if the game is over.
	public static boolean isGameOver() {
		int sunkCounter = 0;
		Player playerTemp = playerOne;
		Ship temp = null;
		// Loops through the two players.
		for (int l = 0; l < 2; l++) {
			temp = (Ship) playerTemp.ships.get(0);
			// Loops through the current player's ships and counts the ones that are sunk.
			for (int i = 0; i < testing; i++) {
				temp = (Ship) playerTemp.ships.get(i);
				if (temp.sunk == true) {
					sunkCounter++;
					System.out.print(temp.name + " ");
					}
			}
			// If 5 ships are sunk it ends the game and calls the gameOver() method.
			if (sunkCounter == testing) {
				if (playerTemp.name.equals(playerOne.name)) {
					gameOver(playerTwo);
				} else {
					gameOver(playerOne);
				}
				return true;
			}
			playerTemp = playerTwo;
		}
		
		// Default options if less than 5 ships have been sunk.
		return false;
	}
	
	public static void gameOver(Player winner) {
		System.out.println("Congratulations! You have won this game of Battleship!");
	}
}
