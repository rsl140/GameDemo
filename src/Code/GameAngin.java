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
				System.out.println("·�ɶ�һ��ʹ�����𽺻���ǹ��һ��" + sb.getBlood() + "���˺�");
				blood = blood - sb.getBlood();
				if (blood <= 0) {
					System.out.println("һ������");
					break;
				}
			} else if (i % 2 != 0) {
				System.out.println("һ����·��ʹ�����Ƶ������ף������" + sb.getBlood() + "���˺�");
				blood = blood - sb.getBlood();
				if (blood <= 0) {
					System.out.println("�������");
					System.out.println("�r(���� ��)�q	���Ϊʲô��ô�ˣ�");
					System.out.println("��Ҳ��֪��ѽ���� (*+�n+*)~@	");
					System.out.println("*\\(^_^)//*	˵�õ���Ź⻷�أ�");
					System.out.println("�⻷û�о��������뵽ʱ������ b����������d	");
					break;
				}
			}
		}
		System.out.println("�Ƿ����ս����Y/N��");
		String choose = input.next();
		if ("y".equals(choose) || "Y".equals(choose)) {
			play();
		} else {
			meun.mainMeun();
		}
	}
}
