package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Code.Data.*;
import Code.Modle.*;

public class Meun extends DataSql {

	public Scanner input = new Scanner(System.in);

	/**
	 * 启动数据库
	 */
	public Meun() {
		nameIdInIt();
		this.campDataInIt();
	}

	/**
	 * 登录界面
	 */
	public void hasRole() {
		System.out.println("欢迎来到动漫大乱斗");
		System.out.println("您是大神（1）还是菜鸟（2）：");
		// try {
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			login();
			break;
		case 2:
			AddNew();
			break;
		default:
			System.out.println("请选择（1/2）：");
			hasRole();
			// }
			// } catch (InputMismatchException ex) {
			// System.out.println("输入错误！");
			// hasRole();
		}
	}

	/**
	 * 主界面
	 */
	void mainMeun() {
		System.out.println("≧◇≦	猪脚驾到……");
		System.out.println("撒花……<※	<※	<※	<※	");
		System.out.println("鼓掌……└(￣ ￣└)(┘￣ ￣)┘");
		System.out.println("1.开始游戏");
		System.out.println("2.角色管理");
		System.out.println("3.管理员登录");
		System.out.println("0.退出");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			play();
			break;
		case 2:
			roleMnue();
			break;
		case 3:
			admin();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			mainMeun();
		}
	}

	/**
	 * 角色管理页面
	 */
	void roleMnue() {
		System.out.println("1.查看");
		System.out.println("2.抽牌");
		System.out.println("3.分解");
		System.out.println("0.返回上一级");
		int choose = input.nextInt();

		switch (choose) {
		case 1:
			for (OnePiecePerson roles : nowId.getRole()) {
				System.out.println("阵营：" + roles.getCamp());
				System.out.println("\t职责：" + roles.getJob());
				System.out.println("\t\t姓名：" + roles.getName());
				System.out.println("\t\t生命值：" + roles.getBlood());
				System.out.println("\t\t性别：" + roles.getSex());
				System.out.println("\t\t能力：" + roles.getSkill());
			}
			roleMnue();
			break;
		case 2:
			// System.out.println("开发中..");
			// roleMnue();
			boolean chen = false;
			do {
				System.out.println("是否开始抽牌？（Y/N）");
				String ch = input.next();
				if ("y".equals(ch) || "Y".equals(ch)) {
					List<OnePiecePerson> addRole = new ArrayList<OnePiecePerson>();
					addRole = nowId.getRole();
					int index = (int) (Math.random() * 8);
					OnePiece one = new OnePiece();
					one.ranDom(addRole);
					nowId.setRole(addRole);
					chen = true;
				} else {
					roleMnue();
				}
			} while (chen);

			break;
		case 3:
			System.out.println("开发中..");
			roleMnue();
			break;
		case 0:
			mainMeun();
			break;
		default:
			System.out.println("请选择（1/2/3/0）：");
			roleMnue();
		}
	}

	/**
	 * 判断用户是否拥有角色
	 */
	void hasHave() {
		if (role.size() == 0) {
			AddNew();
		}
	}

	/**
	 * 老玩家登陆
	 */
	void login() {
		int count=1;
		System.out.println("你的代号是什么？");
		String idNum = input.next();
		for (int i = 0; i < id.size(); i++) {
			if (idNum.equals(id.get(i).getId())) {
				mainMeun();
				break;
			} else {
				System.out.println("我不知道你是谁！\n滚回主界面去\n");
				System.out.println("(*+﹏+*)~@	");
				System.out.println("(*+﹏+*)~@	");
				System.out.println("(*+﹏+*)~@	");
				System.out.println("");
				hasRole();
			}
		}
		
		
	}

	/**
	 * 新玩家注册
	 */
	void AddNew() {
		System.out.println("告诉我你叫什么？");
		String idNum = input.next();
		for (int i = 0; i < id.size(); i++) {
			if (idNum.equals(id.get(i).getId())) {
				System.out.println("已有此角色名！");
				AddNew();
				break;
			}
		}
		AddNewRoleInit(idNum);
		System.out.println("创建成功！");
		mainMeun();
	}

	/**
	 * 注册成功选择阵营并初始化角色
	 */
	void AddNewRoleInit(String name) {
		NameId nameid = new NameId();
		List<OnePiecePerson> nameRole = new ArrayList<OnePiecePerson>();
		nameid.setId(name);
		System.out.println("请选择阵营：");

		this.campDataPrint();

		int choose = input.nextInt();
		switch (choose) {
		case 1:
			nameid.setCamp(this.campData.get(choose - 1).getCamp());
			System.out.println("获得角色“路飞”");
			nameRole.add(new OnePiecePerson("蒙奇·D·路飞", 100, "男", nameid.getCamp(), "船长", "橡胶果实"));
			break;
		case 2:
			nameid.setCamp(this.campData.get(choose - 1).getCamp());
			System.out.println("获得角色“黑崎一护”");
			nameRole.add(new OnePiecePerson("黑崎一护", 100, "男", nameid.getCamp(), "酱油党", "卍解"));
			break;
		case 3:
			nameid.setCamp(this.campData.get(choose - 1).getCamp());
			System.out.println("获得角色“漩涡鸣人”");
			nameRole.add(new OnePiecePerson("漩涡鸣人", 100, "男", nameid.getCamp(), "草根", "隐分身之术"));
			break;
		default:
			System.err.println("请重新选择！");
			AddNewRoleInit(name);
		}
		nameid.setRole(nameRole);
		id.add(nameid);
		nowId = nameid;
	}

	/**
	 * 开始游戏
	 */
	void play() {
		GameAngin ga=new GameAngin();
		ga.play();
	}
	
	/**
	 * 管理员登录
	 */
	void admin(){
		System.out.println("哪位？");
		String adminName=input.next();
		System.out.println("道上的朋友？");
		String codeKey=input.next();
		if("admin".equals(adminName)&&"天王盖地虎".equals(codeKey)){
			System.out.println("宝塔镇河妖");
			System.out.println("失敬！失敬！");
			System.out.println("你想做点什么呢？");
			System.out.println("\t1.找点东西\n\t2.放点东西\n\t3.换点东西\n\t4.丢点东西\n\t0.家徒四壁");
			int choose=input.nextInt();
			switch(choose){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				break;
			default:
				break;
			}
		}
		
	}
}
