package com.apps.reactive.config;

import com.apps.reactive.models.ElasticSearchDetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "config")
/**
 * 
 * @author Tenzin Dawa
 *
 */
public class AppConfig {
    @Value("${config.elastic.elastic-url}")
    private String elasticUrl;
    @Value("${config.elastic.elastic-port}")
    private String elasticPort;
    @Value("${config.elastic.elastic-protocol}")
    private String elasticProtocol;
    @Value("${config.elastic.index-name}")
    private String indexName;
    @Value("${config.elastic.type-name}")
    private String typeName;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public ElasticSearchDetails elasticSearchDetails() {
        ElasticSearchDetails elasticSearchDetails = new ElasticSearchDetails();
        elasticSearchDetails.setElasticPort(elasticPort);
        elasticSearchDetails.setElasticProtocol(elasticProtocol);
        elasticSearchDetails.setElasticUrl(elasticUrl);
        elasticSearchDetails.setIndexName(indexName);
        elasticSearchDetails.setTypeName(typeName);
        return elasticSearchDetails;
    }
}
