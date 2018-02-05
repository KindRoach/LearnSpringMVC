package spittr.data;

import spittr.model.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long maxValue, int count);

    Spittle findOne(long spittleId);

    Spittle save(Spittle spittle);
}
