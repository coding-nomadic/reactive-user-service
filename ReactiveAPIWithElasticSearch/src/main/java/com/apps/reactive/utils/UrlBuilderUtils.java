package com.apps.reactive.utils;

import com.apps.reactive.config.AppConfig;

import org.springframework.web.util.UriComponentsBuilder;
/**
 * 
 * @author Tenzin Dawa
 *
 */
public class UrlBuilderUtils {
    /**
     * 
     * @param appConfig
     * @param id
     * @return
     */
    public static String url(AppConfig appConfig, String id) {
        return UriComponentsBuilder.newInstance().scheme(appConfig.elasticSearchDetails().getElasticProtocol())
                                        .host(appConfig.elasticSearchDetails().getElasticUrl())
                                        .port(appConfig.elasticSearchDetails().getElasticPort())
                                        .path(appConfig.elasticSearchDetails().getIndexName() + "/")
                                        .path(appConfig.elasticSearchDetails().getTypeName() + "/").path(id).build()
                                        .toString();
    }

    /**
     * 
     * @param appConfig
     * @return
     */
    public static String getAllUrl(AppConfig appConfig) {
        return UriComponentsBuilder.newInstance().scheme(appConfig.elasticSearchDetails().getElasticProtocol())
                                        .host(appConfig.elasticSearchDetails().getElasticUrl())
                                        .port(appConfig.elasticSearchDetails().getElasticPort())
                                        .path(appConfig.elasticSearchDetails().getIndexName() + "/")
                                        .path("_search?" + "pretty=true").build().toString();
    }
}
