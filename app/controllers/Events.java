package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import models.CodeTable;
import models.Event;
import models.ModelHelper;
import play.cache.Cache;
import play.data.validation.Valid;
import utils.DateUtils;
import utils.PaginationList;
import constants.Constants;
import constants.JPASQL;
import constants.URLMapping;

public class Events extends Basic {

	public static void listAsJson(Long type, String start, String end) {
		String query = "from Event e where e.date >= ? and e.date <= ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(start);
		objs.add(end);
		if (type != null) {
			query += " and e.facility.id=? ";
			objs.add(type);
		}

		List<Event> events = Event.find(query, objs.toArray()).fetch();
		renderJSON(events);
	}

	public static void list(PaginationList paginationList) {
		paginationList = ModelHelper.pagination(JPASQL.EVENT_FIND_ALL, paginationList, new Object[] {});
		render(URLMapping.EVENT_MANAGER_EVENTS, paginationList);
	}

	// TODO: refactor
	public static void save(@Valid Event event) {
		Map<String, String> json = new HashMap<String, String>();
		if (!validation.hasErrors()) {
			Date today = DateUtils.toDateTimeAtStartOfDay(new Date(), DateUtils.ORA_DATES_FORMAT);
			Date eventDate = DateUtils.StringToDate(event.date, DateUtils.ORA_DATES_FORMAT);

			// check the start date
			if (today.getTime() > eventDate.getTime()) {
				json.put("flag", "error");
				json.put("message", "You may not book it in previous date.");
			} else {
				// check the limits
				CodeTable table = (CodeTable) Cache.get(Constants.CODE_LIMIT_DAYS);
				int limits = Integer.parseInt(table.value);
				int ranges = DateUtils.getDayInRange(DateUtils.StringToDate(event.date, DateUtils.ORA_DATES_FORMAT), today);
				if (ranges > limits) {
					json.put("flag", "error");
					json.put("message", "The limit of booking is within " + limits + " days.");
				} else {
					// save the record
					Event exist = Event.find("from Event where date = ? and eventSession.id = ?", event.date, event.eventSession.id).first();
					if(exist != null){
						json.put("flag", "error");
						json.put("message", "Someone has already booked it at that time.");
					}else{
						event.name = event.facility.name + "_" + event.eventSession.name + "/" + event.user.unitNo;
						event.save();
						json.put("flag", "success");
						json.put("message", "Add succefully.");
						json.put("eventId", String.valueOf(event.id));
						json.put("eventName", event.name);
						json.put("startTime", event.eventSession.startTime);
						json.put("endTime", event.eventSession.endTime);
					}
				}
			}

		} else {
			json.put("flag", "error");
			json.put("message", "Validation is error, please check your form.");
		}
		renderJSON(json);
	}

	public static void approve(Long id, String remark) {
		if (id != null) {
			Event event = Event.findById(id);
			event.color = "green";
			event.remark = remark;
			event.save();
		}
		list(null);
	}
	
	public static void approveAjax(Long id, String remark) {
		if (id != null) {
			Event event = Event.findById(id);
			event.color = "green";
			event.remark = remark;
			event.save();
		}
		renderText("success");
	}

	public static void delete() {
		Long[] ids = params.get("ids", Long[].class);
		if (ids != null && ids.length > 0) {
			List<Event> events = Event.find(JPASQL.EVENT_FIND_BY_IDS).bind("ids", ids).fetch();
			for (Event event : events) {
				event.delete();
			}
		}
		flash.success("Event delete successfully.");
		list(null);
	}

	public static void deleteById(Long id) {
		Event event = Event.findById(id);
		if (event != null) {
			Long userId = Long.parseLong(session.get(Constants.CURRENT_USERID));
			if (userId == event.user.id) {
				event.delete();
			}
		}
		renderText("success");
	}

}