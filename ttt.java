import java.io.IOException;
import java.net.UnknownHostException;


public class ttt {
public static void  main(String[] args) throws UnknownHostException, IOException, InterruptedException{



/**
 * ˫socketͨ����Comunication.java �÷�ʾ����
 * �½�����Communication����c,c1
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
