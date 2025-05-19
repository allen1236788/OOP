// A) This is a Solo or Pair activity
// B) Write your name(s) in 1/8 crosswise
// C) You can open previous sample program
// D) Use of internet is strictly prohibited (Violaton = ZERO)
// E) Hands-on quiz duration = 90 minutes (Time is UP - Everyone should stay outside the lab)

// 1) Play the video (OutputFlow.mp4)
// 2) Analyze the program that implements abstract class (HotelRoom - StandardRoom, DeluxeRoom, SuiteRoom)
// 3) In reference to the video, construct your source program here...
// 4) Use the sample inputs sequentially from the video when you test your program
// 5) Every correct output is equivalent to 4 pts

// ONE TIME CHECKING ONLY
// YOU CAN ASK FOR CHECKING EVEN IF TIME DURATION IS NOT OVER
// "UNNECESSARY NOISE" WOULD MEAN -5 pts PER OCCURENCE
// INTERACTION WITH OTHER PAIR = ZERO

import java.util.Scanner;

public class HotelManagementApp1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double totalPrice = 0;
        int[] nightsBooked = new int[HotelRoom.rooms.length]; 
while (true)
        {while (true) {
            System.out.println("\nAvailable Rooms:");
            displayRooms();
            System.out.println("\n--- Main Menu ---");
            System.out.println("1 - Book Room");
            System.out.println("2 - Cancel Booking");
            System.out.println("3 - Proceed to Payment");
            System.out.print("Choose an option: ");
            String menuChoice = scanner.nextLine();

            if (menuChoice.equals("1")) {
                int roomIndex = -1;
                while (true){
                    System.out.print("\nEnter Room Number to book: ");
                    String roomToBook = scanner.nextLine();
                    roomIndex = -1;
                    for (int i = 0; i < HotelRoom.rooms.length; i++){
                        if (HotelRoom.rooms[i].roomNumber.equals(roomToBook)){
                            roomIndex = i;
                            break;
                        }
                    }
                    if (roomIndex == -1){
                        System.out.println("Invalid room number. Please try again.");
                        continue;
                    }
                    if (!HotelRoom.rooms[roomIndex].isAvailable){
                        System.out.println("Sorry, Room " + HotelRoom.rooms[roomIndex].roomNumber + " is not available. Please choose another room.");
                        continue;
                    }
                    break;
                }
                System.out.print("\nEnter number of nights: ");
                int nights = scanner.nextInt();
                nightsBooked[roomIndex] = nights; 
                boolean isMember = false;
                while (true){
                    System.out.print("Are you a member? (T/F): ");
                    String memberInput = scanner.next().toUpperCase();
                    if (memberInput.equals("T")){
                        isMember = true;
                        break;
                    } else if (memberInput.equals("F")){
                        isMember = false;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter either 'T' (for true) or 'F' (for false).");
                    }
                }
                double price = HotelRoom.rooms[roomIndex].calculatePrice(nights, isMember);
                System.out.println("Total Price for " + nights + " night(s): " + price);
                totalPrice += price;
                HotelRoom.rooms[roomIndex].bookRoom(roomIndex); 
                scanner.nextLine(); 
            } else if (menuChoice.equals("2")) {
                while (true) {
                    System.out.print("\nEnter room number to cancel: ");
                    String cancelRoom = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < HotelRoom.rooms.length; i++) {
                        if (HotelRoom.rooms[i].roomNumber.equals(cancelRoom)) {
                            found = true;
                            if (!HotelRoom.rooms[i].isAvailable) {
                                int nights = nightsBooked[i];
                                if (nights == 0) nights = 1; 
                                double refund = HotelRoom.rooms[i].ratePerNight * nights;
                                totalPrice -= refund;
                                HotelRoom.rooms[i].isAvailable = true;
                                nightsBooked[i] = 0; 
                                System.out.println("Room " + cancelRoom + " successfully cancelled!");
                                break;
                            } else {
                                System.out.println("Room " + cancelRoom + " is not currently booked. Please enter a valid booked room number.");
                                break;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid room number. Please try again.");
                    } else {
                        boolean cancelled = false;
                        for (int i = 0; i < HotelRoom.rooms.length; i++) {
                            if (HotelRoom.rooms[i].roomNumber.equals(cancelRoom) && HotelRoom.rooms[i].isAvailable) {
                                cancelled = true;
                                break;
                            }
                        }
                        if (cancelled) break;
                    }
                }
            } else if (menuChoice.equals("3")) {
                if(totalPrice==0){
                        System.out.println("No records to be paid!");
                       
                    }else{
                System.out.println("\nTotal amount for all bookings: " + totalPrice);
                double payment = 0;
                while (true) {
                    System.out.print("Enter amount to pay: ");
                    try {
                        payment = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        continue;
                    }
                    if (payment < totalPrice) {
                        System.out.println("Insufficient payment. Please pay the full amount.");
                    } else {
                        break;
                    }
                }
                for (int i = 0; i < HotelRoom.rooms.length; i++) {
                    if (!HotelRoom.rooms[i].isAvailable) {
                        HotelRoom.rooms[i].isAvailable = true;
                    }
                }
                System.out.println("Payment successful! All rooms are now available for booking.");
                totalPrice=0;
                break;
            }
            } else {
                System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
        
    }}

    private static void displayRooms(){
        for (int i = 0; i < HotelRoom.rooms.length; i++){
            if (HotelRoom.rooms[i].isAvailable){
                System.out.println(HotelRoom.rooms[i]);
            } else {
                System.out.println(HotelRoom.rooms[i] + " | Status: Not Available");
            }
        }
    }
}