package Code.Listener;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Code.SetData;
import Code.Modle.NameId;
import Code.Modle.RolePereson;
import View.MainView;
import View.SelectCardView;

public class SelectCardListener extends JLabel{
	private NameId loginUserInfo;
	private JLabel goback;
	private JLabel gitCard;
	private JFrame frame;
	public SelectCardListener(JFrame frame,JLabel goback, JLabel gitCard,NameId loginUserInfo) {
		this.goback = goback;
		this.gitCard = gitCard;
		this.loginUserInfo = loginUserInfo;
		this.frame = frame;
	}
	
	public void cilickListener(){
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				MainView main =new MainView(loginUserInfo);
				main.loginUserInfo = loginUserInfo;
			}
		});
		gitCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null, "开发中！", "提示",
//						JOptionPane.ERROR_MESSAGE);
				//new ManageCardView(loginUserInfo);
				SetData data = new SetData();
				//取得牌库里的卡牌数据
				List<RolePereson> cardRole = new ArrayList<RolePereson>();
				cardRole = data.getRolePereson();
				//随机产生一个卡牌
				int index = (int)(Math.random()*cardRole.size());
				//提示抽到的什么
				JOptionPane.showMessageDialog(null, "您抽到了一张"+cardRole.get(index).getName(), "提示",
						JOptionPane.ERROR_MESSAGE);
				//讲随机产生的数据存入数据库
				List<RolePereson> tempRole = new ArrayList<RolePereson>();
				tempRole = loginUserInfo.getRole();
				tempRole.add(cardRole.get(index));
				loginUserInfo.setRole(tempRole);
				//取得数据库内用户信息
				List<NameId> user = new ArrayList<NameId>();
				user = data.getUserInfo();
				for (int i = 0; i < user.size(); i++) {
					if(user.get(i).getId().equals(loginUserInfo.getId())){
						user.get(i).setRole(loginUserInfo.getRole());
						break;
					}
				}
				//修改后的用户写入数据库
				data.setUserInfo(user);
				
				
				
			}
		});
	}
}
