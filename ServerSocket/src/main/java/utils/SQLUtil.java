package utils;

import java.util.Arrays;

public class SQLUtil {
	
	private SQLUtil() {
		
	}
	
	public static <T extends AutoCloseable> void close(T ... closeElement) {
		Arrays.stream(closeElement).forEach(element -> {
			if (element != null) {
				try {
					element.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
