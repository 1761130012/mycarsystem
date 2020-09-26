package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.TestUserService;
import com.utils.AuthService;
import com.utils.Base64Util;
import com.utils.HttpUtil;
import com.vo.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class TestUserController {
    @Autowired
    private TestUserService testUserService;

    @RequestMapping("/login.info")
    @ResponseBody
    public boolean login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String base = request.getParameter("base");
        System.out.println(base);

        //对前端获取的base64数据进行处理
        base = base.replaceFirst("data:image/png;base64,", "");

        //对base64编码进行解码
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] hhh = decoder.decodeBuffer(base);
        for (int i = 0; i < hhh.length; ++i) {
            if (hhh[i] < 0) {                // 调整异常数据
                hhh[i] += 256;
            }
        }
        boolean result = false;
        try {

            List<TestUser> users = testUserService.queryAll();
            String base64 = "";
            PrintWriter writer = response.getWriter();
            response.reset();

            for (TestUser user : users) {
                base64 = new String(user.getImage());
                result = match(hhh, user.getImage());
                System.out.println("是否匹配：" + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return result;
    }

    public static boolean match(byte[] imgStr1, byte[] imgStr2) {
        // 请求url
        boolean flag = false;
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {

            /*byte[] bytes1 = FileUtil.readFileByBytes("d:/04.jpg");
            byte[] bytes2 = FileUtil.readFileByBytes("d:/01.jpg");*/
            String image1 = Base64Util.encode(imgStr1);
            String image2 = Base64Util.encode(imgStr2);

            List<Map<String, Object>> images = new ArrayList<>();

            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NORMAL");

            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");

            images.add(map1);
            images.add(map2);

            String param = JSONObject.toJSONString(images);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth("W4mqqG7E8SmuhK6ZbWvGFEGs",
                    "C3GBOkjWHnOSjCiAFldrKpEPOb9sthBN");

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            /*JSONObject fromObject = JSONObject.fromObject(result);

    		JSONArray jsonArray = fromObject.getJSONArray("result");

    		for (int i = 0; i < jsonArray.size(); i++) {
    			JSONObject object = (JSONObject) jsonArray.get(i);
    			double resultList = object.getDouble("score");
    			if (resultList >= 90) {
    				flag = true;

    			}
    		}*/
            ObjectMapper mapper = new ObjectMapper();

            Map map = mapper.readValue(result, Map.class);

            Set keySet = map.keySet();
            Iterator iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                System.out.print("key:" + key);
                System.out.println(",value:" + map.get(key));

                if (key.equals("result")) {
                    Map map3 = (Map) map.get(key);

                    double resultList = Double.parseDouble(map3.get("score") + "");
                    if (resultList >= 90) {
                        flag = true;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
