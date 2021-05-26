public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String altAddress;
    private int idNum;
    private static int idCount = 0;

    public Contact() {
        this(null, null, null, null, null);
    }

    public Contact(String firstName, String lastName, String phoneNumber, String address, String altAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.altAddress = altAddress;
        idNum = ++idCount;
    }

    public String toString() {
        return idNum + " - " + firstName + " " + lastName + "\n\tPhone Number: " + phoneNumber + "\n\tAddress: " + address + "\n\tAlternative Address: " + altAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAltAddress() {
        return this.altAddress;
    }

    public void setAltAddress(String altAddress) {
        this.altAddress = altAddress;
    }

    public int getIdNum() {
        return this.idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }



}
