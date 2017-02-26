package MyClass;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private final String fullName;
    private List<String> phoneNumber = new ArrayList<>();

    public Contact(String fullName, List<String> phoneNumber) {
        this.fullName = fullName;
        for (int i = 0; i < phoneNumber.size(); i++) {
           this.addPhoneNumber(phoneNumber.get(i));
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber.toString();
    }

    public boolean addPhoneNumber(String n) {
        String pattern1 = "^(8|\\+7)[\\- ]?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(n);
        String pattern2 = "^(\\*)(\\d{3})(#)$";
        Pattern p2 = Pattern.compile(pattern2);
        Matcher m2 = p2.matcher(n);
        if (m1.matches() || m2.matches()) {
            phoneNumber.add(n);
             return true;
        }
        return false;
    }

    public void removePhoneNumber(String n) {
        phoneNumber.remove(n);
    }

}
