package controllers;

import java.util.Date;

import models.About;
import models.Circular;

import org.apache.commons.lang.time.DateFormatUtils;

import play.data.validation.Valid;
import constants.URLMapping;

public class Abouts extends Basic {


	public static void create() {
		render(URLMapping.CIRCULAR_MANAGER_CIRCULAR_FORM);
	}

	public static void save(@Valid About about) {
		if (!validation.hasErrors()) {
			if (about.id == null) {
				about.date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
				flash.success("About save successfully.");
			}else{
				flash.success("About update successfully.");
			}
			about.save();
			edit(about.id);
		} else {
			render(URLMapping.ABOUT_MANAGER_ABOUT_FORM, about);
		}
	}

	public static void edit(Long id) {
		About about = About.findById(id);
		render(URLMapping.ABOUT_MANAGER_ABOUT_FORM, about);
	}
	
	public static void view(Long id) {
		About about = About.findById(id);
		render(URLMapping.ABOUT_ABOUT_FORM, about);
	}

}