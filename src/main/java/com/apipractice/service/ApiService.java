package com.apipractice.service;

import com.apipractice.dto.ListDTO;
import com.apipractice.mapper.ListMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    @Autowired
    ListMapper listMapper;

    private final String url = "https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=중구";

    public JSONArray get_list(@RequestParam String language){
        RestTemplate restTemplate = new RestTemplate();
        String list = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(list);
        JSONArray jsonArray = (JSONArray)jsonObject.get("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            ListDTO listDTO = new ListDTO();
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            listDTO.setTitle(jsonObject1.get("BZ_NM").toString());
            listDTO.setAddress(jsonObject1.get("GNG_CS").toString());
            listDTO.setLanguage(jsonObject1.get("PSB_FRN").toString());
            listMapper.db_insert(listDTO);
            System.out.println(jsonObject1);

        }


        return jsonArray;

//        return (JSONArray) jsonObject.get("data");
    }


}
