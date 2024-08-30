import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GeminiLibrarian implements ActionCapable {

    private static final String API_KEY = "AIzaSyAHShLwdpAJdx8mgmvBWEOzaFgwDuPK_vk"; // Replace with your actual API key
    private static final String REQUEST_URL = "https://api.example.com/your-gemini-endpoint"; // Replace with the actual API endpoint URL


    private String geminiCall(String prompt) {
        String result;
        try {

            URL url = new URL(REQUEST_URL + "?key=" + API_KEY);


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);


            String jsonInputString = "{\"contents\": [{\"parts\": [{\"text\": \"" + prompt + "\"}]}]}";


            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }


            int code = connection.getResponseCode();
            System.out.println("Response Code: " + code);


            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                result = "";
                while ((responseLine = br.readLine()) != null) {
                    if (responseLine.trim().startsWith("\"text\": ")) {
                        result = responseLine.trim().substring(9, responseLine.trim().length() - 1);
                    }
                }
            }
        } catch (Exception e) {
            return "I am sorry, I cannot help you with that. Gemini offline at the moment.";
        }
        if (result == null || result.isEmpty()) {
            result = "I am sorry, I cannot help you with that.";
        }
        return result;
    }


    public String speak(String prompt) {
        return geminiCall(prompt);
    }

    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new TalkAction(this));
        return actions;
    }

    @Override
    public String speak() {
        return "";
    }
}
