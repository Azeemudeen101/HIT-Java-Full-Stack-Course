import java.util.Scanner;

public class Second5{
    public static void main(String[] args){
        //7.Find LCM
        int n1=72, n2=120, lcm;
        lcm=(n1>n2)?n1:n2;
        while(true)
        {
            if(lcm % n1 == 0 && lcm % n2 ==0 ){
                System.out.printf("The LCM of %d and %d is %d\n", n1, n2, lcm);
                break;
            }
            ++lcm;
        }
        
        
        //8.Find Power of a Number
        int base = 3, exponent = 4;
        long result = 1;
        while (exponent != 0) {
            result *= base;
            --exponent;
            }                
        System.out.println("Answer = " + result);

        //9.Amstrong Number
        int number =371, orignalNumber, remainder;
        result=0;
        orignalNumber = number;
        while(orignalNumber != 0)
        {
            remainder= orignalNumber % 10;
            result += Math.pow(remainder, 3);
            orignalNumber /=10;
        }
        if(result == number)
        {
            System.out.println(number+" is an Armstrong number");
        }
        else
        {
            System.out.println(number+" is Not an Armstrong number");
        }

        //10.Reverse of a Number using while loop

        int num=0;
        int reversenum = 0;
        System.out.println("Enter your Number: " );
        Scanner input=new Scanner(System.in);
        num =input.nextInt();
        while(num!=0){
            reversenum = reversenum*10;
            reversenum = reversenum + num%10;
            num =num/10;
        }
        System.out.println("Reverse Number:"+reversenum);
        input.close();
        
    }
}