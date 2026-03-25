
 // Tahmin edilmeye çalışılan rastgele sayının (aralık dahilinde) üretildiği kodlar.

import java.util.Random;

// Rastgele üretilecek sayının aralıklarının tanımlanması.
public class RandomNumberGenerator {
    private final int min;
    private final int max;
    private final Random random; // Javaya ait rastgele sayı üretici nesne.

    // Rastgele üretilecek sayının değerlerini atayan constructor.
    public RandomNumberGenerator(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    // Rastgele sayının üretilmesi.
    public int generate() {
        return random.nextInt(max - min + 1) + min;
    }
}