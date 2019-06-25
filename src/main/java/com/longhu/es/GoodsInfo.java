package com.longhu.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author: houyong
 * @description:
 * @create: 2019-05-22 10:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName="testgoods",type = "goods")
public class GoodsInfo implements Serializable {
    private Long id;
    private String name;
    private String description;
}
