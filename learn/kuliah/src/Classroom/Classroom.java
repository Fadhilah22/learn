
public class Classroom{
	char building; 
	int floor;
	int id;
	String name;

	public Classroom(char building, int floor, int id){
		this.building = building;
		this.floor = floor;
		this.id = id;
		this.name = "" + this.building + this.floor + this.id;
	}

	public static void main(String[] args) {

	}
} 
