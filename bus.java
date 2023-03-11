import java.util.*;
import java.lang.*;
import java.io.*;

class bus

{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                        WELCOME ");
        System.out.println("                    U && U TRANSPORTS");
        System.out.println("");
        boolean f=true;
        while(f)
        {
            System.out.println("");
            System.out.println(" MENU ");
            System.out.println(" 1 : see menu");
            System.out.println(" 2 : book tickets");
            System.out.println(" 3 : leave");
            int choice = sc.nextInt();
            if(choice == 1)
            {
                System.out.println("                        Here are you bus list");
                System.out.println(" BUS. No   | PICK UP        |   ARRIVAL TIME    |     DESTINATION STATION  |    DROP TIME    |   FARE FOR WINDOW SEAT   |  FARE FOE NORMAL SEAT");
                System.out.println(" 12344     |   GORAKHPUR    |   09:00           |     KANPUR               |    15;00        |   1000                   |  900");
                System.out.println(" 02321     |   GORAKHPUR    |   10:00           |     KANPUR               |    16:00        |   950                    |  850");
                System.out.println(" 12112     |   GORAKHPUR    |   11:00           |     KANPUR               |    17:00        |   790                    |  690");
                System.out.println(" 08443     |   GORAKHPUR    |   12:00           |     KANPUR               |    18:00        |   900                    |  800");
                System.out.println(" 03233     |   GORAKHPUR    |   13:00           |     KANPUR               |    19:00        |   1090                   |  990");
                System.out.println(" 63843     |   GORAKHPUR    |   14:00           |     KANPUR               |    20:00        |   800                    |  700");
                System.out.println(" 28383     |   GORAKHPUR    |   15:00           |     KANPUR               |    21:00        |   890                    |  790");
                System.out.println(" 93949     |   GORAKHPUR    |   09:30           |     DELHI                |    21:30        |   910                    |  810");
                System.out.println(" 82823     |   GORAKHPUR    |   10:30           |     DELHI                |    22:30        |   900                    |  800");
                System.out.println(" 28383     |   GORAKHPUR    |   11:30           |     DELHI                |    23:30        |   1010                   |  910");
                System.out.println(" 38383     |   GORAKHPUR    |   12:30           |     DELHI                |    00:30        |   1020                   |  920");
                System.out.println(" 21204     |   GORAKHPUR    |   13:30           |     DELHI                |    01:30        |   920                    |  820");
                System.out.println(" 10293     |   GORAKHPUR    |   14:30           |     DELHI                |    02:30        |   622                    |  522");
            }
            else if(choice == 2)
            {
                System.out.println("Enter your bus serial no : ");
                int bus_no = sc.nextInt();
                int bus_row[] = {10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 18, 19 , 20 , 21 , 22};
                int bus_column[] = {7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7};
                int bus_rate_normal[] = {900 , 850 , 690 , 800 , 990 , 700 , 790 , 810 , 800 , 910 , 920 , 820 , 522};
                int bus_rate_windows[] = {1000 , 950 , 790 , 900 , 1090 , 800 , 890 , 910 , 900 , 1010 , 1020 , 920 , 622};
                int n = bus_row[bus_no-1];
                int l = bus_column[bus_no-1];
                int total_seats = (n-1)*5+l;
                int seat_matrix[][] = new int[(n-1)][5];
                int lseat_martix[] = new int[l];
                int cost = 0;
                System.out.println("no of persons : ");
                int no_of_person = sc.nextInt();
                while(no_of_person!=0)
                {
                    System.out.println("Number of Seats Availible : " + total_seats);
                    System.out.println("Number of person left : " + no_of_person);
                    System.out.println("Enter seat no : ");
                    String str=sc.next();
                    int seat_row = str.charAt(0)-65;
                    int seat_column = str.charAt(1)-49;
                    if(seat_row > n-1 || ( seat_column > 4 && seat_row < n-1) || (seat_column > l-1 && seat_row == n-1) )
                    {
                        System.out.println("Invalid Seat");
                        continue;
                    }
                    
                    if(seat_row==(n-1))
                    {
                        if(lseat_martix[seat_column]==0)
                        {
                            lseat_martix[seat_column] = 1;
                            total_seats = total_seats - 1;
                            no_of_person -= 1;
                            if( seat_column==0 || seat_column==l-1)
                                cost += bus_rate_windows[bus_no-1];
                            else
                                cost += bus_rate_normal[bus_no-1];
                            
                        }
                        else
                        {
                            System.out.println("The Seat is BOOKED !!!");
                            continue;
                        }
                    }
                    else
                    {
                        if(seat_matrix[seat_row][seat_column]==0)
                        {
                            seat_matrix[seat_row][seat_column] = 1;
                            total_seats = total_seats - 1;
                            no_of_person -= 1;
                            if( seat_column==0 || seat_column==4)
                                cost += bus_rate_windows[bus_no-1];
                            else
                                cost += bus_rate_normal[bus_no-1];
                        }
                        else
                        {
                            System.out.println("The Seat is BOOKED !!!");
                            continue;
                        }
                        
                    }
                }
                System.out.println("YOUR COST IS : " + cost);
            }
           
            else
            {
                System.out.println(" bye bye !!");
                f=false;
            }
        }
    }
}


