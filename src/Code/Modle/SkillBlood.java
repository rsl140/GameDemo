package Code.Modle;
/**
 * @鎶�鑳戒激瀹冲��
 */
public class SkillBlood {

	private String skill;
	private int blood;
	
	public SkillBlood(){}
	
	SkillBlood(String skill,int blood){
		this.skill=skill;
		this.blood=blood;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	
}
