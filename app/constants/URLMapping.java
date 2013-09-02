package constants;

public class URLMapping {
	
	// Login mapping
	public static String ERROR_FOLDER = "/errors";
	public static String ERROR_404 = ERROR_FOLDER + "/404.html";
	public static String ERROR_500 = ERROR_FOLDER + "/500.html";
	
	// Login mapping
	public static String HOME_FOLDER = "/pages";
	public static String LOGIN = HOME_FOLDER + "/login.html";
	public static String RESIDENT_WELCOME = HOME_FOLDER + "/resident.html";
	public static String MANAGER_WELCOME = HOME_FOLDER + "/manager.html";
	public static String APPLICATION_FORMS = HOME_FOLDER + "/forms.html";
	// Login action
	public static String LOGIN_ACTION = HOME_FOLDER + "/login.html";

	// User Manager mapping
	public static String USER_MANAGER_FOLDER = "/pages/manager";
	public static String USER_MANAGER_USERS = USER_MANAGER_FOLDER + "/users.html";
	public static String USER_MANAGER_USER_FORM = USER_MANAGER_FOLDER + "/userForm.html";
	
	// User Resident mapping
	public static String USER_RESIDENT_FOLDER = "/pages";

	// Facility Manager mapping
	public static String FACILITY_MANAGER_FOLDER = "/pages/manager";
	public static String FACILITY_MANAGER_FACILITIES = FACILITY_MANAGER_FOLDER + "/facilities.html";
	public static String FACILITY_MANAGER_FACILITY_FORM = FACILITY_MANAGER_FOLDER + "/facilityForm.html";
	
	// Event Manager mapping
	public static String EVENT_MANAGER_FOLDER = "/pages/manager";
	public static String EVENT_MANAGER_EVENTS = EVENT_MANAGER_FOLDER + "/events.html";
	
	// Feedback Manager mapping
	public static String FEEDBACK_MANAGER_FOLDER = "/pages/manager";
	public static String FEEDBACK_MANAGER_FEEDBACKS = FACILITY_MANAGER_FOLDER + "/feedbacks.html";
	public static String FEEDBACK_MANAGER_FEEDBACK_ANSWER_FORM = FACILITY_MANAGER_FOLDER + "/feedbackAnswer.html";

	// Feedback mapping
	public static String FEEDBACK_FOLDER = "/pages";
	
	// Circular Manager mapping
	public static String CIRCULAR_MANAGER_FOLDER = "/pages/manager";
	public static String CIRCULAR_MANAGER_CIRCULARS = CIRCULAR_MANAGER_FOLDER + "/circulars.html";
	public static String CIRCULAR_MANAGER_CIRCULAR_FORM = CIRCULAR_MANAGER_FOLDER + "/circularForm.html";
	
	// Circular Manager mapping
	public static String CIRCULAR_FOLDER = "/pages";
	public static String CIRCULAR_CIRCULAR_FORM = CIRCULAR_FOLDER + "/circularForm.html";
	
	
	// About Manager mapping
	public static String ABOUT_MANAGER_FOLDER = "/pages/manager";
	public static String ABOUT_MANAGER_ABOUT_FORM = ABOUT_MANAGER_FOLDER + "/aboutForm.html";
	
	// About mapping
	public static String ABOUT_FOLDER = "/pages";
	public static String ABOUT_ABOUT_FORM = ABOUT_FOLDER + "/aboutForm.html";
}
