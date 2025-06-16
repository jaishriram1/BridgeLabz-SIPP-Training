import java.util.Scanner;

public class code6 {
    public static void main(String[] args){
Scanner sc= new Scanner(System.in);
double principle= sc.nextDouble();
double rate= sc.nextDouble();
double time= sc.nextDouble();
double SI= principle*rate*time*0.01;
System.out.print(SI);
}
}
