package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Code.Data.DataSql;
import Code.Modle.OnePiecePerson;
import Code.Modle.SkillBlood;

public class GameAngin {

	public Scanner input = new Scanner(System.in);
	Meun meun = new Meun();
	DataSql sql = new DataSql();
	SkillBlood sb = new SkillBlood();
	OnePiece op = new OnePiece();

	GameAngin() {
	}

	void getRole() {
	}

	void play() {
		int blood=100;
		for (int i = 1; i > 0; i++) {
			if (i % 2 == 0) {
				System.out.println("路飞对一户使用了橡胶机关枪：一户" + sb.getBlood() + "点伤害");
				blood = blood - sb.getBlood();
				if (blood <= 0) {
					System.out.println("一户阵亡");
					break;
				}
			} else if (i % 2 != 0) {
				System.out.println("一户对路飞使用了破道·闪雷：造成了" + sb.getBlood() + "点伤害");
				blood = blood - sb.getBlood();
				if (blood <= 0) {
					System.out.println("猪脚阵亡");
					System.out.println("╮(￣▽ ￣)╭	猪脚为什么这么菜？");
					System.out.println("我也不知道呀…… (*+﹏+*)~@	");
					System.out.println("*\\(^_^)//*	说好的猪脚光环呢？");
					System.out.println("光环没感觉到，光腚到时看见了 b（￣▽￣）d	");
					break;
				}
			}
		}
		System.out.println("是否继续战斗（Y/N）");
		String choose = input.next();
		if ("y".equals(choose) || "Y".equals(choose)) {
			play();
		} else {
			meun.mainMeun();
		}
	}
}
