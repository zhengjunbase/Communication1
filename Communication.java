import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;


/**

*
*
 * ˫socketͨ����Comunication.java �÷�ʾ����
 * �½�����Communication������c,c1
 * ��ʼ��c�Ķ˿ں�c��initserver(c�Ķ˿ں�)
 * ��ʼ��c1�Ķ˿ں�c1��initserver(c1�Ķ˿ں�)
 * ����c��c1������c.initstep2(c1�Ķ˿ںţ�
 * ����c1��c������c1.initstep2(c�Ķ˿ںţ�
 * ��ʼ��c�Ŀͻ��˵�socket c��initclient()
 * ��ʼ��c1�Ŀͻ��˵�socket c1��initclient()
 * 
 * 
 * ��ʼ������Ϣ��  c.sendmsg(��Ϣ)����ֻ֧��Integer����
 * ������Ϣ��value=c1.recvmsg()  ���� Integer����  
 */
	
public class Communication {
	
	private ServerSocket server;
	private Socket client;
	private Queue<String>	qin;
	private Queue<String>	qout;

public Communication() throws IOException{
	
	this.server=new ServerSocket();
	this.client=new Socket();
	this.qin=new LinkedList<String>();
	this.qout=new LinkedList<String>();

}

public void initserver(Integer port) throws IOException{
	
	this.server=new ServerSocket(port);
	
}
public void initstep2(Integer port,Integer cport) throws InterruptedException, IOException {
	this.server=new ServerSocket(port);
	while(true){
		
		if(this.client.isConnected())
		{System.out.println("conneted!"+this.client.getRemoteSocketAddress());
		break;
		}
	   try {
		   if(!this.client.isConnected())
			this.client=new Socket(InetAddress.getLocalHost(),cport);
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		Thread.sleep(50);
	   }
	}
	try {
		Socket s = this.server.accept();
		InputStream in=s.getInputStream();
		OutputStream out=this.client.getOutputStream();
		new WriteThread(out,qout).start();
		new ReadThread(in,qin).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
public void initclient() {
	try {
		Socket s = this.server.accept();
		InputStream in=s.getInputStream();
		OutputStream out=this.client.getOutputStream();
		new WriteThread(out,qout).start();
		new ReadThread(in,qin).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}

public void sendmsg(String value){
	
	qout.add(value);
}
public String recvmsg() throws InterruptedException{
	String value=null;
	while(true){
		if(!qin.isEmpty()) 
		{
			value=qin.poll();
			return value;
		}
		Thread.sleep(33);
	}
}
}
