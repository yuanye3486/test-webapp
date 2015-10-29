package com.fengqiliu.test.hightqualitycode.item7_07.com.company.section2;

import java.util.Arrays;
import java.util.List;

public class UserHandler<T extends User>{
	// 判断用户是否有权限执行操作
	public boolean permit(T user, List<Job> jobs) {
		List<Class<?>> iList = Arrays.asList(user.getClass().getInterfaces());
		// 判断是否是管理员
		if (iList.indexOf(Admin.class) > -1) {
			Admin admin = (Admin) user;
			/* 判断管理员是否有此权限 */
		} else {
			/* 判断普通用户是否有此权限 */
		}
		return false;
	}
}



interface User {

}

class UserImpl implements User, Admin {

}

interface Admin {

}

class Job {

}