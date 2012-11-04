import java.io.*;
import java.util.Queue;


public class ReadThread extends Thread{

	private InputStream in;
	private Queue<String> qin;

public ReadThread(InputStream in,Queue<String> qin){
	this.in=in;
	this.qin=qin;
}

public void run(){
		
		String value=null;
		DataInputStream din =new DataInputStream(in);
		while(true){
				try {
					value=din.readUTF();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				qin.add(value);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	
}

}
