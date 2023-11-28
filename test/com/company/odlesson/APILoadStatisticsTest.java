package com.company.odlesson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class APILoadStatisticsTest {

    @Test
    public void calApiLoad() {
        APILoadStatistics apiLoadStatistics = new APILoadStatistics();
        int num = 8;
        List<String> apis = new ArrayList<>();
        apis.add("/test/okk/compute/t1");
        apis.add("/test/okk/add/t1");
        apis.add("/test/okk/compute/wbg");
        apis.add("/test/okk/compute/jdg");
        apis.add("/test/Okk/compute/WBG");
        apis.add("/odd/Okk/compute/wbg");
        apis.add("/odd/Okk/subtract/eng");
        apis.add("/odd/tkk/subtract/math");
        int layer1 = 1;
        String keyword1 = "odd";
        assertEquals(3, apiLoadStatistics.calApiLoad(num, apis, layer1, keyword1));
        int layer2 = 1;
        String keyword2 = "test";
        assertEquals(5, apiLoadStatistics.calApiLoad(num, apis, layer2, keyword2));
        int layer3 = 1;
        String keyword3 = "ODD";
        assertEquals(0, apiLoadStatistics.calApiLoad(num, apis, layer3, keyword3));
        int layer4 = 2;
        String keyword4 = "Okk";
        assertEquals(3, apiLoadStatistics.calApiLoad(num, apis, layer4, keyword4));
        int layer5 = 3;
        String keyword5 = "add";
        assertEquals(1, apiLoadStatistics.calApiLoad(num, apis, layer5, keyword5));
        int layer6 = 3;
        String keyword6 = "Add";
        assertEquals(0, apiLoadStatistics.calApiLoad(num, apis, layer6, keyword6));
        int layer7 = 4;
        String keyword7 = "WBG";
        assertEquals(1, apiLoadStatistics.calApiLoad(num, apis, layer7, keyword7));
    }
}