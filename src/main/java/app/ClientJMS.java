package app;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import providers.ActiveMQ;
import providers.MQQueue;

public class ClientJMS {

	private static final String QUEUE_MANAGER = "demo.manager";
	private static final String QUEUE = "demo.queue";

	public static void main(String[] args) throws Exception {
		// Getting JMS connection
		Connection connection = new ActiveMQ().createConnection();
		// Connection connection = new MQQueue().createConnection(QUEUE_MANAGER);
		connection.start();

		// Creating a non transactional session to send/receive JMS message.
		boolean transacted = false;
		Session session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);

		// Destination represents here our queue on the JMS server.
		// The queue will be created automatically on the server.
		Destination destination = session.createQueue(QUEUE);

		// MessageProducer is used for sending messages to the queue.
		MessageProducer producer = session.createProducer(destination);

		// We will send a small text message
		TextMessage message = session.createTextMessage();
		message.setText("A small and kindly message");

		// Here we are sending our message!
		producer.send(message);

		System.out.println("ClientJMS printing@@ '" + message.getText() + "'");
		connection.close();
	}
}
