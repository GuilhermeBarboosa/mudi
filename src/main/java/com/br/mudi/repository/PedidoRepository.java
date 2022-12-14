package com.br.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Cacheable("pedidos")
	List<Pedido> findByStatus(StatusPedido statusPedido, PageRequest paginacao);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findByUsername(@Param("username")String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> listarPedidosStatusUsername(@Param("status")StatusPedido valueOf, @Param("username")String name);

	@Query("select p from Pedido p join p.user u where u.username != :username and p.status = :status")
	List<Pedido> listarOfertas(@Param("status")StatusPedido status, @Param("username")String name);
	
}
