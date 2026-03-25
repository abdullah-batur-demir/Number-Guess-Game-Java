# Java OOP: Sayı Tahmin Oyunu (Console Application)

Bu proje, **YMÜ227 Nesne Tabanlı Programlama** dersi kapsamında geliştirilmiş, modüler mimariye ve güçlü hata yönetimine sahip bir konsol uygulamasıdır. 

## 🎯 Proje Amacı ve Kapsamı
Uygulama, belirlenen aralıkta rastgele üretilen bir sayının, kısıtlı deneme hakkı içinde kullanıcı tarafından bulunmasını hedefler. Temel amaç, kodun sadece çalışması değil; **Nesne Tabanlı Programlama (OOP)** prensiplerine uygun, sürdürülebilir ve modüler bir yapıda inşa edilmesidir.

## 🏗️ Teknik Mimari ve Tasarım Desenleri
Proje, her bileşenin tek bir sorumluluğu üstlenmesi (**Single Responsibility Principle**) esasına göre 5 ana sınıfa ayrılmıştır:

| Sınıf Adı | Rol / Sorumluluk | Tasarım Gerekçesi |
| :--- | :--- | :--- |
| **App.java** | Controller / UI | Kullanıcı etkileşimi ve oyun akışını yönetir. |
| **NumberGuessGame.java** | Model / Logic | Oyun kurallarını, hak takibini ve değerlendirme mantığını kapsüller. |
| **GameConfig.java** | Configuration | Oyun ayarlarının (min, max, hak) tek noktadan yönetimini sağlar. |
| **RandomNumberGenerator.java** | Utility | Rastgele sayı üretme işini soyutlayarak karmaşayı önler. |
| **Attempt.java** | Data Model | Her bir tahminin sonucunu (`Enum`) ve detaylarını temsil eder. |

## 🚀 Öne Çıkan Teknik Özellikler
* **Hata Yönetimi (Error Handling):** Sayısal olmayan girişler (`NumberFormatException`) ve aralık dışı değerler için sağlam bir doğrulama mekanizması.
* **Kaynak Yönetimi:** `java.util.Scanner` nesnesinin kaynak sızıntısını (resource leak) önlemek için **try-with-resources** yapısı kullanımı.
* **Modülerlik:** İş mantığı (logic) ile kullanıcı arayüzü (I/O) tamamen birbirinden ayrılmıştır.
* **Enum Kullanımı:** Tahmin sonuçları (`HIGH`, `LOW`, `CORRECT`) tip güvenliği (type safety) için Enum ile tanımlanmıştır.

## 📄 Mühendislik Raporu
Projenin detaylı analizini, sınıf diyagramı mantığını ve test senaryolarını içeren resmi raporuma aşağıdan ulaşabilirsiniz:
👉 **[Proje Teknik Raporu (PDF)](./reports/Abdullah_Batur_Demir_Proje_Raporu.pdf)**

## 🛠️ Kurulum ve Çalıştırma
1. Projeyi bilgisayarınıza indirin.
2. Terminal üzerinden proje klasörüne gidin.
3. Derlemek için: `javac *.java`
4. Çalıştırmak için: `java App`
