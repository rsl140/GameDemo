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
	public NameId loginUserInfo;//��½�˺�
	static final int WIDTH=500;
    static final int HEIGHT=600;
	
	public MainView(NameId loginUserInfo){
		setTitle("��ӭ "+loginUserInfo.getId()+" ������Ҷ����磡");
		setSize(WIDTH, HEIGHT);
		
		//����ҳ�������ʾλ��
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
