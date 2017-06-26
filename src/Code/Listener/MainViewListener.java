package Code.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Code.Modle.NameId;
import View.ManageCardView;
import View.SelectCardView;
/**
 * 主页面监听事件
 *
 */
public class MainViewListener {
	private NameId loginUserInfo;
	private JLabel starGame;
	private JLabel lookRole;
	private JLabel drawACard;
	private JLabel quiteGame;
	private JFrame frame;
	
	public MainViewListener(JFrame frame,JLabel starGame, JLabel lookRole, JLabel drawACard, JLabel quiteGame,NameId loginUserInfo) {
		super();
		this.starGame = starGame;
		this.lookRole = lookRole;
		this.drawACard = drawACard;
		this.quiteGame = quiteGame;
		this.loginUserInfo = loginUserInfo;
		this.frame = frame;
	}

	public void cilickListener(){
		starGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "开发中！", "提示",
						JOptionPane.ERROR_MESSAGE);
			}
		});
		lookRole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null, "开发中！", "提示",
//						JOptionPane.ERROR_MESSAGE);
				frame.setVisible(false);
				ManageCardView manage = new ManageCardView(loginUserInfo);
			}
		});
		drawACard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SelectCardView select = new SelectCardView(loginUserInfo);
			}
		});
		quiteGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
	}
	
}
