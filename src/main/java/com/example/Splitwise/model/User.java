package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel{

    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;

}

/*
    in database two tables are created for bi-directional mapping of users and group -> splitwise_user_groups
    and splitwise_groups_user, we only need one mapping table.

    for bi-directional (since many to many annotation is in both the class) m:m, we use mappedBy

 */
