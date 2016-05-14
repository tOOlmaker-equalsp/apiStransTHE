package com.equalsp.stransthe.modelo;

import java.util.List;

import com.equalsp.stransthe.InthegraAPI;

public class Linha {

	private String CodigoLinha;

	private String Denomicao;

	private String Origem;

	private String Retorno;

	private boolean Circular;

	private List<Veiculo> Veiculos;

	private List<Parada> paradas;

	public String getCodigoLinha() {
		return CodigoLinha;
	}

	public void setCodigoLinha(String codigoLinha) {
		CodigoLinha = codigoLinha;
	}

	public String getDenomicao() {
		return Denomicao;
	}

	public void setDenomicao(String denomicao) {
		Denomicao = denomicao;
	}

	public String getOrigem() {
		return Origem;
	}

	public void setOrigem(String origem) {
		this.Origem = origem;
	}

	public String getRetorno() {
		return Retorno;
	}

	public void setRetorno(String retorno) {
		this.Retorno = retorno;
	}

	public boolean isCircular() {
		return Circular;
	}

	public void setCircular(boolean circular) {
		this.Circular = circular;
	}

	public List<Veiculo> getVeiculos() {
		if (Veiculos == null) {
			try {
				Veiculos = InthegraAPI.getVeiculos(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		Veiculos = veiculos;
	}

	public List<Parada> getParadas() {
		if (paradas == null) {
			try {
				paradas = InthegraAPI.getParadas(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}

}
