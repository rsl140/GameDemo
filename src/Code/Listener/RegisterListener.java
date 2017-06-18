package Code.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Code.SetData;
import Code.Modle.NameId;
import Code.Modle.RolePereson;
import View.Loginview;
import View.MainView;
import View.RegisterView;

public class RegisterListener implements ActionListener{

	private JTextField jtext;
	private JPasswordField jpwd;
	private JButton jbutton;
	private JFrame frame;
	private JLabel login;
	private JComboBox jcombox;
	
	public RegisterListener(JTextField jtext, JPasswordField jpwd, JButton jbutton,JFrame frame,JLabel login,JComboBox jcombox) {
		super();
		this.jtext = jtext;
		this.jpwd = jpwd;
		this.jbutton = jbutton;
		this.frame = frame;
		this.login = login;
		this.jcombox = jcombox;
	}
	/**
	 * 给文本框增加提示内容
	 */
	public void setTextReminder(){
		jtext.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(jtext.getText().length() == 0){
					jtext.setText("输入用户名");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
					if(jtext.getText().equals("输入用户名")){
						jtext.setText("");
					}
			}
		});
	}
	/**
	 * 给密码框增加提示内容
	 */
	public void setPwdReminder(){
		jpwd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(jpwd.getPassword().length == 0){
					jpwd.setEchoChar('\0');
					jpwd.setText("输入密码");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(jpwd.getPassword()).equals("输入密码")){
					jpwd.setEchoChar('*');
					jpwd.setText("");
				}
			}
		});
	}

	
	@Override
	/**
	 * 登陆事件
	 */
	public void actionPerformed(ActionEvent e) {
		//回车事件
			if (e.getSource() == jtext || e.getSource() == jpwd || e.getSource() == jbutton){
				
				if(jtext.getText().equals("输入用户名") || jtext.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "请输入用户名", "提示",
							JOptionPane.ERROR_MESSAGE);
				}else{
					if(new String(jpwd.getPassword()).equals("输入密码") || jpwd.getPassword().length == 0){
						JOptionPane.showMessageDialog(null, "请输入密码", "提示",
								JOptionPane.ERROR_MESSAGE);
					}else{
						SetData data = new SetData();
						List<NameId> userInfo = new ArrayList<NameId>();
						userInfo = data.getUserInfo();
						//查找登陆用户的下标
						int index = data.findUserInfo(jtext.getText());
						if(index == -1){
							//新增一个用户信息
							NameId addName = new NameId();
							addName.setId(jtext.getText());
							addName.setPwd(new String(jpwd.getPassword()));
							addName.setCamp(jcombox.getSelectedItem().toString());
							List<RolePereson> role = new ArrayList<RolePereson>();
							role.add(new RolePereson("A级","小明",100,"平民","新手村","普通","乱拳"));
							addName.setRole(role);
							MainView mainLogin = new MainView(addName);
							//新增当前登陆用户并写入数据库
							userInfo.add(addName);
							data.setUserInfo(userInfo);
							//mainLogin.loginUserInfo = addName;
							frame.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "已有此用户", "提示",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			}
	}
	
	/**
	 * 注册
	 */
	public void goToRegusterFram(){
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new Loginview();
			}
		});
	}


}
