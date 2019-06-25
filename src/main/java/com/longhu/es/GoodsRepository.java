package com.longhu.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author: houyong
 * @description:
 * @create: 2019-05-22 10:42
 */
@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo, Long> {
}
