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

import Code.SetData;
import Code.Modle.Camp;
import Code.Modle.NameId;
import Code.Modle.RolePereson;

public class RegisterView extends JFrame{
	static final int WIDTH=280;
    static final int HEIGHT=230;
    
    public RegisterView() {

		//JFrame frames = new JFrame("注册大乱斗");//新建一个顶层容器
    	setTitle("注册大乱斗");
		setSize(WIDTH, HEIGHT);//设置容器的宽度和高度
		setResizable(false);
		JPanel panel = new JPanel();
		
		add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		JLabel NameId = new JLabel("用户名：");
		JLabel pwd = new JLabel("密   码：");
		JLabel secondpwd = new JLabel("确认密码：");
		JLabel campLable = new JLabel("选择阵营：");
		//创建提示语
		JLabel vrNameId = new JLabel();
		JLabel vrpwd = new JLabel();
		JLabel vrsecondpwd = new JLabel();
		//阵营选择
		JComboBox camp = new JComboBox();
		camp.addItem("无私");
		camp.addItem("无畏");
		camp.addItem("诚实");
		camp.addItem("友好");
		camp.addItem("博学");
		
		JTextField idName = new JTextField();
		JPasswordField idPassword = new JPasswordField();
		JPasswordField idPassword2 = new JPasswordField();
		
		JButton zhuce = new JButton("注册");
		//设置页面显示位置
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        setLocation(x,y);
        //设置内容在panel里的坐标
		NameId.setBounds(25, 20, 80, 30);
		pwd.setBounds(25, 50, 80, 30);
		secondpwd.setBounds(25, 80, 80, 30);
		campLable.setBounds(25, 110, 80, 30);
		//提示语
		vrNameId.setBounds(200, 20, 80, 30);
		vrpwd.setBounds(200, 50, 80, 30);
		vrsecondpwd.setBounds(200, 80, 80, 30);
		//输入框
		idName.setBounds(80, 20, 120, 30);
		idPassword.setBounds(80, 50, 120, 30);
		idPassword2.setBounds(80, 80, 120, 30);
		//按钮
		zhuce.setBounds(100, 160, 80, 20);
		//选择阵营
		camp.setBounds(80, 115, 120, 20);
		
		//添加到panel中
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
		
		//逻辑代码块
		zhuce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//重置提示语
				vrNameId.setText("");
				vrpwd.setText("");
				vrsecondpwd.setText("");
				//读取数据库内容
				SetData data = new SetData();
				List<NameId> userInfo = new ArrayList<NameId>();
				userInfo = data.getUserInfo();
				boolean isHave = false;
				//判断是否为空
				if(idName.getText().trim().length() == 0){
					vrNameId.setText("不能为空！");
				}else{
					//查找是否有此人
					for (int i = 0; i < userInfo.size(); i++) {
						if(userInfo.get(i).getId().equals(idName.getText())){
							vrNameId.setText("已存在！");
							isHave = true;
							break;
						}
					}
					
					if(!isHave){
						vrNameId.setText("");
						String pwd1 = new String(idPassword.getPassword());
						String pwd2 = new String(idPassword2.getPassword());
						if(pwd1.length() == 0){
							vrsecondpwd.setText("不能为空！");
						}else if(!pwd1.equals(pwd2)){
							vrsecondpwd.setText("密码不一致！");
						}else{
							//新增一个用户信息
							NameId addName = new NameId();
							addName.setId(idName.getText());
							addName.setPwd(pwd1);
							addName.setCamp(camp.getSelectedItem().toString());
							List<RolePereson> role = new ArrayList<RolePereson>();
							role.add(new RolePereson("A级","小明",100,"平民","新手村","普通","乱拳"));
							addName.setRole(role);
							MainView mainLogin = new MainView(addName);
							//新增当前登陆用户并写入数据库
							userInfo.add(addName);
							data.setUserInfo(userInfo);
							//mainLogin.loginUserInfo = addName;
							setVisible(false);
						}
					}
				}
				
			}
		});
	
	}
}
