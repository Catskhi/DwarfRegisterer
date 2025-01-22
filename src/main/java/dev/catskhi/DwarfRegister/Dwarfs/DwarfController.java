package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dwarfs")
public class DwarfController {

    private DwarfService dwarfService;

    public DwarfController(DwarfService dwarfService) {
        this.dwarfService = dwarfService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // Add Dwarf (Create)
    @PostMapping("/create")
    public DwarfModel createDwarf(@RequestBody DwarfModel dwarf) {
        return dwarfService.createDwarf(dwarf);
    }

    // Show all dwarfs (Read)
    @GetMapping("/list")
    public List<DwarfModel> showAllDwarfs() {
        return dwarfService.listDwarfs();
    }

    // Search Dwarf by Id (Read)
    @GetMapping("/list/{id}")
    public DwarfModel showDwarfsById(@PathVariable Long id) {
        return dwarfService.getDwarfsById(id);
    }

    // Update dwarf data (Update)
    @PutMapping("/updateId")
    public String updateDwarf() {
        return "Updated Dwarf";
    }

    // Delete dwarf (Delete)
    @DeleteMapping("/delete")
    public String deleteDwarf() {
        return "Deleted Dwarf";
    }
}
