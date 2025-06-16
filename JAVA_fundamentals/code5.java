import java.util.Scanner;
public class code5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int StudentFees= sc.nextInt();
        float discount=sc.nextInt();
        float finalFees= StudentFees - (StudentFees * discount / 100);
        System.out.println("The discount amount is INR" + discount+ "and final discounted fees is INR" + finalFees);
        
    }
}
