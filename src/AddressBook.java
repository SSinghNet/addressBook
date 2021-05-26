import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class AddressBook {
    private ArrayList<Contact> Contacts;
    private Scanner scan;

    public AddressBook(ArrayList<Contact> Contacts) {
        setContacts(Contacts);
        scan = new Scanner(in);
    }

    public AddressBook() {
        this(new ArrayList<Contact>());
    }

    public void run() {
        int option = -1;
        while(option != 7){
            option = menu();
            switch (option) {
                case 1:
                    printBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    addPerson();
                    break;
                case 4:
                    removePerson();
                    break;
                case 5:
                    editPerson();
                    break;
                case 6:
                    callPerson();
                    break;
                case 7:
                    out.println("\nBye!");
                    break;
                default:
                    out.println("\nInvalid Option.\n");
                    break;
            }

        }
    }

    public int menu() {
        out.println("\n1. List Contacts\n2. Search\n3. Add Contact\n4. Remove Contact\n5. Edit Contact\n6. Call Contact\n7. Quit\n");
        return scan.nextInt();
    }
    
    public void printBook() {
        out.println();
        for (Contact c : Contacts) {
            out.println(c);
        }
    }

    public void searchBook() {

        out.println(
                "\nWhat do you want to search by?\n1. First Name\n2. Last Name\n3. Phone Number\n4. Address\n5. Alternative Address\n6. Quit\n");
        int input = scan.nextInt();
        scan.nextLine();
        out.println("\nQuery:");
        String query = scan.nextLine();
        out.println("Results: ");
        switch (input) {
            case 1:
                for (Contact c : Contacts){
                    if(c.getFirstName().equals(query)){
                        out.println(c);
                    }
                }
                break;
            case 2:
                for (Contact c : Contacts){
                    if(c.getLastName().equals(query)){
                        out.println(c);
                    }
                }
                break;
            case 3:
                for (Contact c : Contacts){
                    if(c.getPhoneNumber().equals(query)){
                        out.println(c);
                    }
                }
                break;
            case 4:
                for (Contact c : Contacts){
                    if(c.getAddress().equals(query)){
                        out.println(c);
                    }
                }
                break;
            case 5:
                for (Contact c : Contacts){
                    if(c.getAltAddress().equals(query)){
                        out.println(c);
                    }
                }
                break;
            case 6:
                break;
            default:
                out.println("Invalid Option");
        }

        out.println();

    }

    public void addPerson() {
        scan.nextLine();
        out.println("\nEnter contacts info:");
        out.println("\nFirst Name: ");
        String firstName = scan.nextLine();
        out.println("\nLast Name: ");
        String lastName = scan.nextLine();
        out.println("\nPhone Number: ");
        String phoneNumber = scan.nextLine();
        out.println("\nAddress: ");
        String address = scan.nextLine();
        out.println("\nAlternative Address: ");
        String altAddress = scan.nextLine();

        Contacts.add(new Contact(firstName, lastName, phoneNumber, address, altAddress));
    }
    
    public void removePerson(){
        printBook();
        out.println("Enter the id of the contact to delete: ");
        int id = scan.nextInt();
        boolean found = false;
        for (int i = 0; i < Contacts.size(); i++) {
            if (Contacts.get(i).getIdNum() == id) {
                Contacts.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            out.println("No Contact with id " + id + " was found. No contact was deleted.");
        }else{
            out.println("Contact " + id + " was deleted");
        }
    }
    
    public void editPerson() {
        printBook();
        out.println("Enter the id of the contact to edit: ");
        int id = scan.nextInt();
        boolean found = false;
        for (int i = 0; i < Contacts.size(); i++) {
            if (Contacts.get(i).getIdNum() == id) {
                found = true;
                int input = -1;
                while (input != 6) {
                    out.println(
                            "\nWhat do you want to edit?\n1. First Name\n2. Last Name\n3. Phone Number\n4. Address\n5. Alternative Address\n6. Stop Editing\n");
                    input = scan.nextInt();
                    scan.nextLine();
                    switch (input) {
                        case 1:
                            out.println("\nEnter new first name: ");
                            Contacts.get(i).setFirstName(scan.nextLine());
                            break;
                        case 2:
                            out.println("\nEnter new last name: ");
                            Contacts.get(i).setLastName(scan.nextLine());
                            break;
                        case 3:
                            out.println("\nEnter new phone number: ");
                            Contacts.get(i).setPhoneNumber(scan.nextLine());
                            break;
                        case 4:
                            out.println("\nEnter new address: ");
                            Contacts.get(i).setAddress(scan.nextLine());
                            break;
                        case 5:
                            out.println("\nEnter new alternative address: ");
                            Contacts.get(i).setAltAddress(scan.nextLine());
                            break;
                        case 6:
                            break;
                        default:
                            out.println("Invalid Option");
                    }
                    out.println();
                }
            }
        }
        if (!found) {
            out.println("No contact found with id " + id);
        }
    }
    
    public void callPerson() {
        printBook();
        out.println("Enter the id of the contact to call: ");
        int id = scan.nextInt();
        boolean found = false;
        for (int i = 0; i < Contacts.size(); i++) {
            if (Contacts.get(i).getIdNum() == id) {
                found = true;
                String pn = Contacts.get(i).getPhoneNumber();
                int count = pn.length() / 2;
                out.println(("\n|" + "-".repeat(30) + "|") + ("\n|" + " ".repeat(30) + "|").repeat(5)
                        + ("\n|" + " ".repeat(10) + "CALLING..." + " ".repeat(10) + "|").repeat(1)
                        + ("\n|" + " ".repeat(30) + "|").repeat(5)
                        + ("\n|" + " ".repeat(15 - count) + pn + " ".repeat(15 - count) + "|").repeat(1)
                        + ("\n|" + " ".repeat(30) + "|").repeat(5) + ("\n|" + "_".repeat(30) + "|"));
                break;
            }
        }
        if (!found) {
            out.println("Contact with id " + id + " was not found.");
        }
    }
    
    public ArrayList<Contact> getContacts() {
        return this.Contacts;
    }

    public void setContacts(ArrayList<Contact> Contacts) {
        this.Contacts = Contacts;
    }

    public Scanner getScan() {
        return this.scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

}
