package com.mnp.springbootrestapi.api;

import com.mnp.springbootrestapi.model.Computer;
import com.mnp.springbootrestapi.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/springboot-restapi")
public class ComputerApi {
    private ComputerService computerService;

    @Autowired
    public ComputerApi(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/get-computers")
    public Iterable<Computer> getComputers(){
        return computerService.getComputers();
    }

    @GetMapping("/get-computer")
    public Optional<Computer> getComputers(@RequestParam long id){
        return computerService.getComputer(id);
    }

    @PostMapping("/add-computer")
    public Computer add(@RequestBody Computer computer){
        return computerService.addComputer(computer);
    }

    @DeleteMapping("/delete-computer")
    public void deleteComputer(@RequestParam long id){
        computerService.deleteComputer(id);
    }
}
