package com.rechecking.utils;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clrvn
 * @description 分割算法工具类
 * @className SegmentationAlgorithmUtil
 * @date 2019-05-22 1:50
 */
public class SegmentationAlgorithmUtil {
    
    private static List<String> seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
        List<String> stringList = new ArrayList<>();
        for (Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)) {
            stringList.add(word.getText());
        }
        return stringList;
    }
    
    public static List<String> segmentationAlgorithm(String text) {
        List<String> stringList = new ArrayList<>();
        for (SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()) {
            stringList.addAll(seg(text, segmentationAlgorithm));
        }
        return stringList;
    }
}
