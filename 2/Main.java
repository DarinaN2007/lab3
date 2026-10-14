import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 10;

        PrimesGenerator generator = new PrimesGenerator(n);

        System.out.println("Простые числа в прямом порядке:");
        for (int prime : generator) {
            System.out.print(prime + " ");
        }
        System.out.println();

        System.out.println("Простые числа в обратном порядке:");
        List<Integer> primes = new ArrayList<>();
        for (int prime : generator) {
            primes.add(prime);
        }
        for (int i = primes.size() - 1; i >= 0; i--) {
            System.out.print(primes.get(i) + " ");
        }
        System.out.println();
    }
}

class PrimesGenerator implements Iterable<Integer> {
    private int count;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int found = 0;
            private int current = 2;

            @Override
            public boolean hasNext() {
                return found < count;
            }

            @Override
            public Integer next() {
                while (!isPrime(current)) {
                    current++;
                }
                int result = current;
                current++;
                found++;
                return result;
            }

            private boolean isPrime(int number) {
                if (number < 2) return false;
                for (int i = 2; i * i <= number; i++) {
                    if (number % i == 0) return false;
                }
                return true;
            }
        };
    }
}