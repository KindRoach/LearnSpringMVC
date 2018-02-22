package spittr.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spittr.api.error.ApiError;
import spittr.api.exception.SpittleUnsavedException;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.util.List;

@RestController
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public Spittle getSpittleById(
            @PathVariable(value = "spittleId") long spittleId) {
        return spittleRepository.findOne(spittleId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json")
    public ResponseEntity<Spittle> saveSpittle(Spittle spittle)
            throws SpittleUnsavedException {
        if (spittle.getLatitude() == null || spittle.getLongitude() == null) {
            throw new SpittleUnsavedException("Latitude or Longitude is null");
        } else {
            return new ResponseEntity<>(
                    spittleRepository.save(spittle),
                    HttpStatus.CREATED);
        }
    }

    @ExceptionHandler(SpittleUnsavedException.class)
    public ResponseEntity<ApiError> spittleNotFound(SpittleUnsavedException e) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}