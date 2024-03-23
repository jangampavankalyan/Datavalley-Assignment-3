class Customer implements Serializable {
    private static final long serialVersionUID = 1L; 
    private int id;
    private String name;
    private String contactNo;
    private String address;

   
    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }
}


public class SerializationExample {
    public static void main(String[] args) {
        
        Customer customer = new Customer(101, "John Doe", "1234567890", "123 Main St");

        
        try {
            FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(customer);
            objectOut.close();
            fileOut.close();
            System.out.println("Customer object has been serialized and saved to JavaObject.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        try {
            FileInputStream fileIn = new FileInputStream("JavaObject.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Customer deserializedCustomer = (Customer) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Customer object has been deserialized from JavaObject.txt:");
            System.out.println("ID: " + deserializedCustomer.getId());
            System.out.println("Name: " + deserializedCustomer.getName());
            System.out.println("Contact No: " + deserializedCustomer.getContactNo());
            System.out.println("Address: " + deserializedCustomer.getAddress());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
