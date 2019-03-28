package providers;

import javax.jms.Connection;
import javax.jms.JMSException;

import com.ibm.mq.jms.MQQueueConnectionFactory;

public class MQQueue {

	private static final String DEFAULT_HOST = "localhost";
	private static final int DEFAULT_PORT = 1414;

	/**
	 * Getting JMS connection from the server.
	 * 
	 * @param queueManagerName Queue manager name
	 * @return Connection
	 * @throws JMSException
	 */
	public Connection createConnection(String queueManagerName) throws JMSException {
		MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();

		connectionFactory.setHostName(DEFAULT_HOST);
		connectionFactory.setPort(DEFAULT_PORT);
		connectionFactory.setQueueManager(queueManagerName);

		return connectionFactory.createConnection();
	}
}
