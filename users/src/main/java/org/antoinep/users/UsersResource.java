package org.antoinep.users;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.antoinep.users.models.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject UsersService usersService;

    @GET
    public List<User> list() {
        return usersService.list();
    }

    @POST
    public void add(User user) {
        usersService.add(user);
    }
}