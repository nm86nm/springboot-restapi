package com.mnp.springbootrestapi.service;

import com.mnp.springbootrestapi.model.Computer;
import com.mnp.springbootrestapi.repo.ComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService {
    private ComputerRepo computerRepo;

    @Autowired
    public ComputerService(ComputerRepo computerRepo) {
        this.computerRepo = computerRepo;
        addComputer(new Computer(
                "Intel 9900K",
                "Corsair Dominator Platinum RGB 2x16gb 3600MHz",
                "ASRock Z390 Taichi",
                "Gainward GeForce RTX 2080 Ti Phoenix"));
        addComputer(new Computer(
                "AMD Ryzen 7 3700X",
                "G.Skill Trident Z RGB 2x8gb 3600MHz",
                "Aorus Elite X570",
                "MSI Geforce RTX 2080 SUPER VENTUS XS"));
        addComputer(new Computer(
                "AMD Ryzen 5 3600X",
                "HyperX Predator 2x8gb 3200MHz",
                "Gigabyte B450 Pro",
                "AMD RX 5700 XT"));
    }

    public Iterable<Computer> getComputers(){
        return computerRepo.findAll();
    }

    public Optional<Computer> getComputer(long id){
        return computerRepo.findById(id);
    }

    public Computer addComputer(Computer computer){
        return computerRepo.save(computer);
    }

    public void deleteComputer(long id){
        computerRepo.deleteById(id);
    }
}
