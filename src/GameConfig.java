
  // Oyunun sınırlandırıcılarının(tahmin edilecek max/min değer ve deneme hakkı) olduğu kodlar.
 
public class GameConfig {    // Sınırlayıcıların tanımlanması.
    private final int min;
    private final int max;
    private final int maxAttempts;

    // Sınırlayıcıların atanmasının yapıldığı constructor.
    public GameConfig(int min, int max, int maxAttempts) {
        this.min = min;
        this.max = max;
        this.maxAttempts = maxAttempts;
    }

    // Sınırlayıcı değerlerin dışarıdan erişilmesini sağlayan kodlar.
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}