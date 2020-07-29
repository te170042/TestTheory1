package jp.te4a.spring.boot.myapp6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest {
	static Calc calc = null;
	@BeforeAll
	static void テスト前処理() {
	    calc = new Calc();
	}
	@Test
	void addテスト_正常() {
	    assertEquals(calc.add(1, 3), 4);
	    assertThat(calc.add(1, 3)).isEqualTo(4);
	}
	@Test
	void divテスト_正常() {
	    assertEquals(calc.div(4, 2), 2);
	    assertThat(calc.div(4, 2)).isEqualTo(2);
	}
	@Test
	void multテスト_正常() {
	    assertEquals(calc.mul(2, 4), 8);
	    assertThat(calc.mul(2, 4)).isEqualTo(8);
	}
	@Test
	void divテスト_異常() {
		assertThatThrownBy(() -> {
		    calc.div(4, 0);
		})
		// 発生したExceptionのクラス
		.isInstanceOf(ArithmeticException.class)
		// エラーメッセージに特定の文字列が含まれるか）
		.hasMessageContaining("/ by zero");
	}

	@AfterAll
	static void テスト後処理() {
	    calc = null;
	}
	

}
