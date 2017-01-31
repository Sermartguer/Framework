package Users.Modules.User.Model.Classes.order;

import java.util.Comparator;

import Users.Modules.User.Model.Classes.usu;

public class Orderbirthday implements Comparator <usu>{
	public int compare (usu u1, usu u2) {
		return u1.getf_nac().comparaFechas("other",u2.getf_nac());
	}
}
