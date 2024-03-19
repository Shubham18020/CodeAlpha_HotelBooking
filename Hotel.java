import java.util.Scanner;

public class Hotel {
    private int totalRooms = 50, availableRooms = 50, price = 12000, bookedRooms = 0, x = 0;
    String name;

    // Hotel Welcome
    Hotel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t_________________Welcome to our Hotel Service_______________");
        System.out.print("\tWhat is your name sir/madam: ");
        name = sc.nextLine();
        System.out.println("\tHello " + name + ".");
    }

    // to book room or rooms
    boolean bookRoom(int room) {
        if (room == 0) {
            System.out.println("\tNo Rooms available !");
        } else if (room <= availableRooms) {
            x = room;
            availableRooms -= room;
            bookedRooms += room;
            return true;
        }
        return false;
    }

    void reverseBooking(int room) {
        availableRooms += room;
        bookedRooms += room;
    }

    // billing information
    void billing() {
        System.out.println("\t\t\t________________Bill_______________");
        System.out.println("\t\t\tBooking for " + x + " rooms");
        System.out.println("\t\t\tAmount payable: " + price + " * " + x + " : " + (price * x));
        System.out.println("\t\t\t___________________________________");
    }

    // hotel details
    void hotelDetails() {
        System.out.println("\t____________________Hotel Details_____________________");
        System.out.println("\tAvailable Rooms: " + availableRooms());
        System.out.println("\tPrice of a room: " + price);
    }

    // to get information about available rooms
    int availableRooms() {
        return availableRooms;
    }
}

class Menus extends Hotel {
    Scanner scm = new Scanner(System.in);
    String strComm;
    int intComm;

    void inputStr() {
        System.out.print(">>> ");
        strComm = scm.nextLine();
        scm.reset();
    }

    void inputInt() {
        System.out.print(">>> ");
        intComm = scm.nextInt();
        scm.reset();
    }

    Menus() {
        System.out.println("\toptions available......");
        System.out.println("\tdetails\t\tbookRoom\t\texit");
        while (true) {
            inputStr();
            if (strComm.equalsIgnoreCase("details") || strComm.equalsIgnoreCase("details ")) {
                hotelDetails();
            } else if (strComm.equalsIgnoreCase("exit") || strComm.equalsIgnoreCase("exit ")) {
                System.out.println("Thank you !!");
                break;
            } else if (strComm.equalsIgnoreCase("bookRoom") || strComm.equalsIgnoreCase("bookRoom ")) {
                System.out.println("\tNumber of rooms to book: ");
                inputInt();
                Boolean x = bookRoom(intComm);
                if (x) {
                    billing();
                    System.out.print("\tsure want to book: ");
                    inputStr();
                    if (strComm.equalsIgnoreCase("yes") || strComm.equalsIgnoreCase("yes ")) {
                        System.out.println("bill");
                        billing();
                    } else if (strComm.equalsIgnoreCase("no") || strComm.equalsIgnoreCase("no ")) {
                        reverseBooking(intComm);
                        System.out.println("booking canceled !");
                    }
                } else {
                    System.out.println("\tSorry! Only " + availableRooms() + " rooms are available.");
                }
            }
        }
    }
}

class Head {
    public static void main(String args[]) {
        Menus m = new Menus();
    }
}