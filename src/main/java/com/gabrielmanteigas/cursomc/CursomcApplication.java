package com.gabrielmanteigas.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielmanteigas.cursomc.domain.Categoria;
import com.gabrielmanteigas.cursomc.domain.Cidade;
import com.gabrielmanteigas.cursomc.domain.Cliente;
import com.gabrielmanteigas.cursomc.domain.Endereco;
import com.gabrielmanteigas.cursomc.domain.Estado;
import com.gabrielmanteigas.cursomc.domain.Produto;
import com.gabrielmanteigas.cursomc.domain.enums.TipoCliente;
import com.gabrielmanteigas.cursomc.repositories.CategoriaRepository;
import com.gabrielmanteigas.cursomc.repositories.CidadeRepository;
import com.gabrielmanteigas.cursomc.repositories.ClienteRepository;
import com.gabrielmanteigas.cursomc.repositories.EnderecoRepository;
import com.gabrielmanteigas.cursomc.repositories.EstadoRepository;
import com.gabrielmanteigas.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepos;
	
	@Autowired
	private ProdutoRepository produtoRepos;	
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1= new Categoria(null, "Informática");
		Categoria cat2= new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 1000.00);
		Produto p2 = new Produto(null, "Impressora", 200.00);
		Produto p3 = new Produto(null, "Rato Eletrónico", 20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepos.saveAll(Arrays.asList(cat1, cat2));		
		produtoRepos.saveAll(Arrays.asList(p1,p2,p3));		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1= new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1); 
		Endereco e2= new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
