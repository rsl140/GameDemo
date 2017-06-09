package Code.Modle;
/**
 * @人物技能
 */
import java.util.List;

public class Skill {

	private String name;
	private List<SkillBlood> skill;
	
	Skill(){}
	
	Skill(String name, List<SkillBlood> skill){
		this.name=name;
		this.skill=skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SkillBlood> getSkill() {
		return skill;
	}

	public void setSkill(List<SkillBlood> skill) {
		this.skill = skill;
	}
	
	
}
