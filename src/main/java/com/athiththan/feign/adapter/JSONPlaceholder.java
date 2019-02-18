package com.athiththan.feign.adapter;

import java.util.List;

import com.athiththan.feign.dao.Post;
import com.athiththan.feign.dao.User;

import feign.Param;
import feign.RequestLine;

public interface JSONPlaceholder {

    /**
     * get all users from json placeholder
     * 
     * @return a list of {@link User}
     */
    @RequestLine("GET /")
    List<User> users();

    /**
     * get user by id
     * 
     * @param id
     * @return a single {@link User} Object
     */
    @RequestLine("GET /{id}/")
    User users(@Param("id") int id);

    /**
     * get posts of a user using userId
     * 
     * @param userId
     * @return a list of {@link Post}
     */
    @RequestLine("GET /{id}/posts")
    List<Post> posts(@Param("id") int userId);

}
