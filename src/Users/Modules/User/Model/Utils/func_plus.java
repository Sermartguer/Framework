package Users.Modules.User.Model.Utils;

import Users.Main.menu4;
import Users.Modules.User.Model.Classes.userad;

public class func_plus {
public static int salary (int ant){
	if ((ant>0)&&(ant<=5)) {
		return 50;
	}else if ((ant>6)&&(ant<=20)){
		return 100;
	}else if((ant>21)&&(ant<=25)){
		return 150;
	}else if((ant>26)&&(ant<=30)){
		return 200;
	}else if((ant>31)&&(ant<=40)){
		return 250;
	}else if((ant>41)&&(ant<=49)){
		return 300;
	}
	return 0;
}

public static int discount (int n_comp){
	if ((n_comp>0)&&(n_comp<=20)){
		return 10;
	}else if((n_comp>21)&&(n_comp<=40)){
		return 20;
	}else if ((n_comp>41)&&(n_comp<=60)){
		return 30;
	}else if ((n_comp>61)&&(n_comp<=80)){
		return 40;
	}else if ((n_comp>81)&&(n_comp<=100)){
		return 50;
	}
	return 0;
}
public static String karma(int karma){
	if ((karma>0)&&(karma<=20)){
		return "Bronze";
	}else if((karma>21)&&(karma<=40)){
		return "Silver";
	}else if ((karma>41)&&(karma<=1000)){
		return "Gold";
	}
	return null;
}

public static int points(String karma){
	if(karma.equals("Bronze")){
		return 25;
	}else if(karma.equals("Silver")){
		return 50;
	}else if(karma.equals("Gold")){
		return 100;
	}
	return 0;
}

}
