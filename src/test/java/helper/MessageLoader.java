package helper;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class MessageLoader {
	private Map<String, Map<String, String>> messages;

	private String filePath = "src/test/resources/messages.json";

	public MessageLoader() {
		loadMessages();
	}

	private void loadMessages() {
		Gson gson = new Gson();
		try (FileReader reader = new FileReader(filePath)) {
			System.out.println("Loading messages from: " + filePath);
			messages = gson.fromJson(reader, Map.class);

		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public String getMessage(String key, String lang) {
		if (messages.containsKey(key) && messages.get(key).containsKey(lang)) {
			return messages.get(key).get(lang);
		} else {
			return "Mensagem não encontrada.";
		}
	}
}