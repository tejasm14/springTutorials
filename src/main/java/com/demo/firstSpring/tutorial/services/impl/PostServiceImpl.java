package com.demo.firstSpring.tutorial.services.impl;

import com.demo.firstSpring.tutorial.entities.Posts;
import com.demo.firstSpring.tutorial.repositories.PostRepository;
import com.demo.firstSpring.tutorial.services.PostService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private RestTemplate restTemplate;

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PostRepository postRepository;
    String baseUrl = "https://jsonplaceholder.typicode.com/";
    StringBuilder builder = new StringBuilder(baseUrl);
    String POSTS = "posts";

    @Override
    public String getPosts() {

        try {
            String url = String.valueOf(builder.append(POSTS));
            String response = restTemplate.getForObject(url,String.class);
            JsonArray responseArray = JsonParser.parseString(response).getAsJsonArray();
            for (JsonElement element :responseArray) {

                Posts posts = new Posts();
                JsonObject object = element.getAsJsonObject();
                Integer userId = object.get("userId").getAsInt();
                Integer id = object.get("id").getAsInt();
                String title = object.get("title").getAsString();
                String body = object.get("body").getAsString();

                posts.setUserId(userId);
                posts.setId(id);
                posts.setTitle(title);
                posts.setBody(body);

                postRepository.save(posts);
            }
            return "Response Added successfully";
        }catch (Exception exception) {
            LOG.error(exception.getMessage());
            return "Response not Added successfully";
        }
    }

    @Override
    public String addPosts(String reqObj) {
        String url = String.valueOf(builder.append(POSTS));
        HttpEntity<String > entity=new HttpEntity<>(reqObj,getHttpHeaders());
        return restTemplate.postForObject(url, entity, String.class);
    }

    @Override
    public String getAllPost() {
        String url = builder.append(POSTS).toString();
        return restTemplate.getForObject(url,String.class);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
