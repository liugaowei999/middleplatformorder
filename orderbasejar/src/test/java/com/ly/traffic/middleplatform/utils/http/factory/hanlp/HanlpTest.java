package com.ly.traffic.middleplatform.utils.http.factory.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.BaseSearcher;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.utils.http.factory.hanlp
 * @Description: ${TODO}
 * @date 2020/8/17 10:44
 */
public class HanlpTest {
    Segment segment;
    @Before
    public void init() {
        segment = HanLP.newSegment().enablePlaceRecognize(false)
                .enableNameRecognize(true)
                .enableOrganizationRecognize(true)
                .enableTranslatedNameRecognize(true) // 音译人名
                .enableJapaneseNameRecognize(true);  // 日本人名
        System.out.println(segment.seg("你好，刘高卫李亚洲刘杨！淄博高青县唐坊"));
        List<Term> termList = StandardTokenizer.segment("商品和服务");
        System.out.println(termList);
        System.out.println("========================== init finish =============");
    }
    /**
     * 语义距离
     */
    @Test
    public void demoWordDistance()
    {
        String[] wordArray = new String[]
                {
                        "香蕉",
                        "苹果",
                        "白菜",
                        "水果",
                        "蔬菜",
                        "自行车",
                        "公交车",
                        "飞机",
                        "买",
                        "卖",
                        "购入",
                        "新年",
                        "春节",
                        "丢失",
                        "补办",
                        "办理",
                        "送给",
                        "寻找",
                        "孩子",
                        "教室",
                        "教师",
                        "会计",
                };
        for (String a : wordArray)
        {
            for (String b : wordArray)
            {
                System.out.println(a + "\t" + b + "\t之间的距离是\t" + CoreSynonymDictionary.distance(a, b));
            }
        }
    }
    /**
     * 机构识别
     */
    @Test
    public void organizationRecognition() {
        /**
         * 机构名识别
         */
        String[] testCase = new String[]{
                "我在上海林原科技有限公司兼职工作，",
                "我经常在台川喜宴餐厅吃饭，",
                "偶尔去地中海影城看电影。",
        };
        for (String sentence : testCase)
        {
            List<Term> termList1 = segment.seg(sentence);
            System.out.println(termList1);
        }
    }
    /**
     * 文本推荐(句子级别，从一系列句子中挑出与输入句子最相似的那一个)
     * @author hankcs
     */
    @Test
    public void demoSuggester()
    {
        Suggester suggester = new Suggester();
        String[] titleArray =
                (
                        "威廉王子发表演说 呼吁保护野生动物\n" +
                                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
                                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
                                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
                                "英报告说空气污染带来“公共健康危机\n" +
                                "北京南站服务大厅停业"
                ).split("\\n");
        for (String title : titleArray)
        {
            suggester.addSentence(title);
        }
        System.out.println(suggester.suggest("讲话", 1));       // 语义
        System.out.println(suggester.suggest("危机公共", 1));   // 字符
        System.out.println(suggester.suggest("mayun", 1));      // 拼音
        System.out.println(suggester.suggest("火车站", 1));
    }

    /**
     * 依存句法解析 --- 需要下载data， 不能只通过jar包使用
     * @author hankcs
     */
    @Test
    public void DemoDependencyParser()
    {
        System.out.println(HanLP.parseDependency("把市场经济奉行的等价交换原则引入党的生活和国家机关政务活动中"));
    }

    /**
     * 索引分词
     */
    @Test
    public void indexTokenizer() {
        List<Term> termList = IndexTokenizer.segment("主副食品");
        for (Term term : termList) {
            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
        }
    }

    /**
     * N-最短路径分词
     * 1. N最短路分词器NShortSegment比最短路分词器慢，但是效果稍微好一些，对命名实体识别能力更强。
     * 2. 一般场景下最短路分词的精度已经足够，而且速度比N最短路分词器快几倍，请酌情选择。
     */
    @Test
    public void shortSegment() {
        Segment nShortSegment = new NShortSegment()
                .enableCustomDictionary(false)
                .enablePlaceRecognize(true)
                .enableOrganizationRecognize(true);

        Segment shortestSegment = new DijkstraSegment()
                .enableCustomDictionary(false)
                .enablePlaceRecognize(true)
                .enableOrganizationRecognize(true);
        String[] testCase = new String[]{
                "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。",
                "刘喜杰石国祥会见吴亚琴先进事迹报告团成员",
        };
        for (String sentence : testCase)
        {
            System.out.println("N-最短分词：" + nShortSegment.seg(sentence)
                    + "\n最短路分词：" + shortestSegment.seg(sentence));
        }
    }

