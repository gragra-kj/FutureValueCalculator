import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int pmt=0;
        float rate=0;
        int period=0;
        System.out.println("Future Value Calculator");
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.print("Periodic Monthly Payments: ");
            pmt=scanner.nextInt();
            if (pmt >=10000 && pmt <=1000000)
                break;
            System.out.println("Enter a number between 10000 and 1000000");
        }
        while (true){
            System.out.print("Annual interest Rate: ");
            rate=scanner.nextFloat();
            if (rate >= 0 && rate <=30) {

                break;
            }
            System.out.println("Enter a value between 0 and 70");
        }
        while (true){
            System.out.print("Number of Years/Period: ");
            period= scanner.nextInt();
            if (period >=1 && period<=30){

                break;

            }
            System.out.println("Enter a value between 1 and 30");

        }
        double futureValue=calculateFv(pmt,rate,period);
        String formatedFureValue= NumberFormat.getCurrencyInstance().format(futureValue);
        System.out.println("Future Value: " +formatedFureValue);
    }
    public static double calculateFv(int pmt,float rate,int period){
        final byte MONTH=12;
        final byte PERCENT=100;
        float monthlyRate=rate / MONTH /PERCENT;
        int periodInMonths=period * MONTH;
        double futureValue=pmt*((Math.pow(1+monthlyRate,periodInMonths)-1)/(monthlyRate));
        return futureValue;



    }

}