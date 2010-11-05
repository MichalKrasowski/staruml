package org.star.uml.designer.base.db;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.internal.util.BundleUtility;
import org.osgi.framework.Bundle;

public class DBConnectionManager {
	/**
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getConnectionDB(String dbClass, String url, String user,
			String password) throws Exception {

		Bundle bundle = Platform.getBundle("sobis.bpa.designer");
		URL libUrl = BundleUtility.find(bundle, "lib/ojdbc14.jar");
		URLClassLoader classLoader = URLClassLoader.newInstance(
				new URL[] { libUrl }, new DBConnectionManager().getClass()
						.getClassLoader());

		Driver driver = null;
		driver = (Driver) Class.forName(dbClass, true, classLoader)
				.newInstance();

		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);

		return driver.connect(url, info);
	}
}
