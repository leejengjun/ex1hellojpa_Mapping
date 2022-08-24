package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberProduct {    // 다대다 한계 극복 // Member 와 Product 사이 연결 테이블용 엔티티
// 실제 비즈니스 모델은 더 복잡하므로 실무에서는 가급적 다대다로 매핑하지 말것!
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;

}
