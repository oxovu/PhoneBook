package MyClass;

import javafx.util.Pair;
import org.junit.Test;
import org.junit.Before;

import java.awt.*;
import java.awt.List;
import java.util.*;

import static org.junit.Assert.*;

public class Tests {

    PhoneBook book = new PhoneBook();
    Contact contact1 = new Contact("Анна", Arrays.asList("89277092265", "+7-943-576-86-99", "*101#"));
    Contact contact2 = new Contact("Елена Сергеевна", Arrays.asList("89277004265", "*161#"));
    Contact contact3 = new Contact("Ванюша", Arrays.asList("()gjhj"));
    Contact contact4 = new Contact("Ирина", Arrays.asList("+7-977-576-86-99"));

    @Before
    public void setup() {
        book.addRecord(contact1);
        book.addRecord(contact2);
        book.addRecord(contact3);
    }


    @Test
    public void addAndRemoveRecord() {
        book.addRecord(contact4);
        assertEquals("[+7-977-576-86-99]", book.findPhoneNumber("Ирина"));
        book.removeRecord(contact4);
        assertEquals("not found", book.findPhoneNumber("Ирина"));
    }

    @Test
    public void addAndRemovePhoneNumber() {
        contact1.addPhoneNumber("89265437654");
        assertEquals("[89277092265, +7-943-576-86-99, *101#, 89265437654]", contact1.getPhoneNumber());
        contact1.removePhoneNumber("+7-943-576-86-99");
        assertEquals("[89277092265, *101#, 89265437654]", contact1.getPhoneNumber());
    }

    @Test
    public void findName() {
        assertEquals("Елена Сергеевна", book.findName("89277004265"));
        assertEquals("not found", book.findName("glrwah"));

    }

    @Test
    public void findNumber() {
        assertEquals("[89277092265, +7-943-576-86-99, *101#]", book.findPhoneNumber("Анна"));
        assertEquals("not found", book.findPhoneNumber("Аня"));
    }

}
