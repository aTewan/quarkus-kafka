package org.antoinep.users;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.antoinep.users.models.User;
import org.bson.Document;

@ApplicationScoped
public class UsersService {
  @Inject MongoClient mongoClient;

  public List<User> list() {
    List<User> users = new ArrayList<User>();
    MongoCursor<Document> cursor = getCollection().find().iterator();

    try {
      while(cursor.hasNext()) {
        Document document = cursor.next();
        User user = new User();
        user.setFirstName(document.getString("firstName"));
        user.setLastName(document.getString("lastName"));
        user.setBirthDate(document.getDate("birthDate"));
        user.setGender(document.getString("gender"));
        users.add(user);
      }
    } finally {
      cursor.close();
    }
    return users;
  }

  public void add(User user) {
    Document document = new Document()
      .append("firstName", user.getFirstName())
      .append("lastName", user.getLastName())
      .append("birthDate", user.getBirthDate())
      .append("gender", user.getGender());

      getCollection().insertOne(document);
  }

  private MongoCollection getCollection() {
    return mongoClient.getDatabase("user").getCollection("user");
  }
}
