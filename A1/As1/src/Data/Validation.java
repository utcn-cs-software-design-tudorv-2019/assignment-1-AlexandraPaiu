package Data;

import java.sql.SQLException;

public class Validation {

	public boolean verifNume(String nume) throws SQLException{
        if (nume.equals(""))
            return false;
        else return true;
    }

 
	public boolean verifGrade(double grade) throws SQLException{
        if (grade>0)
            return true;
        else return false;
    }

	public boolean verifGroup(int group) throws SQLException{
        if(group>0)
            return true;
        else return false;
        }
	
	public boolean verifOras(String oras)throws SQLException{
		if (oras.equals(""))
			return false;
		else return true;
	}
	
	public boolean verifEmail(String mail) throws SQLException{
		  String ePattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher mu = p.matcher(mail);
     //   System.out.println(mu.matches());
			return mu.matches();
	}
	
	public boolean verifCnp(String mail) throws SQLException{
		  String ePattern = "0-9+";
      java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
      java.util.regex.Matcher mu = p.matcher(mail);
      	if( mail.length() < 13 )
      			return true;
      	return mu.matches() & false;
	}
}
