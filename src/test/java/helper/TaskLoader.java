package helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;

public class TaskLoader {
	private Map<String, Map<String, String>> task;

	private String filePath = "src/test/resources/task.json";

	public TaskLoader() {
		loadTask();
	}

	private void loadTask() {
		Gson gson = new Gson();
		try (FileReader reader = new FileReader(filePath)) {
			task = gson.fromJson(reader, Map.class);
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public String getTask(String key, String lang) {
		if (task.containsKey(key) && task.get(key).containsKey(lang)) {
			return task.get(key).get(lang);
		} else {
			return "Mensagem não encontrada.";
		}
	}
}
