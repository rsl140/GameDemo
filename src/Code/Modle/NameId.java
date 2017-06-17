package Code.Modle;

import java.io.Serializable;
import java.util.List;

/*
 * 鐢ㄦ埛ID/甯愬彿
 */
public class NameId implements Serializable{

	String id;// 用户名
	String pwd = "123";//用户密码
	String camp;//阵营
	List<RolePereson> role;// 包含角色

	public NameId() {

	}

	/**
	 * 编辑用户和阵营
	 * */
	public NameId(String id, String camp) {
		super();
		this.id = id;
		this.camp = camp;
	}

	/**
	 * 用户和角色
	 * */
	public NameId(String id, List<RolePereson> role) {
		super();
		this.id = id;
		this.role = role;
	}
	/**
	 * 用户名，密码，阵营
	 * */
	public NameId(String id, String pwd, String camp) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.camp = camp;
	}
	/**
	 * 用户名，密码，阵营，拥有角色
	 * */
	public NameId(String id, String pwd, String camp, List<RolePereson> role) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.camp = camp;
		this.role = role;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RolePereson> getRole() {
		return role;
	}

	public void setRole(List<RolePereson> role) {
		this.role = role;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
