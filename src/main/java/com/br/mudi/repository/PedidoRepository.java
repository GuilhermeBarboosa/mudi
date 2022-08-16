package com.br.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido statusPedido);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findByUsername(@Param("username")String username);
	
}