    /**
     * CRF分词(在最新训练的未压缩100MB模型下，能够取得较好的效果，可以投入生产环境)
     * CRF对新词有很好的识别能力，但是无法利用自定义词典。
     */
    @Test
    public void demoCRFSegment()
    {
        HanLP.Config.ShowTermNature = false;    // 关闭词性显示
        Segment segment = new CRFSegment();
        String[] sentenceArray = new String[]
                {
                        "HanLP是由一系列模型与算法组成的Java工具包，目标是普及自然语言处理在生产环境中的应用。",
                        "鐵桿部隊憤怒情緒集結 馬英九腹背受敵",           // 繁体无压力
                        "馬英九回應連勝文“丐幫說”：稱黨內同志談話應謹慎",
                        "高锰酸钾，强氧化剂，紫红色晶体，可溶于水，遇乙醇即被还原。常用作消毒剂、水净化剂、氧化剂、漂白剂、毒气吸收剂、二氧化碳精制剂等。", // 专业名词有一定辨识能力
                        "《夜晚的骰子》通过描述浅草的舞女在暗夜中扔骰子的情景,寄托了作者对庶民生活区的情感",    // 非新闻语料
                        "这个像是真的[委屈]前面那个打扮太江户了，一点不上品...@hankcs",                       // 微博
                        "鼎泰丰的小笼一点味道也没有...每样都淡淡的...淡淡的，哪有食堂2A的好次",
                        "克里斯蒂娜·克罗尔说：不，我不是虎妈。我全家都热爱音乐，我也鼓励他们这么做。",
                        "今日APPS：Sago Mini Toolbox培养孩子动手能力",
                        "财政部副部长王保安调任国家统计局党组书记",
                        "2.34米男子娶1.53米女粉丝 称夫妻生活没问题",
                        "你看过穆赫兰道吗",
                        "乐视超级手机能否承载贾布斯的生态梦"
                };
        for (String sentence : sentenceArray)
        {
            List<Term> termList = segment.seg(sentence);
            System.out.println(termList);
        }
    }

    /**
     * 演示极速分词，基于AhoCorasickDoubleArrayTrie实现的词典分词，适用于“高吞吐量”“精度一般”的场合
     */
    @Test
    public void demoHighSpeedSegment()
    {
        String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
        System.out.println(SpeedTokenizer.segment(text));
        long start = System.currentTimeMillis();
        int pressure = 1000000;
        for (int i = 0; i < pressure; ++i)
        {
            SpeedTokenizer.segment(text);
        }
        double costTime = (System.currentTimeMillis() - start) / (double)1000;
        System.out.printf("分词速度：%.2f字每秒", text.length() * pressure / costTime);
    }

