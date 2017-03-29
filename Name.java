package MyClass;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Name {
    private String name;

    public Name(String name) {
        String pattern1 = "[a-z|A-Z|а-я|А-Я]+\\s*[a-z|A-Z|а-я|А-Я]*\\s*[a-z|A-Z|а-я|А-Я]*";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(name);
        if (m1.matches()) {
            this.name = name;
        } else throw new IllegalArgumentException("неверный формат имени");
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this.toString() == object.toString()) return true;
        return  false;
    }
}
