package com.example.waryu.Repositories;

import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.DistritoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IDistritoFavoritoRepository extends JpaRepository<DistritoFavorito, Integer> {
    @Query("select df.distrito from DistritoFavorito df where df.usuario.ID_Usuario =:id and df.Estado = true")
    public List<Distrito> findDistritoFavoritoByUsuario(@Param("id") Integer id);
}
