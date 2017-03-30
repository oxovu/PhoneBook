package MyClass;

import java.util.*;

public final class PhoneBook {

    private Map<Name, List<PhoneNumber>> book = new HashMap<>();

    public void addContact(Name name, List<PhoneNumber> numbers) {
        final List<PhoneNumber> outNumbers = numbers;
        if (name == null) throw new IllegalArgumentException();
        if (numbers == null) throw new IllegalArgumentException();
        List<PhoneNumber> curNumbers = book.get(name);
        if (curNumbers == null) {
            book.put(name, outNumbers);
        } else {
            for (PhoneNumber number : outNumbers) addNumber(name, number);
        }
    }

    public void removeContact(Name name) {
        book.remove(name);
    }

    public boolean contains(Name name, List<PhoneNumber> numbers) {
        List<PhoneNumber> contNumbers = book.get(name);
        if (contNumbers == null || !contNumbers.equals(numbers)) {
            return false;
        } else {
            return true;
        }
    }

    public void addNumber(Name name, PhoneNumber number) {
        final List<PhoneNumber> numbers = new ArrayList(book.get(name));
        if (numbers == null) throw new IllegalArgumentException();
        if (!numbers.contains(number)) numbers.add(number);
        book.put(name, numbers);
    }

    public void removeNumber(Name name, PhoneNumber number) {
        List<PhoneNumber> numbers = book.get(name);
        if (numbers == null) throw new IllegalArgumentException();
        for (Iterator iter = numbers.iterator(); iter.hasNext(); ) {
            if (number.equals(iter.next())) iter.remove();
        }
    }


    public List<PhoneNumber> findNumbers(Name name) {
        List<PhoneNumber> numbers = book.get(name);
        if (numbers == null) throw new IllegalArgumentException();
        return numbers;
    }

    public List<Name> findName(PhoneNumber number) {
        List<Name> names = new ArrayList();
        for (Map.Entry<Name, List<PhoneNumber>> entry : book.entrySet()) {
            if (entry.getValue().contains(number)) names.add(entry.getKey());
        }
        return names;
    }
}


