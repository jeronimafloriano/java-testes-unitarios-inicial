package br.com.tdd.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tdd.modelo.Funcionario;
import br.com.tdd.service.BonusService;

class BonusServiceTest {
  
  private BonusService calculoBonus;
  
  @BeforeEach
  public void inicializar() {
    this.calculoBonus = new BonusService();
  }

  @Test
  public void bonusZeroParaSalarioAlto() {
    assertThrows(IllegalArgumentException.class, 
      () -> calculoBonus.calcularBonus(new Funcionario("Jeronima", LocalDate.of(2017, Month.FEBRUARY, 13), new BigDecimal("11000.00"))));
  }
  
  
  @Test
  public void bonus10PorCentoDoSalario() {
    BigDecimal  bonus = calculoBonus.calcularBonus(new Funcionario("João", LocalDate.of(2020, Month.FEBRUARY, 13), new BigDecimal("6000.00")));
    assertEquals(new BigDecimal("600.00"), bonus);  
  }
  
  @Test
  public void bonus10PorCentoDoSalarioArredondandoValor() {
    BigDecimal  bonus = calculoBonus.calcularBonus(new Funcionario("João", LocalDate.of(2020, Month.FEBRUARY, 13), new BigDecimal("5537.99")));
    assertEquals(new BigDecimal("553.80"), bonus);  
  }
  
  @Test
  public void bonus10PorCentoParaSalarioExatamente10000() {
    BigDecimal  bonus = calculoBonus.calcularBonus(new Funcionario("João", LocalDate.of(2020, Month.FEBRUARY, 13), new BigDecimal("10000.00")));
    assertEquals(new BigDecimal("1000.00"), bonus);  
  }

}
