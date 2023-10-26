

public class Teacher{
	String name;
	Integer age;
	
	public Teacher(String name, int age){
		this.name = name;
		this.age = new Integer(age);
	}
	public void showInfo(){
		System.out.println("Name : " + this.name);
		System.out.println("Age  : " + this.age);
	}

	public static void main(String[] args) {
		
	}
}
