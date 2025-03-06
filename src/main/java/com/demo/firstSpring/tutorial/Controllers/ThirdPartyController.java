package com.demo.firstSpring.tutorial.Controllers;

import com.demo.firstSpring.tutorial.services.PostService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ThirdPartyController {

    @Autowired
    private PostService postService;

    @GetMapping(path = "/getDetails",produces = {MediaType.APPLICATION_JSON_VALUE})
    private String getHello() {
        String uri = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate template = new RestTemplate();
        return JsonParser.parseString(template.getForObject(uri,String.class)).getAsJsonArray().toString();
    }

    @GetMapping(path = "/getPosts", produces = {MediaType.APPLICATION_JSON_VALUE})
    private String getPosts() {
        return postService.getPosts();
    }

    @PostMapping(path = "/getPostData",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    private String getPostData(@RequestBody String reqData) {
        return postService.addPosts(reqData);
    }

    @GetMapping(path = "/getAllPosts", produces = {MediaType.APPLICATION_JSON_VALUE})
    private String getAllPosts() {
        return postService.getAllPost();
    }



}
