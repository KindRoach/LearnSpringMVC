package spittr.data;

import org.springframework.stereotype.Component;
import spittr.model.Spitter;

import java.util.Date;

@Component
public class TestSpitterRepository implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        spitter.setUserId(24L);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        spitter.setFirstName(new Date().toString());
        spitter.setLastName(new Date().toString());
        return spitter;
    }
}
