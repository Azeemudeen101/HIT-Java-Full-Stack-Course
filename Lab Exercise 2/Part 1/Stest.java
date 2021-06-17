package labwork2;

class Student{
    String name,city;
    int age;
    static int m;
    public void printData(){
        System.out.println("Student Name: "+name);
        System.out.println("Student Name: "+city);
        System.out.println("Student Name: "+age);
    }
}
public class Stest{
    public static void main(String[] args) {
        Student s1=new Student();
        Student s2=new Student();
        s1.name="Mega";
        s1.city="Chennai";
        s1.age=28;      
        s2.name="Akash";
        s2.city="Kovai";
        s2.age=24;
        s1.printData();
        s2.printData();
        s1.m=10;
        s2.m=20;
        Student.m=30;
        System.out.println("s1 m is..."+s1.m);
        System.out.println("s2 m is..."+s2.m);
        System.out.println("Student m is..."+Student.m);
    }
}