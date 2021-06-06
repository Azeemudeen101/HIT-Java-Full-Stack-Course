public class First5{
    public static void main(String[] args){
    //1.Add Two Numbers
    int a=13;
    int b=4;
    System.out.println("Add: "+(a+b));

    //2.Find Quotient and Remainder

    int quotient=a/b;
    int remainder=a%b;
    System.out.println("Q:"+quotient+" R:"+remainder);

    //3. Swapping two numbers
    System.out.println("Swap 1");
    System.out.println("a value is "+a);
    System.out.println("b value is "+b);
    int temp =a;
    a=b;
    b=temp;
    System.out.println("a value is "+a);
    System.out.println("b value is "+b);

    //4. Swapping without temp
    System.out.println("Swap 2");
    System.out.println("a value is "+a);
    System.out.println("b value is "+b);
    a= a-b;
    b= a+b;
    a= b-a;
    System.out.println("a value is "+a);
    System.out.println("b value is "+b);

    //5.Check Even or Odd
    if((a%2)==0){
        System.out.println("A is Even Number =>"+a);
    }
    else{
        System.out.println("A is Odd Number =>"+a);
    }

    }
    
}