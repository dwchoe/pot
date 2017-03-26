package dwchoe.integration_tools;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;


public class MyMessageListener implements MessageListener {
	private static final Logger LOG = Logger.getLogger(MyMessageListener.class);
	
	public void onMessage(Message message) {

		try {
			TextMessage msg = (TextMessage) message;
			System.out.println("Consumed message: " + msg.getText());
	
	    } 
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
