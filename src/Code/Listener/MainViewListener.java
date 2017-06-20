package Code.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	public MainViewListener(JLabel starGame, JLabel lookRole, JLabel drawACard, JLabel quiteGame,NameId loginUserInfo) {
		super();
		this.starGame = starGame;
		this.lookRole = lookRole;
		this.drawACard = drawACard;
		this.quiteGame = quiteGame;
		this.loginUserInfo = loginUserInfo;
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
				ManageCardView manage = new ManageCardView(loginUserInfo);
			}
		});
		drawACard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectCardView select = new SelectCardView();
				select.loginUserInfo = loginUserInfo;
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
