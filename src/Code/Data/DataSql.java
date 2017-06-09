package Code.Data;

import java.util.ArrayList;
import java.util.List;

import Code.Modle.Camp;
import Code.Modle.NameId;
import Code.Modle.OnePiecePerson;

public class DataSql {
		/**
		 * 数据存储类==SQL
		 * */
		//现有用户数据
	protected List<NameId> id = new ArrayList<NameId>();
		
		//记录当前登录账号
		protected NameId nowId = new NameId();
		//角色记录
		protected List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();
		/**
		 * 初始化现有用户
		 * */
		protected void nameIdInIt() {
			role.add(new OnePiecePerson("蒙奇·D·路飞", 100, "男", "草帽海贼团", "船长", "橡胶果实"));
			role.add(new OnePiecePerson("罗罗诺亚·索隆", 100, "男", "草帽海贼团", "船员", "三刀流剑士"));
			id.add(new NameId("张自强", role));
		}
		/**
		 * 初始化现有阵营
		 * */
		protected List<Camp> campData = new ArrayList<Camp>();
		
		protected void campDataInIt(){
			campData.add(new Camp("海贼"));
			campData.add(new Camp("死神"));
			campData.add(new Camp("火影"));
		}
		/**
		 * 打印现有阵营
		 * */
		protected void campDataPrint(){
			for (int i = 0; i < campData.size(); i++) {
				System.out.print((i+1)+"."+campData.get(i).getCamp()+"\t");
			}
			System.out.println();
		}
}
