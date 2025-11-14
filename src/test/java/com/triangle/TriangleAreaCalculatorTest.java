package com.triangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Юнит-тесты для класса TriangleAreaCalculator
 */
@DisplayName("TriangleAreaCalculator Tests")
public class TriangleAreaCalculatorTest {

    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Расчет площади прямоугольного треугольника 3-4-5")
    void testRightTriangle345() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(3, 4, 5);
        assertEquals(6.0, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Расчет площади равностороннего треугольника")
    void testEquilateralTriangle() {
        double side = 2;
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(side, side, side);
        double expectedArea = (side * side * Math.sqrt(3)) / 4;
        assertEquals(expectedArea, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Расчет площади треугольника 5-6-7")
    void testTriangle567() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(5, 6, 7);
        double expectedArea = Math.sqrt(9 * 4 * 3 * 2);
        assertEquals(expectedArea, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Расчет площади равнобедренного треугольника")
    void testIsoscelesTriangle() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(5, 5, 6);
        double s = (5 + 5 + 6) / 2.0;
        double expectedArea = Math.sqrt(s * (s - 5) * (s - 5) * (s - 6));
        assertEquals(expectedArea, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Ошибка при отрицательной первой стороне")
    void testNegativeSideA() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(-3, 4, 5);
        });
    }

    @Test
    @DisplayName("Ошибка при отрицательной второй стороне")
    void testNegativeSideB() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(3, -4, 5);
        });
    }

    @Test
    @DisplayName("Ошибка при отрицательной третьей стороне")
    void testNegativeSideC() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(3, 4, -5);
        });
    }

    @Test
    @DisplayName("Ошибка при нулевой первой стороне")
    void testZeroSideA() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(0, 4, 5);
        });
    }

    @Test
    @DisplayName("Ошибка при нулевой второй стороне")
    void testZeroSideB() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(3, 0, 5);
        });
    }

    @Test
    @DisplayName("Ошибка при нулевой третьей стороне")
    void testZeroSideC() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(3, 4, 0);
        });
    }

    @Test
    @DisplayName("Ошибка при нарушении неравенства треугольника (1, 2, 5)")
    void testTriangleInequalityViolation1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(1, 2, 5);
        });
    }

    @Test
    @DisplayName("Ошибка при нарушении неравенства треугольника (1, 2, 3)")
    void testTriangleInequalityViolation2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(1, 2, 3);
        });
    }

    @Test
    @DisplayName("Ошибка при нарушении неравенства треугольника (1, 10, 20)")
    void testTriangleInequalityViolation3() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(1, 10, 20);
        });
    }

    @Test
    @DisplayName("Валидный треугольник с дробными сторонами")
    void testValidTriangleWithDecimals() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(2.5, 3.5, 4.0);
        double s = (2.5 + 3.5 + 4.0) / 2.0;
        double expectedArea = Math.sqrt(s * (s - 2.5) * (s - 3.5) * (s - 4.0));
        assertEquals(expectedArea, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Валидный треугольник с очень малыми сторонами")
    void testValidTriangleWithSmallSides() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(0.1, 0.1, 0.1);
        double s = (0.1 + 0.1 + 0.1) / 2.0;
        double expectedArea = Math.sqrt(s * (s - 0.1) * (s - 0.1) * (s - 0.1));
        assertEquals(expectedArea, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Валидный треугольник с большими сторонами")
    void testValidTriangleWithLargeSides() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(100, 100, 100);
        double s = (100 + 100 + 100) / 2.0;
        double expectedArea = Math.sqrt(s * (s - 100) * (s - 100) * (s - 100));
        assertEquals(expectedArea, calculator.calculateArea(), DELTA);
    }

    @Test
    @DisplayName("Проверка getter методов")
    void testGetters() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(3, 4, 5);
        assertEquals(3, calculator.getSideA(), DELTA);
        assertEquals(4, calculator.getSideB(), DELTA);
        assertEquals(5, calculator.getSideC(), DELTA);
    }

    @Test
    @DisplayName("Проверка toString метода")
    void testToString() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator(3, 4, 5);
        String result = calculator.toString();
        assertNotNull(result);
        assertTrue(result.contains("3.00"));
        assertTrue(result.contains("4.00"));
        assertTrue(result.contains("5.00"));
        assertTrue(result.contains("6.00"));
    }

    @Test
    @DisplayName("Все три стороны отрицательные")
    void testAllNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(-3, -4, -5);
        });
    }

    @Test
    @DisplayName("Два из трех сторон отрицательные")
    void testTwoNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TriangleAreaCalculator(-3, -4, 5);
        });
    }
}
