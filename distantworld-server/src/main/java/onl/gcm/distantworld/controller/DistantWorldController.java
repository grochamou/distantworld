package onl.gcm.distantworld.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import onl.gcm.hermes.dto.DistantWorldDTO;

@RestController
@PropertySource("classpath:hermes.properties")
@PropertySource("classpath:hermes-${spring.profiles.active}.properties")
public class DistantWorldController {

    private static final String DATA = "Hello, World!";
    private static final String CRASH = "Crash!";

    @GetMapping("${distantworld.path.alive}")
    protected ResponseEntity<Void> isAlive() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("${distantworld.path.test}")
    protected ResponseEntity<DistantWorldDTO> test(@PathVariable String id) {
        return ResponseEntity.ok(DistantWorldDTO.builder().data(DATA).build());
    }

    @GetMapping("${distantworld.path.nocontent}")
    protected ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("${distantworld.path.crash}")
    protected ResponseEntity<Void> crash() {
        throw new IllegalStateException(CRASH);
    }

}
