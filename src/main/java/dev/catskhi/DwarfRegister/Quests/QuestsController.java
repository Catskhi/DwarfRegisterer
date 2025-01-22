package dev.catskhi.DwarfRegister.Quests;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quests")
public class QuestsController {

    private QuestsService questsService;

    public QuestsController(QuestsService questsService) {
        this.questsService = questsService;
    }

    @PostMapping("/create")
    public QuestsModel createQuest(@RequestBody QuestsModel quest) {
        return questsService.createQuest(quest);
    }

    @GetMapping("/list")
    public List<QuestsModel> listQuest() {
        return questsService.listQuests();
    }

    @GetMapping("/list/{id}")
    public QuestsModel listQuestById(@PathVariable Long id) {
        return questsService.getQuestsById(id);
    }

    @PutMapping("/updateId")
    public String updateQuest() {
        return "Updated quest";
    }

    @DeleteMapping("/delete")
    public void deleteQuest(@PathVariable Long id) {
        questsService.deleteQuest(id);
    }
}
