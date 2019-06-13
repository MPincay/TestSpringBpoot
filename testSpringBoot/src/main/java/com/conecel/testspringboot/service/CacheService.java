package com.conecel.testspringboot.service;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.conecel.testspringboot.configuration.RedisConfig;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Service
public class CacheService {

	static final Logger logger = LogManager.getLogger(CacheService.class.getName());

	@Value("${external.redis.expiration}")
	private Integer expiration;

	@Autowired
	private RedisConfig util;

	private JedisPool jedisPool = null;

	public String testConnection() {
		String message = null;
		jedisPool = util.getJedisPool();
		try (Jedis jedis = jedisPool.getResource()) {
			if (jedis.isConnected()) {
				message = "connection successful";
			} else {
				message = "connection failed";
			}
		} catch (Exception e) {
			message = "connection failed";
		}
		logger.info(message);
		return message;
	}

	public String setex(final String key, final String value) {
		String returnCode = "-1";

		logger.info("Values to setter key:"+key+ " value: "+value);
		Jedis jedis = null;

		try {
			jedisPool = util.getJedisPool();
			jedis =  jedisPool.getResource();
			logger.info("Inside try pool resource connect ::"+jedis.isConnected());
			logger.info("NumActive():"+jedisPool.getNumActive());

			String keyfinal = key;

			returnCode = jedis.setex(keyfinal, expiration.intValue(), value);
			
			logger.info("Data Inserted/Updated Successfully");

		} catch (Exception ex) {
			logger.error("error al procesar CACHE: ", ex);

		}
		finally {
			if (jedis != null) {

				logger.info("jedis disconnect.");
				jedis.disconnect();
				logger.info("jedis closed.");
				jedis.close();
			}
		}

		return returnCode;
	}

	public String get(final String key) {

		String result = null;
		Jedis jedis = null;
		try 
		{
			logger.info("Getting jedis pool..");
			jedisPool = util.getJedisPool();
			logger.info("Getting jedis pool resource..");
			jedis = jedisPool.getResource();
			String keyfinal =  key;
			logger.info("KEY:"+keyfinal);
			result = jedis.get(keyfinal);


		} catch (Exception ex) {
			logger.error("error al procesar CACHE: ", ex.getMessage());

		}

		finally {
			if (jedis != null) {

				logger.info("jedis disconnect.");
				jedis.disconnect();
				logger.info("jedis closed.");
				jedis.close();
			}
		}

		return result;
	}

	public void killClient(Jedis jedis) {

		try
		{

			for (String clientInfo : jedis.clientList().split("\n")) {
				logger.info("Client List:"+clientInfo);
				String hostAndPortString  = clientInfo.split(" ")[0].split("=")[1];
				String[] hostAndPortParts = HostAndPort.extractParts(hostAndPortString);
				logger.info("Host:"+hostAndPortParts[0]);
				logger.info("Port:"+hostAndPortParts[1]);
				jedis.clientKill(hostAndPortParts[0] + ":" + hostAndPortParts[1]);
				logger.info("Client connect killed");
	
			}

		} catch (Exception ex) {
			logger.error("error to delete conection: ", ex);
		}

		finally {
			if (jedis != null) {

				logger.info("jedis disconnect.");
				jedis.disconnect();
				logger.info("jedis closed.");
				jedis.close();

			}
		}

	}
}
