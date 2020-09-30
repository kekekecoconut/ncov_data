package com.keke.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.WordDictionary;
import com.keke.domain.WordCloud;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class SemesterAnalyseUtil {

    public List<String> analyseSemester(String content){
     //   String content = "北京新增确诊连续5天为个位数 治愈出院病例持续增加";
        CustomDictionary.add("新冠肺炎");
        CustomDictionary.add("抗击肺炎");
        CustomDictionary.add("就业率");
        CustomDictionary.add("迪士尼");
        CustomDictionary.add("抗击疫情");
        CustomDictionary.add("核酸检测");
        CustomDictionary.add("核酸检测能力");
        CustomDictionary.add("治愈出院");
        CustomDictionary.add("确诊病例");
        CustomDictionary.add("集中隔离");
        CustomDictionary.add("外卖小哥");
        CustomDictionary.add("世卫");
        CustomDictionary.add("新增确诊病例");
        CustomDictionary.add("输入病例");
        CustomDictionary.add("加剧疫情");
        List<String> keywordList = HanLP.extractKeyword(content, 2);
        System.out.println(keywordList);
        return keywordList;
    }

}
