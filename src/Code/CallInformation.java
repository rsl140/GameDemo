package Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Code.Modle.NameId;
import Code.Modle.OnePiecePerson;

public class CallInformation {

	/**
	 * 用户相对路径
	 */
	final String userInfoPath = "/Code/Data/userInfo.txt";
	/**
	 * 角色相对路径
	 */
	final String OnePiecePersonPath = "/Code/Data/OnePiecePerson.txt";

	/**
	 * 创建用户信息并录入txt
	 */
	public void OutPutRole() {
		ObjectOutputStream oop = null;
		try {
			String site = CallInformation.class.getResource(OnePiecePersonPath).getFile();
			File file = new File(site);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();
			role.add(new OnePiecePerson("SSS级", "蒙奇·D·路飞", 100, "橡皮人", "草帽海贼团", "船长", "橡胶果实"));
			role.add(new OnePiecePerson("SSS级", "罗罗诺亚·索隆", 100, "路痴", "草帽海贼团", "剑士", "三刀流剑术"));
			role.add(new OnePiecePerson("SSS级", "波斯卡特·D·艾斯", 100, "海贼王之子", "白胡子海贼团", "第三队队长", "烧烧果实"));
			role.add(new OnePiecePerson("SSS级", "黑崎一护", 100, "命运之子", "现世", "瀞灵庭外派员", "斩月"));
			role.add(new OnePiecePerson("SSS级", "蓝染忽右介", 100, "破面之主", "瀞灵庭", "五番队队长", "镜花水月"));
			role.add(new OnePiecePerson("SSS级", "乌尔奇奥拉·西法", 100, "虚无", "虚圈", "十刃之四", "黑翼大魔（二段归刃）"));
			role.add(new OnePiecePerson("SSS级", "漩涡鸣人", 100, "九尾妖狐", "火之村", "下忍", "忍之密卷"));
			role.add(new OnePiecePerson("SSS级", "宇智波·佐助", 100, "因陀罗转世", "火之村", "下忍", "写轮眼"));
			role.add(new OnePiecePerson("SSS级", "卡卡西", 100, "暗部", "火之村", "精英上忍", "血继限界"));
			role.add(new OnePiecePerson("SS级", "娜美", 100, "小贼猫", "草帽海贼团", "航海士", "天候棒"));
			role.add(new OnePiecePerson("SS级", "香吉士", 100, "杀手家族", "草帽海贼团", "厨子", "黑足"));
			role.add(new OnePiecePerson("SS级", "甚平", 100, "鱼人", "太阳海贼团", "原七武海", "空气道"));
			role.add(new OnePiecePerson("SS级", "妮可·罗宾", 100, "恶魔之子", "草帽海贼团", "历史学家", "花花果实"));
			role.add(new OnePiecePerson("SS级", "朽木露琪亚", 100, "朽木族女", "瀞灵庭", "十三番队副队长", "袖白雪"));
			role.add(new OnePiecePerson("SS级", "市丸银", 100, "蛇", "瀞灵庭", "三番队队长", "银枪"));
			role.add(new OnePiecePerson("SS级", "更木剑八", 100, "战斗狂人", "瀞灵庭", "十一番队队长", "浅打（无解）"));
			role.add(new OnePiecePerson("SS级", "浦原喜助", 100, "浦原商店", "现世", "店长", "红姬"));
			role.add(new OnePiecePerson("SS级", "四枫院夜一", 100, "四枫院家第二十二代族长", "瀞灵庭", "隐秘机动队队长", "体术"));
			role.add(new OnePiecePerson("SS级", "山本元柳斎重国", 100, "瀞灵庭元老", "瀞灵庭", "一番队队长", "流忍若火"));
			role.add(new OnePiecePerson("SS级", "朽木白哉", 100, "朽木家第二十八代族长", "瀞灵庭", "六番队队长", "千本樱"));
			role.add(new OnePiecePerson("SS级", "石田龙雨", 100, "灭却师", "现世", "一户好友", "灵弓弧雀"));
			role.add(new OnePiecePerson("SS级", "茶渡泰虎", 100, "一户好友", "现世", "完现术", "巨人右臂/恶魔左臂"));
			role.add(new OnePiecePerson("SS级", "井上织姬", 100, "一户好友", "现世", "神之力量", "盾舜六花"));
			role.add(new OnePiecePerson("SS级", "春野·樱", 100, "医疗忍者", "火之村", "下忍", "百豪之印"));
			role.add(new OnePiecePerson("SS级", "日向宁次", 100, "天才少年", "火之村", "下忍", "八卦掌回天"));
			role.add(new OnePiecePerson("SS级", "我爱罗", 100, "沙之守鹤", "沙之村", "下忍", "控砂术"));
			role.add(new OnePiecePerson("SS级", " 李洛克", 100, "热血", "火之村", "下忍", "八门遁甲"));
			role.add(new OnePiecePerson("S级", "托尼托尼·乔巴", 100, "驯鹿", "草帽海贼团", "船医", "人人果实"));
			role.add(new OnePiecePerson("S级", " 弗兰奇", 100, "人造人", "草帽海贼团", "船工", "各种热武器"));
			role.add(new OnePiecePerson("S级", " 布鲁克", 100, "白骨", "草帽海贼团", "音乐家", "黄泉果实"));
			role.add(new OnePiecePerson("S级", "自来也", 100, "三忍", "火之村", "精英上忍", "通灵之术"));
			role.add(new OnePiecePerson("S级", "大蛇丸", 100, "三忍", "火之村", "精英上忍", "通灵之术"));
			role.add(new OnePiecePerson("S级", "纲手", 100, "三忍", "火之村", "精英上忍", "通灵之术"));
			role.add(new OnePiecePerson("S级", "雀部长次郎", 100, "贵族", "瀞灵庭", "一番队副队长", "严灵丸"));
			role.add(new OnePiecePerson("SS级", "碎蜂", 100, "蜂家第九代传人", "瀞灵庭", "二番队队长", "雀蜂"));
			role.add(new OnePiecePerson("S级", "大前田希千代", 100, "吃货", "瀞灵庭", "二队番副队长", "五形头"));
			role.add(new OnePiecePerson("A级", "吉良井鶴", 100, "远征队", "瀞灵庭", "三队番副队长", "侘助"));
			role.add(new OnePiecePerson("SS级", "卯之花烈", 100, "女性死神协会理事长", "瀞灵庭", "四番队队长", "肉雫唼（水无月）"));
			role.add(new OnePiecePerson("S级", "虎彻勇音", 100, "女性死神协会理事", "瀞灵庭", "四番队副队长", "冻云"));
			role.add(new OnePiecePerson("A级", "雏森桃", 100, "花痴", "瀞灵庭", "五番队副队长", "飞梅"));
			role.add(new OnePiecePerson("SS级", "狛村左阵", 100, "狼人", "瀞灵庭", "七番队队长", "天谴"));
			role.add(new OnePiecePerson("A级", "铁左卫门射场", 100, "孝子", "瀞灵庭", "七番队副队长", "不详"));
			role.add(new OnePiecePerson("SS级", "京乐春水", 100, "懒癌患者", "瀞灵庭", "八番队队长", "花天狂骨"));
			role.add(new OnePiecePerson("A级", "伊势七绪", 100, "学霸女", "瀞灵庭", "八番队副队长", "不详"));
			role.add(new OnePiecePerson("SS级", "东仙要", 100, "瞎子", "瀞灵庭", "九番队队长", "清虫-阎魔蟋蟀"));
			role.add(new OnePiecePerson("S级", "桧佐木修兵", 100, "正派", "瀞灵庭", "九番队副队长", "风死"));
			role.add(new OnePiecePerson("SSS级", "日番谷冬狮郎", 100, "小白", "瀞灵庭", "十番队队长", "大红莲冰轮丸"));
			role.add(new OnePiecePerson("A级", "松本乱菊", 100, "御姐", "瀞灵庭", "十番队副队长", "灰猫"));
			role.add(new OnePiecePerson("SS级", "草鹿八千流", 100, "护庭十三队最强的副队长", "瀞灵庭", "十一番队副队长", "从未拔刀"));
			role.add(new OnePiecePerson("SS级", "涅茧利", 100, "科学狂人", "瀞灵庭", "十二番队队长", "疋杀地藏"));
			role.add(new OnePiecePerson("A级", "涅音梦", 100, "人造人", "瀞灵庭", "十二番队副队长", "鬼道"));
			role.add(new OnePiecePerson("SS级", "浮竹十四郎", 100, "病痨", "瀞灵庭", "十三番队队长", "双鱼理"));
			role.add(new OnePiecePerson("S级", "斑目一角", 100, "战斗狂人", "瀞灵庭", "十一番队第三席", "龙纹鬼灯丸"));
			role.add(new OnePiecePerson("A级", "绫濑川弓亲", 100, "臭美", "瀞灵庭", "十一番队第五席", "琉璃孔雀"));
			role.add(new OnePiecePerson("B级", "山田花太郎", 100, "胆小", "瀞灵庭", "上级救护班班长", "瓠丸"));
			role.add(new OnePiecePerson("S级", "柯雅泰·史塔克", 100, "孤独", "虚圈", "十刃之一", "群狼"));
			role.add(new OnePiecePerson("S级", "拜勒岗·鲁伊森邦", 100, "衰老", "虚圈", "十刃之二", "髑髅大帝"));
			role.add(new OnePiecePerson("A级", "蒂雅·赫丽贝尔", 100, "牺牲", "虚圈", "十刃之三", "皇鲛后"));
			role.add(new OnePiecePerson("A级", "诺伊特拉·吉尔加", 100, "绝望", "虚圈", "十刃之五", "圣哭螳螂"));
			role.add(new OnePiecePerson("SS级", "葛力姆乔·贾卡杰克", 100, "破坏", "虚圈", "十刃之六", "豹王"));
			role.add(new OnePiecePerson("S级", "牙密", 100, "愤怒", "虚圈", "十刃之零", "愤兽"));
			role.add(new OnePiecePerson("SS级", "孙悟空", 100, "赛亚人", "", "", ""));
			role.add(new OnePiecePerson("", "", 100, "", "", "", ""));
			role.add(new OnePiecePerson("", "", 100, "", "", "", ""));
			role.add(new OnePiecePerson("", "", 100, "", "", "", ""));
			role.add(new OnePiecePerson("", "", 100, "", "", "", ""));
			role.add(new OnePiecePerson("A级", "绸屋雨", 100, "浦原商店", "现世", "店员", "巨力之拳"));
			role.add(new OnePiecePerson("A级", "握菱鉄斎", 100, "浦原商店", "现世", "店员", "缚道99"));
			role.add(new OnePiecePerson("B级", "小椿仙太郎", 100, "大嗓门", "现世", "护廷十三队十三番队第三席", "无"));
			role.add(new OnePiecePerson("B级", "握菱鉄斎", 100, "浦原商店", "现世", "店员", "缚道99"));
			// 实例化输入流
			oop = new ObjectOutputStream(new FileOutputStream(file));
			// 序列化写入
			oop.writeObject(role);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					oop.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	

	public void OutPutUesr() {
		ObjectOutputStream oop = null;
		try {
			String site = CallInformation.class.getResource(userInfoPath).getFile();
			File file = new File(site);
			if (!file.exists()) {
				file.createNewFile();
			}
			List<NameId> uesrName = new ArrayList<NameId>();
			oop = new ObjectOutputStream(new FileOutputStream(file));
			List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();

			role.add(new OnePiecePerson("SSS级", "罗罗诺亚·索隆", 100, "路痴", "草帽海贼团", "剑士", "三刀流剑术"));
			role.add(new OnePiecePerson("SS级", "更木剑八", 100, "战斗狂人", "瀞灵庭", "十一番队队长", "浅打（无解）"));

			uesrName.add(new NameId("张自强", "hage", "海贼", role));

			oop.writeObject(uesrName);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					oop.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	

	/**
	 * 从txt读取角色
	 */
	public List<OnePiecePerson> getRole() {
		ObjectInputStream oos = null;
		List<OnePiecePerson> role = null;
		try {
			oos = new ObjectInputStream(
					new FileInputStream(CallInformation.class.getResource(OnePiecePersonPath).getFile()));
			// 反序列化，强制转换
			role = (List<OnePiecePerson>) oos.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return role;

	}

	/**
	 * 从txt读取用户信息
	 */
	public List<NameId> getName() {
		ObjectInputStream oos = null;
		List<NameId> uesr = null;

		try {
			oos = new ObjectInputStream(new FileInputStream(CallInformation.class.getResource(userInfoPath).getFile()));
			// 反序列化，强制转换
			uesr = (List<NameId>) oos.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return uesr;
	}

	/**
	 * 修改角色信息到txt
	 */
	public void setRole(List<OnePiecePerson> role) {
		ObjectOutputStream oop = null;
		try {
			String site = CallInformation.class.getResource(OnePiecePersonPath).getFile();
			File file = new File(site);
			if (!file.exists()) {
				file.createNewFile();
			}
			oop = new ObjectOutputStream(new FileOutputStream(file));
			oop.writeObject(role);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oop != null) {
					oop.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	/**
	 * 修改用户信息到txt
	 */
	public void setName(List<NameId> uesr) {
		ObjectOutputStream oop = null;
		try {
			String site = CallInformation.class.getResource(userInfoPath).getFile();
			File file = new File(site);
			if (!file.exists()) {
				file.createNewFile();
			}
			oop = new ObjectOutputStream(new FileOutputStream(file));
			oop.writeObject(uesr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oop != null) {
					oop.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CallInformation test = new CallInformation();
		test.OutPutRole();
		test.OutPutUesr();
	}
}
