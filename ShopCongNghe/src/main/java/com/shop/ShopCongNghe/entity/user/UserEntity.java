package com.shop.ShopCongNghe.entity.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="tbl_user"
)
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE ,  generator = "sequence_gen" )
    @SequenceGenerator(
            name = "sequence_gen", sequenceName = "sequence", allocationSize = 1
    )
    private Long id;

    @Column
    private String full_name;

    @Column
    private String phone_number;

    @Column
    private String address;

    @Column
    private String email;


}
