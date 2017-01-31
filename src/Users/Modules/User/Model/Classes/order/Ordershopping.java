package Users.Modules.User.Model.Classes.order;

import java.util.Comparator;

import Users.Modules.User.Model.Classes.usercl;


public class Ordershopping implements Comparator <usercl> {
	public int compare (usercl u1, usercl u2) {
		if(((usercl)u1).getn_comp()>((usercl)u2).getn_comp())
			return 1;
		if(((usercl)u1).getn_comp()<((usercl)u2).getn_comp())
			return -1;
		return 0;
	}
}
