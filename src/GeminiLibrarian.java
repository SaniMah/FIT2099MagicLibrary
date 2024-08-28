import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GeminiLibrarian implements ActionCapable {

    private static final String REQUEST_URL = "AIzaSyAHShLwdpAJdx8mgmvBWEOzaFgwDuPK_vk"; // Replace with actual URL

    /**
     * Makes a call to the Gemini API with the user's prompt and returns the response.
     *
     * @param prompt The user's prompt to be sent to the Gemini API.
     * @return The response from the Gemini API or an error message if the API is unavailable.
     */
    private String geminiCall(String prompt) {
        String result;
        try {
            // Create the URL object
            URL url = new URL(REQUEST_URL);
            // Cast URLConnection to HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Create JSON payload
            String jsonInputString = "{\"contents\": [{\"parts\": [{\"text\": \"" + prompt + "\"}]}]}";

            // Send JSON input
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int code = connection.getResponseCode();
            System.out.println("Response Code: " + code);

            // Read the response
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

    /**
     * The speak method that prompts the user for input and returns a response from the Gemini API.
     *
     * @param prompt The user's prompt to be sent to the Gemini API.
     * @return The response from the Gemini API.
     */
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
