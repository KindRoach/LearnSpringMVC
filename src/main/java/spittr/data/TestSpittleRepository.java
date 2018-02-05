package spittr.data;

import org.springframework.stereotype.Component;
import spittr.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TestSpittleRepository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long maxValue, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("message" + i, new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle("message" + spittleId, new Date());
    }

    @Override
    public Spittle save(Spittle spittle) {
        spittle.setId(24L);
        return spittle;
    }
}
