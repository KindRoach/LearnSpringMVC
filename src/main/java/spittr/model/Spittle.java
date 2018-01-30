package spittr.model;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.List;

public class Spittle {

    private static final List<String> FIELDS = ImmutableList.of("id", "message", "time");

    @Getter
    private final Long id;

    @Getter
    private final String message;

    @Getter
    private final Date time;

    @Setter
    @Getter
    private Double latitude;

    @Setter
    @Getter
    private Double longitude;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double longitude, Double latitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, FIELDS);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, FIELDS);
    }
}