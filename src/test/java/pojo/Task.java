package pojo;

public class Task {
	private String category;
	private String summary;
	private String description;
	
	public Task(String category, String summary, String description) {
	      this.category = category;
	      this.summary = summary;
	      this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public String getSummary() {
		return summary;
	}

	public String getDescription() {
		return description;
	}	 	
	
	
	 
}
