package dev.catskhi.DwarfRegister.Dwarfs;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createDwarf(@RequestBody DwarfDTO dwarf) {
        DwarfDTO newDwarf = dwarfService.createDwarf(dwarf);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dwarf successfully created: " + newDwarf.getName() + ", ID: " + newDwarf.getId());
    }

    // Show all dwarfs (Read)
    @GetMapping("/list")
    public ResponseEntity<List<DwarfDTO>> showAllDwarfs() {
        List<DwarfDTO> dwarfsList = dwarfService.listDwarfs();
        return ResponseEntity.ok(dwarfsList);
    }

    // Search Dwarf by Id (Read)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> showDwarfsById(@PathVariable Long id) {
        DwarfDTO dwarf = dwarfService.listDwarfsById(id);
        if (dwarf != null) {
            return ResponseEntity.ok(dwarf);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dwarf of id: " + id + " don't exists.");
        }
    }

    // Update dwarf data (Update)
    @PutMapping("/updateId/{id}")
    public ResponseEntity<?> updateDwarf(@PathVariable Long id, @RequestBody DwarfDTO updatedDwarf) {
        DwarfDTO dwarf = dwarfService.updateDwarf(id, updatedDwarf);
        if (dwarf != null) {
            return ResponseEntity.ok(dwarf);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dwarf of id " + id + " not found.");
        }
    }

    // Delete dwarf (Delete)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDwarf(@PathVariable Long id) {
        if (dwarfService.listDwarfsById(id) != null) {
            dwarfService.deleteDwarf(id);
            return ResponseEntity.ok("Dwarf of id: " + id + " successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dwarf of id: " + id + " not found.");
        }
    }
}
