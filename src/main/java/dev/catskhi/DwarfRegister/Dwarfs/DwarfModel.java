package dev.catskhi.DwarfRegister.Dwarfs;
import dev.catskhi.DwarfRegister.Quests.QuestsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_dwarf")
@NoArgsConstructor
@AllArgsConstructor
public class DwarfModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "age")
    private int age;

    // @ManyToOne a dwarf have only one quest
    @ManyToOne
    @JoinColumn(name = "quests_id") // Foreign Key
    private QuestsModel quests;
}
