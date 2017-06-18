package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Code.CallInformation;
import Code.Modle.NameId;
import Code.Modle.OnePiecePerson;

public class RegisterView extends JFrame {
	static final int WIDTH=280;
	static final int HIGTH=230;
	
	public RegisterView(){
		//设置注册标签并添加载体容器
		setTitle("注册大乱斗");
		setSize(WIDTH, HIGTH);
		setResizable(false);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HIGTH);
		//设置提示
		JLabel NameId=new JLabel("用户名：");
		JLabel pwd = new JLabel("密　码：");
		JLabel secondpwd=new JLabel("确认密码：");
		JLabel campLable=new JLabel("选择阵营：");
		
		JLabel vrNameId =new JLabel();
		JLabel vrpwd =new JLabel();
		JLabel vrsecondpwd =new JLabel();
		//设置下拉列表
		JComboBox camp=new JComboBox();
		camp.addItem("无畏派");
		camp.addItem("无私派");
		camp.addItem("诚实派");
		camp.addItem("友好派");
		camp.addItem("博学派");
		//设置文本输入框体
		JTextField idName = new JTextField();
		JPasswordField idPassword=new JPasswordField();
		JPasswordField idPassword2=new JPasswordField();
		//设置按钮
		JButton zhuce=new JButton("注册");
		// 设置页面剧中显示位置（固定格式）
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int heigth = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (heigth - HIGTH) / 2;
		setLocation(x, y);
		
		// 设置内容在panel里的坐标
		NameId.setBounds(25, 20, 80, 30);
		pwd.setBounds(25, 50, 80, 30);
		secondpwd.setBounds(25, 80, 80, 30);
		campLable.setBounds(25, 110, 80, 30);
		
		// 提示语
		vrNameId.setBounds(200, 20, 80, 30);
		vrpwd.setBounds(200, 50, 80, 30);
		vrsecondpwd.setBounds(200, 80, 80, 30);
		// 输入框
		idName.setBounds(85, 25, 120, 25);
		idPassword.setBounds(85, 55, 120, 25);
		idPassword2.setBounds(85, 85, 120, 25);
		// 按钮
		zhuce.setBounds(100, 160, 80, 20);
		//选择阵营
		camp.setBounds(85, 115, 120, 20);

		idName.setColumns(16);
		idPassword.setColumns(16);
		
		panel.add(NameId);
		panel.add(idName);
		panel.add(secondpwd);
		panel.add(vrNameId);
		panel.add(vrpwd);
		panel.add(pwd);
		panel.add(vrsecondpwd);
		panel.add(idPassword);
		panel.add(idPassword2);
		panel.add(zhuce);
		panel.add(campLable);
		panel.add(camp);
		
		panel.setVisible(true);
		setVisible(true);
		//注册监听时间
		zhuce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vrNameId.setText("");
				vrpwd.setText("");
				vrsecondpwd.setText("");
				//判断注册信息并返回序列化
				CallInformation data = new CallInformation();
				List<NameId> userInfo = new ArrayList<NameId>();
				userInfo = data.getName();
				boolean isHave = false;
				
				if(idName.getText().trim().length()==0){
					vrNameId.setText("请输入用户名");
				}else{
					for(int i=0;i<userInfo.size();i++){
						if(userInfo.get(i).getId().equals(idName.getText())){
							vrNameId.setText("用户名被占用");
							isHave = true;
							break;
						}
					}
					if(!isHave){
						vrNameId.setText("");
						String pwd1=new String(idPassword.getPassword());
						String pwd2=new String(idPassword2.getPassword());
						if(pwd1.length()==0){
							vrsecondpwd.setText("请输入密码");
						}else if(!pwd1.endsWith(pwd2)){
							vrsecondpwd.setText("两次密码输入不一致");
						}else{
							//返回序列化并储存
							NameId addName = new NameId();
							addName.setId(idName.getText());
							addName.setSec(pwd1);
							addName.setCamp(camp.getSelectedItem().toString());
							//新用户初始角色添加
							List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();
							role.add(new OnePiecePerson("SSS级", "波斯卡特·D·艾斯", 100, "海贼王之子", "白胡子海贼团", "第三队队长", "烧烧果实"));
							addName.setRole(role);
							MainView mainLogin = new MainView(addName);
							//新增当前登录用户并写入数据库
							userInfo.add(addName);
							data.setName(userInfo);
							setVisible(false);
						}
					}
				}
			}
		});
	}
	
}
