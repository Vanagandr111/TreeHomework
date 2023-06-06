import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

  int maxLengthToCheck;

  public PersonComparator(int maxLengthToCheck) {
    this.maxLengthToCheck = maxLengthToCheck;
  }

  @Override
  public int compare(Person p1, Person p2) {
    boolean surnameNoCheck = p1.getSurname().length() > maxLengthToCheck && p2.getSurname().length() > maxLengthToCheck;
    boolean currentMoreThanOther = p1.getSurname().length() > p2.getSurname().length();
    boolean surnameEquals = p1.getSurname().length() == p2.getSurname().length();

    boolean currentOlderThanOther = p1.getAge() > p2.getAge();
    boolean ageEquals = p1.getAge() == p2.getAge();

    return surnameNoCheck ? (currentOlderThanOther ? 1 : ageEquals ? 0 : -1) : currentMoreThanOther ? 1 : !surnameEquals ? -1 : currentOlderThanOther ? 1 : ageEquals ? 0 : -1;
  }
}
