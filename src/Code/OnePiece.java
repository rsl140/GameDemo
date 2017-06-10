package Code;

/**
 * @闃佃惀锛氳崏甯芥捣璐煎洟
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Code.Modle.*;

public class OnePiece extends OnePiecePerson {

	public Scanner input = new Scanner(System.in);

	boolean ck = true;

	List<OnePiecePerson> caoMao = new ArrayList<OnePiecePerson>();

	public OnePiece() {
	}

	public OnePiece(String name, int blood, String sex, String camp, String job, String skill) {
		super(name, blood, sex, camp, job, skill);
	}

	/*
	 * 姓名赋值
	 */
	public void showInfo() {
		/*
		 * 给予数组初始
		 */
		caoMao.add(new OnePiecePerson("蒙奇·D·路飞", 100, "男", "草帽海贼团", "船长", "橡胶果实"));
		caoMao.add(new OnePiecePerson("罗罗诺亚·索隆", 100, "男", "草帽海贼团", "船员", "三刀流剑士	"));
		caoMao.add(new OnePiecePerson("娜美", 100, "女", "草帽海贼团", "航海士", "天候棒"));
		caoMao.add(new OnePiecePerson("山治", 100, "男", "草帽海贼团", "船厨", "赤足"));
		caoMao.add(new OnePiecePerson("乌索普", 100, "男", "草帽海贼团", "狙击手", "弹弓"));
		caoMao.add(new OnePiecePerson("托尼托尼·乔巴", 100, "驯鹿", "草帽海贼团", "船医", "人人果实"));
		caoMao.add(new OnePiecePerson("妮可·罗宾", 100, "女", "草帽海贼团", "历史学家", "果实"));
		caoMao.add(new OnePiecePerson("弗兰奇", 100, "男", "草帽海贼团", "船匠", "人造人"));
		caoMao.add(new OnePiecePerson("布鲁克", 100, "骷髅", "草帽海贼团", "音乐家", "黄泉果实"));
		/*
		 * 菜单循环
		 */
		do {
			System.out.println("**********草帽海贼团**********");
			System.out.println("草帽海贼团目前共" + caoMao.size() + "人");
			System.out.println("***********详细数据***********");
			show(caoMao);

			addcaoMao();
			System.out.println("是否继续：");
			System.out.println("(1.继续/2.退出)");
			int choose = input.nextInt();
			if (choose == 1) {
				ck = true;
			} else if (choose == 2) {
				ck = false;
				break;
			} else {
				System.out.println("选择错误！请重新输入");
				ck = true;
			}
		} while (ck);

		System.exit(0);
	}

	/*
	 * 显示循环
	 */
	public static void show(List<OnePiecePerson> caoMao) {
		for (OnePiecePerson caoMao1 : caoMao) {
			System.out.println("阵营：" + caoMao1.getCamp());
			System.out.println("\t职责：" + caoMao1.getJob());
			System.out.println("\t\t姓名：" + caoMao1.getName());
			System.out.println("\t\t生命值：" + caoMao1.getBlood());
			System.out.println("\t\t性别：" + caoMao1.getSex());
			System.out.println("\t\t能力：" + caoMao1.getSkill());

		}
	}

	/*
	 * 输入调用
	 */
	void addcaoMao() {
		System.out.println("请输入添加成员：");
		System.out.println("阵营：");
		String camp = input.next();
		System.out.println("职责：");
		String job = input.next();
		System.out.println("姓名：");
		String name = input.next();
		System.out.println("性别：");
		String sex = input.next();
		System.out.println("能力：");
		String skill = input.next();
		OnePiecePerson a = new OnePiecePerson(name, 100, sex, camp, job, skill);
		caoMao.add(a);
	}

	void ranDom(List<OnePiecePerson> caoMao) {
		//for (int i = 0; i < caoMao.size(); i++) {
		int i=(int) (Math.random()*8);
			System.out.println("阵营：" + ((caoMao.get(i))).getCamp());
			System.out.println("\t职责：" + ((caoMao.get(i))).getJob());
			System.out.println("\t\t姓名：" + ((caoMao.get(i))).getName());
			System.out.println("\t\t生命值：" + ((caoMao.get(i))).getBlood());
			System.out.println("\t\t性别：" + ((caoMao.get(i))).getSex());
			System.out.println("\t\t能力：" + ((caoMao.get(i))).getSkill());
		//}
	}
}
