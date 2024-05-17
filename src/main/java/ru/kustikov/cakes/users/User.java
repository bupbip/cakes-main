package ru.kustikov.cakes.users;

import lombok.Data;
import ru.kustikov.cakes.filling.Filling;
import ru.kustikov.cakes.producttype.ProductType;
import ru.kustikov.cakes.socials.SocialNetwork;

import java.sql.Timestamp;
import java.util.List;

@Data
public class User {
    private Long userId;

    private String email;

    private String phone;

    private String username;

    private String description;

    private String password;

    private String role;

    private String image;

    private List<SocialNetwork> socialNetworks;

    private List<ProductType> productTypes;

    private List<Filling> fillings;

    private Timestamp lastActivity;

    private Object subscriptions;

    private Object feedbacksTo;
}
