package tcp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ParagraphAttribute;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextPane;

public class TcpMulClientGUI extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<JLabel> userList;
	private JPanel panel;
	private JTextPane textPane;
	private StyledDocument doc;
	private LocalTime now;
	private DateTimeFormatter formatter;
	
	Toolkit tk1=Toolkit.getDefaultToolkit(); 
	
	DataOutputStream outputStream;  
	DataInputStream inputStream;
	String myID;
	
	/**
	 * Create the frame.
	 */
	public TcpMulClientGUI(DataOutputStream outputStream, DataInputStream inputStream, String myID) {
		
		this.outputStream = outputStream;
		this.inputStream = inputStream;
		this.myID = myID;
		
		formatter = DateTimeFormatter.ofPattern("a h:mm");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 150, 703);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(150, 669, 532, 34);
		contentPane.add(panel_2);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == textField) {
					try {
						outputStream.writeUTF(myID + ":" + textField.getText());
					} catch (IOException ee) {
						ee.printStackTrace();
					}
					textField.setText("");
				}
			}
		});
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		panel_2.add(textField);
		textField.setColumns(40);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 0, 532, 669);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		MutableAttributeSet set = new SimpleAttributeSet();
		StyleConstants.setLineSpacing(set, 0.1f);
		textPane.setParagraphAttributes(set, true);
		
		doc = textPane.getStyledDocument();
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		Style s = doc.addStyle("id", def);
		StyleConstants.setForeground(s, Color.black);
		StyleConstants.setBold(s, true);
		StyleConstants.setFontSize(s, 13);
		StyleConstants.setFontFamily(s, "¸¼Àº °íµñ");
		//StyleConstants.setLineSpacing(s, 10.0f);
		
		s = doc.addStyle("myID", def);
		StyleConstants.setForeground(s, Color.black);
		StyleConstants.setBold(s, true);
		StyleConstants.setFontSize(s, 13);
		StyleConstants.setFontFamily(s, "¸¼Àº °íµñ");
		StyleConstants.setUnderline(s, true);
		StyleConstants.setForeground(s, new Color(56, 118, 29));
		//StyleConstants.setLineSpacing(s, 10.0f);
		
		s = doc.addStyle("content", def);
		StyleConstants.setFontSize(s, 10);
		StyleConstants.setFontFamily(s, "¸¼Àº °íµñ");
		
		s = doc.addStyle("time", def);
		StyleConstants.setFontSize(s, 8);
		StyleConstants.setFontFamily(s, "¸¼Àº °íµñ");
		
		scrollPane.setViewportView(textPane);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0); 
				setVisible(false);
			}
		});
		
		Thread th1 = new Thread(this); 
		th1.start();
	}
	
	@Override
	public void run() {
		String currentChatID = "";
		String currentTime = "";
		try {
			while(true) {
				String strServer1 = inputStream.readUTF();
				if(strServer1 == null) {
					return;
				}
				
				if(strServer1.indexOf("qwer1234") != -1) { // »ç¿ëÀÚ ÀÔÀå,ÅðÀå ½Ã
					String id = strServer1.substring(8);
					String[] idList = id.split("#");
					userList = new ArrayList<>();
					
					for(String str : idList) {
						if(str.equals("")) continue;
						userList.add(new JLabel(str));
					}
					
					panel.removeAll();
					
					JLabel lblNewLabel = new JLabel("\uC0AC\uC6A9\uC790 \uC218 " + userList.size()); // »ç¿ëÀÚ ¼ö
					lblNewLabel.setBounds(14, 12, 122, 18);
					lblNewLabel.setFont(new Font("¸¼Àº °íµñ" , Font.BOLD, 12));
					panel.add(lblNewLabel);
					
					int y = 52;
					for(JLabel j : userList) {
						j.setBounds(14, y, 62, 18);
						j.setFont(new Font("¸¼Àº °íµñ" , Font.BOLD, 12));
						panel.add(j);
						y += 40;
					}
					panel.repaint();
					
				} else { // Ã¤ÆÃ
					int idx = strServer1.indexOf(":");
					String id = strServer1.substring(0, idx);
					String content = strServer1.substring(idx+1);
					try {
						now = LocalTime.now();
						String time = now.format(formatter);
						if((!id.equals(currentChatID)) || (!time.equals(currentTime))) {
							if(id.equals(myID)) {
								doc.insertString(doc.getLength(), "\n  ", doc.getStyle("id"));
								doc.insertString(doc.getLength(), id, doc.getStyle("myID"));
							} else {
								doc.insertString(doc.getLength(), "\n  " + id, doc.getStyle("id"));
							}
							doc.insertString(doc.getLength(), " " + time, doc.getStyle("time"));
							currentTime = time;
						}
						currentChatID = id;
					} catch (BadLocationException ble) {}
					doc.insertString(doc.getLength(), "\n\t" + content, doc.getStyle("content"));
					int kkeut = doc.getLength();
					textPane.setCaretPosition(kkeut);
				}
			}
		} catch (Exception e) {
			try {
				doc.insertString(doc.getLength(), "\n" + e, doc.getStyle("content"));
			} catch (Exception ee) {}
		}
		
	}
}
