package com.github.wxz.framework.netease;

import com.github.wxz.common.util.CommonContent;
import com.github.wxz.common.util.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxianzhi
 * @date: 2018/1/28
 * @time: 16:44
 * @email: xianzhi@eastmoney.com
 */

public class NetEaseUtil {


    private static final int RETRY_TIMES = 5;
    private static Logger LOGGER = LoggerFactory.getLogger(NetEaseUtil.class);
    private static Map<String, String> headers = new HashMap<>();

    static {
        headers.put("Referer", "http://music.163.com");
        headers.put("Origin", "http://music.163.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
    }

    private static String post(String url, String requestJsonStr) {
        Map<String, String> body = NetEaseEncryptUtil.encrypt(requestJsonStr);
        LOGGER.info("url {}  requestJsonStr {}", url, requestJsonStr);
        try {
            String response = MusicUtils.getNetEase(url, body);
            LOGGER.info("url {}  requestJsonStr {} result {} ", url, requestJsonStr, response);
            return response;
        } catch (Exception e) {
            return null;
        }

    }

    public static String getMusic(NetEaseSearchDO netEaseSearchDO,
                                  Integer type, String word, Integer offset, Integer limit) {
        type = 1;
        offset = 0;
        if (netEaseSearchDO.getLimit() == null) {
            netEaseSearchDO.setLimit(15);
        }

        word = "简单爱";
        // String data = "{\"s\":\"" + UrlUtils.encode(word) + "\",\"type\":\"" + type + "\",\"offset\":\"" + offset + "\",\"limit\":\"" + limit + "\"}";
        String url = "https://s.music.163.com/search/get/?s=" + UrlUtils.encode(word) + "&type=1&offset=0&limit=30";
        try {
            return MusicUtils.getHtml(url);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getLyric(long id) {

        String url = "https://music.163.com/api/song/lyric?os=pc&id=" + id + "&lv=-1";
        try {
            return MusicUtils.getHtml1(url);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getPlayUrl(long id) {

        //String data = "{\"uid\":" + userId + ",\"wordwrap\":\"7\",\"offset\":\"0\",\"total\":\"true\",\"limit\":\"1000\"}";
        String data = "{\"ids\":" + "[" + id + "]" + ",\"br\":\"128000\"" + ",\"wordwrap\":\"7\",\"offset\":\"0\",\"total\":\"true\",\"limit\":\"1000\"}";
        String url = "http://music.163.com/weapi/song/enhance/player/url";
        return post(url, data);
    }

    public static String getPlayUrlByIds(long[] ids) {
        StringBuffer id = new StringBuffer();
        for (int i = 0; i < ids.length; i++) {
            if (i == ids.length - 1) {
                id.append(ids[i] + "");
            } else {
                id.append(ids[i] + ",");
            }
        }
        String sid = ids.toString();

        //String data = "{\"uid\":" + userId + ",\"wordwrap\":\"7\",\"offset\":\"0\",\"total\":\"true\",\"limit\":\"1000\"}";
        String data = "{\"ids\":" + "[" + sid + "]" + ",\"br\":\"128000\"" + ",\"wordwrap\":\"7\",\"offset\":\"0\",\"total\":\"true\",\"limit\":\"1000\"}";
        String url = "http://music.163.com/weapi/song/enhance/player/url";
        return post(url, data);
    }

    /**
     * 搜索
     *
     * @param type
     * @param word
     * @param offset
     * @param limit
     * @return
     */
    public String cloudSearch(Integer type, String word, Integer offset, Integer limit) {
        if (type == null) {
            type = 1;
        }
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = 25;
        }

        String data = "{" +
                "\"hlpretag\":\"\"," +
                "\"hlposttag\":\"\"," +
                "\"s\":\"" + UrlUtils.encode(word) +
                "\",\"type\":\""
                + type
                + "\",\"offset\":\"" +
                offset + "\"," +
                "\"total\":\"true\"," +
                "\"limit\":\"" + limit + "\"}";
        return post(CommonContent.CLOUD_SEARCH_URL, data);
    }


}
