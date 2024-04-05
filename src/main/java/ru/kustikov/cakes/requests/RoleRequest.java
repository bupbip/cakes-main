package ru.kustikov.cakes.requests;

import lombok.Data;
import ru.kustikov.cakes.users.User;

import java.sql.Timestamp;

@Data
public class RoleRequest {
    private Long roleRequestId;

    private User user;

    private Timestamp requestDatetime;
}
