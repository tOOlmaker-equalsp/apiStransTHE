package com.equalsp.stransthe;

import java.util.ArrayList;
import java.util.List;

import com.equalsp.stransthe.modelo.Linha;
import com.equalsp.stransthe.modelo.Parada;
import com.equalsp.stransthe.modelo.ParadaLinha;
import com.equalsp.stransthe.modelo.Veiculo;
import com.equalsp.stransthe.modelo.VeiculoLinha;

public class InthegraAPI {

	private static InthegraAgent tokenManager;

	public static boolean init(String email, String senha, String key) throws Exception {
		tokenManager = new InthegraAgent(email, senha, key);
		return tokenManager.autenticar();
	}

	public static List<Linha> getLinhas() throws Exception {
		return tokenManager.getLinhas();
	}

	public static List<Linha> getLinhas(String busca) throws Exception {
		return tokenManager.getLinhas(busca);
	}

	public static List<Parada> getParadas() throws Exception {
		return tokenManager.getParadas();
	}

	public static List<Parada> getParadas(String busca) throws Exception {
		return tokenManager.getParadas(busca);
	}

	
	public static List<Parada> getParadas(Linha linha) throws Exception {
		ParadaLinha p = tokenManager.getParadasLinha(linha.getCodigoLinha());
		return p.getParadas();
	}

	public static List<Veiculo> getVeiculos() throws Exception {
		List<Veiculo> v = new ArrayList<Veiculo>();
		List<VeiculoLinha> linhas = tokenManager.getVeiculos();
		for (VeiculoLinha veiculoLinha : linhas) {
			v.addAll(veiculoLinha.getLinha().getVeiculos());
		}
		return v;
	}

	public static List<Veiculo> getVeiculos(Linha linha) throws Exception {
		return tokenManager.getVeiculosLinha(linha.getCodigoLinha()).getLinha().getVeiculos();
	}

	public static void main(String[] args) throws Exception {
		InthegraAPI.init("erickpassos@gmail.com", "circ51sp", "ef5f05bdedd34cada40187761d5daaa7");
		Linha l = InthegraAPI.getLinhas("ininga").get(0);
		Parada p = InthegraAPI.getParadas(l).get(0);
		System.out.println(p.getCodigoParada());
	}

}
