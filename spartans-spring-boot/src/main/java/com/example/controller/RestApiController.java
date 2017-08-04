package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.model.User;
import com.example.service.CustomErrorType;
import com.example.service.UserService;
 
 
@RestController
@RequestMapping("/api")
public class RestApiController {
 
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
 
    @Autowired
    UserService userService; //Service which will do all data retrieval/manipulation work
 
    // -------------------Retrieve All Users---------------------------------------------
 
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single User------------------------------------------
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        logger.info("Fetching User with id {}", id);
        User user = userService.findById(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
    // -------------------Create a User-------------------------------------------
 
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", user);
 
        if (userService.isUserExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
            user.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a User ------------------------------------------------
 
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        logger.info("Updating User with id {}", id);
 
        User currentUser = userService.findById(id);
 
        if (currentUser == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentUser.setName(user.getName());
        
        currentUser.setEmail(user.getEmail());
        currentUser.setPhoneNumber(user.getPhoneNumber());
 
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = "/chartjson/", method = RequestMethod.GET )
    public ResponseEntity<String> chart() {
 
        System.out.println("inside json chart-------------");
        Map<String, String> data1 = new HashMap<String,String>();
        data1.put( "key", "Computers");
        data1.put( "value","114");
 
        Map<String, Object> data2 = new HashMap<String, Object>();
        data2.put( "key", "Electronics");
        data2.put( "value","214");
 
        Map<String, Object> data3 = new HashMap<String, Object>();
        data3.put( "key", "Mechanical");
        data3.put( "value","514");
 
        JSONObject json1 = new JSONObject(data1);
        JSONObject json2 = new JSONObject(data2);
        JSONObject json3 = new JSONObject(data3);
 
        JSONArray array = new JSONArray();
        array.put(json1);
        array.put(json2);
        array.put(json3);
 
        JSONObject finalObject = new JSONObject();
        finalObject.put("student_data", array);
 
//        response.getOutputHeaders().putSingle("Access-Control-Allow-Origin", "*");
//        return Response.status(200).entity(finalObject.toString()).build();
      
        return new ResponseEntity<String>(finalObject.toString(), HttpStatus.OK);
    }
    
    
 
    // ------------------- Delete a User-----------------------------------------
 
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
//        logger.info("Fetching & Deleting User with id {}", id);
// 
//        User user = userService.findById(id);
//        if (user == null) {
//            logger.error("Unable to delete. User with id {} not found.", id);
//            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
//                    HttpStatus.NOT_FOUND);
//        }
//        userService.deleteUserById(id);
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
// 
    // ------------------- Delete All Users-----------------------------
 
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUsers() {
//        logger.info("Deleting All Users");
// 
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
 
//    @Context org.jboss.resteasy.spi.HttpResponse response;
 
//    @Produces("application/json")
//    @RequestMapping(value = "/chartjson", method = RequestMethod.GET)
//    public Response getJSONData() {
//
//    }
}