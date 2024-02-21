package ru.kustikov.cakes.socials;

import lombok.Data;

@Data
public class SocialNetwork {
    private Long socialNetworkId;

    private String type;

    private String url;
}
