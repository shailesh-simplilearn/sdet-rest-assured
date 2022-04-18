package rest;

public class RestPOJO {
	
	public RestPOJO(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	private String job;
	@Override
	public String toString() {
		return "RestPOJO [name=" + this.name + ", job=" + this.job + "]";
	}

}
