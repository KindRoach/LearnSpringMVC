package spittr.data;

import com.google.common.collect.ImmutableList;
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
}
