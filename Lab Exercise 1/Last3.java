import java.util.Scanner;

public class Last3{

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        //16.Factorial of a Number
        System.out.println("Enter the number: ");
        int num=scan.nextInt();
        int factorial =fact(num);
        System.out.println("Factorial of the number: "+factorial);

        //Find Leap year

        int year;
        System.out.print("Enter year: ");
        year= scan.nextInt();
        boolean isLeap = false;
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if(year % 400 == 0)
                    isLeap =true;
                else
                    isLeap =false;
            }
            else
                isLeap = true;
        }
        else
        {
            isLeap = false;
        }
        if(isLeap)
        {
            System.out.println(year + " is a Leap Year");
        }
        else
        {
            System.out.println(year + " is not a Leap Year");
        }


        

        //Calculator using switch
        char operator;
        double number1, number2, result;
        System.out.println("Enter the Operator: + - / * ");
        operator=scan.next().charAt(0);
        System.out.println("Enter the first number: ");
        number1= scan.nextDouble();
        System.out.println("Enter the second number: ");
        number2=scan.nextDouble();

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println(number1+"+"+number2+" = "+result); 
                break;
            case '-':
                result = number1 - number2;
                System.out.println(number1+"-"+number2+" = "+result); 
                break;
            case '*':
                result = number1 * number2;
                System.out.println(number1+"*"+number2+" = "+result); 
                break;
            case '/':
                result = number1 / number2;
                System.out.println(number1+"/"+number2+" = "+result); 
                break;                                        
            default:
                System.out.println("invlaid Operator!"); 
                break;
        }

        scan.close();

    }

    static int fact(int n)
        {
            int output;
            if(n==1){
                return 1;
            }
            output = fact(n-1)*n;
            return output;
        }
          
    
}