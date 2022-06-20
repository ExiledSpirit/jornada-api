package com.financas.repositories;

import com.financas.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends RepositoryGenerico<Usuario, Long>{
    @Query(value = "SELECT * from public.usuario WHERE login = :login and senha = :senha", nativeQuery = true)
    Optional<Usuario> autenticar(String login, String senha);
}
