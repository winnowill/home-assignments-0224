package ru.sberbank.jd.lesson07;

import java.util.Objects;
import lombok.Getter;

/**
 * Класс для хранения данных о человеке.
 */
public class Person implements Comparable<Person> {
    @Getter
    private final String name;
    @Getter
    private final String city;
    @Getter
    private final Integer age;

    /**
     * Constructor.
     *
     * @param name Person
     * @param city Person
     * @param age Person
     */
    public Person(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Check object equals.
     *
     * @param obj compare
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Person other = (Person) obj;
        return getName().equalsIgnoreCase(other.getName()) && getCity().equalsIgnoreCase(other.getCity())
                && getAge().equals(other.getAge());
    }

    /**
     * Get hash.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName().toLowerCase(), getCity().toLowerCase(), getAge());
    }

    /**
     * Get content in format.
     *
     * @return string for print
     */
    @Override
    public String toString() {
        return "Person{" + "name='" + getName() + '\'' + ", city='" + getCity() + '\''
                + ", age=" + getAge() + '}' + " \n";
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     * The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     * Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Person o) {
        if ((o.getCity() == null) || (o.getName() == null)) {
            throw new NullPointerException("Illegal argument");
        }
        return getCity().compareToIgnoreCase(o.getCity()) + getName().compareToIgnoreCase(o.getName());
    }

}

