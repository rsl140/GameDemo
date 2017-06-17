package Code.Modle;

import java.io.Serializable;
import java.util.List;

/*
 * 用户ID/帐号
 */
public class NameId implements Serializable{

	String id;// �û���
	String pwd = "123";//�û�����
	String camp;//��Ӫ
	List<RolePereson> role;// ������ɫ

	public NameId() {

	}

	/**
	 * �༭�û�����Ӫ
	 * */
	public NameId(String id, String camp) {
		super();
		this.id = id;
		this.camp = camp;
	}

	/**
	 * �û��ͽ�ɫ
	 * */
	public NameId(String id, List<RolePereson> role) {
		super();
		this.id = id;
		this.role = role;
	}
	/**
	 * �û��������룬��Ӫ
	 * */
	public NameId(String id, String pwd, String camp) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.camp = camp;
	}
	/**
	 * �û��������룬��Ӫ��ӵ�н�ɫ
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
