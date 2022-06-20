package com.financas.repositories;

import com.financas.models.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends RepositoryGenerico<Projeto, Long> {
    @Query(value = "select * from public.projeto p LEFT JOIN projeto_tem_usuario pm on (pm.fk_projeto_id = p.id) WHERE pm.fk_usuario_id = :usuarioId", nativeQuery = true)
    List<Projeto> buscarProjetosPorUsuarioId(Long usuarioId);
}
