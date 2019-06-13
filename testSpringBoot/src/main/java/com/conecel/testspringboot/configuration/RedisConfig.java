package com.conecel.testspringboot.configuration;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	static final Logger logger = LogManager.getLogger(RedisConfig.class.getName());

    @Value("${external.redis.host}")
    private String host;
    @Value("${external.redis.port}")
    private Integer port;
    @Value("${external.redis.timeout}")
    private Integer timeOut;
    @Value("${external.redis.max.wait}")
    private Integer maxWait;
    @Value("${external.redis.max.total.pool.conections}")
    private Integer maxTotalPool;

    private  JedisPool jedisPool;
    
 
    public void initializeJedisPool() {
        if (jedisPool == null) {
        	JedisPoolConfig jedisConfig = new JedisPoolConfig();
        	jedisConfig.setMaxWaitMillis(maxWait);
        	jedisConfig.setMaxTotal(maxTotalPool);
        
            jedisPool = new JedisPool(jedisConfig,
                    host,
                    port,
                    timeOut);
            logger.info("Jedis Pool is Initialized");
           
           
        }
    }

    /**
     * Method to return Jedis Pool. If the pool is null, it calls
     * initialize method and then returns the pool
     *
     * @return {@link JedisPool}
     */
    public JedisPool getJedisPool() {
        if (jedisPool == null) {
        	logger.info("Initilizing pool for null conections");
            initializeJedisPool();
        }
        return jedisPool;
    }

    /**
     * Method to close and detroy Jedis Pool
     */
    public void destroyJedisPool() {
        if (jedisPool != null && !jedisPool.isClosed()) {
            jedisPool.close();
            jedisPool.destroy();
            logger.info("Closed and Destroyed Jedis Pool");
        }
    }
}
