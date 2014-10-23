package a1;

import java.util.UUID;

public class Student {
    private String id;

    Student() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
