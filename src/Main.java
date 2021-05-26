import static java.lang.System.out;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Contact person = new Contact("John", "Doe", "11232453", "123 Pine Street, Budd Lake, NJ, USA", "3 Pine Street, Budd Lake, NJ, USA");
        Contact person2 = new Contact("John", "Doe", "11232453", "123 Pine Street, Budd Lake, NJ, USA",
                "3 Pine Street, Budd Lake, NJ, USA");
        ArrayList<Contact> c = new ArrayList<Contact>();
        c.add(person);
        c.add(person2);
        AddressBook book = new AddressBook(c);
        
        book.run();

    }
}
