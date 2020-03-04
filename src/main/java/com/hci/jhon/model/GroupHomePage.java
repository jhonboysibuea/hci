package com.hci.jhon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_group_home_page")
public class GroupHomePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @OneToMany(mappedBy = "groupHomePage",cascade = CascadeType.ALL,orphanRemoval = true)
    List<User> userList=new LinkedList<>();

    @OneToMany(mappedBy = "groupHomePage",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Modules> modulesList=new LinkedList<>();
}
