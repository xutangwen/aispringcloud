package com.handlewell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;//ID
    private Integer num;//数量
    private BigDecimal price;//几个
    private String name;//名称
    private String category;//类别
}
