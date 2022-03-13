package br.com.tdd.service;

import java.math.BigDecimal;
import br.com.tdd.modelo.Funcionario;

public class ReajusteService {

  public void calculoReajuste(Funcionario funcionario, Desempenho desempenho) {
      BigDecimal percentual = desempenho.percentual();
      BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
      funcionario.reajusteSalario(reajuste);
    }
    

}
