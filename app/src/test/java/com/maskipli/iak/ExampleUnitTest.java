package com.maskipli.iak;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() throws Exception {
        Document doc = Jsoup.connect("http://kbbi.web.id/hidayat").get();
        Elements result = doc.select("div#d1");
        Elements info = result.select("div#info");
        System.out.println(result);
        System.out.println(info);
    }
}