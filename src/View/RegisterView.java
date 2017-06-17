package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Code.SetData;
import Code.Modle.Camp;
import Code.Modle.NameId;
import Code.Modle.RolePereson;

public class RegisterView extends JFrame{
	static final int WIDTH=280;
    static final int HEIGHT=230;
    
    public RegisterView() {

		//JFrame frames = new JFrame("ע����Ҷ�");//�½�һ����������
    	setTitle("ע����Ҷ�");
		setSize(WIDTH, HEIGHT);//���������Ŀ�Ⱥ͸߶�
		setResizable(false);
		JPanel panel = new JPanel();
		
		add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		JLabel NameId = new JLabel("�û�����");
		JLabel pwd = new JLabel("��   �룺");
		JLabel secondpwd = new JLabel("ȷ�����룺");
		JLabel campLable = new JLabel("ѡ����Ӫ��");
		//������ʾ��
		JLabel vrNameId = new JLabel();
		JLabel vrpwd = new JLabel();
		JLabel vrsecondpwd = new JLabel();
		//��Ӫѡ��
		JComboBox camp = new JComboBox();
		camp.addItem("��˽");
		camp.addItem("��η");
		camp.addItem("��ʵ");
		camp.addItem("�Ѻ�");
		camp.addItem("��ѧ");
		
		JTextField idName = new JTextField();
		JPasswordField idPassword = new JPasswordField();
		JPasswordField idPassword2 = new JPasswordField();
		
		JButton zhuce = new JButton("ע��");
		//����ҳ����ʾλ��
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        setLocation(x,y);
        //����������panel�������
		NameId.setBounds(25, 20, 80, 30);
		pwd.setBounds(25, 50, 80, 30);
		secondpwd.setBounds(25, 80, 80, 30);
		campLable.setBounds(25, 110, 80, 30);
		//��ʾ��
		vrNameId.setBounds(200, 20, 80, 30);
		vrpwd.setBounds(200, 50, 80, 30);
		vrsecondpwd.setBounds(200, 80, 80, 30);
		//�����
		idName.setBounds(80, 20, 120, 30);
		idPassword.setBounds(80, 50, 120, 30);
		idPassword2.setBounds(80, 80, 120, 30);
		//��ť
		zhuce.setBounds(100, 160, 80, 20);
		//ѡ����Ӫ
		camp.setBounds(80, 115, 120, 20);
		
		//��ӵ�panel��
		panel.add(NameId);
		panel.add(idName);
		panel.add(secondpwd);
		panel.add(vrNameId);
		panel.add(vrpwd);
		panel.add(pwd);
		panel.add(vrsecondpwd);
		panel.add(idPassword);
		panel.add(idPassword2);
		panel.add(zhuce);
		panel.add(campLable);
		panel.add(camp);
		
		
		
		panel.setVisible(true);
		setVisible(true);
		
		//�߼������
		zhuce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ʾ��
				vrNameId.setText("");
				vrpwd.setText("");
				vrsecondpwd.setText("");
				//��ȡ���ݿ�����
				SetData data = new SetData();
				List<NameId> userInfo = new ArrayList<NameId>();
				userInfo = data.getUserInfo();
				boolean isHave = false;
				//�ж��Ƿ�Ϊ��
				if(idName.getText().trim().length() == 0){
					vrNameId.setText("����Ϊ�գ�");
				}else{
					//�����Ƿ��д���
					for (int i = 0; i < userInfo.size(); i++) {
						if(userInfo.get(i).getId().equals(idName.getText())){
							vrNameId.setText("�Ѵ��ڣ�");
							isHave = true;
							break;
						}
					}
					
					if(!isHave){
						vrNameId.setText("");
						String pwd1 = new String(idPassword.getPassword());
						String pwd2 = new String(idPassword2.getPassword());
						if(pwd1.length() == 0){
							vrsecondpwd.setText("����Ϊ�գ�");
						}else if(!pwd1.equals(pwd2)){
							vrsecondpwd.setText("���벻һ�£�");
						}else{
							//����һ���û���Ϣ
							NameId addName = new NameId();
							addName.setId(idName.getText());
							addName.setPwd(pwd1);
							addName.setCamp(camp.getSelectedItem().toString());
							List<RolePereson> role = new ArrayList<RolePereson>();
							role.add(new RolePereson("A��","С��",100,"ƽ��","���ִ�","��ͨ","��ȭ"));
							addName.setRole(role);
							MainView mainLogin = new MainView(addName);
							//������ǰ��½�û���д�����ݿ�
							userInfo.add(addName);
							data.setUserInfo(userInfo);
							//mainLogin.loginUserInfo = addName;
							setVisible(false);
						}
					}
				}
				
			}
		});
	
	}
}
