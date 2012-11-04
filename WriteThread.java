import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Queue;

public class WriteThread extends Thread{
	private OutputStream out;
	private Queue<String> qout;
	
	
public WriteThread(OutputStream out,Queue<String> qout){
	this.out=out;
	this.qout=qout;
}

public void run(){
	
	String value=null;
	DataOutputStream dout= new DataOutputStream(out);
	while(true){
		if(!qout.isEmpty())
		{
			value=qout.poll();
		//value=453;
			try {
				dout.writeUTF(value);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			WriteThread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}//¸ô50ms¼àÌýÒ»´Î
		}
    }

