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
    public DwarfDTO createDwarf(@RequestBody DwarfDTO dwarf) {
        return dwarfService.createDwarf(dwarf);
    }

    // Show all dwarfs (Read)
    @GetMapping("/list")
    public List<DwarfDTO> showAllDwarfs() {
        return dwarfService.listDwarfs();
    }

    // Search Dwarf by Id (Read)
    @GetMapping("/list/{id}")
    public DwarfDTO showDwarfsById(@PathVariable Long id) {
        return dwarfService.getDwarfsById(id);
    }

    // Update dwarf data (Update)
    @PutMapping("/updateId/{id}")
    public DwarfDTO updateDwarf(@PathVariable Long id, @RequestBody DwarfDTO updatedDwarf) {
        return dwarfService.updateDwarf(id, updatedDwarf);
    }

    // Delete dwarf (Delete)
    @DeleteMapping("/delete/{id}")
    public void deleteDwarf(@PathVariable Long id) {
        dwarfService.deleteDwarf(id);
    }
}
