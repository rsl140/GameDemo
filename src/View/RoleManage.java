package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Code.CallInformation;
import Code.Modle.NameId;
import Code.Modle.OnePiecePerson;

public class RoleManage extends JFrame {

	public NameId loginInfo;// 登陆账号
	public List<OnePiecePerson> rolInfo;// 角色
	static final int WIDTH = 800;
	static final int HIGTH = 600;
	String str = "";
	String ste = "";

	public RoleManage() {
		//设置顶层容器
		setSize(WIDTH, HIGTH);
		setResizable(false);
		//设置标题
		setTitle("开始游戏");
		setSize(WIDTH, HIGTH);
		// 设置页面剧中显示位置（固定格式）
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSiz = kit.getScreenSize();
		int width = screenSiz.width;
		int heigth = screenSiz.height;
		int x = (width - WIDTH) / 2;
		int y = (heigth - HIGTH) / 2;
		setLocation(x, y);
		//设置载体容器
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HIGTH);
		add(panel);
		//设置文本显示框体并隐藏
		JTextArea field = new JTextArea();
		field.setBounds(180, 0, 400, 250);
		field.setOpaque(false);
		field.setBorder(null);
		JTextArea field2 = new JTextArea();
		field2.setBounds(180, 285, 400, 250);
		field2.setOpaque(false);
		field2.setBorder(null);
		//设置按钮
		JButton one1 = new JButton("角色查看");
		// one1.setOpaque(false);
		JButton one2 = new JButton("角色抽取");
		// one2.setOpaque(false);
		JButton one3 = new JButton("角色分解");
		// one3.setOpaque(false);
		
		//角色查看按钮监听事件
		one1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginInfo.getRole().size() == 0) {
					str = "kong";
				} else {
					for (int i = 0; i < loginInfo.getRole().size(); i++) {
						str += loginInfo.getRole().get(i).getLever() + "," + loginInfo.getRole().get(i).getName() + ","
								+ loginInfo.getRole().get(i).getBlood() + "," + loginInfo.getRole().get(i).getSex()
								+ "," + loginInfo.getRole().get(i).getCamp() + "," + loginInfo.getRole().get(i).getJob()
								+ "," + loginInfo.getRole().get(i).getSkill() + "\n";
					}
				}
				field.setText(str);
			}
		});
		//角色抽取按钮监听事件
		one2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NameId addName = new NameId();
				CallInformation data = new CallInformation();
				List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();
				List<NameId> userInfo = new ArrayList<NameId>();
				rolInfo = new CallInformation().getRole();
				
				int index = (int) (1 + Math.random() * rolInfo.size());

				ste += rolInfo.get(index).getLever() + "," + rolInfo.get(index).getName() + ","
						+ rolInfo.get(index).getBlood() + "," + rolInfo.get(index).getSex() + ","
						+ rolInfo.get(index).getCamp() + "," + rolInfo.get(index).getJob() + ","
						+ rolInfo.get(index).getSkill() + "\n";

				role.add(new OnePiecePerson(rolInfo.get(index).getLever(), rolInfo.get(index).getName(),
						rolInfo.get(index).getBlood(), rolInfo.get(index).getSex(), rolInfo.get(index).getCamp(),
						rolInfo.get(index).getJob(), rolInfo.get(index).getSkill()));

				addName.setRole(role);
				userInfo.add(addName);
				data.setName(userInfo);
				// CallInformation data = new CallInformation();
				// List<OnePiecePerson> role = new ArrayList<OnePiecePerson>();
				// List<NameId> info = new ArrayList<NameId>();
				// rolInfo = data.getRole();
				// info = data.getName();
				// int index = (int) (1 + Math.random() * rolInfo.size());
				//
				// ste += rolInfo.get(index).getLever() + "," +
				// rolInfo.get(index).getName() + ","
				// + rolInfo.get(index).getBlood() + "," +
				// rolInfo.get(index).getSex() + ","
				// + rolInfo.get(index).getCamp() + "," +
				// rolInfo.get(index).getJob() + ","
				// + rolInfo.get(index).getSkill() + "\n";
				//
				// loginInfo.getRole().add(new
				// OnePiecePerson(rolInfo.get(index).getLever(),
				// rolInfo.get(index).getName(),
				// rolInfo.get(index).getBlood(), rolInfo.get(index).getSex(),
				// rolInfo.get(index).getCamp(),
				// rolInfo.get(index).getJob(), rolInfo.get(index).getSkill()));
				//
				// for (int i = 0; i < info.size(); i++) {
				// if (loginInfo.getId().equals(info.get(i).getId())) {
				// info.get(i).setRole(loginInfo.getRole());
				// break;
				// }
				// }
				// data.setName(info);
				field2.setText(ste);

			}

		});
		one1.setBounds(180, 250, 100, 25);
		one2.setBounds(300, 250, 100, 25);
		one3.setBounds(420, 250, 100, 25);

		panel.add(field);
		panel.add(one1);
		panel.add(one2);
		panel.add(one3);
		panel.add(field2);

		setVisible(true);
	}
}
