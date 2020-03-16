package com.rechecking;

import com.rechecking.utils.CosineSimilarityUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecheckingApplication {
    
    public static void main(String[] args) {
        
        CosineSimilarityUtil text1 = new CosineSimilarityUtil("我觉的我还行吧，I am icon man");
        CosineSimilarityUtil text2 = new CosineSimilarityUtil("你觉得我还行吗？I am super man");
        System.out.println(text1.similarityRatio(text2.getMap()) + " similarityRatio.");
        CosineSimilarityUtil text3 = new CosineSimilarityUtil("他觉得你还行吧。I am black woman");
        System.out.println(text3.similarityRatio(text2.getMap()) + " similarityRatio.");
        
        SpringApplication.run(RecheckingApplication.class, args);
    }
    
}
