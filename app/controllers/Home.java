package controllers;

import java.util.List;

import models.User;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import play.cache.Cache;
import constants.Constants;
import constants.JPASQL;
import constants.URLMapping;

public class Home extends Basic {

	public static void index() {
		render(URLMapping.LOGIN);
	}

	public static void login(User vo) {
		validation.required(vo.username).message("username cannot empty");
		validation.required(vo.password).message("password cannot empty");
		if (!validation.hasErrors()) {
			List<User> lists = User.find(JPASQL.USER_LOGIN, vo.username, vo.password).fetch();
			if (CollectionUtils.size(lists) > 0) {
				User user = lists.get(0);
				session.put(Constants.CURRENT_USERID, user.id);
				session.put(Constants.CURRENT_USERNAME, user.username);
				session.put(Constants.CURRENT_USER_REALNAME, user.realName);
				session.put(Constants.CURRENT_USERTYPE, user.usertype);
				session.put(Constants.CURRENT_USER_UNITNO, user.unitNo);
				Cache.set(session.getId(), user);
				successLogin(user.usertype);
			} else {
				flash.put("error", "username/password is not corrent.");
				render(URLMapping.LOGIN, vo);
			}
		} else {
			render(URLMapping.LOGIN, vo);
		}
	}
	
	private static void successLogin(String userType) {
		if(StringUtils.isNotEmpty(userType)){
			render(URLMapping.MANAGER_WELCOME);
		}else{
			render(URLMapping.ERROR_404);
		}
	}
	
	public static void events() {
		render(URLMapping.RESIDENT_WELCOME);
	}
	
	public static void forms() {
		render(URLMapping.APPLICATION_FORMS);
	}

	public static void welcome() {
		successLogin(session.get(Constants.CURRENT_USERTYPE));
	}

	public static void logout() {
		Cache.delete(session.getId());
		session.clear();
		index();
	}
}