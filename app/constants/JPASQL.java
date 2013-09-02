package constants;

public class JPASQL {

	// User mapping
	public static String USER_FIND_ALL = "from User order by username";
	public static String USER_LOGIN = "from User where username = ? and password = ? ";
	public static String USER_USERNAME_AVAILABLE = "from User where username = ? ";
	public static String USER_FIND_BY_IDS = "from User where id in (:ids)";

	// Facility mapping
	public static String FACILITY_FIND_ALL = "from Facility order by name";
	public static String FACILITY_FIND_BY_IDS = "from Facility where id in (:ids)";
	
	
	// Event mapping
	public static String EVENT_FIND_ALL = "from Event order by id desc";
	public static String EVENT_FIND_BY_IDS = "from Event where id in (:ids)";
	
	
	// Feedback mapping
	public static String FEEDBACK_FIND_ALL = "from Feedback order by id desc";
	public static String FEEDBACK_FIND_BY_IDS = "from Feedback where id in (:ids)";
	public static String FEEDBACK_FIND_BY_ANSWER_IDS = "from Answer where id in (:ids)";
	
	
	// Bulletin mapping
	public static String CIRCULAR_FIND_ALL = "from Circular order by name";
	public static String CIRCULAR_FIND_BY_IDS = "from Circular where id in (:ids)";
}
