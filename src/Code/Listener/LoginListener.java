package Code.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Code.SetData;
import Code.Modle.NameId;
import View.MainView;
import View.RegisterView;

public class LoginListener implements ActionListener{
	private JTextField jtext;
	private JPasswordField jpwd;
	private JButton jbutton;
	private JFrame frame;
	private JLabel reguster;
	
	public LoginListener(JTextField jtext, JPasswordField jpwd, JButton jbutton,JFrame frame,JLabel reguster) {
		super();
		this.jtext = jtext;
		this.jpwd = jpwd;
		this.jbutton = jbutton;
		this.frame = frame;
		this.reguster = reguster;
	}
	/**
	 * ���ı���������ʾ����
	 */
	public void setTextReminder(){
		jtext.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(jtext.getText().length() == 0){
					jtext.setText("�����û���");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
					if(jtext.getText().equals("�����û���")){
						jtext.setText("");
					}
			}
		});
	}
	/**
	 * �������������ʾ����
	 */
	public void setPwdReminder(){
		jpwd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(jpwd.getPassword().length == 0){
					jpwd.setEchoChar('\0');
					jpwd.setText("��������");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(jpwd.getPassword()).equals("��������")){
					jpwd.setEchoChar('*');
					jpwd.setText("");
				}
			}
		});
	}

	
	@Override
	/**
	 * ��½�¼�
	 */
	public void actionPerformed(ActionEvent e) {
		//�س��¼�
			if (e.getSource() == jtext || e.getSource() == jpwd || e.getSource() == jbutton){
				
				if(jtext.getText().equals("�����û���") || new String(jpwd.getPassword()).equals("��������")){
					JOptionPane.showMessageDialog(null, "�������û������룡", "��ʾ",
							JOptionPane.ERROR_MESSAGE);
				}else{
					SetData data = new SetData();
					List<NameId> userInfo = new ArrayList<NameId>();
					userInfo = data.getUserInfo();
					//���ҵ�½�û����±�
					int index = data.findUserInfo(jtext.getText());
						if(index != -1){
							if(userInfo.get(index).getPwd().equals(new String(jpwd.getPassword()))){
								//��½�ɹ�
								frame.setVisible(false);
								MainView main =new MainView(userInfo.get(index));
							}else{
								//������ʾ
								JOptionPane.showMessageDialog(null, "�������", "��ʾ",
										JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "�û����������", "��ʾ",
									JOptionPane.ERROR_MESSAGE);
						}
				}
			}
	}
	
	/**
	 * ע��
	 */
	public void goToRegusterFram(){
		reguster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new RegisterView();
			}
		});
	}

}
