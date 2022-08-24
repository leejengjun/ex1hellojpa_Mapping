package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "products")  // 다대다 양방향 매핑.  // 그러나 실무에서 사용x
//    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<MemberProduct > memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}