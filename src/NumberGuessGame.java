
 // Oyunun yönetildiği kodlar.


 // Yönetici değişkenlerin tanımlanması.
public class NumberGuessGame {
    private final GameConfig config;
    private final int sayi;
    private int kalanTahmin;
    private int yapilanTahmin;
    private boolean finished;
    private boolean won;

    // Yönetici değişkenleri atayan constructor.
    public NumberGuessGame(GameConfig config) {
        this.config = config;
        this.sayi = new RandomNumberGenerator(config.getMin(), config.getMax()).generate();
        this.kalanTahmin = config.getMaxAttempts();
        this.yapilanTahmin = 0;
        this.finished = false;
        this.won = false;
    }

    public Attempt.GuessResult evaluateGuess(int guess) {
        if (finished) { // Oyun bittiyse işlem yapmaz.
            return null;
        }

        kalanTahmin--;
        yapilanTahmin++;

        // Tahmine göre yönlendirilmenin yapılması.
        Attempt.GuessResult result;
        if (guess == sayi) {
            result = Attempt.GuessResult.CORRECT; 
            this.won = true;
            this.finished = true;
        } else if (guess > sayi) {
            result = Attempt.GuessResult.HIGH; 
        } else {
            result = Attempt.GuessResult.LOW; 
        }

        if (kalanTahmin <= 0 && !won) {
            this.finished = true;
        }

        return result;
    }

    // Yönetici kodların dışarıdan erişilmesi.
    public boolean isOver() {
        return finished;
    }

    public boolean isWon() {
        return won;
    }

    public int getNumber() {
        return sayi;
    }

    public int getKalanTahmin() {
        return kalanTahmin;
    }

    public int getYapilanTahmin() {
        return yapilanTahmin;
    }

    public GameConfig getConfig() {
        return config;
    }
    
}