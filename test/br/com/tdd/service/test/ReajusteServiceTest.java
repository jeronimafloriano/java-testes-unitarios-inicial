package br.com.tdd.service.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tdd.modelo.Funcionario;
import br.com.tdd.service.Desempenho;
import br.com.tdd.service.ReajusteService;

public class ReajusteServiceTest {
  
  private ReajusteService reajuste;
  private Funcionario funcionario;
  
  @BeforeEach
  public void inicializar() {
    this.reajuste = new ReajusteService();
    this.funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal("2000.00"));
  }

  @Test
  public void reajusteTresPorCentoParaDesempenhoADesejar() {
    reajuste.calculoReajuste(funcionario, Desempenho.A_DESEJAR);
    assertEquals(new BigDecimal("2060.00"), funcionario.getSalario());
  }
  
  @Test
  public void reajusteQuinzePorCentoParaDesempenhoBom() {
    reajuste.calculoReajuste(funcionario, Desempenho.BOM);
    assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
  }
  
  @Test
  public void reajusteVintePorCentoParaDesempenhoOtimo() {
    reajuste.calculoReajuste(funcionario, Desempenho.OTIMO);
    assertEquals(new BigDecimal("2400.00"), funcionario.getSalario());
  }

}
