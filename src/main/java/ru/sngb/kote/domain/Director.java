package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Director's ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */

@Entity
@Table(name = "k26_director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k26_director_id", insertable = true, updatable = true, nullable = false)
    int DirectorId;

    @OneToMany(mappedBy = "DirectorId", cascade = CascadeType.ALL)
    Collection<Organization> Organizations;


}
