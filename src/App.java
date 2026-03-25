
// Oyunun çalıştırılacağı ve oyuncunun yönlendirildirilmesi için çıktı verecek olan kodlar.

import java.util.Scanner;

// Main metod 
public class App {

    public static void main(String[] args) {
        System.out.println("=== NTP Sayı Tahmin Oyunu ===");

        // Kaynak sızıntısı için önlem.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Oyun yapılandırmasını alma ve Scannerın iletimi.
            GameConfig config = configureGame(scanner); 
            NumberGuessGame game = new NumberGuessGame(config);
            
            System.out.printf("\nOyun Başladı! %d ile %d arasındaki sayıyı tahmin et. Deneme hakkı: %d\n", 
                              config.getMin(), config.getMax(), config.getMaxAttempts());

            // Ana oyun döngüsü.
            while (!game.isOver()) {
                displayStatus(game);

                System.out.print("Tahmininiz: ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    continue; 
                }

                try {
                    int guess = Integer.parseInt(input);
                    
                    // Aralık dışı değer kontrolü.
                    if (guess < config.getMin() || guess > config.getMax()) {
                        System.out.printf("Aralık dışı değer! Lütfen %d ile %d arasında bir tam sayı girin.\n", config.getMin(), config.getMax());
                        continue; 
                    }

                    Attempt.GuessResult result = game.evaluateGuess(guess);
                    
                    if (game.isOver()) {
                        break;
                    }
                    // Oyuncuya geri bildirim.
                    switch (result) {
                        case HIGH:
                            System.out.println("Çok Yüksek");
                            break;
                        case LOW:
                            System.out.println("Çok Düşük");
                            break;
                        default:
                            break;
                    }
                    // Sayısal olmayan giriş kontrolü.
                } catch (NumberFormatException e) {
                    System.out.println("Geçersiz giriş. Lütfen bir tam sayı girin.");
                    continue; 
                }
            }

            displayGameSummary(game); // Oyun sonu özet mesajı.
        }
    }

    // Aralık ve deneme hakkının kullanıcıdan alınması.
    private static GameConfig configureGame(Scanner scanner) {
        int min = 1, max = 100, maxAttempts = 7;
        
        
        // Aralık seçiminin doğrulanması.
       
        boolean girdi = false;
        
        while (!girdi) {         // Girdi kontrolü için döngü.
            System.out.print("Aralık ? (1) 1-100 (Varsayılan deneme: 7) (2) 1-1000 (Varsayılan deneme: 10): ");
            String rangeChoice = scanner.nextLine().trim();

            if (rangeChoice.equals("1")) {
                max = 100;
                maxAttempts = 7;
                girdi = true;
            } else if (rangeChoice.equals("2")) {
                max = 1000;
                maxAttempts = 10;
                girdi = true;
            } else {
                // 1 veya 2 den farklı bir sayı girilirse uyarı veren ve kodlar.
                System.out.println("Hata: Lütfen sadece '1' veya '2' giriniz.");
            }
        }
        
        // Max deneme hakkı seçimi.
        System.out.printf("Maksimum deneme hakkı (Varsayılan %d)? : ", maxAttempts);
        try {
            String attemptInput = scanner.nextLine().trim();
            // Boş bırakılmasına karşı önlem.
            if (!attemptInput.isEmpty()) {
                maxAttempts = Integer.parseInt(attemptInput);
            }
        } catch (NumberFormatException ignored) { }    // Varsayılan değerin kullanılması.
        
        return new GameConfig(min, max, maxAttempts);
    }
    
    // O anki kalan deneme hakkının gösterilmesi. 
    private static void displayStatus(NumberGuessGame game) {
        System.out.printf("\nKalan Deneme: %d\n", game.getKalanTahmin());
    }

    // Oyun sonu durum çıktıları.
    private static void displayGameSummary(NumberGuessGame game) {
        System.out.println("\n=== Oyun Bitti ===");
        
        if (game.isWon()) {
            System.out.printf("Tebrikler doğru bildiniz! %d. denemede oyunu kazandınız.\n", game.getYapilanTahmin()); 
        } else {
            System.out.printf("Deneme hakkınız bitti! Doğru sayı: %d. Yine bekleriz.\n", game.getNumber());
        }
    }
}