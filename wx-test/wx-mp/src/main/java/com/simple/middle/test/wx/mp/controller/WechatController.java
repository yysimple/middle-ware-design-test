package com.simple.middle.test.wx.mp.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.simple.middle.test.wx.mp.model.BehaviorMatter;
import com.simple.middle.test.wx.mp.model.MessageTextEntity;
import com.simple.middle.test.wx.mp.util.SignatureUtil;
import com.simple.middle.test.wx.mp.util.XmlUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 项目: middle-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-08-19 21:40
 **/
@RestController
public class WechatController {

    private final Logger logger = LoggerFactory.getLogger(WechatController.class);

    String token = "yysimple";
    String appid = "";
    String aseKey = "";

    /**
     * 处理微信服务器发来的get请求，进行签名的验证
     * <p>
     * appid     微信端AppID
     * signature 微信端发来的签名
     * timestamp 微信端发来的时间戳
     * nonce     微信端发来的随机字符串
     * echostr   微信端发来的验证字符串
     */
    @GetMapping("/wx/checkCall")
    public String validate(@RequestParam(value = "signature", required = false) String signature, @RequestParam(value = "timestamp", required = false) String timestamp, @RequestParam(value = "nonce", required = false) String nonce, @RequestParam(value = "echostr", required = false) String echostr) {
        try {
            logger.info("微信公众号验签信息{}开始 [{}, {}, {}, {}]", appid, signature, timestamp, nonce, echostr);
            if (StrUtil.hasBlank(signature, timestamp, nonce, echostr)) {
                throw new IllegalArgumentException("请求参数非法，请核实!");
            }
            boolean check = checkSign(signature, timestamp, nonce);
            logger.info("微信公众号验签信息{}完成 check：{}", appid, check);
            if (!check) {
                return null;
            }
            return echostr;
        } catch (Exception e) {
            logger.error("微信公众号验签信息{}失败 [{}, {}, {}, {}]", appid, signature, timestamp, nonce, echostr, e);
            return null;
        }
    }

    public boolean checkSign(String signature, String timestamp, String nonce) {
        return SignatureUtil.check(token, signature, timestamp, nonce);
    }

    /**
     * 此处是处理微信服务器的消息转发的
     */
    @PostMapping("/wx/checkCall")
    public String post(@RequestBody String requestBody, @RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce, @RequestParam("openid") String openid, @RequestParam(name = "encrypt_type", required = false) String encType, @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        try {
            logger.info("接收微信公众号信息请求{}开始 {}", openid, requestBody);
            MessageTextEntity message = XmlUtil.xmlToBean(requestBody, MessageTextEntity.class);
            logger.info("解析后的信息：{}", JSON.toJSONString(message));
            BehaviorMatter behaviorMatter = new BehaviorMatter();
            behaviorMatter.setOpenId(openid);
            behaviorMatter.setFromUserName(message.getFromUserName());
            behaviorMatter.setMsgType(message.getMsgType());
            behaviorMatter.setContent(StringUtils.isBlank(message.getContent()) ? null : message.getContent().trim());
            behaviorMatter.setEvent(message.getEvent());
            behaviorMatter.setCreateTime(new Date(Long.parseLong(message.getCreateTime()) * 1000L));
            // 处理消息
            logger.info("接收微信公众号信息请求，内容： {}", JSON.toJSONString(behaviorMatter));
            BehaviorMatter sendMsg = new BehaviorMatter();
            BeanUtils.copyProperties(behaviorMatter, sendMsg);
            return send(sendMsg);
        } catch (Exception e) {
            logger.error("接收微信公众号信息请求{}失败 {}", openid, requestBody, e);
            return "";
        }
    }

    public String send(BehaviorMatter request) throws Exception {

        //反馈信息[文本]
        MessageTextEntity res = new MessageTextEntity();
        res.setToUserName("gh_a017f8adf5a5");
        res.setFromUserName(res.getFromUserName());
        res.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000L));
        res.setMsgType("text");
        res.setContent("我接到你的消息了啦..");
        logger.info("发送给用户的消息：{}", JSON.toJSONString(res));
        return XmlUtil.beanToXml(res);
    }

}
