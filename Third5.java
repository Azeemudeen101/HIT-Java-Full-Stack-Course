import java.util.Scanner;
public class Third5{
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);
        
        //11.Check Prime Number
        int temp;
        boolean isPrime=true;
        System.out.print("Enter Number: ");
        int num=scan.nextInt();
        for(int i=2;i<=num/2;i++)
        {
            temp=num%i;
            if(temp==0)
            {
                isPrime=false;
                break;
            }
        }
        if(isPrime){
            System.out.println(num+" is a Prime Number");
        }
        else{
            System.out.println(num+" is not a Prime Number");
        }

        //12.Area of a Rectangle     
        System.out.print("\nEnter length of Rectangle: ");
        double length =scan.nextDouble();
        System.out.print("Enter width of Rectangle: ");
        double width=scan.nextDouble();
        double areaR = length*width;
        System.out.println("Area of Rectangle: "+areaR);

        //13.Area of a Square
        System.out.print("\nEnter Side of a Square: ");
        double side=scan.nextDouble();
        double areaS = side*side;
        System.out.println("Area of Rectangle: "+areaS);

        //14.Area of a Triangle
        System.out.print("\nEnter width of Triangle: ");
        double base =scan.nextDouble();
        System.out.print("Enter height of Rectangle: ");
        double height=scan.nextDouble();
        double areaT = base*height;
        System.out.println("Area of Rectangle: "+areaT);

        //15.Area of a circle
        System.out.print("\nEnter circle radius: ");
        double radius =scan.nextDouble();
        double areaC = Math.PI*(radius*radius);
        System.out.println("Area of Circle: "+areaC);
        double circumference= Math.PI *2*radius;
        System.out.println("The Circumference of the Circle: "+circumference);
        scan.close();

    }
}