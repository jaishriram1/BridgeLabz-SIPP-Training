import java.util.*;
public class code1{
    public static void main(String[] args) {
        int r= 7378;
        double c= 1.33;
        double pi= 3.14;
        long cube= (long)r*r*r;
        double volumeKM= c*pi*cube;
        double volumeMiles= volumeKM * 0.621;;
System.out.println("The volume of Earth in cubic kilometers is "+ volumeKM + "and cubic miles is " + volumeMiles);
    }
}