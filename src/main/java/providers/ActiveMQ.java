package providers;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQ {

	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

	/**
	 * Getting JMS connection from the server.
	 * 
	 * @return Connection
	 * @throws JMSException
	 */
	public Connection createConnection() throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);

		return connectionFactory.createConnection();
	}
}
