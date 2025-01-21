package dev.catskhi.DwarfRegister.Quests;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quests")
public class QuestsController {

    @GetMapping("/list")
    public String listQuest() {
        return "Listed quests";
    }

    @PostMapping("/create")
    public String createQuest() {
        return "Created quest";
    }

    @PutMapping("/update")
    public String updateQuest() {
        return "Updated quest";
    }

    @DeleteMapping("/delete")
    public String deleteQuest() {
        return "Deleted quest";
    }
}
