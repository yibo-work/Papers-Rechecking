package com.clrvn;

import java.util.HashMap;
import java.util.Map;

import com.rechecking.RecheckingApplicationTests;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
/*import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;*/

/**
 * @author Clrvn
 * @description
 * @className SimilaryTest
 * @date 2019-05-22 0:47
 */
public class SegWordTest extends RecheckingApplicationTests {
    
    public Map<String, String> segMore(String text) {
        Map<String, String> map = new HashMap<>();
        for(SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()){
            map.put(segmentationAlgorithm.getDes(), seg(text, segmentationAlgorithm));
        }
        return map;
    }
    private static String seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
        StringBuilder result = new StringBuilder();
        for(Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)){
            result.append(word.getText()).append(" ");
        }
        System.err.println(result);
        return result.toString();
    }
    
    
}
