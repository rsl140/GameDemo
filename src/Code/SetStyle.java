package Code;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *对panel的各种操作集合
 */
public class SetStyle {
	/**
	 * 文本框透明
	 */
	public void setTextOpaque(JTextField Jtext,int x,int y,int width,int height,Font font){
		Jtext.setBounds(x, y, width, height);
		Jtext.setOpaque(false);
		Jtext.setBorder(null);
		Jtext.setFont(font);
	}
	
	/**
	 * 密码框透明
	 */
	public void setPwdTextOpaque(JPasswordField Jpwd,int x,int y,int width,int height,Font font){
		Jpwd.setBounds(x, y, width, height);
		Jpwd.setOpaque(false);
		Jpwd.setBorder(null);
		Jpwd.setFont(font);
	}
	
	/**
	 * 按钮透明
	 */
	public void setButtonOpaque(JButton Jbutton,int x,int y,int width,int height,Font font){
		Jbutton.setBounds(x, y, width, height);
		Jbutton.setOpaque(false);
		Jbutton.setBorder(null);
		Jbutton.setFont(font);
	}
	
	/**
	 * 为Jlable设置字体样式以及在JPanel中的定位
	 */
	public void setJlableFontStyleAndColor(JLabel lable,Font font,Color color,int x,int y,int width,int height){
		lable.setFont(font);
		lable.setForeground(color);
		lable.setBounds(x, y, width, height);
	}
}
