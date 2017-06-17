package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Code.Modle.NameId;

public class MainView extends JFrame{
	public NameId loginUserInfo;//登陆账号
	static final int WIDTH=500;
    static final int HEIGHT=600;
	
	public MainView(NameId loginUserInfo){
		setTitle("欢迎 "+loginUserInfo.getId()+" 进入大乱斗世界！");
		setSize(WIDTH, HEIGHT);
		
		//设置页面居中显示位置
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        setLocation(x,y);
        
        JPanel panel = new JPanel();
        //panel.setSize(WIDTH,HEIGHT);
        panel.setBounds(0, 0, WIDTH, HEIGHT);
        add(panel);
        JLabel userName = new JLabel(loginUserInfo.getId());
        panel.add(userName);
        setVisible(true);
	}
}