    /**
     * 说明
     *
     * CustomDictionary是一份全局的用户自定义词典，可以随时增删，影响全部分词器。
     *
     * 另外可以在任何分词器中关闭它。通过代码动态增删不会保存到词典文件。
     *
     * 追加词典
     *
     * CustomDictionary主词典文本路径是data/dictionary/custom/CustomDictionary.txt，用户可以在此增加自己的词语（不推荐）；也可以单独新建一个文本文件，通过配置文件CustomDictionaryPath=data/dictionary/custom/CustomDictionary.txt; 我的词典.txt;来追加词典（推荐）。
     *
     * 始终建议将相同词性的词语放到同一个词典文件里，便于维护和分享。
     *
     * 词典格式
     *
     * 每一行代表一个单词，格式遵从[单词] [词性A] [A的频次] [词性B] [B的频次] ... 如果不填词性则表示采用词典的默认词性。
     *
     * 词典的默认词性默认是名词n，可以通过配置文件修改：全国地名大全.txt ns;如果词典路径后面空格紧接着词性，则该词典默认是该词性。
     *
     * 关于用户词典的更多信息请参考词典说明一章。
     *
     * 算法详解
     *
     * 《Trie树分词》
     *
     * 《Aho Corasick自动机结合DoubleArrayTrie极速多模式匹配》
     */
    @Test
    public void demoCustomDictionary()
    {
        // 动态增加
        CustomDictionary.add("攻城狮");
        // 强行插入
        CustomDictionary.insert("白富美", "nz 1024");
        // 删除词语（注释掉试试）
        //        CustomDictionary.remove("攻城狮");
        System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
        System.out.println(CustomDictionary.get("单身狗"));

        String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰";  // 怎么可能噗哈哈！

        // DoubleArrayTrie分词
        final char[] charArray = text.toCharArray();
        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>()
        {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value)
            {
                System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
            }
        });
        // 首字哈希之后二分的trie树分词
        BaseSearcher searcher = CustomDictionary.getSearcher(text);
        Map.Entry entry;
        while ((entry = searcher.next()) != null)
        {
            System.out.println(entry);
        }

        // 标准分词
        System.out.println(HanLP.segment(text));

        // Note:动态增删不会影响词典文件
        // 目前CustomDictionary使用DAT储存词典文件中的词语，用BinTrie储存动态加入的词语，前者性能高，后者性能低
        // 之所以保留动态增删功能，一方面是历史遗留特性，另一方面是调试用；未来可能会去掉动态增删特性。
    }

    /**
     * 关键词提取
     * 内部采用TextRankKeyword实现，用户可以直接调用TextRankKeyword.getKeywordList(document, size)
     *
     */
    @Test
    public void getKeyWords() {
        String content = "{\\\"info\\\":\\\"本店新用户立减1元\\\",\\\"icon_url\\\":\\\"http://p0.meituan.net/activityconfig/5db8036686695d41e356f18b97fba2f71079.png\\\",\\\"promotion_type\\\":2,\\\"activity_id\\\":22},{\\\"info\\\":\\\"折扣商品4.98折起\\\",\\\"icon_url\\\":\\\"http://p0.meituan.net/activityconfig/1e5a92350c05d72bc6525e08b266644c889.png\\\",\\\"promotion_type\\\":2,\\\"activity_id\\\":17},{\\\"info\\\":\\\"实际支付30元返2元商家代金券\\\",\\\"icon_url\\\":\\\"http://p0.meituan.net/activityconfig/c15445ed667a5173fe6d96d55336d4e61087.png\\\",\\\"promotion_type\\\":2,\\\"activity_id\\\":100},{\\\"info\\\":\\\"新用户立减17元（本优惠与新人首单红包不可同享）,首次使用美团支付最高再减3元\\\",\\\"icon_url\\\":\\\"http://p1.meituan.net/activityconfig/1899e9f3d64b19f0d781bdbfb7727e1b740.png\\\",\\\"promotion_type\\\":2,\\\"activity_id\\\":1}],\\\"log_field\\\":{\\\"poi_type_icon_type\\\":3,\\\"recommend_type\\\":0,\\\"average_delivery_time\\\":30,\\\"search_log_id\\\":\\\"\\\"},\\\"label_info\\\":[{\\\"activity_id\\\":2,\\\"content\\\":\\\"40减18";
        List<String> keywordList = HanLP.extractKeyword(content, 5);
        System.out.println(keywordList);
    }

    @Test
    public void test1() {
        String text = "算法工程师\n" +
                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。" +
                "如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、" +
                "空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
                "\n" +
                "1职位简介\n" +
                "算法工程师是一个非常高端的职位；\n" +
                "专业要求：计算机、电子、通信、数学等相关专业；\n" +
                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
                "\n" +
                "2研究方向\n" +
                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
                "\n" +
                "3目前国内外状况\n" +
                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。" +
                "算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、" +
                "雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；" +
                "另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法" +
                "(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，" +
                "锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
                "算法工程师逐渐往人工智能方向发展。";
        List<String> phraseList = HanLP.extractPhrase(text, 5);
        System.out.println(phraseList);
    }
}
