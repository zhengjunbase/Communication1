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
 * 双socket通信类Comunication.java 用法示例：
 * 新建两个Communication对象：c,c1
 * 初始化c的端口号c。initserver(c的端口号)
 * 初始化c1的端口号c1。initserver(c1的端口号)
 * 建立c到c1的连接c.initstep2(c1的端口号）
 * 建立c1到c的连接c1.initstep2(c的端口号）
 * 初始化c的客户端的socket c。initclient()
 * 初始化c1的客户端的socket c1。initclient()
 * 
 * 
 * 开始发送消息：  c.sendmsg(消息)，暂只支持Integer类型
 * 接收消息：value=c1.recvmsg()  接受 Integer类型  
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
