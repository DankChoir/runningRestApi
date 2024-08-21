package dev.danko.runnerz.Run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> targetRun = runRepository.findById(id);

        if (targetRun.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return targetRun.get();
    }

    // post : create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    // put : edit
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void put(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run,id);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@Valid @PathVariable Integer id){
        runRepository.delete(id);
    }
}
