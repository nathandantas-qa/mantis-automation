package helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;

public class TaskLoader {
    // Alterar o tipo para refletir o novo formato do JSON
    private Map<String, Map<String, Map<String, String>>> tasks;

    private String filePath = "src/test/resources/task.json";

    public TaskLoader() {
        loadTasks();
    }

    // Carregar o JSON e fazer o parsing
    private void loadTasks() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            tasks = gson.fromJson(reader, Map.class);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para obter uma propriedade específica da task, com suporte ao idioma
    public String getTaskProperty(String key, String lang, String property) {
        if (tasks.containsKey(key) && tasks.get(key).containsKey(lang)) {
            Map<String, String> taskProperties = tasks.get(key).get(lang);
            if (taskProperties.containsKey(property)) {
                return taskProperties.get(property);
            } else {
                return "Propriedade não encontrada.";
            }
        } else {
            return "Mensagem não encontrada.";
        }
    }
}
