package spittr.api;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spittr.model.Spittle;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RestClient {
    @Test
    public void getSpittleById() {
        Long id = 1L;
        RestTemplate rest = new RestTemplate();
        String uri = "http://localhost:8080/spittles/{id}";
        Map<String, String> urlVariables = ImmutableMap.of("id", "1");
        ResponseEntity<Spittle> entity = rest.getForEntity(uri, Spittle.class, urlVariables);
        Spittle spittle = entity.getBody();
        assertEquals("message" + id, spittle.getMessage());
    }
}
