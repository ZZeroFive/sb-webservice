package ml.sb.ws.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private int age;
    private float score;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
