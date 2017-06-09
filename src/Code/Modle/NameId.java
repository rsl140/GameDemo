package Code.Modle;

import java.util.List;

/*
 * 用户ID/帐号
 */
public class NameId {

	String id;// 用户名
	String camp;//阵营
	List<OnePiecePerson> role;// 包含角色

	public NameId() {

	}


	public NameId(String id, String camp) {
		super();
		this.id = id;
		this.camp = camp;
	}


	public NameId(String id, List<OnePiecePerson> role) {
		super();
		this.id = id;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<OnePiecePerson> getRole() {
		return role;
	}

	public void setRole(List<OnePiecePerson> role) {
		this.role = role;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

}
