
public class Player {
	String name;
	ArrayList<Ship> ships = new ArrayList<Ship>();
	View1 myBoard;
	View2 opponentBoard;
	
	Player (String s,int height,int length) {
		name = s;
		myBoard = new View1(height, length);
		opponentBoard = new View2(height, length);
	}
	
	
	/*public void updateBoards() {
		myBoard = new View1(10, 10, ships);
	}*/

}
