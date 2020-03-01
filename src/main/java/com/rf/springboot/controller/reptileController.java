package com.rf.springboot.controller;

import com.rf.springboot.request.RequesetUrlAndTag;
import com.rf.springboot.response.JsonResult;
import com.rf.springboot.util.ParseHtml;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
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
            //将String类型的html转换为Document
            Document doc = ParseHtml.parseHtml(requesetUrlAndTag.getUrl());
            //获取所有class为pl2的元素，即包含所有<a>的div
            Elements nodes = doc.getElementsByClass(requesetUrlAndTag.getElementId());
            JsonResult.success(nodes.text());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.success();
    }

}
