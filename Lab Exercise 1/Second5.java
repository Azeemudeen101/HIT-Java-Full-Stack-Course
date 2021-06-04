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
        























    }
}