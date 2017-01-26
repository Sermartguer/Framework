package Users.Modules.User.Classes.order;

import java.util.Comparator;

import Users.Modules.User.Classes.usu;

public class Orderage implements Comparator <usu>{
	public int compare (usu u1, usu u2) {
		if(u1.getedad()>u2.getedad())
			return 1;
		if(u1.getedad()<u2.getedad())
			return -1;
		return 0;
	}
}
