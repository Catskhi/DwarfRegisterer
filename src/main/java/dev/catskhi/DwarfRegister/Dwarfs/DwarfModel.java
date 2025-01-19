package dev.catskhi.DwarfRegister.Dwarfs;
import dev.catskhi.DwarfRegister.Quests.QuestsModel;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Table(name = "tb_dwarf_register")
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

    public DwarfModel() {
    }

    public DwarfModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
