package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Code.CallInformation;
import Code.Modle.NameId;
import Code.Modle.OnePiecePerson;

public class fightView extends JFrame {

	public NameId loginInfo;// 登陆账号
	public List<OnePiecePerson> rolInfo;// 角色
	static final int WIDTH = 800;
	static final int HIGTH = 600;
	String str = "";
	String ste = "";

	public fightView() {
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
		//设置文本显示框体
		JTextArea field = new JTextArea();
		field.setBounds(180, 0, 400, 200);
		field.setOpaque(false);
		field.setBorder(null);
		JTextArea field2 = new JTextArea();
		field2.setBounds(180, 285, 400, 200);
		field2.setOpaque(false);
		field2.setBorder(null);

		add(panel);
		//设置按钮
		JButton choose1 = new JButton("开始战斗");
		JButton choose2 = new JButton("返　　回");
		JButton refresh = new JButton("刷　　新");
		//开始战斗按钮监听事件
		choose1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rolInfo = new CallInformation().getRole();
				boolean die = false;
				int index = (int) (1 + Math.random() * loginInfo.getRole().size());
				int index1 = (int) (1 + Math.random() * rolInfo.size());
				int blood = (int) (20 + Math.random() * 40);
				int blood1 = (int) (20 + Math.random() * 40);
				int nameBlood = loginInfo.getRole().get(index).getBlood();
				int nameBlood1 = rolInfo.get(index1).getBlood();
				do {
					ste += loginInfo.getRole().get(index).getName() + "对" + rolInfo.get(index1).getName()
							+ "造成了" + blood + "点伤害\n";
					nameBlood = nameBlood - blood;
					ste += rolInfo.get(index1).getName() + "对" + loginInfo.getRole().get(index).getName()
							+ "造成了" + blood1 + "点伤害\n";
					nameBlood1 = nameBlood1 - blood;
					if (nameBlood <= 0) {
						ste += "你的对手go die了！";
						die = false;
					} else if (nameBlood1 <= 0) {
						ste += "你 go die了！";
						die = false;
					} else {
						die = true;
					}
				} while (die);
				field2.setText(ste);
				ste = null;
			}
		});
		//返回上一层监听事件
		choose2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainView mv = new MainView(loginInfo);
			}
		});
		//刷新列表监听事件
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginInfo.getRole().size() == 0) {
					str = "kong";
				} else {
					for (int i = 0; i < loginInfo.getRole().size(); i++) {
						str += loginInfo.getRole().get(i).getName() + "\n";
					}
				}
				field.setText(str);
			}
		});

		choose1.setBounds(180, 250, 100, 25);
		choose2.setBounds(300, 250, 100, 25);
		refresh.setBounds(420, 250, 100, 25);

		panel.add(field);
		panel.add(field2);
		panel.add(choose1);
		panel.add(choose2);
		panel.add(refresh);

		setVisible(true);
	}

}
