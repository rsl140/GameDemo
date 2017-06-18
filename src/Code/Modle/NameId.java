package Code.Modle;

import java.io.Serializable;
import java.util.List;

/*
 * 鐢ㄦ埛ID/甯愬彿
 */
public class NameId implements Serializable{

	String id;// 用户名
	String sec="123";//密码
	String camp;//阵营
	List<OnePiecePerson> role;// 包含角色

	public NameId() {

	}

	public NameId(String id, String sec, String camp, List<OnePiecePerson> role) {
		super();
		this.id = id;
		this.sec = sec;
		this.camp = camp;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSec() {
		return sec;
	}

	public void setSec(String sec) {
		this.sec = sec;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public List<OnePiecePerson> getRole() {
		return role;
	}

	public void setRole(List<OnePiecePerson> role) {
		this.role = role;
	}


}
