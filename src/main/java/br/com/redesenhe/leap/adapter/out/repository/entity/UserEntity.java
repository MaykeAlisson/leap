package br.com.redesenhe.leap.adapter.out.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "id")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

//    @JsonIgnore
    @Column(name = "create_at")
    private Instant createAt;

//    @JsonIgnore
    @Column(name = "update_at")
    private Instant updateAt;

    @PrePersist
    protected void onPrePersist() {
        this.createAt = Instant.now(Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))));
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.updateAt = Instant.now(Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))));
    }

}
