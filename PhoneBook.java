package MyClass;

import java.util.*;

class PhoneBook {

    private Map<Name, List<PhoneNumber>> book = new HashMap<>();

    void addContact(Name name, List<PhoneNumber> numbers) {
        book.put(name, numbers);
    }

    void removeContact(Name name) {
        book.remove(name);
    }

    boolean contains(Name name, List<PhoneNumber> numbers) {
        return book.containsKey(name) && book.containsValue(numbers);
    }

    /*String findNumbers(Name name) {  // еще не отредактированные методы
        return book.get(name).toString();
    }

    public void addNumber(String name, String number) {
        book.put(toName(name), toPhoneNumber(number));
    }

    public void removeNumber(String name, String number) {
        book.remove(toName(name), toPhoneNumber(number));
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
    } */
}


