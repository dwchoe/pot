package dwchoe.integration_tools;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        
        JmsTemplate sender = (JmsTemplate)ctx.getBean("jmsTemplate");
        sender.send("monitoring.queue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello queue world");
              }
        });
        
        MyMessageListener listener = (MyMessageListener)ctx.getBean("simpleMessageListener");
        
        System.out.println( "done!" );
    }
}
