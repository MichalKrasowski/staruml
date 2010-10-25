package org.star.uml.designer.service.uvo;

public class RepositoryDetails {
	private String repository, dbClass, url, user, password;

	public RepositoryDetails(String repository, String dbClass, String url, String user, String password) {
		this.repository = repository;
		this.dbClass = dbClass;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getRepository() {
		return repository;
	}
	
	public String getDBClass() {
		return dbClass;
	}

	public String getURL() {
		return url;
	}
	
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	public String getResource() {
		return String.valueOf(System.currentTimeMillis());
	}
}
