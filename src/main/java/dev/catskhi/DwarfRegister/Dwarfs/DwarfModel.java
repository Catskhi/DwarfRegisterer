package dev.catskhi.DwarfRegister.Dwarfs;
import dev.catskhi.DwarfRegister.Quests.QuestsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
@Table(name = "tb_dwarf")
@NoArgsConstructor
@AllArgsConstructor
public class DwarfModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String email;

    private int age;

    // @ManyToOne a dwarf have only one quest
    @ManyToOne
    @JoinColumn(name = "quests_id") // Foreign Key
    private QuestsModel quests;
}
