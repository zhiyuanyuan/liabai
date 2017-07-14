package com.zhiyuan.libai.bean;

import java.util.List;

/**
 * Created by admin on 2017/7/14.
 */

public class Result {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"list":["第一莫惊懅，三驱仍百步。方与天地长，士卒还故乡。大堤行乐处，夫子思何速。","第一莫惊懅，三男婚令族。方以称文明，士卒难全形。大道连国门，夫君更质真。","第一人擢第，三秋违北地。方传车骑名，士卒难全形。大妇裁纨素，夫子华阴居。","第一第二拍，三山安在哉。方崇庙貌礼，士有不得志。大业光寰宇，夫子佐戎幕。","第一人擢第，三辰破黍稷。方知斯路难，士安逾弱冠。大儿贩材木，夫婿断音书。","第一人擢第，三山银作地。方以称文明，士节自光明。大歌胡无行，夫子屡新命。"]}
     */

    public int showapi_res_code;
    public String showapi_res_error;
    public ShowapiResBodyBean showapi_res_body;

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * list : ["第一莫惊懅，三驱仍百步。方与天地长，士卒还故乡。大堤行乐处，夫子思何速。","第一莫惊懅，三男婚令族。方以称文明，士卒难全形。大道连国门，夫君更质真。","第一人擢第，三秋违北地。方传车骑名，士卒难全形。大妇裁纨素，夫子华阴居。","第一第二拍，三山安在哉。方崇庙貌礼，士有不得志。大业光寰宇，夫子佐戎幕。","第一人擢第，三辰破黍稷。方知斯路难，士安逾弱冠。大儿贩材木，夫婿断音书。","第一人擢第，三山银作地。方以称文明，士节自光明。大歌胡无行，夫子屡新命。"]
         */

        public int ret_code;
        public List<String> list;
    }
}
