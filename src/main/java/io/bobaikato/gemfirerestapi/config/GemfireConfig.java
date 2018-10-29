package io.bobaikato.gemfirerestapi.config;

import java.util.Properties;

import io.bobaikato.gemfirerestapi.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.gemstone.gemfire.cache.GemFireCache;

@Configuration
public class GemfireConfig {
    @Bean
    Properties gemfireProperties() {
        var gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "EmbeddedGemfireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        return gemfireProperties;
    }
     
    @Bean
    CacheFactoryBean gemfireCache() {
        var gemfireCache = new CacheFactoryBean();
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }
     
    @Bean
    LocalRegionFactoryBean<String, Customer> customerRegion(final GemFireCache cache) {
       var customerRegion = new LocalRegionFactoryBean<String, Customer> ();
        customerRegion.setCache(cache);
        customerRegion.setName("customer");
        customerRegion.setPersistent(false);
        return customerRegion;
    }
}