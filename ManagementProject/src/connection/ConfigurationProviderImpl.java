package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProviderImpl implements ConfigurationProvider{

	@Override
	public Properties getProperties() {
		Properties props = new Properties();
		InputStream input = null;
		try {
			File file = new File ("config.properties");
			input = new FileInputStream(file);
			props.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return props;
	}

}
