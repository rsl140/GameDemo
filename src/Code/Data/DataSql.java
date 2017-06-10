package Code.Data;

import java.util.ArrayList;
import java.util.List;

import Code.Modle.Camp;
import Code.Modle.NameId;
import Code.Modle.OnePiecePerson;

public class DataSql {
	/**
	 * ���ݴ洢��==SQL
	 * */
	//�����û�����
	protected List<NameId> id = new ArrayList<NameId>();
	
	//��¼��ǰ��¼�˺�
	protected NameId nowId = new NameId();
	//��ɫ��¼
	protected List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();
	/**
	 * ��ʼ�������û�
	 * */
	protected void nameIdInIt() {
		role.add(new OnePiecePerson("���桤D��·��", 100, "��", "��ñ������", "����", "�𽺹�ʵ"));
		role.add(new OnePiecePerson("����ŵ�ǡ���¡", 100, "��", "��ñ������", "��Ա", "��������ʿ"));
		id.add(new NameId("����ǿ", role));
	}
	/**
	 * ��ʼ��������Ӫ
	 * */
	protected List<Camp> campData = new ArrayList<Camp>();
	/**
	 * ��ֵ��ʼ����Ӫ
	 */
	protected void campDataInIt(){
		campData.add(new Camp("����"));
		campData.add(new Camp("����"));
		campData.add(new Camp("��Ӱ"));
	}
	/**
	 * ��ӡ������Ӫ
	 * */
	protected void campDataPrint(){
		for (int i = 0; i < campData.size(); i++) {
			System.out.print((i+1)+"."+campData.get(i).getCamp()+"\t");
		}
		System.out.println();
	}
}
