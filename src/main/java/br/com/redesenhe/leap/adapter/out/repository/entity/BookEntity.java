package br.com.redesenhe.leap.adapter.out.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Clock;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@EqualsAndHashCode(of = "id")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "author", length = 100)
    private String author;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "finish")
    private Boolean finish;

    @Column(name = "year", length = 4)
    private Year year;

    @Column(name = "desire")
    private Boolean desire;

    @Column(name = "image_link")
    private String imageLink;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<BookNoteEntity> readNotes;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity user;

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
