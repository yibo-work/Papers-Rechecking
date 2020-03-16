package com.rechecking;

import com.rechecking.utils.CosineSimilarityUtil;
import com.rechecking.utils.SegmentationAlgorithmUtil;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecheckingApplicationTests {
    
    private static String seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
        StringBuilder result = new StringBuilder();
        for (Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)) {
            result.append(word.getText()).append(" ");
        }
        System.err.println(result);
        return result.toString();
    }
    
    public static void showMore(Map<String, Map<String, String>> map) {
        map.keySet().forEach(k -> {
            System.out.println(k + " 的分词结果：");
            AtomicInteger i = new AtomicInteger();
            map.get(k).keySet().forEach(a -> System.out.println("\t" + i.incrementAndGet() + " 、【" + a + "】\t" + map.get(k).get(a)));
        });
        
    }
    
    @Test
    public void contextLoads() {
        /*Map<String, String> map = segMore("在本篇文章开始之前，我想先来回答一个问题：我为什么要写这样一篇关于面试的文章？原因有三个：第一，我想为每一个为梦想时刻准备着的“有心人”，尽一份自己的力量，提供一份高度精华的 Java 面试清单；第二，目前市面上的面试题不是答案不准确就是内容覆盖面太窄，所以提供一份经典而又准确的面试题是非常有必要的；第三，本文会对部分面试题提供详细解读和代码案例，让读者知其然并知其所以然，从而学到更多的知识。");
        Map<String, Map<String, String>> newMap = new HashMap<>();
        newMap.put("在本篇文章开始之前，我想先来回答一个问题：我为什么要写这样一篇关于面试的文章？原因有三个：第一，我想为每一个为梦想时刻准备着的“有心人”，尽一份自己的力量，提供一份高度精华的 Java 面试清单；第二，目前市面上的面试题不是答案不准确就是内容覆盖面太窄，所以提供一份经典而又准确的面试题是非常有必要的；第三，本文会对部分面试题提供详细解读和代码案例，让读者知其然并知其所以然，从而学到更多的知识。", map);
        
        showMore(newMap);*/
        
        Map<String, String> map = segMore("Java是世界上最好的语言，不对，Python才是");
        Map<String, Map<String, String>> newMap = new HashMap<>();
        newMap.put("Java是世界上最好的语言，不对，Python才是", map);
        
        showMore(newMap);
    }
    
    public Map<String, String> segMore(String text) {
        Map<String, String> map = new HashMap<>();
        for (SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()) {
            map.put(segmentationAlgorithm.getDes(), seg(text, segmentationAlgorithm));
        }
        return map;
    }
    
    @Test
    public void myTest() {
        List<String> stringList = SegmentationAlgorithmUtil.segmentationAlgorithm("Java是世界上最好的语言，不对，Python才是");
        stringList.forEach(System.out::println);
    }
    
    @Test
    public void similarityTest(){
        CosineSimilarityUtil text1 = new CosineSimilarityUtil("我觉的我还行吧，I am icon man");
        CosineSimilarityUtil text2 = new CosineSimilarityUtil("你觉得我还行吗？I am super man");
        System.out.println(text1.similarityRatio(text2.getMap()) + " similarityRatio.");
        CosineSimilarityUtil text3 = new CosineSimilarityUtil("他觉得你还行吧。I am black woman");
        System.out.println(text3.similarityRatio(text2.getMap()) + " similarityRatio.");
    
    
        CosineSimilarityUtil text4 = new CosineSimilarityUtil("我觉的我还行吧，I am icon man");
        CosineSimilarityUtil text5 = new CosineSimilarityUtil("你觉得我还行吗？I am super man");
        System.out.println(text1.similarityRatio(text4.getMap()) + " similarityRatio.");
        CosineSimilarityUtil text6 = new CosineSimilarityUtil("他觉得你还行吧。I am black woman");
        System.out.println(text4.similarityRatio(text5.getMap()) + " similarityRatio.");
    
        CosineSimilarityUtil text7 = new CosineSimilarityUtil("我觉的我还行吧，I am icon man");
        CosineSimilarityUtil text8 = new CosineSimilarityUtil("你觉得我还行吗？I am super man");
        System.out.println(text8.similarityRatio(text6.getMap()) + " similarityRatio.");
        CosineSimilarityUtil text9 = new CosineSimilarityUtil("他觉得你还行吧。I am black woman");
        System.out.println(text9.similarityRatio(text7.getMap()) + " similarityRatio.");
    
    }
}