package MyClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneNumber {
    private String number;

    PhoneNumber(String number) {
        String pattern1 = "\\+*\\**[\\d\\-]+\\#*";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(number);
        if (m1.matches()) {
            this.number = number;
        } else throw new IllegalArgumentException("неверный формат номера телефона");
    }

    @Override
    public String toString() { //не конечный вариант вывода номеров
        return this.number;
    } // не конечный вариант вывода номеров

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return this == object;
    }
}

