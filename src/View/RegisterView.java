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

	//创建一个JLayeredPane用于分层的。  
    JLayeredPane layeredPane;  
    //创建一个Panel和一个Label用于存放图片，作为背景。  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//用于显示内容的panel
    
	public RegisterView(){
		super("动漫大乱斗");

	    layeredPane=new JLayeredPane();
	    bgjp=new JPanel();
	    
        //创建背景
	    new AddBackgroundImage().addBackgroundImg(this, layeredPane, bgjp, image, "login.png", 0, -3);
        
        //显示层
        showjp = new JPanel();
        showjp.setBounds(145,334,549,192);
        showjp.setOpaque(false);//设置为透明
        showjp.setLayout(null);//取消默认样式
        
        //文本框透明
        JTextField username = new JTextField("输入用户名");
        JPasswordField password = new JPasswordField("输入密码");
        JTextField getFocus = new JTextField();//加载时默认获得焦点用
        getFocus.setBounds(800, 10, 0, 0);
        
        //明文显示密码内容
        password.setEchoChar('\0');
        
        SetStyle sytle = new SetStyle();
        sytle.setTextOpaque(username, 15, 86, 220, 45, new Font("宋体", Font.PLAIN, 20));
        sytle.setPwdTextOpaque(password, 260, 86, 220, 45, new Font("宋体", Font.PLAIN, 20));
        
        //登陆按钮
        JButton submit = new JButton();
        sytle.setButtonOpaque(submit, 494, 80, 53, 60, new Font("宋体", Font.PLAIN, 20));
        
        //注册提示
        JLabel reguster = new JLabel("Old user?");
        //增加下划线
        JLabel regusterClick = new JLabel("<HTML><U>Login here!</U></HTML>");
        //设置字体样式
        reguster.setFont(new Font("Serif", Font.PLAIN, 18));
        regusterClick.setFont(new Font("Serif", Font.BOLD, 18));
        //设置下划线并设置字体颜色
        regusterClick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regusterClick.setForeground(Color.WHITE);
        //定位
        reguster.setBounds(140, 0, 80, 30);
        regusterClick.setBounds(223, 0, 120, 30);
        
      //阵营选择
  		JComboBox camp = new JComboBox();
  		camp.addItem("无私");
  		camp.addItem("无畏");
  		camp.addItem("诚实");
  		camp.addItem("友好");
  		camp.addItem("博学");
  		camp.setBounds(185, 139, 100, 40);
        
        
        showjp.add(username);
        showjp.add(password);
        showjp.add(submit);
        showjp.add(getFocus);
        showjp.add(reguster);
        showjp.add(regusterClick);
        showjp.add(camp);
        
        //显示的东西放在上一层
        layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
        
        this.setLayeredPane(layeredPane);
        //事件
        RegisterListener listener = new RegisterListener(username,password,submit,this,regusterClick,camp);
  		username.addActionListener(listener);
  		password.addActionListener(listener);
  		submit.addActionListener(listener);
  		listener.setTextReminder();
  		listener.setPwdReminder();
  		listener.goToRegusterFram();

  		setVisible(true);
		getFocus.requestFocusInWindow();//页面加载后获得焦点
		
		
		
	}
}
