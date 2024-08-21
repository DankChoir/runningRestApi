package dev.danko.runnerz.Run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Run findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst()
                .get();
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(123, "SchoolRun", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR));
        runs.add(new Run(365, "SchoolRun", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 5, Location.INDOOR));
    }
}
