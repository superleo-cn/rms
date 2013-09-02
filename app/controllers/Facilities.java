package controllers;

import java.util.List;

import models.Facility;
import models.ModelHelper;
import play.cache.Cache;
import play.data.validation.Valid;
import utils.PaginationList;
import constants.Constants;
import constants.JPASQL;
import constants.URLMapping;

public class Facilities extends Basic {

	public static void list(PaginationList paginationList) {
		paginationList = ModelHelper.pagination(JPASQL.FACILITY_FIND_ALL, paginationList, new Object[]{});
		render(URLMapping.FACILITY_MANAGER_FACILITIES, paginationList);
	}

	public static void create() {
		render(URLMapping.FACILITY_MANAGER_FACILITY_FORM);
	}

	public static void save(@Valid Facility facility) {
		if(!validation.hasErrors()){
			if(facility.id != null){
				flash.success("Facility update successfully.");
			}else{
				flash.success("Facility save successfully.");
			}
			facility.save();
			list(new PaginationList());
			Cache.add(Constants.GLOBLE_FACILITIES, Facility.findAll());
		}else{
			render(URLMapping.FACILITY_MANAGER_FACILITY_FORM, facility);
		}
	}

	public static void view(Long id) {
		Facility facility = Facility.findById(id);
		render(URLMapping.FACILITY_MANAGER_FACILITY_FORM, facility);
	}

	public static void delete() {
		Long[] ids = params.get("ids", Long[].class);
		if (ids != null && ids.length > 0) {
			List<Facility> facilities = Facility.find(JPASQL.FACILITY_FIND_BY_IDS).bind("ids", ids).fetch();
			for (Facility facility : facilities) {
				facility.delete();
			}
		}
		list(new PaginationList());
		flash.success("Facility delete successfully.");
		Cache.add(Constants.GLOBLE_FACILITIES, Facility.findAll());
	}
	
	public static void listAjax() {
		renderJSON(Facility.findAll());
	}
}