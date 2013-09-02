package controllers;

import inteceptors.ConstantsInterceptor;
import inteceptors.TimeInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import models.CodeTable;
import models.EventSession;
import models.Facility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import play.Logger;
import play.Play;
import play.cache.Cache;
import play.db.jpa.Model;
import play.mvc.Before;
import play.mvc.Catch;
import play.mvc.Controller;
import play.mvc.Finally;
import play.mvc.With;
import utils.PaginationList;
import constants.Constants;

@With(value = { TimeInterceptor.class, ConstantsInterceptor.class })
public class Basic extends Controller {

	@Before(unless = { "Home.login", "Home.index", "Home.logout" })
	static void checkAuthentification() {
		if (session.get(Constants.CURRENT_USERNAME) == null) {
			flash.put("error", "You need login first");
			Home.index();
		}
		//TODO: refactor
		Cache.safeSet(Constants.GLOBLE_FACILITIES, Facility.findAll(), "365d");
		Cache.safeSet(Constants.GLOBLE_EVENT_SESSIONS, EventSession.findAll(), "365d");
		Cache.safeSet(Constants.CODE_LIMIT_DAYS, CodeTable.all().first(), "365d");
	}

	@Catch(Exception.class)
	public static void exception(Throwable e) {
		Logger.error("error happend.", e);
	}

	@Finally
	public static void finalExecute() {

	}
	
	public static void uploadFile(File imgFile) {
		File file = Play.getFile("/public/uploads");
		String filename = imgFile.getName();
		Map map = new HashMap();
		try {
			FileUtils.copyFileToDirectory(imgFile, file);
			map.put("error", 0);
			map.put("url", Play.ctxPath + "/public/uploads/" + filename);
		} catch (IOException e) {
			Logger.error("upload file error", e);
			map.put("error", 1);
			map.put("url", Play.ctxPath + "/public/uploads/error.jpg");
		}
		renderJSON(map);
	}

}