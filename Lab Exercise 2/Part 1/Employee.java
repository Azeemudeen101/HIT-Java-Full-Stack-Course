package labwork2;

public class Employee {
	int empId;
	String empName;
	public Employee(int id, String name){
		this.empId=id;
		this.empName=name;		
	}
	void info() {
		System.out.println("Employee ID: "+empId+" Employee Name: "+empName);			
	}
	public static void main(String[] args) {
		Employee obj1=new Employee(2020,"Jain");
		Employee obj2=new Employee(2021,"Hiren");
		obj1.info();
		obj2.info();
		
	}

}
