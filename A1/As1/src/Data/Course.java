package Data;

public class Course {

	private int location;
	private String name;
	private String endHour;
	private String startHour;
	private int idteacher;
	private int id;
	
	public Course() {
		
	}
	
	public int getTeacher() {
		return idteacher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdTeacher(int teacher) {
		this.idteacher = teacher;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	
}
