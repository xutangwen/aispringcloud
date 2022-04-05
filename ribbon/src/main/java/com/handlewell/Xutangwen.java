package com.handlewell;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Xutangwen {
    public static void main(String[] args) {
        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        List<Product> prodList = new ArrayList<>();
        prodList.add(prod1);
        prodList.add(prod2);
        prodList.add(prod3);
        prodList.add(prod4);
        prodList.add(prod5);

//        //按照类目分组
//        Map<String, List<Product>> collect = prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
//        for (Map.Entry entry : collect.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//
//        System.out.println("===============================================================================================================");
//        System.out.println("按照几个属性拼接：");
//        Map<String, List<Product>> collect1 = prodList.stream().collect(Collectors.groupingBy(item -> item.getCategory() + "_" + item.getName()));
//        for (Map.Entry entry : collect1.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//        System.out.println("===============================================================================================================");
//        Map<String, List<Product>> collect2 = prodList.stream().collect(Collectors.groupingBy(item -> {
//            if (item.getNum() < 3) {
//                return "数量小于3";
//            } else {
//                return "数量大于等于3";
//            }
//        }));
//        for (Map.Entry entry : collect2.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//
//        System.out.println("===============================================================================================================");
//        System.out.println("多级分组：");
//        final Map<String, Map<String, List<Product>>> collect3 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.groupingBy(item -> {
//            if (item.getNum() < 3) {
//                return "数量小于3";
//            } else {
//                return "数量大于等于3";
//            }
//        })));
//        for (Map.Entry entry : collect3.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//
//        System.out.println("===============================================================================================================");
//        System.out.println("按照子组收集数据：");
//        System.out.println("求总和");
//        final Map<String, Long> collect4 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
//        for (Map.Entry entry : collect4.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//        System.out.println("===============================================================================================================");
//        final Map<String, Integer> collect5 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getNum)));
//        for (Map.Entry entry : collect5.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//        System.out.println("===============================================================================================================");

//        System.out.println("把收集器的结果转换为另一种类型");
//        Map<String, Product> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory,
//                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Product::getNum)), Optional::get)));
//        for (Map.Entry entry : prodMap.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }

        Map<String, Map> collect6 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.collectingAndThen(Collectors.toList(), m -> {
            Map hashMap = new HashMap();
            final BigDecimal 啤酒 = m.stream().filter(mm -> mm.getCategory().equals("啤酒")).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            final BigDecimal 零食 = m.stream().filter(mm -> !mm.getCategory().equals("啤酒")).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

            hashMap.put("啤酒总价格", 啤酒);
            hashMap.put("零食总价格", 零食);
            System.out.println("啤酒总价格:" + 啤酒);
            System.out.println("零食总价格:" + 零食);
            return hashMap;
        })));

    }
}
