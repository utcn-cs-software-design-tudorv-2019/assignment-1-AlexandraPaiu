package Data;

public class Student extends User{

	private int group;
	
	public Student() {
		
	}
	public Student(String name,String email,String password, String address, String cnp, int group) {
	//	this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setAddress(address);
		this.setCnp(cnp);
		this.setName(name);
		this.group = group;
	}
	
	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
	
}
