package com.backend.User;

import java.net.UnknownHostException;
import java.util.*;

import com.mongodb.*;


public class MongodbUtility{

   public static DB getMongoDb() throws UnknownHostException{
      MongoClient mongoClient = new MongoClient("localhost", 27017);
      DB database = mongoClient.getDB("library");
      System.out.println("Mongodb Database: " +database);
      return database;
   }

   public static Object getAllMongoData(String collectionName){
      List<Object> list = new ArrayList<>();
      try {
         DB db = getMongoDb();
         DBCollection collection = db.getCollection(collectionName);
         System.out.println("Mongodb Collection: "+collection);

         DBCursor cursor = collection.find();
         Objects res;
         while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            list.add(obj);
            //System.out.println(obj);
         }
      }
      catch (Exception e){
         e.printStackTrace();
      }
      return list;
   }

   public static Object getOneMongoData(int id, String collectionName)  {
      List<Object> list = new ArrayList<>();
      try {
         DB db = getMongoDb();
         DBCollection collection = db.getCollection(collectionName);
         DBObject doc =  collection.findOne(id);
         list.add(doc);
         System.out.println(list);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      }
      return list;
   }
   public static List<Object> putOneMongoData(int id, String collectionName,Object data)  {
      List<Object> list = new ArrayList<>();
      try {
         DB db = getMongoDb();
         DBCollection collection = db.getCollection(collectionName);
         //DBObject andRemove = collection.findAndRemove(new DBObject(id));
         String st = addOneInMongo(collectionName,data);
         list.add(data);
         System.out.println(list);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      }
      return list;
   }

   public static String addOneInMongo(String collectionName, Object doc){
      try {
         DB db = getMongoDb();
         DBCollection collection = db.getCollection(collectionName);
         System.out.println("Mongodb Collection: "+collection);
         collection.insert((DBObject) doc);
         return "Data added successfully";

      }catch (Exception e){
         e.printStackTrace();
         return "Data can't added due to internal Mongo Error";
      }
   }

   public static void main(String[] args) {
      MongodbUtility obj = new MongodbUtility();
      //Map<String,String> res = new HashMap<>();
      DBObject res = new BasicDBObject();
      //res1.isPartialObject("");
      res.put("_id","1");
      res.put("name","new book");
//      obj.addOneInMongo("book",res);
      //obj.getOneMongoData(1,"book");
      obj.putOneMongoData(1,"book",res);
   }
}


