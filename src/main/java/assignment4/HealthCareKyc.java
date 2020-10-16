package assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HealthCareKyc {
    final static String format="dd-MM-yyyy";
    public void anniversary(String signupDate, String today){
        String currDate = signupDate.substring(0,6)+today.substring(6);
        LocalDate dateNew = LocalDate.parse(currDate, DateTimeFormatter.ofPattern(format));
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern(format));

        String startRange = dateNew.minusDays(30).format(DateTimeFormatter.ofPattern(format));
        String endRange = dateNew.plusDays(30).format(DateTimeFormatter.ofPattern(format));

        String signupYear = signupDate.substring(6,10);
        String currYear = today.substring(6,10);

        if(Integer.parseInt(signupYear)>= Integer.parseInt(currYear)){
            System.out.println("No range");
        }
        else{
            System.out.print(startRange);
            System.out.println();
            if(todayDate.compareTo(dateNew.plusDays(30))>=0){
                System.out.println(endRange);
            }
            else{
                System.out.println(today);
            }
        }
    }
    public static void main(String[] args){
        HealthCareKyc kyc = new HealthCareKyc();
        Scanner sc =new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            String arr[]=s.split(" ");
            //System.out.println(Arrays.toString(arr));
            String signupDate = arr[0];
            String currDate = arr[1];
            kyc.anniversary(signupDate,currDate);
        }

    }
}
