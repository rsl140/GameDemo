package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Code.Data.*;
import Code.Modle.*;

public class Meun extends DataSql {

	public Scanner input = new Scanner(System.in);

	/**
	 * �������ݿ�
	 */
	public Meun() {
		nameIdInIt();
		this.campDataInIt();
	}

	/**
	 * ��¼����
	 */
	public void hasRole() {
		System.out.println("��ӭ�����������Ҷ�");
		System.out.println("���Ǵ���1�����ǲ���2����");
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
			System.out.println("��ѡ��1/2����");
			hasRole();
			// }
			// } catch (InputMismatchException ex) {
			// System.out.println("�������");
			// hasRole();
		}
	}

	/**
	 * ������
	 */
	void mainMeun() {
		System.out.println("�R��Q	��żݵ�����");
		System.out.println("��������<��	<��	<��	<��	");
		System.out.println("���ơ�����(�� ����)(���� ��)��");
		System.out.println("1.��ʼ��Ϸ");
		System.out.println("2.��ɫ����");
		System.out.println("3.����Ա��¼");
		System.out.println("0.�˳�");
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
	 * ��ɫ����ҳ��
	 */
	void roleMnue() {
		System.out.println("1.�鿴");
		System.out.println("2.����");
		System.out.println("3.�ֽ�");
		System.out.println("0.������һ��");
		int choose = input.nextInt();

		switch (choose) {
		case 1:
			for (OnePiecePerson roles : nowId.getRole()) {
				System.out.println("��Ӫ��" + roles.getCamp());
				System.out.println("\tְ��" + roles.getJob());
				System.out.println("\t\t������" + roles.getName());
				System.out.println("\t\t����ֵ��" + roles.getBlood());
				System.out.println("\t\t�Ա�" + roles.getSex());
				System.out.println("\t\t������" + roles.getSkill());
			}
			roleMnue();
			break;
		case 2:
			// System.out.println("������..");
			// roleMnue();
			boolean chen = false;
			do {
				System.out.println("�Ƿ�ʼ���ƣ���Y/N��");
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
			System.out.println("������..");
			roleMnue();
			break;
		case 0:
			mainMeun();
			break;
		default:
			System.out.println("��ѡ��1/2/3/0����");
			roleMnue();
		}
	}

	/**
	 * �ж��û��Ƿ�ӵ�н�ɫ
	 */
	void hasHave() {
		if (role.size() == 0) {
			AddNew();
		}
	}

	/**
	 * ����ҵ�½
	 */
	void login() {
		int count=1;
		System.out.println("��Ĵ�����ʲô��");
		String idNum = input.next();
		for (int i = 0; i < id.size(); i++) {
			if (idNum.equals(id.get(i).getId())) {
				mainMeun();
				break;
			} else {
				System.out.println("�Ҳ�֪������˭��\n����������ȥ\n");
				System.out.println("(*+�n+*)~@	");
				System.out.println("(*+�n+*)~@	");
				System.out.println("(*+�n+*)~@	");
				System.out.println("");
				hasRole();
			}
		}
		
		
	}

	/**
	 * �����ע��
	 */
	void AddNew() {
		System.out.println("���������ʲô��");
		String idNum = input.next();
		for (int i = 0; i < id.size(); i++) {
			if (idNum.equals(id.get(i).getId())) {
				System.out.println("���д˽�ɫ����");
				AddNew();
				break;
			}
		}
		AddNewRoleInit(idNum);
		System.out.println("�����ɹ���");
		mainMeun();
	}

	/**
	 * ע��ɹ�ѡ����Ӫ����ʼ����ɫ
	 */
	void AddNewRoleInit(String name) {
		NameId nameid = new NameId();
		List<OnePiecePerson> nameRole = new ArrayList<OnePiecePerson>();
		nameid.setId(name);
		System.out.println("��ѡ����Ӫ��");

		this.campDataPrint();

		int choose = input.nextInt();
		switch (choose) {
		case 1:
			nameid.setCamp(this.campData.get(choose - 1).getCamp());
			System.out.println("��ý�ɫ��·�ɡ�");
			nameRole.add(new OnePiecePerson("���桤D��·��", 100, "��", nameid.getCamp(), "����", "�𽺹�ʵ"));
			break;
		case 2:
			nameid.setCamp(this.campData.get(choose - 1).getCamp());
			System.out.println("��ý�ɫ������һ����");
			nameRole.add(new OnePiecePerson("����һ��", 100, "��", nameid.getCamp(), "���͵�", "�d��"));
			break;
		case 3:
			nameid.setCamp(this.campData.get(choose - 1).getCamp());
			System.out.println("��ý�ɫ���������ˡ�");
			nameRole.add(new OnePiecePerson("��������", 100, "��", nameid.getCamp(), "�ݸ�", "������֮��"));
			break;
		default:
			System.err.println("������ѡ��");
			AddNewRoleInit(name);
		}
		nameid.setRole(nameRole);
		id.add(nameid);
		nowId = nameid;
	}

	/**
	 * ��ʼ��Ϸ
	 */
	void play() {
		GameAngin ga=new GameAngin();
		ga.play();
	}
	
	/**
	 * ����Ա��¼
	 */
	void admin(){
		System.out.println("��λ��");
		String adminName=input.next();
		System.out.println("���ϵ����ѣ�");
		String codeKey=input.next();
		if("admin".equals(adminName)&&"�����ǵػ�".equals(codeKey)){
			System.out.println("���������");
			System.out.println("ʧ����ʧ����");
			System.out.println("��������ʲô�أ�");
			System.out.println("\t1.�ҵ㶫��\n\t2.�ŵ㶫��\n\t3.���㶫��\n\t4.���㶫��\n\t0.��ͽ�ı�");
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
