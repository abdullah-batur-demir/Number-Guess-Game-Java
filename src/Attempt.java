
 //  Tahmin detaylarının tutulduğu kodlar.

public class Attempt {

    public enum GuessResult { // Tahmin sonucunun değerini belirtmek için kullanılacak olan enum.
        HIGH,
        LOW,
        CORRECT
    }
    
    private final int guessValue;
    private final GuessResult result;
    private final int attemptNo;

    // Tahmin değerini, değerin doğruluğunu ve tahmin sayısını atayan constructor.
    public Attempt(int guessValue, GuessResult result, int attemptNo) { 
        this.guessValue = guessValue;
        this.result = result;
        this.attemptNo = attemptNo;
    }
    
    // Değerlerin dışarıdan erişilmesini sağlayan kodlar.
    public int getGuessValue() {
        return guessValue;
    }

    public GuessResult getResult() {
        return result;
    }

    public int getAttemptNo() {
        return attemptNo;
    }

}