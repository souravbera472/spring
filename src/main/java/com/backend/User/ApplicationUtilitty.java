package com.backend.User;

import java.util.HashMap;
import java.util.Map;

public class ApplicationUtilitty {

    Map<String,Object> data = new HashMap<>();

    public Map<String, Object> getData(){

        data.put("name1", "sourav1");
        data.put("name2","sourav2");
       return data;
    }

    public Map<String ,Object> addData(Map<String ,Object> reqestBody){

        String res1 = (String) reqestBody.get("name");
        data.put("name3",res1);
        return data;
    }
}
