//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world hello Java world HELLO java world";

        // Приводим всё к нижнему регистру, чтобы регистр не влиял
        String lower = text.toLowerCase();

        // Разбиваем строку на слова по пробелам
        String[] words = lower.split("\\s+");

        // Считаем частоту каждого слова
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Выводим результат
        System.out.println("Текст: " + text);
        System.out.println();
        System.out.println("Частота слов:");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println("   " + entry.getKey() + " (" + entry.getValue() + " раз)");
        }
    }
}