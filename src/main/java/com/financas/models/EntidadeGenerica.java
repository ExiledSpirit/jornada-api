package com.financas.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Where(clause = "deletado = false")
public class EntidadeGenerica implements Serializable {
    @Id
    @Column(name = "id",unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "deletado", columnDefinition = "boolean default false")
    private boolean deletado;

    public EntidadeGenerica() { }

    public EntidadeGenerica(Long id, Date createdAt, Boolean deletado) {
        this.id = id;
        this.createdAt = createdAt;
        this.deletado = deletado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDeletado() {
        return deletado;
    }

    public void setDeletado(Boolean deletado) {
        this.deletado = deletado;
    }

    @Override
    public String toString() {
        return "EntidadeGenerica{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", deletado=" + deletado +
                '}';
    }
}
