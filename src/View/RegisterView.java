package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Code.AddBackgroundImage;
import Code.SetFrameCenter;
import Code.SetStyle;
import Code.Listener.RegisterListener;

public class RegisterView extends JFrame{

	//����һ��JLayeredPane���ڷֲ�ġ�  
    JLayeredPane layeredPane;  
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//������ʾ���ݵ�panel
    
	public RegisterView(){
		super("�������Ҷ�");

	    layeredPane=new JLayeredPane();
	    bgjp=new JPanel();
	    
        //��������
	    new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "login.png", 0, -3);
        
        //��ʾ��
        showjp = new JPanel();
        showjp.setBounds(145,334,549,192);
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
        sytle.setButtonOpaque(submit, 494, 80, 53, 60, new Font("����", Font.PLAIN, 20));
        
        //ע����ʾ
        JLabel reguster = new JLabel("Old user?");
        //�����»���
        JLabel regusterClick = new JLabel("<HTML><U>Login here!</U></HTML>");
        //����������ʽ
        reguster.setFont(new Font("Serif", Font.PLAIN, 18));
        regusterClick.setFont(new Font("Serif", Font.BOLD, 18));
        //�����»��߲�����������ɫ
        regusterClick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regusterClick.setForeground(Color.WHITE);
        //��λ
        reguster.setBounds(140, 0, 80, 30);
        regusterClick.setBounds(223, 0, 120, 30);
        
      //��Ӫѡ��
  		JComboBox camp = new JComboBox();
  		camp.addItem("��˽");
  		camp.addItem("��η");
  		camp.addItem("��ʵ");
  		camp.addItem("�Ѻ�");
  		camp.addItem("��ѧ");
  		camp.setBounds(185, 139, 100, 40);
        
        
        showjp.add(username);
        showjp.add(password);
        showjp.add(submit);
        showjp.add(getFocus);
        showjp.add(reguster);
        showjp.add(regusterClick);
        showjp.add(camp);
        
        //��ʾ�Ķ���������һ��
        layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
        
        this.setLayeredPane(layeredPane);
        //�¼�
        RegisterListener listener = new RegisterListener(username,password,submit,this,regusterClick,camp);
  		username.addActionListener(listener);
  		password.addActionListener(listener);
  		submit.addActionListener(listener);
  		listener.setTextReminder();
  		listener.setPwdReminder();
  		listener.goToRegusterFram();

  		setVisible(true);
		getFocus.requestFocusInWindow();//ҳ����غ��ý���
		
		
		
	}
}
