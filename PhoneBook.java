package MyClass;


import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Contact> record;

    public PhoneBook() {
        record = new ArrayList<Contact>();
    }
    public void addRecord(Contact contact) {
        record.add(contact);
    }

    public void removeRecord(Contact contact) {
        record.remove(contact);
    }

    public String findPhoneNumber(String name) {
        for (int i = 0; i < record.size(); i++)
        {
            if (name.equals(record.get(i).getFullName())) return record.get(i).getPhoneNumber();
        }
        return "not found";
    }

    public String findName(String phonenumber) {
        for (int i = 0; i < record.size(); i++)
        {
            if (record.get(i).getPhoneNumber().contains(phonenumber)) return record.get(i).getFullName();
        }
        return "not found";
    }
}
