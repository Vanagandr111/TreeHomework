import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Main {

  public static final Logger logger = Logger.getAnonymousLogger();

  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    Comparator<Person> comparator;

    comparator = (p1, p2) -> {
      boolean surnameNoCheck = p1.getSurname().length() > 6 && p2.getSurname().length() > 6;
      boolean currentMoreThanOther = p1.getSurname().length() > p2.getSurname().length();
      boolean surnameEquals = p1.getSurname().length() == p2.getSurname().length();

      boolean currentOlderThanOther = p1.getAge() > p2.getAge();
      boolean ageEquals = p1.getAge() == p2.getAge();

      return surnameNoCheck ? (currentOlderThanOther ? 1 : ageEquals ? 0 : -1) : currentMoreThanOther ? 1 : !surnameEquals ? -1 : currentOlderThanOther ? 1 : ageEquals ? 0 : -1;
    };

    people.add(new Person("Роман", "Маркелов", 24));
    people.add(new Person("Иван", "Быков", 37));
    people.add(new Person("Игорь", "Покровский", 22));
    people.add(new Person("Ярослав", "Астафьев", 16));
    people.add(new Person("Лев", "Головин", 16));
    people.add(new Person("Мирон", "Павлов", 25));
    people.add(new Person("Ярослав", "Филатов", 11));
    people.add(new Person("Александр", "Волков", 21));
    people.add(new Person("Артём", "Степанов", 32));
    people.add(new Person("Тихон", "Тарасов", 17));
    people.add(new Person("Марат", "Серов", 28));
    people.add(new Person("Кирилл", "Леонов", 14));
    people.add(new Person("Даниил", "Константинов", 13));
    people.add(new Person("Александр", "Панков", 31));
    people.add(new Person("Андрей", "Кондратьев", 33));
    people.add(new Person("Леон", "Панфилов", 35));

    //Удаляем людей младше 18 лет
    people.removeIf(person -> person.getAge() < 18);

    Collections.sort(people, comparator);

    String output = people.toString();
    logger.info("Не отформатированный список: " + output);

    StringBuilder formattedOutput = new StringBuilder();

    for (Person person: people) {
      formattedOutput.append(String.format("%14s %20s %4d\n", person.getName(), person.getSurname(), person.getAge()));
    }

    logger.info("Отформатированный список: \n" + formattedOutput);
  }
}