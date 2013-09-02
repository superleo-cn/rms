package jobs;

import java.util.UUID;

import models.Facility;

import constants.Constants;

import play.Play;
import play.Play.Mode;
import play.cache.Cache;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class InitApplication extends Job {

	public void doJob() {
		if (Play.mode == Mode.DEV) {
			Play.secretKey = UUID.randomUUID().toString();
		}
	}
}