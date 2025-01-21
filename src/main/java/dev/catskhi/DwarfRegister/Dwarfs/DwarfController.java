package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DwarfController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // Add Dwarf (Create)
    @PostMapping("/create")
    public String createDwarf() {
        return "Dwarf created";
    }

    // Show all dwarfs (Read)
    @GetMapping("/all")
    public String showAllDwarfs() {
        return "All dwarfs";
    }

    // Search Dwarf by Id (Read)
    @GetMapping("/dwarfID")
    public String showAllDwarfsById() {
        return "Show all dwarfs by id";
    }

    // Update dwarf data (Update)
    @PutMapping("/updateDwarf")
    public String updateDwarf() {
        return "Updated Dwarf";
    }

    // Delete dwarf (Delete)
    @DeleteMapping("/deleteDwarf")
    public String deleteDwarf() {
        return "Deleted Dwarf";
    }
}
