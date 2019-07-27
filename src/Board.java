import java.util.Scanner;

public abstract class Board {
	int[][] board;
	ArrayList<Ship> ships=new ArrayList<Ship>(5);
	ArrayList<String> sunkShips=new ArrayList<String>(5);
	public Board(int x, int y) {
		this.ships=ships;
		board=new int[x][y];
		/*for(int i=0;i<ships.size();i++) {
			for(int j=0;j<ships.get(i).getShipPoints().size();j++) {
				setValue(ships.get(i).getShipPoints().getAt(j).getData(),3);
			}
		}*/
	}
	public Board(int x,int y,ArrayList<Ship> ships) {
		this.ships=ships;
		board=new int[x][y];
		for(int i=0;i<ships.size();i++) {
			for(int j=0;j<ships.get(i).getShipPoints().size();j++) {
				setValue(ships.get(i).getShipPoints().getAt(j).getData(),3);
			}
		}
	}
	public void addShip(Ship ship) throws Exception {
		for(int i=0;i<ship.getShipPoints().size;i++) {
			if(getValue(ship.getShipPoints().getAt(i).getData())==3) {
				throw new Exception("ship overlaps");
			}else {
				setValue(ship.getShipPoints().getAt(i).getData(),3);
			}
		}
		ships.add(ship);
	}
	public void setBoard(int[][] board) {
		this.board=board;
	}
	public int[][] getBoard(){
		return board;
	}
	public void setValue(String point,int num) {
		board[getXPoint(point)][getYPoint(point)]=num;
	}
	public int getXPoint(String point) {
		return point.charAt(0)-65;
	}
	public int getYPoint(String point) {
		return Integer.parseInt(point.substring(1))-1;
	}
	public boolean alreadyPlayed(String point) {
		return getValue(point)==1||getValue(point)==2;
	}
	public int getValue(String point) {
		return board[getXPoint(point)][getYPoint(point)];
	}
	public char getChar(int value) {
		return '0';
	}
	public boolean playPoint(String point,Scanner scan) {
		while(alreadyPlayed(point)) {
			System.out.println("point already played\nPlease enter a different point");
			point=scan.next();
		}
		if(getValue(point)==0) {
			setValue(point,1);
			return false;
		}else if(getValue(point)==3) {
			int place;
			for(int i=0;i<ships.size();i++) {
				if(ships.get(i).sinkPoint(point)) {
					if(ships.get(i).sunk) {
						sunkShips.add(ships.get(i).name);
						ships.remove(i);
					}
				}
			}
			setValue(point,2);
			return true;
		}
		return false;
	}
	public boolean playPoint(String point) {
		if(getValue(point)==0) {
			setValue(point,1);
			return false;
		}else if(getValue(point)==3) {
			setValue(point,2);
			return true;
		}
		return true;
	}
	public String print() {
		String end="  ";
		for(int i=1;i<=board.length;i++) {
			end+=i+" ";
		}
		end+="\n";
		for(int i=0;i<board.length;i++) {
			end+=(char)(i+65)+"|";
			for(int j=0;j<board[i].length;j++) {
				end+=getChar(board[i][j])+" ";
			}
			end+="\n";
		}
		return end;
	}
}
