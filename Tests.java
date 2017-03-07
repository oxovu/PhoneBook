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
    Name name1 = new Name("Ира Колесникова");
    Name name2 = new Name("Олеся");
    Name name3 = new Name("Ian");

    @Before
    public void setup() {
        book.put(name1, number1);
        book.put(name1, number2);
        book.put(name1, number3);
        book.put(name2, number6);
        book.put(name3, number5);
        book.put(name3, number4);
    }


    @Test
    public void addAndRemoveContact() {
        book.addContact("Настя", "89277453302, *134#, 334-54-23");
        assertEquals("89277453302, *134#, 334-54-23", book.findNumber("Настя")); //не могу разобраться в причине ошибки java.lang.NullPointerException
        //book.removeContact("Настя");
        //assertEquals("", book.findNumber("Настя"));
    }

}
