package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * UserBean
 */
public class User {

	// id INT PRIMARY KEY AUTO_INCREMENT,
	// email VARCHAR(50),
	// username VARCHAR(20),
	// PASSWORD VARCHAR(20),
	// sex VARCHAR(20),
	// telephone VARCHAR(20),
	// introduce VARCHAR(100)

	private int id;
	private String email;
	private String username;
	private String password;
	private String sex;
	private String telephone;
	private String introduce;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", sex=" + sex + ", telephone="
				+ telephone + ", introduce=" + introduce + "]";
	}

	// 校验方法
	public Map<String, String> validate() {
		Map<String, String> map = new HashMap<String, String>();
		
		if(email==null||email.trim().length()==0){
			map.put("email.msg", "邮箱不能为空");
		}
		
		if(username==null||username.trim().length()==0){
			map.put("username.msg", "用户名不能为空");
		}
		if(password==null||password.trim().length()==0){
			map.put("password.msg", "密码不能为空");
		}
		
		
		return map;
	}

}
