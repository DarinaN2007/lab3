//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаём список людей
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Елена", "Петрова", 20));
        humans.add(new Human("Карина", "Астафьева", 19));
        humans.add(new Human("Дарина", "Петрова", 18));
        humans.add(new Human("Анастасия", "Краева", 34));
        humans.add(new Human("Данила", "Астафьев", 25));
        humans.add(new Human("Карина", "Астафьева", 19));// дубликат

        System.out.println("Исходный список:");
        for (Human h : humans) {
            System.out.println("   " + h);
        }
        System.out.println();

        // a) HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("a) HashSet (порядок НЕ сохраняется, дубликаты убраны):");
        for (Human h : hashSet) {
            System.out.println("   " + h);
        }
        System.out.println();

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("b) LinkedHashSet (порядок добавления сохранён):");
        for (Human h : linkedHashSet) {
            System.out.println("   " + h);
        }
        System.out.println();

        // c) TreeSet (использует Comparable — compareTo)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("c) TreeSet (сортировка по compareTo — возраст+имя+фамилия):");
        for (Human h : treeSet) {
            System.out.println("   " + h);
        }
        System.out.println();

        // d) TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("d) TreeSet с компаратором по фамилии:");
        for (Human h : treeSetByLastName) {
            System.out.println("   " + h);
        }
        System.out.println();

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("e) TreeSet с анонимным компаратором по возрасту:");
        for (Human h : treeSetByAge) {
            System.out.println("   " + h);
        }
        System.out.println();

        // f) Комментарии — почему так
        // HashSet — не сохраняет порядок, потому что использует хеш-код для размещения
        // LinkedHashSet — сохраняет порядок добавления (внутри двусвязный список)
        // TreeSet — сортирует элементы. Без компаратора использует compareTo (Comparable)
        // TreeSet с компаратором — сортирует по правилу компаратора
        // Все Set убирают дубликаты, потому что Set не может содержать одинаковые элементы
    }
}

// Класс Human с Comparable
class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Human other) {
        // Сначала по возрасту, потом по фамилии, потом по имени
        int result = Integer.compare(this.age, other.age);
        if (result != 0) return result;

        result = this.lastName.compareTo(other.lastName);
        if (result != 0) return result;

        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age
                && Objects.equals(firstName, human.firstName)
                && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", " + age + " лет";
    }
}

// Компаратор по фамилии
class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}