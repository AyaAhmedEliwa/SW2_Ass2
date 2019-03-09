
package peertopeer.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageTransmitter extends Thread{

    String message, hostname;
    int port;
    
    public MessageTransmitter() {
    }

    public MessageTransmitter(String message, String hostname, int port ) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
        }

    @Override
    public void run() {
        try {
            Socket s= new Socket (hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public synchronized void waitMethod() throws IOException {
 	int num=0;
		while (num<10) 
                {
                    Socket s = new Socket(hostname, port);
                      
                      double x = Math.random()*100+1;
                      message="sending fake data "+x+"";
                    
                       s.getOutputStream().write(message.getBytes());
                       s.close();
			//System.out.println("always running program ==> " + Calendar.getInstance().getTime());
			try {
				this.wait(2000);
			} catch (InterruptedException e) {
 
				e.printStackTrace();
			}
		}
}
    
    
}
