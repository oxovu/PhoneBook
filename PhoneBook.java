package MyClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class PhoneBook {

    private Map<Name, PhoneNumber> book = new HashMap<>();


    void put(Name name, PhoneNumber number){
        book.put(name, number);
    }


    private Name toName(String n) {
        return new Name(n);
    }

    private PhoneNumber toPhoneNumber(String n) {
        return new PhoneNumber(n);
    }

    void addContact(String name, String numbers) {
        String[] number = numbers.split(", ");
        for (String n : number) {
            book.put(toName(name), toPhoneNumber(n));
        }
    }

    public void removeContact(String name) {
        book.remove(toName(name));
    }

    public void addNumber(String name, String number) {
        book.put(toName(name), toPhoneNumber(number));
    }

    public void removeNumber(String name, String number) {
        book.remove(toName(name), toPhoneNumber(number));
    }

    String findNumber(String name) {
        return book.get(toName(name)).toString();
    }

    public String findName(String number) {
        for (Map.Entry<Name, PhoneNumber> entry : book.entrySet()) {
            if (entry.getValue().toString().equals(number)) return entry.getKey().toString();
        }
        return "не найдено";
    }

    @Override
    public int hashCode() {
        return book.hashCode();
    }

    @Override
    public String toString() {
        return book.toString();
    }
}


