import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


public class ContactBook {
	private final String filename = "contact.bin";
	private Map<String, Contact> contactBook = new HashMap<>();

	public void load() throws ContactBookException {
		try {
			contactBook = deserialize(filename);
		} catch (ClassNotFoundException | IOException e) {
			throw new ContactBookException(e.getMessage());
		}
	}

	public void save() throws ContactBookException {
		try {
			serialize("contact.bin", contactBook);
		} catch (IOException e) {
			throw new ContactBookException("Failed to save contact book. " + e.getMessage());
		}
	}

	public void addContact(String name, String address) {
		if (contactBook.containsKey(name)) {
			throw new IllegalArgumentException("Name already exists");
		}
		contactBook.put(name, new Contact(name, address));
	}

	public void addNumber(String name, String number, String description) {
		if (!contactBook.containsKey(name)) {
			throw new IllegalArgumentException("Name does not exist");
		}
		Contact contact = contactBook.get(name);
		contact.addPhoneEntry(new PhoneEntry(number, description));
	}

	public Contact findContact(String name) {
		return contactBook.get(name);
	}
	
	
	
	public static void serialize(String path, Object object) throws IOException{
		OutputStream fos = new FileOutputStream(path);
		try(ObjectOutputStream stream = new ObjectOutputStream(fos)){
			stream.writeObject(object);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String path) throws ClassNotFoundException, IOException{
		InputStream fis = new FileInputStream(path);
		try(ObjectInputStream stream = new ObjectInputStream(fis)){
			return (T) stream.readObject();
		}
	}


}