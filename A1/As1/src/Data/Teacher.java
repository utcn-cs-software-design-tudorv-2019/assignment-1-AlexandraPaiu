package Data;

public class Teacher extends User {

	public Teacher() {
		
	}
	
	public Teacher( String name,String email, String password ,String address, String cnp) {
		//this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setAddress(address);
		this.setCnp(cnp);
		this.setName(name);
	}
	
}
