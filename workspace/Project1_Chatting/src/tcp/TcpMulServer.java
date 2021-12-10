package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class ServerClass {
	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>();
	ArrayList<String> idList = new ArrayList();

	Socket socket;
	DataOutputStream dos;

	public ServerClass(int portNo) throws IOException {
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portNo);
		System.out.println("서버 가동중......");
		while(true) {
			s1 = ss1.accept();
			System.out.println("접속주소:" + s1.getInetAddress() + ", 접속포트:" + s1.getPort());
			ThreadServerClass tServer1 = new ThreadServerClass(s1);
			tServer1.start();
			
			threadList.add(tServer1);
			int portno = portNo;
			String ipNum = s1.getInetAddress().toString();
			Database db = new Database(ipNum, s1.getPort(), portno);
			try {
				db.insert2();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void sendChat(String chat , int portNo) throws IOException {
		for (int i = 0; i < threadList.size(); i++) {
			threadList.get(i).dos.writeUTF(chat);
		}

		//
		int idx;
		String id="";
		String content = "";
		if(!chat.startsWith("qwer1234")) {
			idx = chat.indexOf(":");
			content = chat.substring(0, idx);
			id = chat.substring(idx+1);
			Database db = new Database(id, content, portNo);
			try {
					db.insert();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public String sendIDList(ArrayList<String> list) {
		String result = "";
		for (String str : list) {
			result += ("#" + str);
		}
		return result;
	}

	public class ThreadServerClass extends Thread {
		Socket socket;
		DataInputStream dis;
		DataOutputStream dos;

		public ThreadServerClass(Socket s1) throws IOException {
			this.socket = s1;
			this.dis = new DataInputStream(s1.getInputStream());
			this.dos = new DataOutputStream(s1.getOutputStream());
		}

		public void run() {
			String nickname = "";
			try {
				if (dis != null) {
					nickname = dis.readUTF();
					idList.add(nickname);
					sendChat("qwer1234" + sendIDList(idList), 0);
				}
				while (dis != null) {
					sendChat(dis.readUTF(), socket.getPort());
				}
			} catch (IOException e) {

			} finally {
				for (int i = 0; i < threadList.size(); i++) {
					if (socket.equals(threadList.get(i).socket)) {
						threadList.remove(i);
						try {
							idList.remove(nickname);
							sendChat("qwer1234" + sendIDList(idList), 0);
						} catch (IOException e) {

						}
					}
				}
			}

		}

	}

}

public class TcpMulServer {

	public static void main(String[] args) throws NumberFormatException, IOException {

		if (args.length != 1) {
			System.out.println("인자로 포트번호를 입력하세요");
			System.exit(0);
		}
		new ServerClass(Integer.parseInt(args[0]));
	}
}
