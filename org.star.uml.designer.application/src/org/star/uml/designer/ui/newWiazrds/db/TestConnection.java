package org.star.uml.designer.ui.newWiazrds.db;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.star.uml.designer.base.constance.CustomMessages;
import org.star.uml.designer.base.db.DBConnectionManager;

public class TestConnection {

	private String serviceName = "";
	private String connectionName = "";
	private String dbVendor = ""; // ex)oracle.jdbc.driver.OracleDriver
	private String connectionType = ""; // ex)jdbc
	private String userName = ""; // ex)enkisoft
	private String password = ""; // ex)admin
	private String driver = ""; // ex)oracle:thin
	private String hostName = ""; // ex)localhost
	private String port = ""; // ex)1521
	private String sid_serviceName = ""; // ex)sid, serviceName
	private String url = ""; // ex) jdbc:oracle:thin:@192.168.10.62:1521:soa11g
	private Connection conn; // ex) Connection
	private boolean successed;

	// 테스트하기
	public String testConnection(String dbVendor, String connectionType,
			String userName, String password, String driver, String hostName,
			String port, String sid_serviceName) {

		setDbVendor(dbVendor);
		setConnectionType(connectionType);
		setUserName(userName);
		setPassword(password);
		setDriver(driver);
		setHostName(hostName);
		setPort(port);
		setSid_serviceName(sid_serviceName);

		// URL 생성
		String url = connectionType + ":" + driver + ":@" + hostName + ":"
				+ port + ":" + sid_serviceName;

		setUrl(url);

		return testConnection();

	}

	// 테스트하기
	public String testConnection(String dbVendor, String url, String userName,
			String password, String validQuery) {

		setUrl(url);
		setDbVendor(dbVendor);
		setUserName(userName);
		setPassword(password);

		return testConnection();
	}

	// 테스트하기
	public String testConnection() {

		String message = CustomMessages.DEFAULT_FAILD;

		try {
			successed = false;

			if (getUrl() == null || getUrl().equals("")) {

				// URL 생성
				String url = connectionType + ":" + driver + ":@" + hostName
						+ ":" + port + ":" + sid_serviceName;

				setUrl(url);
			}

			conn = new DBConnectionManager().getConnectionDB(getDbVendor(),
					getUrl(), getUserName(), getPassword());

		} catch (ClassNotFoundException e) {
			return CustomMessages.NOT_EXIST_DRIVER + e.getMessage();
		} catch (SQLException e) {
			return CustomMessages.ILLEGAL_ARGUMENT + e.getMessage();
		} catch (MalformedURLException e) {
			return CustomMessages.NOT_EXIST_DRIVER + e.getMessage();
		} catch (InstantiationException e) {
			return CustomMessages.NOT_EXIST_DRIVER + e.getMessage();
		} catch (IllegalAccessException e) {
			return CustomMessages.NOT_EXIST_DRIVER + e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return CustomMessages.OCCUR_ERROR + e.getMessage();
		}

		if (conn != null) {

			StringBuffer sql = new StringBuffer();
			sql.append(" select DECODE(COUNT(*), 1, 'SUCCESS', 'FAIL') RLT");
			sql.append(" from TAB");
			sql
					.append(" where TNAME IN ('USER_T')");

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();

				rs.next();
				String result = rs.getString(1);

				if (!result.equals("SUCCESS")) {
					successed = false;
					return CustomMessages.NOT_EXIST_TABLE;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					rs.close();
					pstmt = null;
					rs = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			successed = true;
			return CustomMessages.DEFAULT_SUCCESS;

		} else {
			successed = false;
		}

		return message;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSid_serviceName() {
		return sid_serviceName;
	}

	public void setSid_serviceName(String sid_serviceName) {
		this.sid_serviceName = sid_serviceName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDbVendor() {
		return dbVendor;
	}

	public void setDbVendor(String dbVendor) {
		this.dbVendor = dbVendor;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public boolean isSuccessed() {
		return successed;
	}

	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

}
