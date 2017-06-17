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
 * 对数据进行读取以及修改
 * */
public class SetData {
	/**
	 * 用户相对路径
	 * */
	final String userInfoPath = "/Code/Data/userInfo.txt";
	/**
	 * 角色相对路径
	 * */
	final String rolePeresonPath = "/Code/Data/rolePereson.txt";

	/**
	 * 从txt读取角色
	 * */
	public List<RolePereson> getRolePereson(){
		ObjectInputStream ois=null;
		List<RolePereson> role = null;
		try {
			//创建ObjectInputStream输入流
			ois=new ObjectInputStream(new FileInputStream(this.getClass().getResource(rolePeresonPath).getFile()));
			//反序列化，强转类型
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
	 * 从txt读取用户信息
	 * */
	public List<NameId> getUserInfo(){
		ObjectInputStream ois=null;
		List<NameId> userInfo = null;
		try {
			//创建ObjectInputStream输入流
			ois=new ObjectInputStream(new FileInputStream(this.getClass().getResource(userInfoPath).getFile()));
			//反序列化，强转类型
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
	 * 修改角色信息txt
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
	 * 修改用户信息txt
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
	
	/**
	 * 查找是否有此用户
	 * @param name 需要查找的角色名字
	 * @return 返回查找到的下标 -1表示没有找到
	 */
	public int findUserInfo(String name){
		int flag = -1;//存储查找到的下标
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
