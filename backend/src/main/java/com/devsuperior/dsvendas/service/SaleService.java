package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service //Irá registrar a classe como um componente
public class SaleService {

	@Autowired //Irá injetar a dependência de forma transparente -> ele instancia automaticamente (new)
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){ //Busca paginada
		sellerRepository.findAll(); //Achar todos os vendedores e armazenar em cache para a JPA não fazer várias requisições da quantidade de vendedores
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x)); 
	}
}
