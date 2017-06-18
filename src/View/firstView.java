package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import Code.CallInformation;
import Code.Modle.NameId;

public class firstView {
	static final int WIDTH = 1027;
	static final int HIGTH = 642;

	public firstView() {
	}

	public void Login() {
		String title = "动漫大乱斗";
		JFrame frame = new JFrame(title);

		frame.setSize(WIDTH, HIGTH);
		frame.setResizable(false);
		JPanel panel = new JPanel();

		frame.add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HIGTH);
		JLabel NameId = new JLabel("用户名:");
		JLabel pwd = new JLabel("密　码:");
		JLabel vrNameId = new JLabel();
		JLabel vrPwd = new JLabel();
		vrPwd.setForeground(Color.red);

		JTextArea idName = new JTextArea();
		idName.setOpaque(false);
		idName.setBorder(null);
		JPasswordField idPassword = new JPasswordField();
		idPassword.setOpaque(false);
		idPassword.setBorder(null);

		JButton login = new JButton("　　　　　");
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		JButton register = new JButton("　　　　　");
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		// 设置页面剧终显示位置
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSiz = kit.getScreenSize();
		int width = screenSiz.width;
		int heigth = screenSiz.height;
		int x = (width - WIDTH) / 2;
		int y = (heigth - HIGTH) / 2;
		frame.setLocation(x, y);
		// 设置内容在panel里的坐标
		NameId.setBounds(60, 250, 80, 30);
		pwd.setBounds(60, 290, 80, 30);
		// 提示语
		vrNameId.setBounds(365, 538, 80, 30);
		vrPwd.setBounds(590, 538, 80, 30);
		// 输入框
		idName.setBounds(395, 515, 100, 25);
		idPassword.setBounds(620, 510, 100, 25);
		// 按钮
		login.setBounds(325, 568, 160, 32);
		register.setBounds(550, 568, 160, 32);

		// idName.setColumns(16);
		// idPassword.setColumns(16);

		Icon ic = new ImageIcon("C:\\Users\\lenovo\\Desktop\\动漫人物\\登录界面.jpg");
		JLabel jl1 = new JLabel();
		jl1.setIcon(ic);
		jl1.setBounds(0, 0, WIDTH, HIGTH);

		// panel.add(NameId);
		// panel.add(pwd);
		panel.add(vrNameId);
		panel.add(vrPwd);
		panel.add(idName);
		panel.add(idPassword);
		panel.add(login);
		panel.add(register);
		panel.add(jl1);

		// panel.setVisible(true);
		frame.setVisible(true);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 重置提示语
				vrNameId.setText("");
				vrPwd.setText("");
				CallInformation data = new CallInformation();
				List<NameId> userInfo = new ArrayList<NameId>();
				userInfo = data.getName();
				for (int i = 0; i < userInfo.size(); i++) {
					if (userInfo.get(i).getId().equals(idName.getText())) {
						vrNameId.setText("");

						// 用户名密码一致则隐藏该窗口
						if (userInfo.get(i).getSec().equals(new String(idPassword.getPassword()))) {
							vrPwd.setText("");
							frame.setVisible(false);
							MainView main = new MainView(userInfo.get(i));
							main.loginUserInfo = userInfo.get(i);
							break;
						} else {
							// 提示语
							vrPwd.setText("密码错误");
						}
					} else {
						vrNameId.setText("用户名错误");
					}
				}
			}
		});
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new RegisterView();

			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		firstView fv = new firstView();
		fv.Login();
	}
}
