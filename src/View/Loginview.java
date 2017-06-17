package View;

import javax.swing.JFrame;

import Code.AddBackgroundImage;
import Code.SetFrameCenter;
import Code.SetStyle;
import Code.Listener.LoginListener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;

public class Loginview extends JFrame{
	//����һ��JLayeredPane���ڷֲ�ġ�  
    JLayeredPane layeredPane;  
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//������ʾ���ݵ�panel
    
	public Loginview(){
		super("�������Ҷ�");
	    
	    layeredPane=new JLayeredPane();  
	    //ͼƬ·��
        image=new ImageIcon(this.getClass().getResource("/img/login.png").getFile());        
        //��������
        bgjp=new JPanel();
	    bgjp = new AddBackgroundImage().addBgImg(bgjp,image, 0, -3);
        
        //��ʾ��
        showjp = new JPanel();
        showjp.setBounds(145,334,549,136); 
        showjp.setOpaque(false);//����Ϊ͸��
        showjp.setLayout(null);//ȡ��Ĭ����ʽ
        
        //�ı���͸��
        JTextField username = new JTextField("�����û���");
        JPasswordField password = new JPasswordField("��������");
        JTextField getFocus = new JTextField();//����ʱĬ�ϻ�ý�����
        getFocus.setBounds(800, 10, 0, 0);
        
        //������ʾ��������
        password.setEchoChar('\0');
        
        SetStyle sytle = new SetStyle();
        sytle.setTextOpaque(username, 15, 86, 220, 45, new Font("����", Font.PLAIN, 20));
        sytle.setPwdTextOpaque(password, 260, 86, 220, 45, new Font("����", Font.PLAIN, 20));
        
        //��½��ť
        JButton submit = new JButton();
        sytle.setButtonOpaque(submit, 494, 3, 50, 58, new Font("����", Font.PLAIN, 20));
        
        //ע����ʾ
        JLabel reguster = new JLabel("New user?");
        //�����»���
        JLabel regusterClick = new JLabel("<HTML><U>Reguster here!</U></HTML>");
        //����������ʽ
        reguster.setFont(new Font("Serif", Font.PLAIN, 18));
        regusterClick.setFont(new Font("Serif", Font.BOLD, 18));
        //�����»��߲�����������ɫ
        regusterClick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regusterClick.setForeground(Color.WHITE);
        //��λ
        reguster.setBounds(140, 0, 80, 30);
        regusterClick.setBounds(223, 0, 120, 30);
        
        
        showjp.add(username);
        showjp.add(password);
        showjp.add(submit);
        showjp.add(getFocus);
        showjp.add(reguster);
        showjp.add(regusterClick);
        
        //��bgjp�ŵ���ײ㡣
        layeredPane.add(bgjp,JLayeredPane.DEFAULT_LAYER);
        //��ʾ�Ķ���������һ��
        layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
        
        
        
        
        this.setLayeredPane(layeredPane);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(image.getIconWidth(),image.getIconHeight());
        this.setUndecorated(true);//ɾ��title
        this.setResizable(false);//���ܷŴ�
        
        //����
        SetFrameCenter center = new SetFrameCenter();
        center.Center(this, image.getIconWidth(), image.getIconHeight());
        //�¼�
  		LoginListener listener = new LoginListener(username,password,submit,this,regusterClick);
  		username.addActionListener(listener);
  		password.addActionListener(listener);
  		submit.addActionListener(listener);
  		listener.setTextReminder();
  		listener.setPwdReminder();
  		listener.goToRegusterFram();

  		setVisible(true);
		getFocus.requestFocusInWindow();//ҳ����غ��ý���
		
		
		
	}
	public static void main(String[] args) {
		new Loginview();
	}
}
