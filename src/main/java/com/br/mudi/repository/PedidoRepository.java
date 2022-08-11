package com.br.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.mudi.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
