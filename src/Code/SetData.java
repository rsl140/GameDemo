package Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Code.Modle.*;



/*
 * �����ݽ��ж�ȡ�Լ��޸�
 * */
public class SetData {
	/**
	 * �û����·��
	 * */
	final String userInfoPath = "/Code/Data/userInfo.txt";
	/**
	 * ��ɫ���·��
	 * */
	final String rolePeresonPath = "/Code/Data/rolePereson.txt";

	/**
	 * ��txt��ȡ��ɫ
	 * */
	public List<RolePereson> getRolePereson(){
		ObjectInputStream ois=null;
		List<RolePereson> role = null;
		try {
			//����ObjectInputStream������
			ois=new ObjectInputStream(new FileInputStream(this.getClass().getResource(rolePeresonPath).getFile()));
			//�����л���ǿת����
			role=(List<RolePereson>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (ois != null) {
					ois.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}  
		}
		return role;
	}


	/**
	 * ��txt��ȡ�û���Ϣ
	 * */
	public List<NameId> getUserInfo(){
		ObjectInputStream ois=null;
		List<NameId> userInfo = null;
		try {
			//����ObjectInputStream������
			ois=new ObjectInputStream(new FileInputStream(this.getClass().getResource(userInfoPath).getFile()));
			//�����л���ǿת����
			userInfo=(List<NameId>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (ois != null) {
					ois.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}  
		}
		return userInfo;
	}

	/**
	 * �޸Ľ�ɫ��Ϣtxt
	 * */
	public void setRolePereson(List<RolePereson> role){
		ObjectOutputStream oos = null;
		
		try {
			String path = this.getClass().getResource(rolePeresonPath).getFile();
			File file = new File(path);
			if(!file.exists()){
				file.createNewFile();
			}
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
	 * �޸��û���Ϣtxt
	 * */
	public void setUserInfo(List<NameId> userInfo){

		ObjectOutputStream oos = null;
		
		try {
			String path = this.getClass().getResource(userInfoPath).getFile();
			File file = new File(path);
			if(!file.exists()){
				file.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(file));
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
	
	/**
	 * �����Ƿ��д��û�
	 * @param name ��Ҫ���ҵĽ�ɫ����
	 * @return ���ز��ҵ����±� -1��ʾû���ҵ�
	 */
	public int findUserInfo(String name){
		int flag = -1;//�洢���ҵ����±�
		SetData data = new SetData();
		List<NameId> userInfo = new ArrayList<NameId>();
		userInfo = data.getUserInfo();
		for (int i = 0; i < userInfo.size(); i++) {
			if(userInfo.get(i).getId().equals(name)){
				flag = i;
				break;
			}
		}
		return flag;
	}
}
