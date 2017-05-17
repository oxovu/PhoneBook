package MyClass;

import java.util.*;

public final class PhoneBook {

    private Map<Name, List<PhoneNumber>> book = new HashMap<>();

    public void PhoneBook(Map<Name, List<PhoneNumber>> book){
        this.book = book;
    }

    public void addContact(Name name, List<PhoneNumber> numbers) {
        final List<PhoneNumber> outNumbers = numbers;
        if (name == null) throw new IllegalArgumentException("имя не существует");
        if (numbers == null) throw new IllegalArgumentException("список номеров не существует");
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

    public boolean contains(Name name) {
        if (book.get(name) != null) return true;
        else return false;
    }

    public void addNumber(Name name, PhoneNumber number) {
        final List<PhoneNumber> numbers = new ArrayList(book.get(name));
        if (numbers == null) throw new IllegalArgumentException("список номеров не существует");
        if (!numbers.contains(number)) numbers.add(number);
        book.put(name, numbers);
    }

    public void removeNumber(Name name, PhoneNumber number) {
        List<PhoneNumber> numbers = book.get(name);
        if (numbers == null) throw new IllegalArgumentException("список номеров не существует");
        for (Iterator iter = numbers.iterator(); iter.hasNext(); ) {
            if (number.equals(iter.next())) iter.remove();
        }
    }


    public List<PhoneNumber> findNumbers(Name name) {
        if (book.get(name) == null) throw new IllegalArgumentException("список номеров не существует");
        List<PhoneNumber> numbers = book.get(name);
        return numbers;
    }

    public List<Name> findName(PhoneNumber number) {
        List<Name> names = new ArrayList();
        for (Map.Entry<Name, List<PhoneNumber>> entry : book.entrySet()) {
            if (entry.getValue().contains(number)) names.add(entry.getKey());
        }
        return names;
    }

    @Override
    public String toString() {
        return String.valueOf(book);
    }

    @Override
    public int hashCode() {
        return book.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object instanceof PhoneBook) {
            final PhoneBook other = (PhoneBook) object;
            return this.book.equals(other.book);
        } else return false;
    }
}


