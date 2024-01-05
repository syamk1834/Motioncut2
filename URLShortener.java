import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener{
    private Map<String, String> urlMap;
    private final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int codeLength = 6;

    public URLShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenURL(String originalURL) {
        String code = generateRandomCode();
        urlMap.put(code, originalURL);
        return "http://your-shortened-url.com/" + code;
    }

    public String getOriginalURL(String shortURL) {
        String code = shortURL.substring("http://your-shortened-url.com/".length());
        return urlMap.getOrDefault(code, "URL not found");
    }

    private String generateRandomCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

      
        String originalURL = "https://www.example.com";
        String shortURL = shortener.shortenURL(originalURL);
        System.out.println("Shortened URL: " + shortURL);

       
        String retrievedURL = shortener.getOriginalURL(shortURL);
        System.out.println("Original URL: " + retrievedURL);
    }
}