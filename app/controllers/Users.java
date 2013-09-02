package controllers;

import java.util.List;

import models.ModelHelper;
import models.User;

import org.apache.commons.collections.CollectionUtils;

import play.data.validation.Valid;
import utils.PaginationList;
import constants.JPASQL;
import constants.URLMapping;

public class Users extends Basic {

	public static void list(PaginationList paginationList) {
		paginationList = ModelHelper.pagination(JPASQL.USER_FIND_ALL, paginationList, new Object[]{});
		render(URLMapping.USER_MANAGER_USERS, paginationList);
	}

	public static void create() {
		render(URLMapping.USER_MANAGER_USER_FORM);
	}

	public static void register(@Valid User user, String rePassword) {
		validation.equals(user.password, rePassword);
		if (!validation.hasErrors()) {
			List<User> lists = User.find(JPASQL.USER_USERNAME_AVAILABLE, user.username).fetch();
			if (CollectionUtils.size(lists) > 0) {
				flash.error("system has already contains a user called %s ", user.username);
				render(URLMapping.USER_MANAGER_USER_FORM, user);
			} else {
				user.save();
				flash.success("User save successfully.");
				list(null);
			}
		} else {
			validation.addError("rePassword", "the password and re-password don't match");
			render(URLMapping.USER_MANAGER_USER_FORM, user);
		}

	}

	public static void view(Long id) {
		User user = User.findById(id);
		render(URLMapping.USER_MANAGER_USER_FORM, user);
	}

	public static void update(User user) {
		user.save();
		flash.success("User update successfully.");
		list(null);
	}

	public static void delete() {
		Long[] ids = params.get("ids", Long[].class);
		if (ids != null && ids.length > 0) {
			List<User> users = User.find(JPASQL.USER_FIND_BY_IDS).bind("ids", ids).fetch();
			for (User user : users) {
				user.delete();
			}
		}
		flash.success("User delete successfully.");
		list(null);
	}

}