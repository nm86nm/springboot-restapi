package com.mnp.springbootrestapi.service;

import com.mnp.springbootrestapi.model.Computer;
import com.mnp.springbootrestapi.repo.ComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService {
    private ComputerRepo computerRepo;

    @Autowired
    public ComputerService(ComputerRepo computerRepo) {
        this.computerRepo = computerRepo;
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

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit(){
        addComputer(new Computer(
                "Intel i9 10900KF",
                "Corsair Dominator Platinum RGB 2x16gb 4000MHz",
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
        addComputer(new Computer(
                "Intel i5 10600KF",
                "Corsair Vengeance 2x8gb 3600MHz",
                "Z490",
                "NVidia GeForce RTX 2080 Super"));
    }
}
