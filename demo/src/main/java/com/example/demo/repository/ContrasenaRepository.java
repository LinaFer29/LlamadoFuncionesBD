package com.example.demo.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contrasena;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContrasenaRepository extends JpaRepository<Contrasena, Long> {
	 @Query(value = "SELECT asignar_comision(:n_sales) FROM dual", nativeQuery = true)
	 String asignarComisionRepository(@Param("n_sales") int n_sales);
	 
	 @Query(value = "SELECT calcular_factorial(:numero) FROM dual",nativeQuery = true)
	 int calcularFactorialRepository(@Param("numero") int numero);
	 
	 @Query(value = "SELECT maximo_comun_divisor(:a,:b) FROM dual",nativeQuery = true)
	 int maximoComunDivisorRepository(@Param("a") int a, @Param("b") int b);
	 
	 @Query(value = "SELECT es_primo(:numero) FROM dual", nativeQuery = true)
	 String esPrimoRepository(@Param("numero") int numero);
	 
	 @Query(value = "SELECT fibonacci(:numero) FROM dual",nativeQuery = true)
	 int fibonacciRepository(@Param("numero") int numero);

	 
	 @Modifying
	 @Transactional(timeout = 10)
	 @Query(value = "CALL actualizar_precio_producto(:codigo, :precio)", nativeQuery = true)
	 void actualizarPrecioProductoRepository(@Param("codigo") String codigo, @Param("precio") int precio);

	 
}
