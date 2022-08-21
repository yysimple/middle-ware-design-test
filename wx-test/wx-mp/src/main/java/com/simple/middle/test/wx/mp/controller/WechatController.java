package com.simple.middle.test.wx.mp.controller;

import cn.hutool.core.util.StrUtil;
import com.simple.middle.test.wx.mp.util.SignatureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
