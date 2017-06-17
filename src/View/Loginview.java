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
	//创建一个JLayeredPane用于分层的。  
    JLayeredPane layeredPane;  
    //创建一个Panel和一个Label用于存放图片，作为背景。  
    JPanel bgjp; 
    ImageIcon image;
    JPanel showjp;//用于显示内容的panel
    
	public Loginview(){
		super("动漫大乱斗");
	    
	    layeredPane=new JLayeredPane();  
	    //图片路径
        image=new ImageIcon(this.getClass().getResource("/img/login.png").getFile());        
        //创建背景
        bgjp=new JPanel();
	    bgjp = new AddBackgroundImage().addBgImg(bgjp,image, 0, -3);
        
        //显示层
        showjp = new JPanel();
        showjp.setBounds(145,334,549,136); 
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
        sytle.setButtonOpaque(submit, 494, 3, 50, 58, new Font("宋体", Font.PLAIN, 20));
        
        //注册提示
        JLabel reguster = new JLabel("New user?");
        //增加下划线
        JLabel regusterClick = new JLabel("<HTML><U>Reguster here!</U></HTML>");
        //设置字体样式
        reguster.setFont(new Font("Serif", Font.PLAIN, 18));
        regusterClick.setFont(new Font("Serif", Font.BOLD, 18));
        //设置下划线并设置字体颜色
        regusterClick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regusterClick.setForeground(Color.WHITE);
        //定位
        reguster.setBounds(140, 0, 80, 30);
        regusterClick.setBounds(223, 0, 120, 30);
        
        
        showjp.add(username);
        showjp.add(password);
        showjp.add(submit);
        showjp.add(getFocus);
        showjp.add(reguster);
        showjp.add(regusterClick);
        
        //将bgjp放到最底层。
        layeredPane.add(bgjp,JLayeredPane.DEFAULT_LAYER);
        //显示的东西放在上一层
        layeredPane.add(showjp,JLayeredPane.MODAL_LAYER);
        
        
        
        
        this.setLayeredPane(layeredPane);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(image.getIconWidth(),image.getIconHeight());
        this.setUndecorated(true);//删除title
        this.setResizable(false);//不能放大
        
        //居中
        SetFrameCenter center = new SetFrameCenter();
        center.Center(this, image.getIconWidth(), image.getIconHeight());
        //事件
  		LoginListener listener = new LoginListener(username,password,submit,this,regusterClick);
  		username.addActionListener(listener);
  		password.addActionListener(listener);
  		submit.addActionListener(listener);
  		listener.setTextReminder();
  		listener.setPwdReminder();
  		listener.goToRegusterFram();

  		setVisible(true);
		getFocus.requestFocusInWindow();//页面加载后获得焦点
		
		
		
	}
	public static void main(String[] args) {
		new Loginview();
	}
}
