package spittr.model;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Spitter {

    private static final List<String> FIELDS = ImmutableList.of("userId");

    @Setter
    @Getter
    @NotNull
    private long userId;

    @Setter
    @Getter
    @NotNull
    @Size(min = 5, max = 16)
    private String firstName;

    @Setter
    @Getter
    @NotNull
    @Size(min = 5, max = 16)
    private String lastName;

    @Setter
    @Getter
    @NotNull
    @Size(min = 5, max = 16)
    private String username;

    @Setter
    @Getter
    @NotNull
    @Size(min = 5, max = 16)
    private String password;

    public Spitter() {
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Spitter(long userId, String username, String password, String firstName, String lastName) {
        this(firstName, lastName, username, password);
        this.userId = userId;
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
