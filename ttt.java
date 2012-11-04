import java.io.IOException;
import java.net.UnknownHostException;


public class ttt {
public static void  main(String[] args) throws UnknownHostException, IOException, InterruptedException{



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
	Communication c=new Communication();

	//int nn=0;
	//while(nn<100000000)System.out.println(nn++);
	//Communication c1=new Communication();
	//c.initserver(10683);
	//c1.initserver(10684);
	c.initstep2(10684,10683);
	//c1.initstep2(10683);
	//c.initclient();
	//c1.initclient();
	for(int i=0;i<10;i++)
	c.sendmsg("sfsgs"+i);
	for(int i=0;i<10;i++)
	System.out.println(c.recvmsg());
	//c1.sendmsg("wwww");
	//for(int i=0;i<10;i++)
	//System.out.println(c1.recvmsg());
	//System.out.println(c.recvmsg());
   }
}
