package Code.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Code.SetData;
import Code.Modle.NameId;
import Code.Modle.RolePereson;
import View.Loginview;
import View.MainView;
import View.RegisterView;

public class RegisterListener implements ActionListener{

	private JTextField jtext;
	private JPasswordField jpwd;
	private JButton jbutton;
	private JFrame frame;
	private JLabel login;
	private JComboBox jcombox;
	
	public RegisterListener(JTextField jtext, JPasswordField jpwd, JButton jbutton,JFrame frame,JLabel login,JComboBox jcombox) {
		super();
		this.jtext = jtext;
		this.jpwd = jpwd;
		this.jbutton = jbutton;
		this.frame = frame;
		this.login = login;
		this.jcombox = jcombox;
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
				
				if(jtext.getText().equals("�����û���") || jtext.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "�������û���", "��ʾ",
							JOptionPane.ERROR_MESSAGE);
				}else{
					if(new String(jpwd.getPassword()).equals("��������") || jpwd.getPassword().length == 0){
						JOptionPane.showMessageDialog(null, "����������", "��ʾ",
								JOptionPane.ERROR_MESSAGE);
					}else{
						SetData data = new SetData();
						List<NameId> userInfo = new ArrayList<NameId>();
						userInfo = data.getUserInfo();
						//���ҵ�½�û����±�
						int index = data.findUserInfo(jtext.getText());
						if(index == -1){
							//����һ���û���Ϣ
							NameId addName = new NameId();
							addName.setId(jtext.getText());
							addName.setPwd(new String(jpwd.getPassword()));
							addName.setCamp(jcombox.getSelectedItem().toString());
							List<RolePereson> role = new ArrayList<RolePereson>();
							role.add(new RolePereson("A��","С��",100,"ƽ��","���ִ�","��ͨ","��ȭ"));
							addName.setRole(role);
							MainView mainLogin = new MainView(addName);
							//������ǰ��½�û���д�����ݿ�
							userInfo.add(addName);
							data.setUserInfo(userInfo);
							//mainLogin.loginUserInfo = addName;
							frame.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "���д��û�", "��ʾ",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			}
	}
	
	/**
	 * ע��
	 */
	public void goToRegusterFram(){
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new Loginview();
			}
		});
	}


}
