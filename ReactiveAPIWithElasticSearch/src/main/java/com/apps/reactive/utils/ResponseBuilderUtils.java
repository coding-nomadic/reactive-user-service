package com.apps.reactive.utils;

import com.apps.reactive.models.Hit;
import com.apps.reactive.models.Response;
import com.apps.reactive.models.Root;
import com.apps.reactive.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Tenzin Dawa
 *
 */
public class ResponseBuilderUtils {
    private static final Logger LOGGER = Logger.getLogger(ResponseBuilderUtils.class);

    /**
     * 
     * @param object
     * @return
     */
    public static User prepare(Object object) {
        Response response = null;
        try {
            response = JsonUtils.getObject(JsonUtils.toString(object), Response.class);
        } catch (IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return response.get_source();
    }

    /**
     * 
     * @param object
     * @return
     */
    public static List<User> prepareList(Object object) {
        List<User> listOfUsers = new ArrayList<User>();
        Root response = null;
        try {
            response = new ObjectMapper().readValue(JsonUtils.toString(object), Root.class);
            for (Hit hit : response.getHits().getHits()) {
                User user = setUsers(hit);
                listOfUsers.add(user);
            }
        } catch (IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return listOfUsers;
    }

    /**
     * 
     * @param hit
     * @return
     */
    private static User setUsers(Hit hit) {
        User user = new User();
        user.setAge(hit.get_source().getAge());
        user.setDateOfBirth(hit.get_source().getDateOfBirth());
        user.setFirstName(hit.get_source().getFirstName());
        user.setLastName(hit.get_source().getLastName());
        user.setOccupation(hit.get_source().getOccupation());
        user.setUserId(hit.get_source().getUserId());
        return user;
    }
}
