package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String loginId;
	private String pass;
	private int id;
	private String name;
	private Date birthDate;
	private String createDate;
	private String updateDate;

	public User(String loginId, String pass, int id,
			String name, Date birthDate, String createDate, String updateDate) {
		this.loginId = loginId;
		this.pass = pass;
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public User(String loginId, String name, Date birthDate) {
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public User(String loginId) {
		this.loginId = loginId;
	}



	public User(String loginId, String name, Date birthDate, String createDate, String updateDate) {
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getLoginId() { return loginId; }
	public String getPass() { return pass; }
	public int getId() { return id; }
	public String getName() { return name; }
	public Date getBirthDate() { return birthDate; }
	public String getCreateDate() { return createDate; }
	public String getUpdateDate() { return updateDate; }

	public String getBirthDateStr() {
		 String str;
		 if(birthDate != null) {
			 str = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
		 } else {
			 str = "";
		 }
		return str;
	}
}
