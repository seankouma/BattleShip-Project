
public class View2 extends Board{
	public View2(int x, int y) {
		super(x, y);
	}
	public View2(int x, int y,ArrayList<Ship> ships) {
		super(x,y,ships);
	}
	@Override
	public char getChar(int value) {
		if(value==0||value==3) {
			return '-';
		}else if(value==1) {
			return '*';
		}else {
			return 'X';
		}
	}
}
