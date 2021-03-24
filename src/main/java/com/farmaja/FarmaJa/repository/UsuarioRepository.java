package com.farmaja.FarmaJa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmaja.FarmaJa.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	public List<Usuario> findByEmail (String email); 
}
