package Code;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *��panel�ĸ��ֲ�������
 */
public class SetStyle {
	/**
	 * �ı���͸��
	 */
	public void setTextOpaque(JTextField Jtext,int x,int y,int width,int height,Font font){
		Jtext.setBounds(x, y, width, height);
		Jtext.setOpaque(false);
		Jtext.setBorder(null);
		Jtext.setFont(font);
	}
	
	/**
	 * �����͸��
	 */
	public void setPwdTextOpaque(JPasswordField Jpwd,int x,int y,int width,int height,Font font){
		Jpwd.setBounds(x, y, width, height);
		Jpwd.setOpaque(false);
		Jpwd.setBorder(null);
		Jpwd.setFont(font);
	}
	
	/**
	 * ��ť͸��
	 */
	public void setButtonOpaque(JButton Jbutton,int x,int y,int width,int height,Font font){
		Jbutton.setBounds(x, y, width, height);
		Jbutton.setOpaque(false);
		Jbutton.setBorder(null);
		Jbutton.setFont(font);
	}
	
	/**
	 * ΪJlable����������ʽ�Լ���JPanel�еĶ�λ
	 */
	public void setJlableFontStyleAndColor(JLabel lable,Font font,Color color,int x,int y,int width,int height){
		lable.setFont(font);
		lable.setForeground(color);
		lable.setBounds(x, y, width, height);
	}
	
	/**
	 * ������������»���
	 * @param jlabel
	 * @param str �ı�
	 */
	public void MouseInAndOut(JLabel jlabel,String str){
		jlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				jlabel.setText("<HTML><U>"+ str +"</U></HTML>");
				//��ָ��ʽ
				jlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				jlabel.setText(str);
			}
		});
	}
}
