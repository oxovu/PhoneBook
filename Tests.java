package MyClass;

import org.junit.Test;
import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;

public class Tests {

    PhoneBook book = new PhoneBook();
    PhoneNumber number1 = new PhoneNumber("89277092265");
    PhoneNumber number2 = new PhoneNumber("+794773299");
    PhoneNumber number3 = new PhoneNumber("*101#");
    PhoneNumber number4 = new PhoneNumber("2255074");
    PhoneNumber number5 = new PhoneNumber("225-30-03");
    PhoneNumber number6 = new PhoneNumber("+7-983-576-86-99");
    PhoneNumber number7 = new PhoneNumber("225-90-03");
    PhoneNumber number8 = new PhoneNumber("+7-944-576-86-66");
    PhoneNumber number9 = new PhoneNumber("89277882265");
    PhoneNumber number10 = new PhoneNumber("+7-884-576-86-66");
    Name name1 = new Name("Ира Колесникова");
    Name name2 = new Name("Олеся");
    Name name3 = new Name("Ian");
    Name name4 = new Name("Настя");
    List<PhoneNumber> numbers1 = Arrays.asList(number1, number2, number3);
    List<PhoneNumber> numbers2 = Arrays.asList(number4);
    List<PhoneNumber> numbers3 = Arrays.asList(number5, number6);
    List<PhoneNumber> numbers4 = Arrays.asList(number7, number8);
    List<PhoneNumber> numbers1add = Arrays.asList(number1, number2, number3, number9);
    List<PhoneNumber> numbers2add = Arrays.asList(number4, number10);

    @Before
    public void setup() {
        book.addContact(name1, numbers1);
        book.addContact(name2, numbers2);
        book.addContact(name3, numbers3);
        book.addContact(name4, numbers4);
    }


    @Test
    public void addAndRemoveContact() {
        assertEquals(true, book.contains(name1, numbers1));
        assertEquals(true, book.contains(name2, numbers2));
        assertEquals(true, book.contains(name3, numbers3));
        assertEquals(true, book.contains(name4, numbers4));
        book.removeContact(name4);
        assertEquals(false, book.contains(name4, numbers4));
    }

    @Test
    public void addAndRemovePhoneNumber() {
        book.addNumber(name1, number9);
        assertEquals(true, book.contains(name1, numbers1add));
        book.addNumber(name2, number10);
        assertEquals(true, book.contains(name2, numbers2add));
        book.removeNumber(name1, number9);
        assertEquals(true, book.contains(name2, numbers1));
    }

    @Test
    public void findNumbers() {
        assertEquals(numbers1, book.findNumbers(name1));

    }

    @Test
    public void findName() {
        assertEquals(name1, book.findName(number2));

    }

}
