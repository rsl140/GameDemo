package Code.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Code.SetData;
import Code.Modle.NameId;
import View.MainView;
import View.RegisterView;

public class LoginListener implements ActionListener{
	private JTextField jtext;
	private JPasswordField jpwd;
	private JButton jbutton;
	private JFrame frame;
	private JLabel reguster;
	
	public LoginListener(JTextField jtext, JPasswordField jpwd, JButton jbutton,JFrame frame,JLabel reguster) {
		super();
		this.jtext = jtext;
		this.jpwd = jpwd;
		this.jbutton = jbutton;
		this.frame = frame;
		this.reguster = reguster;
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
				
				if(jtext.getText().equals("输入用户名") || new String(jpwd.getPassword()).equals("输入密码")){
					JOptionPane.showMessageDialog(null, "请输入用户名密码！", "提示",
							JOptionPane.ERROR_MESSAGE);
				}else{
					SetData data = new SetData();
					List<NameId> userInfo = new ArrayList<NameId>();
					userInfo = data.getUserInfo();
					//查找登陆用户的下标
					int index = data.findUserInfo(jtext.getText());
						if(index != -1){
							if(userInfo.get(index).getPwd().equals(new String(jpwd.getPassword()))){
								//登陆成功
								frame.setVisible(false);
								MainView main =new MainView(userInfo.get(index));
							}else{
								//弹窗提示
								JOptionPane.showMessageDialog(null, "密码错误", "提示",
										JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "用户名输入错误", "提示",
									JOptionPane.ERROR_MESSAGE);
						}
				}
			}
	}
	
	/**
	 * 注册
	 */
	public void goToRegusterFram(){
		reguster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new RegisterView();
			}
		});
	}

}
