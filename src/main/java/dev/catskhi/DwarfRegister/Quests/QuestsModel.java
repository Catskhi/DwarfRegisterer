package dev.catskhi.DwarfRegister.Quests;
import dev.catskhi.DwarfRegister.Dwarfs.DwarfModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_quests")
public class QuestsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String difficulty;

    @OneToMany(mappedBy = "quests")
    private List<DwarfModel> dwarf;
}
