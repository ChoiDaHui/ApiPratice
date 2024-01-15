package com.apipractice;

import com.apipractice.dto.ListDTO;
import com.apipractice.service.ApiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ApipracticeApplicationTests {
    private final String url = "https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=중구";
    @Test
    void contextLoads() throws Exception {


        RestTemplate restTemplate = new RestTemplate();
        String list = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(list);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        String title = null;
        String address = null;
        String language = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            title = item.getString("BZ_NM");
            address = item.getString("GNG_CS");
            language = item.getString("PSB_FRN");

            System.out.println();
            System.out.println(title);
            System.out.println(address);
            System.out.println(language);
            System.out.println("-----------------------------------------");
        }

        System.out.println(jsonObject.get("data"));

    }
}
