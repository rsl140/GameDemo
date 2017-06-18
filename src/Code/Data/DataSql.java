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
 * ��ʼ����������
 * �����ڻָ���������
 * */
public class DataSql {
	/**
	 * �û����·��
	 * */
	final String userInfoPath = "/Code/Data/userInfo.txt";
	/**
	 * ��ɫ���·��
	 * */
	final String rolePeresonPath = "/Code/Data/rolePereson.txt";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DataSql test = new DataSql();
		test.resetRolePereson();
		test.resetUserInfo();
	}
	/**
	 * ������ɫ���ݲ�д��txt
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
			role.add(new RolePereson("SSS��","���桤D��·��",100,"��Ƥ��","��ñ������","����","�𽺹�ʵ"));
			role.add(new RolePereson("SSS��","����ŵ�ǡ���¡",100,"·��","��ñ������","��ʿ","����������"));
			role.add(new RolePereson("SSS��","��˹���ء�D����˹",100,"������֮��","�׺��Ӻ�����","�����Ӷӳ�","���չ�ʵ"));
			role.add(new RolePereson("SSS��","����һ��",100,"����֮��","����","�s��ͥ����Ա","ն��"));
			role.add(new RolePereson("SSS��","��Ⱦ���ҽ�",100,"����֮��","�s��ͥ","�巬�Ӷӳ�","����ˮ��"));
			role.add(new RolePereson("SSS��","�ڶ������������",100,"����ʮ��","��Ȧ","����","�����ħ�����ι��У�"));
			role.add(new RolePereson("SSS��","��������",100,"��β����","��֮��","����","��֮�ܾ�"));
			role.add(new RolePereson("SSS��","���ǲ�������",100,"������ת��","��֮��","����","д����"));
			role.add(new RolePereson("SSS��","������",100,"����","��֮��","��Ӣ����","Ѫ���޽�"));
			role.add(new RolePereson("SS��","����",100,"С��è","��ñ������","����ʿ","����"));
			role.add(new RolePereson("SS��","�㼪ʿ",100,"ɱ�ּ���","��ñ������","����","����"));
			role.add(new RolePereson("SS��","��ƽ",100,"����","̫��������","ԭ���亣","������"));
			role.add(new RolePereson("SS��","�ݿɡ��ޱ�",100,"��ħ֮��","��ñ������","��ʷѧ��","������ʵ"));
			role.add(new RolePereson("SS��","��ľ��¶����",100,"��ľ��Ů","�s��ͥ","ʮ�����Ӹ��ӳ�","���ѩ"));
			role.add(new RolePereson("SS��","������",100,"��","�s��ͥ","�����Ӷӳ�","��ǹ"));
			role.add(new RolePereson("SS��","��ľ����",100,"ս������","�s��ͥ","ʮһ���Ӷӳ�","ǳ���޽⣩"));
			role.add(new RolePereson("SS��","����Ԫ�����ع�",100,"�s��ͥԪ��","�s��ͥ","һ���Ӷӳ�","��������"));
			role.add(new RolePereson("SS��","��ľ������",100,"��ľ�ڶ�ʮ�˴��峤","�s��ͥ","�����Ӷӳ�","ǧ��ӣ"));
			role.add(new RolePereson("SS��","ʯ������",100,"��ȴʦ","����","һ������","�鹭��ȸ"));
			role.add(new RolePereson("SS��","���̩��",100,"һ������","����","������","�����ұ�/��ħ���"));
			role.add(new RolePereson("SS��","����֯��",100,"һ������","����","��֮����","��˴����"));
			role.add(new RolePereson("SS��","��Ұ��ӣ",100,"ҽ������","��֮��","����","�ٺ�֮ӡ"));
			role.add(new RolePereson("SS��","��������",100,"�������","��֮��","����","����"));
			role.add(new RolePereson("SS��","�Ұ���",100,"ɳ֮�غ�","ɳ֮��","����","��ɰ��"));
			role.add(new RolePereson("SS��"," �����",100,"��Ѫ","��֮��","����","���Ŷݼ�"));
			role.add(new RolePereson("S��","�������ᡤ�ǰ�",100,"ѱ¹","��ñ������","��ҽ","���˹�ʵ"));
			role.add(new RolePereson("S��"," ������",100,"������","��ñ������","����","����������"));
			role.add(new RolePereson("S��"," ��³��",100,"�׹�","��ñ������","���ּ�","��Ȫ��ʵ"));
			role.add(new RolePereson("S��","����Ҳ",100,"����","��֮��","��Ӣ����","ͨ��֮��"));
			role.add(new RolePereson("S��","������",100,"����","��֮��","��Ӣ����","ͨ��֮��"));
			role.add(new RolePereson("S��"," ����",100,"����","��֮��","��Ӣ����","ͨ��֮��"));
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// �������л���д�������
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
	 * �����û���Ϣ��д��txt
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
			//��ʼ���û���ɫ
			List<RolePereson> role = new ArrayList<RolePereson>();
			role.add(new RolePereson("SSS��","���桤D��·��",100,"��Ƥ��","��ñ������","����","�𽺹�ʵ"));
			role.add(new RolePereson("SSS��","����ŵ�ǡ���¡",100,"·��","��ñ������","��ʿ","����������"));
			
			
			userInfo.add(new NameId("����ǿ","123","��ñ������",role));
			userInfo.add(new NameId("123","123","����",role));
			// �������л���д�������
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
