package helper;

import page.login.TaskPage;
import pojo.Task;

public class CreateEditTaskHelper {

	public static void fillTaskWithMandatoryFields( Task taskData) {
		TaskPage taskPage = new TaskPage();
		
		taskPage.selectedCategory(taskData.getCategory());
		taskPage.fillSummary(taskData.getSummary());
		taskPage.fillDescription(taskData.getDescription());
    }
	
}
