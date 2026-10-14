//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> original = new HashMap<>();
        original.put(1, "один");
        original.put(2, "два");
        original.put(3, "три");
        original.put(4, "четыре");

        System.out.println("Исходный Map:");
        System.out.println("   " + original);
        System.out.println();

        Map<String, Integer> inverted = invertMap(original);

        System.out.println("Инвертированный Map:");
        System.out.println("   " + inverted);
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> source) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : source.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
}