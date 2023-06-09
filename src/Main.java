import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Main {

  public static final Logger logger = Logger.getAnonymousLogger();

  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    PersonComparator comparator = new PersonComparator(6);

    people.add(new Person("Роман", "Маркелов", 24));
    people.add(new Person("Иван", "Быков", 37));
    people.add(new Person("Игорь", "Покровский", 22));
    people.add(new Person("Ярослав", "Астафьев", 40));
    people.add(new Person("Лев", "Головин", 26));
    people.add(new Person("Мирон", "Павлов", 25));
    people.add(new Person("Ярослав", "Филатов", 33));
    people.add(new Person("Александр", "Волков", 21));
    people.add(new Person("Артём", "Степанов", 32));
    people.add(new Person("Тихон", "Тарасов", 38));
    people.add(new Person("Марат", "Серов", 28));
    people.add(new Person("Кирилл", "Леонов", 40));
    people.add(new Person("Даниил", "Константинов", 31));
    people.add(new Person("Александр", "Панков", 31));
    people.add(new Person("Андрей", "Кондратьев", 33));
    people.add(new Person("Леон", "Панфилов", 35));

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