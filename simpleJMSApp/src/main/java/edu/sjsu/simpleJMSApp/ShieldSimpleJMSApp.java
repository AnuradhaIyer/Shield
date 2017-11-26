package edu.sjsu.simpleJMSApp;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * 
 * @author Anushri Srinath Aithal
 *
 */
public class ShieldSimpleJMSApp {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 100; i++) {
			(new Thread(new ShieldMessageProducer())).start();
			(new Thread(new ShieldMessageProducer())).start();
			(new Thread(new ShieldMessageProducer())).start();
			(new Thread(new ShieldMessageProducer())).start();

		}
	}

	/**
	 * 
	 * @author Anushri Srinath Aithal
	 * Ashwini Shankar Narayan
	 *
	 */
	public static class ShieldMessageProducer implements Runnable {

		public void run() {
			try {

				Context ctx = new InitialContext();
				ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();
 
                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
 
                // Create the destination (Topic or Queue)
                Destination destination = (Destination) ctx.lookup("SimpleTopic");
 
                // Create a MessageProducer from the Session to the Topic or Queue
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
 
                // Create a messages
                String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
                TextMessage message = session.createTextMessage(text);
                
             // Consumer
    			MessageConsumer consumer = session.createConsumer(destination);
    			consumer.setMessageListener(new ShieldMessageLister("Consumer"));
 
                // Tell the producer to send the message
                System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
                producer.send(message);
 
                // Clean up
                session.close();
                connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @author Nidhi Jamar
	 * Anuradha Rajashekar
	 *
	 */
	public static class ShieldMessageLister implements MessageListener {

		private String consumerName;

		public ShieldMessageLister(String consumerName) {
			this.consumerName = consumerName;
		}

		@Override
		public void onMessage(Message message) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println(consumerName + " received " + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}
}