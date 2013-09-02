package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Circular;
import models.ModelHelper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.h2.util.StringUtils;

import play.Logger;
import play.Play;
import play.data.validation.Valid;
import utils.PaginationList;
import constants.JPASQL;
import constants.URLMapping;

public class Circulars extends Basic {

	public static void list(PaginationList paginationList) {
		paginationList = ModelHelper.pagination(JPASQL.CIRCULAR_FIND_ALL, paginationList, new Object[] {});
		render(URLMapping.CIRCULAR_MANAGER_CIRCULARS, paginationList);
	}

	public static void create() {
		render(URLMapping.CIRCULAR_MANAGER_CIRCULAR_FORM);
	}

	public static void save(@Valid Circular circular) {
		if (!validation.hasErrors()) {
			if (circular.id == null) {
				circular.createDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
				flash.success("Circular save successfully.");
			}else{
				flash.success("Circular update successfully.");
			}
			circular.save();
			list(null);
		} else {
			render(URLMapping.CIRCULAR_MANAGER_CIRCULAR_FORM, circular);
		}
	}

	public static void edit(Long id) {
		Circular circular = Circular.findById(id);
		render(URLMapping.CIRCULAR_MANAGER_CIRCULAR_FORM, circular);
	}
	
	public static void view(Long id) {
		Circular circular = Circular.findById(id);
		render(URLMapping.CIRCULAR_CIRCULAR_FORM, circular);
	}

	public static void delete() {
		Long[] ids = params.get("ids", Long[].class);
		if (ids != null && ids.length > 0) {
			List<Circular> facilities = Circular.find(JPASQL.CIRCULAR_FIND_BY_IDS).bind("ids", ids).fetch();
			for (Circular circular : facilities) {
				circular.delete();
			}
		}
		flash.success("Circular delete successfully.");
		list(null);
	}

	public static void circularAjax() {
		String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm");
		Circular obj = Circular.find("from Circular where startDate <= ? and endDate >= ?", date, date).first();
		if(obj != null){
			renderJSON(obj);
		}else{
			renderJSON("");
		}
	}

}