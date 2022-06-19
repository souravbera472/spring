package com.backend.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GetApplication {

    @RequestMapping("/get/student")
    public Object getHelloWorld(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Map<String,Object>> data = new HashMap<>();
        result.put("Name","Sourav");
        result.put("Mark", 70);
        result.put("Phone","7548036747");
        data.put("result",result);

        return data;
    }
    @GetMapping("/new")
    public Object getMethod(){
        return MongodbUtility.getAllMongoData("book");
    }

    @GetMapping("/user")
    public Object getUserData(){
        return MongodbUtility.getAllMongoData("user_data");
    }

    @GetMapping("/new/{id}")
    public Object getOneData(@PathVariable int id){
        return MongodbUtility.getOneMongoData(id,"book");
    }

}
