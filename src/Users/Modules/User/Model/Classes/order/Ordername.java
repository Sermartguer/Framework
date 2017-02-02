package Users.Modules.User.Model.Classes.order;

import java.util.Comparator;

import Users.Modules.User.Model.Classes.usu;

public class Ordername implements Comparator <usu>{
	
	public int compare (usu u1, usu u2) {
		if(u1.getnom().compareTo(u2.getnom())>0)
			return 1;
		if(u1.getnom().compareTo(u2.getnom())<0)
			return -1;
		return 0;
	}
}
