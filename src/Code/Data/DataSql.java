package Code.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Code.SetData;
import Code.Modle.NameId;
import Code.Modle.RolePereson;

/**
 * 初始化数据内容
 * 可用于恢复出厂设置
 * */
public class DataSql {
	/**
	 * 用户相对路径
	 * */
	final String userInfoPath = "/Code/Data/userInfo.txt";
	/**
	 * 角色相对路径
	 * */
	final String rolePeresonPath = "/Code/Data/rolePereson.txt";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DataSql test = new DataSql();
		test.resetRolePereson();
		test.resetUserInfo();
	}
	/**
	 * 创建角色数据并写入txt
	 * */
	public void resetRolePereson(){
		ObjectOutputStream oos = null;
		
		try {
			String path = this.getClass().getResource(rolePeresonPath).getFile();
			File file = new File(path);
			if(!file.exists()){
				file.createNewFile();
			}
			List<RolePereson> role = new ArrayList<RolePereson>();
			role.add(new RolePereson("SSS级","蒙奇·D·路飞",100,"橡皮人","草帽海贼团","船长","橡胶果实"));
			role.add(new RolePereson("SSS级","罗罗诺亚·索隆",100,"路痴","草帽海贼团","剑士","三刀流剑术"));
			role.add(new RolePereson("SSS级","波斯卡特·D·艾斯",100,"海贼王之子","白胡子海贼团","第三队队长","烧烧果实"));
			role.add(new RolePereson("SSS级","黑崎一护",100,"命运之子","现世","瀞灵庭外派员","斩月"));
			role.add(new RolePereson("SSS级","蓝染忽右介",100,"破面之主","瀞灵庭","五番队队长","镜花水月"));
			role.add(new RolePereson("SSS级","乌尔奇奥拉·西法",100,"破面十刃","虚圈","虚无","黑翼大魔（二段归刃）"));
			role.add(new RolePereson("SSS级","漩涡鸣人",100,"九尾妖狐","火之村","下忍","忍之密卷"));
			role.add(new RolePereson("SSS级","宇智波·佐助",100,"因陀罗转世","火之村","下忍","写轮眼"));
			role.add(new RolePereson("SSS级","卡卡西",100,"暗部","火之村","精英上忍","血继限界"));
			role.add(new RolePereson("SS级","娜美",100,"小贼猫","草帽海贼团","航海士","天候棒"));
			role.add(new RolePereson("SS级","香吉士",100,"杀手家族","草帽海贼团","厨子","黑足"));
			role.add(new RolePereson("SS级","甚平",100,"鱼人","太阳海贼团","原七武海","空气道"));
			role.add(new RolePereson("SS级","妮可·罗宾",100,"恶魔之子","草帽海贼团","历史学家","花花果实"));
			role.add(new RolePereson("SS级","朽木·露琪亚",100,"朽木族女","瀞灵庭","十三番队副队长","袖白雪"));
			role.add(new RolePereson("SS级","市丸银",100,"蛇","瀞灵庭","三番队队长","银枪"));
			role.add(new RolePereson("SS级","更木剑八",100,"战斗狂人","瀞灵庭","十一番队队长","浅打（无解）"));
			role.add(new RolePereson("SS级","三本元柳斎重国",100,"瀞灵庭元老","瀞灵庭","一番队队长","流忍若火"));
			role.add(new RolePereson("SS级","朽木·白哉",100,"朽木第二十八代族长","瀞灵庭","六番队队长","千本樱"));
			role.add(new RolePereson("SS级","石田龙雨",100,"灭却师","现世","一户好友","灵弓弧雀"));
			role.add(new RolePereson("SS级","茶渡泰虎",100,"一户好友","现世","完现术","巨人右臂/恶魔左臂"));
			role.add(new RolePereson("SS级","井上织姬",100,"一户好友","现世","神之力量","盾舜六花"));
			role.add(new RolePereson("SS级","春野·樱",100,"医疗忍者","火之村","下忍","百豪之印"));
			role.add(new RolePereson("SS级","日向宁次",100,"天才少年","火之村","下忍","白眼"));
			role.add(new RolePereson("SS级","我爱罗",100,"沙之守鹤","沙之村","下忍","控砂术"));
			role.add(new RolePereson("SS级"," 李洛克",100,"热血","火之村","下忍","八门遁甲"));
			role.add(new RolePereson("S级","托尼托尼·乔巴",100,"驯鹿","草帽海贼团","船医","人人果实"));
			role.add(new RolePereson("S级"," 弗兰奇",100,"人造人","草帽海贼团","船工","各种热武器"));
			role.add(new RolePereson("S级"," 布鲁克",100,"白骨","草帽海贼团","音乐家","黄泉果实"));
			role.add(new RolePereson("S级","自来也",100,"三忍","火之村","精英上忍","通灵之术"));
			role.add(new RolePereson("S级","大蛇丸",100,"三忍","火之村","精英上忍","通灵之术"));
			role.add(new RolePereson("S级"," 纲手",100,"三忍","火之村","精英上忍","通灵之术"));
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 对象序列化，写入输出流
			oos.writeObject(role);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{

			try {
				if (oos != null) {
					oos.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}         			
		
		}
		
	}
	
	/**
	 * 创建用户信息并写入txt
	 * */
	public void resetUserInfo(){

		ObjectOutputStream oos = null;
		
		try {
			String path = this.getClass().getResource(userInfoPath).getFile();
			File file = new File(path);
			if(!file.exists()){
				file.createNewFile();
			}
			List<NameId> userInfo = new ArrayList<NameId>();
			oos = new ObjectOutputStream(new FileOutputStream(file));
			//初始化用户角色
			List<RolePereson> role = new ArrayList<RolePereson>();
			role.add(new RolePereson("SSS级","蒙奇·D·路飞",100,"橡皮人","草帽海贼团","船长","橡胶果实"));
			role.add(new RolePereson("SSS级","罗罗诺亚·索隆",100,"路痴","草帽海贼团","剑士","三刀流剑术"));
			
			
			userInfo.add(new NameId("张自强","123","草帽海贼团",role));
			userInfo.add(new NameId("123","123","死神",role));
			// 对象序列化，写入输出流
			oos.writeObject(userInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{

			try {
				if (oos != null) {
					oos.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}         			
		
		}
	}
	
	
}
