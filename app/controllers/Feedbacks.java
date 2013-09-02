package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import models.Answer;
import models.Feedback;
import models.ModelHelper;
import models.User;
import play.cache.Cache;
import play.data.validation.Valid;
import utils.DateUtils;
import utils.PaginationList;
import constants.Constants;
import constants.JPASQL;
import constants.URLMapping;

public class Feedbacks extends Basic {
	public static void list(PaginationList paginationList) {
		String sql = "from Feedback where 1=1 ";
		List parameters = new ArrayList();
		Long userId = Long.parseLong(session.get(Constants.CURRENT_USERID));
		String type = session.get(Constants.CURRENT_USERTYPE);
		if(userId != null && !StringUtils.equalsIgnoreCase(type, Constants.USERTYPE_MGR)){
			sql += " and user.id = ? ";
			parameters.add(userId);
		}
		sql += " order by id desc";
		paginationList = ModelHelper.initPaginationList(paginationList);
		paginationList.setPageSize(10);
		paginationList = ModelHelper.pagination(sql, paginationList, parameters.toArray());
		render(URLMapping.FEEDBACK_MANAGER_FEEDBACKS, paginationList);
	}

	public static void save(@Valid Feedback feedback) {
		if(!validation.hasErrors()){
			feedback.createDate = DateUtils.toString(new Date(), DateUtils.DATE_TIME_FORMAT);
			feedback.save();
			renderText("success");
		}else{
			renderText("error");
		}
	}
	
	public static void answer(@Valid Answer answer) {
		if(!validation.hasErrors()){
			answer.createDate = DateUtils.toString(new Date(), DateUtils.DATE_TIME_FORMAT);
			answer.save();
			renderText("success");
		}else{
			renderText("error");
		}
	}

	public static void view(Long id) {
		Feedback feedback = Feedback.findById(id);
		render(URLMapping.FEEDBACK_MANAGER_FEEDBACK_ANSWER_FORM, feedback);
	}

	public static void delete(Long[] ids) {
		if (ids != null && ids.length > 0) {
			List<Feedback> facilities = Feedback.find(JPASQL.FEEDBACK_FIND_BY_IDS).bind("ids", ids).fetch();
			for (Feedback feedback : facilities) {
				Feedback.em().remove(feedback);
			}
		}
		list(null);
	}
	
	public static void deleteAnswers(Long id, Long []ids) {
		if (ids != null && ids.length > 0) {
			List<Answer> answers = Answer.find(JPASQL.FEEDBACK_FIND_BY_ANSWER_IDS).bind("ids", ids).fetch();
			for (Answer answer : answers) {
				answer.delete();
			}
		}
		view(id);
	}
}