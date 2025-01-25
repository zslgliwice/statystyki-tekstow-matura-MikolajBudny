import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZadanieA {
    public static void main(String[] args) throws IOException {
        String plik = "tekst.txt";
        int licznik = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            String linia;
            Pattern pattern = Pattern.compile(".*([A-Z])\\1.*");

            while ((linia = br.readLine()) != null) {
                String[] slowa = linia.split(" ");

                for (String slowo : slowa) {
                    Matcher matcher = pattern.matcher(slowo);
                    if (matcher.matches()) {
                        licznik++;
                    }
                }
            }
        }

        System.out.println("Slow z dwoma kolejnymi literami: " + licznik);
    }
}