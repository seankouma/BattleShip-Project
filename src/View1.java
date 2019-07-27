
public class View1 extends Board{

	public View1(int x, int y) {
		super(x, y);
	}
	public View1(int x, int y,ArrayList<Ship> ships) {
		super(x,y,ships);
	}
	
	@Override
	public char getChar(int value) {
		if(value==0) {
			return '-';
		}else if(value==1) {
			return '*';
		}else if(value==2) {
			return 'X';
		}else {
			return 'O';
		}
	}

}
