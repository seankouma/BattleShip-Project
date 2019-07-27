
public class Ship {
	String name;
	Boolean sunk = false;
	LinkedList<String> shipPoints;
	public Ship(String name, String start, String end) throws Exception {
		this.name=name;
		shipPoints=new LinkedList<String>();
		int s1=start.charAt(0)-65;
		int e1=end.charAt(0)-65;
		int s2=Integer.parseInt(start.substring(1)+"");
		int e2=Integer.parseInt(end.substring(1)+"");
		if(s1==e1) {
			int length=e2-s2+1;
			if(nameMatchLength(name,length)) {
				for(int i=s2;i<=e2;i++) {
					String point=start.charAt(0)+""+i+"";
					shipPoints.addLast(point);
				}
			}else {
				throw new Exception("length doesn't match name");
			}
		}else if(s2==e2) {
			int length=e1-s1+1;
			if(nameMatchLength(name,length)) {
				for(int i=s1;i<=e1;i++) {
					String point=(char)(i+65)+""+s2;
					shipPoints.addLast(point);
				}
				System.out.println();
			}else {
				throw new Exception("length doesn't match name");
			}
		}else {
			throw new Exception("start and end are diagonal");
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void updateSunk() {
		if (shipPoints.size == 0) {
			this.sunk = true;
		}
	}

	public Boolean getSunk() {
		return sunk;
	}

	public void setSunk(Boolean sunk) {
		this.sunk = sunk;
	}

	public LinkedList<String> getShipPoints() {
		return shipPoints;
	}

	public void setShipPoints(LinkedList<String> shipPoints) {
		this.shipPoints = shipPoints;
	}

	public boolean nameMatchLength(String name, int length) {
		return (name.equals("Carrier")&&length==5)||(name.equals("Battleship")&&length==4)||(name.equals("Cruiser")&&length==3)||(name.equals("Submarine")&&length==3)||(name.equals("Destroyer")&&length==2);
	}
	public boolean isSunk() {
		return shipPoints.size()==0;
	}
	public boolean sinkPoint(String point) {
		for(int i=0;i<shipPoints.size();i++) {
			if(shipPoints.getAt(i).toString().equals(point)) {
				shipPoints.remove(i);
				if(isSunk()) {
					sunk=true;
				}
				return true;
			}
		}
		return false;	
	}
	public boolean pointInShip(String point) {
		for(int i=0;i<shipPoints.size();i++) {
			if(shipPoints.getAt(i).equals(point)) {
				return true;
			}
		}
		return false;	
	}
}
