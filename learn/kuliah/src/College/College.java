import java.util.ArrayList;

class College{
	public String name;
	public ArrayList<Classroom> classrooms;
	
	public College(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
		
	public static void main(String[] args) {
		College college1 = new College("Bina Nusantara University");
		Teacher teacher1 = new Teacher("Henry Lucky", 25);
		teacher1.showInfo(); 
	}
}
