package com.financas.repositories;

import com.financas.models.EntidadeGenerica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface RepositoryGenerico<T extends EntidadeGenerica, ID extends Serializable> extends JpaRepository<T, ID> {
}
