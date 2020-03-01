package com.rf.springboot.controller;

import com.rf.springboot.request.RequesetUrlAndTag;
import com.rf.springboot.response.JsonResult;
import com.rf.springboot.util.ParseHtml;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: wuwei
 * @Date:2020-02-22 23:19
 * 爬取网站信息
 */
@RestController
@RequestMapping("reptile")
public class reptileController {

    public static final Logger logger = LoggerFactory.getLogger(reptileController.class);

    @PostMapping("/getDocumentByTag")
    public JsonResult getDocumentByTag(@RequestBody @Valid RequesetUrlAndTag requesetUrlAndTag) {
        try {
            if (StringUtils.isEmpty(requesetUrlAndTag.getUrl())) {
                logger.error("请输入需要抓取的地址");
            }
            if (StringUtils.isEmpty(requesetUrlAndTag.getElementId())) {
                logger.error("请输入需要抓取地址的标签");
            }
            Document doc = ParseHtml.parseHtml(requesetUrlAndTag.getUrl());
            Elements nodes = doc.getElementsByClass(requesetUrlAndTag.getElementId());
            logger.info("解析的结果--------nodes.text():"+nodes.toString());
            return JsonResult.success(nodes.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.success();
    }

}
