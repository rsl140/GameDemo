package Code.Modle;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * @角色信息
 */
public class RolePereson implements Serializable{

	String lever;//卡牌等级
	String name;// 姓名
	int blood;// 血量
	String sex;// 性别
	String camp;// 阵营
	String job;// 职能
	String skill;// 技能


	/*
	 * 构造方法
	 */
	public RolePereson() {
	}

	/*
	 * 构造函数
	 */
	public RolePereson(String lever,String name, int blood, String sex, String camp, String job, String skill) {
		super();
		this.lever = lever;
		this.name = name;
		this.blood = blood;
		this.sex = sex;
		this.camp = camp;
		this.job = job;
		this.skill = skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLever() {
		return lever;
	}

	public void setLever(String lever) {
		this.lever = lever;
	}
	
}
