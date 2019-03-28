package app;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import providers.ActiveMQ;
import providers.MQQueue;

public class JMSListeners {

	private static final String QUEUE_MANAGER = "demo.manager";
	private static final String QUEUE = "demo.queue";

	public static void main(String[] args) throws Exception {
		// Getting JMS connection
		Connection connection = new ActiveMQ().createConnection();
		// Connection connection = new MQQueue().createConnection(QUEUE_MANAGER);
		connection.start();

		// Creating session for sending messages
		boolean transacted = false;
		Session session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);

		// Getting the queue
		Destination destination = session.createQueue(QUEUE);

		// MessageConsumer is used for receiving (consuming) messages
		MessageConsumer consumer = session.createConsumer(destination);

		// Here we receive the message.
		Message message = consumer.receive();

		// We will be using TestMessage in our example. MessageProducer sent us a
		// TextMessage so we must cast to it to get access to its .getText() method.
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			String contenu = textMessage.getText();
			System.out.println("Received message '" + contenu + "'");
		}

		connection.close();
	}
}
