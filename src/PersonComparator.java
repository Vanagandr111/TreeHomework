import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

  @Override
  public int compare(Person p1, Person p2) {
    boolean currentMoreThanOther = p1.getSurname().length() > p2.getSurname().length();
    boolean surnameEquals = p1.getSurname().length() == p2.getSurname().length();

    boolean currentOlderThanOther = p1.getAge() > p2.getAge();
    boolean ageEquals = p1.getAge() == p2.getAge();

    return currentMoreThanOther ? 1 : !surnameEquals ? -1 : currentOlderThanOther ? 1 : ageEquals ? 0 : -1;
  }
}
