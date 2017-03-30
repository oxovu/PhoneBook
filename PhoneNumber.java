package MyClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  final class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        String pattern1 = "\\+*\\**[\\d\\-]+\\#*";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(number);
        if (m1.matches()) {
            this.number = number;
        } else throw new IllegalArgumentException("неверный формат номера телефона");
    }

    @Override
    public String toString() { return this.number; }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object instanceof PhoneNumber) {
            final PhoneNumber other = (PhoneNumber) object;
            return number.equals(other.number);
        } else return false;
    }
}

