package tcp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginGUI extends JFrame{

	private JPanel contentPane;
	private JTextField textField_ipadd;
	private JTextField textField_portnum;
	private JTextField textField_id;
	private String ip = "";
	private String portnum = "";
	private String id = "";
	
	private String checkFormat(String id, String ip, String portnum) {
		String check = "";
		
		if(ip.equals("")) {
			check = "IP �ּҸ� �Է��ϼ���";
			return check;
		} else if(portnum.equals("")) {
			check = "��Ʈ��ȣ�� �Է��ϼ���";
			return check;
		} else if(id.equals("")) {
			check = "ID�� �Է��ϼ���";
			return check;
		}
		
		String[] test = ip.split("\\.");
		
		try {
			for(String str : test) {
				Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			check = "IP �ּҴ� ����.����.����.���� ���·� �Է��ϼ���";
			return check;
		}
		
		if(test.length != 4) {
			check = "IP �ּҴ� ����.����.����.���� ���·� �Է��ϼ���";
			return check;
		}
		
		try {
			Integer.parseInt(portnum);
		} catch (NumberFormatException e) {
			check = "��Ʈ��ȣ�� ���ڷ� �Է��ϼ���";
			return check;
		}
		
		if(portnum.length() != 4) {
			check = "��Ʈ��ȣ�� ���ڸ� ���ڷ� �Է��ϼ���";
			return check;
		}
		
		return check;
	}

	public LoginGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ipadd = new JLabel("IP \uC8FC\uC18C");
		lbl_ipadd.setBounds(25, 31, 57, 15);
		contentPane.add(lbl_ipadd);
		
		JLabel lbl_portnum = new JLabel("\uD3EC\uD2B8 \uB118\uBC84");
		lbl_portnum.setBounds(25, 91, 69, 15);
		contentPane.add(lbl_portnum);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(25, 151, 57, 15);
		contentPane.add(lbl_id);
		
		textField_ipadd = new JTextField();

		textField_ipadd.setBounds(184, 28, 116, 21);
		contentPane.add(textField_ipadd);
		textField_ipadd.setColumns(10);
		
		textField_portnum = new JTextField();

		textField_portnum.setBounds(184, 91, 116, 21);
		contentPane.add(textField_portnum);
		textField_portnum.setColumns(10);
		
		textField_id = new JTextField();

		textField_id.setBounds(184, 151, 116, 21);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);// ���� ��ư ����� â ���� 
			}
		});
		btnExit.setBounds(203, 228, 97, 23);
		contentPane.add(btnExit);
		
		JButton btnEnter = new JButton("\uC785\uC7A5");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ��ư ����� ä��â���� �Ѿ. �켱�� ���Ƿ� .java ���� ���� �־����.
				// ���߿� ���̵� ��й�ȣ ��ġ ���� ���� �� ���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ� â�� ������ �� .
				id = textField_id.getText();
				portnum = textField_portnum.getText();
				ip = textField_ipadd.getText();
				
				String check = checkFormat(id, ip, portnum);
				if(!check.equals("")) {
					JOptionPane.showMessageDialog(null, check);
					return;
				}
				
				try {              
					Socket s1 = new Socket(ip, Integer.parseInt(portnum));
					
					setVisible(false);
					
					if(s1.isConnected()) {
						System.out.println("������ ����.....");

						DataOutputStream outputStream = new DataOutputStream(s1.getOutputStream());
						DataInputStream inputStream = new DataInputStream(s1.getInputStream());
						outputStream.writeUTF(id); 

						new TcpMulClientGUI(outputStream, inputStream, id) {////////
							public void closeWork() throws IOException {
								outputStream.close();
							    inputStream.close();
							    System.exit(0);
						    }
				        };

					}
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "�ش� ä�ù��� ���������ʽ��ϴ�.");
				}
			}
		});
		
		btnEnter.setBounds(30, 228, 97, 23);
		contentPane.add(btnEnter);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0); 
				setVisible(false);
			}
		});
		

	}

}
