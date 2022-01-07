package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Player {
    private String name;
    private Long id;
    @Setter
    private int location;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.location = 0;
    }
}
