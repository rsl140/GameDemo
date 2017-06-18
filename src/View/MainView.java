package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Code.AddBackgroundImage;
import Code.SetStyle;
import Code.Listener.MainViewListener;
import Code.Modle.NameId;

public class MainView extends JFrame{
	public NameId loginUserInfo;//��½�˺�
	//����һ��JLayeredPane���ڷֲ�ġ�  
    JLayeredPane layeredPane;  
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//������ʾ���ݵ�panel
	
	public MainView(NameId loginUserInfo){
		layeredPane=new JLayeredPane();
		bgjp = new JPanel();
		//���ñ���
		new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "main.jpg", 0, -3);
        //
		showjp = new JPanel();
		showjp.setBounds(290, 350, 237, 233);
		showjp.setOpaque(false);
		showjp.setLayout(null);
		JLabel hasRole = new JLabel("��ǰӵ�н�ɫ:"+loginUserInfo.getRole().size()+"��");
		JLabel starGame = new JLabel("1.��ʼ��Ϸ");
		JLabel lookRole = new JLabel("2.������");
		JLabel drawACard = new JLabel("3.��ʼ����");
		JLabel quiteGame = new JLabel("4.�˳���Ϸ");
		
		Font hasRoleFont = new Font("����", Font.BOLD, 16);
		Font lableFont = new Font("����", Font.BOLD, 24);
		Color red = Color.RED;
		Color white = Color.WHITE;
		
		SetStyle style = new SetStyle();
		style.setJlableFontStyleAndColor(hasRole, hasRoleFont, red, 40, 5, 200, 30);
		style.setJlableFontStyleAndColor(starGame, lableFont, white, 30, 40, 150, 30);
		style.setJlableFontStyleAndColor(lookRole, lableFont, white, 30, 80, 150, 30);
		style.setJlableFontStyleAndColor(drawACard, lableFont, white, 30, 120, 150, 30);
		style.setJlableFontStyleAndColor(quiteGame, lableFont, white, 30, 160, 150, 30);
		
		showjp.add(hasRole);
		showjp.add(starGame);
		showjp.add(lookRole);
		showjp.add(drawACard);
		showjp.add(quiteGame);
		
		layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
		
		//�¼�
		MainViewListener listener = new MainViewListener(starGame,lookRole,drawACard,quiteGame);
		listener.MouseInAndOut(starGame,"1.��ʼ��Ϸ");
		listener.MouseInAndOut(lookRole,"2.������");
		listener.MouseInAndOut(drawACard,"3.��ʼ����");
		listener.MouseInAndOut(quiteGame,"4.�˳���Ϸ");
		
		this.setLayeredPane(layeredPane);
        setVisible(true);
	}
}
