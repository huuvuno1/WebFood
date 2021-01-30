package nguyenhuuvu.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


}
