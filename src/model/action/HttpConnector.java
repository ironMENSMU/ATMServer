package model.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpConnector {

	public HttpConnector() {
	}

	public static void buildHttpConnection(String toUrl,
			String query) {

		String destination = toUrl;
		String charset = "UTF-8";
		URLConnection connection = null;
		try {
			connection = new URL(destination).openConnection();
		} catch (MalformedURLException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		connection.setDoOutput(true);
		connection.setRequestProperty("Accept-Charset", charset);
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset=" + charset);
		OutputStream output = null;

		try {
			output = connection.getOutputStream();
			output.write(query.getBytes(charset));
			
			InputStream theResponse = connection.getInputStream();
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			//if (output != null)
				try {
					output.close();
				} catch (IOException logOrIgnore) {
					System.out.println(logOrIgnore.toString());
				}
		}
	}
}
