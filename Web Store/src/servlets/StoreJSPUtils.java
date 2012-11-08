package servlets;

public class StoreJSPUtils {
	
	public static String formatErrorPage(String error) {
		StringBuilder sb = new StringBuilder();
		sb.append("<title>Error</title>\n");
		sb.append("<head><body>\n");
		sb.append("<h1>" + error + "</h1>\n");
		sb.append("</head></body>");
		return sb.toString();
	}

}
