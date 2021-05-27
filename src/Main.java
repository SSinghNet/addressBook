import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Contact person = new Contact("John", "Doe", "11232453", "123 Main St, Word, NJ, USA", null);
        Contact person2 = new Contact("Jane", "Doe", "2326123", "123 Pine Street, Towm, NJ, USA",
                "3 Pine Street, Budd Lake, NJ, USA");
        Contact person3 = new Contact("Person", "Name", "7321513", null, "78 Main Street, Town, Sate, USA");
        ArrayList<Contact> c = new ArrayList<Contact>();
        c.add(person);
        c.add(person2);
        c.add(person3);
        AddressBook book = new AddressBook(c);
        
        book.run();

    }
}
