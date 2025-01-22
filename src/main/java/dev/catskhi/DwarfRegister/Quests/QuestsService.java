package dev.catskhi.DwarfRegister.Quests;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestsService {

    private QuestsRepository questsRepository;

    public QuestsService(QuestsRepository questsRepository) {
        this.questsRepository = questsRepository;
    }

    public QuestsModel createQuest(QuestsModel quest) {
        return questsRepository.save(quest);
    }

    public List<QuestsModel> listQuests() {
        return questsRepository.findAll();
    }

    public QuestsModel getQuestsById(Long id) {
        Optional<QuestsModel> questById = questsRepository.findById(id);
        return questById.orElse(null);
    }

    public void deleteQuest(Long id) {
        questsRepository.deleteById(id);
    }
}
