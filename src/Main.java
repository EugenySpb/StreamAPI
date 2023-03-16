import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        // Ищем количество несовершеннолетних
        long countUnderage = persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();
        System.out.printf("Количество несовершеннолетних: %,d", countUnderage);

        //Список фамилий призывников (от 18 и до 27 лет)
        List<String> conscriptsSurnames = persons.stream()
                .filter(p -> p.getSex() == Sex.MAN && p.getAge() >= 18 && p.getAge() <= 27)
                .map(Person::getSurname)
                .collect(Collectors.toList());
        System.out.println("Фамилии призывников: " + conscriptsSurnames);

        // Люди с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин
        List<Person> potentialEmployees = persons.stream()
                .filter(p -> p.getEducation() == Education.HIGHER)
                .filter(p -> p.getSex() == Sex.WOMAN && p.getAge() >= 18 && p.getAge() <= 60 ||
                        p.getSex() == Sex.MAN && p.getAge() >= 18 && p.getAge() <= 65)
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());
        System.out.println("Работоспособные люди: " + potentialEmployees);
    }
}