package MyClass;

import java.util.*;

public final class PhoneBook {

    private Map<Name, List<PhoneNumber>> book = new HashMap<>();

    public void addContact(Name name, List<PhoneNumber> numbers) {
        if (!book.containsKey(name)) {
            if (!numbers.equals(null)) book.put(name, numbers);
        } else {
            for (PhoneNumber number:numbers) addNumber(name, number);
        }
    }

    public void removeContact(Name name) {
        book.remove(name);
    }

    public boolean contains(Name name, List<PhoneNumber> numbers) {
        return book.containsKey(name) && book.get(name).equals(numbers);
    }

    public void addNumber(Name name, PhoneNumber number) {
        List<PhoneNumber> numbers = new ArrayList(book.get(name));
        if (!numbers.contains(number)) numbers.add(number);
        book.put(name, numbers);
    }

    public void removeNumber(Name name, PhoneNumber number) {
        List<PhoneNumber> numbers = book.get(name);
        for (Iterator iter = numbers.iterator(); iter.hasNext(); ) {
            if (number.equals(iter.next())) iter.remove();
        }
    }


    public List<PhoneNumber> findNumbers(Name name) {
        List<PhoneNumber> numbers = new ArrayList();
        numbers.addAll(book.get(name));
        return numbers;
    }

    public List<Name> findName(PhoneNumber number) {
        List<Name> names = new ArrayList<Name>();
        for (Map.Entry<Name, List<PhoneNumber>> entry : book.entrySet()) {
            if (entry.getValue().contains(number)) names.add(entry.getKey());
        }
        return names;
    }
}


