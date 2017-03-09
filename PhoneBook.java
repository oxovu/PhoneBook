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

    void addNumber(Name name, PhoneNumber number) {
        List<PhoneNumber> newNumbers = new ArrayList<PhoneNumber>() {
            {
                for (PhoneNumber n : book.get(name)) add(n);
                add(number);
            }
        };
        book.remove(name);
        book.put(name, newNumbers);
    }

    void removeNumber(Name name, PhoneNumber number) {
        List<PhoneNumber> newNumbers = new ArrayList<PhoneNumber>() {
            {
                for (PhoneNumber n : book.get(name)) if (!n.equals(number)) add(n);
            }
        };
        book.remove(name);
        book.put(name, newNumbers);
    }


    List<PhoneNumber> findNumbers(Name name) {
        return book.get(name);
    }

    Name findName(PhoneNumber number) {
        for (Map.Entry<Name, List<PhoneNumber>> entry : book.entrySet()) {
            if (entry.getValue().contains(number)) return entry.getKey();
        }
        return null;
    }
}


