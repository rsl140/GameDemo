package Code.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Code.Modle.NameId;
import View.MainView;
import View.ManageCardView;
import View.SelectCardView;
/**
 * 主页面监听事件
 *
 */
public class ManageCardListener {
	private NameId loginUserInfo;
	private JLabel goback;
	private JFrame frame;
	
	public ManageCardListener(JFrame frame,JLabel goback,NameId loginUserInfo){
		this.frame = frame;
		this.goback = goback;
		this.loginUserInfo = loginUserInfo;
	}
	
	public void cilickListener(){
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println(loginUserInfo);
				frame.setVisible(false);
				MainView main =new MainView(loginUserInfo);
				main.loginUserInfo = loginUserInfo;
			}
		});
	}
}
