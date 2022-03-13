package br.com.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000.00")) > 0) {
			throw new IllegalArgumentException("Funcionário com salário maior que R$10.000 não está apto à receber bônus!");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
