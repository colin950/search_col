package com.example.search.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;

public abstract class AbstractElasticsearchConfiguration extends ElasticsearchConfigurationSupport {

    @Bean
    public abstract ElasticsearchClient elasticsearchClient();

    @Bean(name = { "elasticsearchOperations", "elasticsearchTemplate" })
    public ElasticsearchOperations elasticsearchOperations(ElasticsearchConverter elasticsearchConverter,
                                                           ElasticsearchClient elasticsearchClient) {
        ElasticsearchTemplate template = new ElasticsearchTemplate(elasticsearchClient, elasticsearchConverter);
        template.setRefreshPolicy(refreshPolicy());
        return template;
//        template.setRefreshPolicy(refreshPolicy());
    }
}
