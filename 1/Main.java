//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // a) Массив из N случайных чисел от 0 до 100
        int n = 15;  // N — сколько чисел (можно любое)
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
        {
            array[i] = random.nextInt(101);  // 0..100 включительно
        }
        System.out.println("a) Массив: " + Arrays.toString(array));

        // b) Массив -> список List
        List<Integer> list = new ArrayList<>();
        for (int x : array)
        {
            list.add(x);
        }
        System.out.println("b) Список: " + list);

        // c) Сортировка по возрастанию
        Collections.sort(list);
        System.out.println("c) По возрастанию: " + list);

        // d) Сортировка в обратном порядке
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("d) По убыванию: " + list);

        // e) Перемешать
        Collections.shuffle(list);
        System.out.println("e) Перемешано: " + list);

        // f) Циклический сдвиг на 1
        Collections.rotate(list, 1);
        System.out.println("f) Сдвиг на 1: " + list);

        // g) Только уникальные элементы
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("g) Уникальные: " + uniqueList);

        // h) Только дублирующиеся
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int x : list)
        {
            if (!seen.add(x))
            {
                duplicates.add(x);
            }
        }
        System.out.println("h) Дубликаты: " + duplicates);

        // i) Список -> массив
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("i) Массив: " + Arrays.toString(newArray));

        // j) Частота каждого числа
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int x : list) {
            if (frequency.containsKey(x))
            {
                frequency.put(x, frequency.get(x) + 1);
            } else
            {
                frequency.put(x, 1);
            }
        }
        System.out.println("j) Частота чисел:");
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet())
        {
            System.out.println("   " + entry.getKey() + " (" + entry.getValue() + " раз)");
        }
    }
}