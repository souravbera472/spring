package com.backend.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class postUserDataApplication {

    @PostMapping("/user")
    public String postUserData(@RequestBody Map<String,Object> usr){
        try {
        MongodbUtility object = new MongodbUtility();
        DBObject res = new BasicDBObject();
        res.put("_id",usr.get("_id"));
        res.put("email",usr.get("email"));
        res.put("password",usr.get("password"));
        object.addOneInMongo("user_data",res);
        return "Data post successfully";
        }catch (Exception e){
            e.printStackTrace();
            return "Data not posted";
        }
    }

    @PostMapping("/new")
    public void postData(@RequestBody Map<String,Object> usr){
        MongodbUtility object = new MongodbUtility();
        DBObject res = new BasicDBObject();
        res.put("_id",usr.get("_id"));
        res.put("name",usr.get("name"));
        object.addOneInMongo("book",res);
    }
}
