package com.hf.running_application.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String  userName;
    private String Email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "userId",referencedColumnName = "Id"),inverseJoinColumns = {@JoinColumn(name = "role_Id",referencedColumnName = "Id ")})
    private List<Role> roles  = new ArrayList<>();

}
