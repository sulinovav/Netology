package com.triangle;

/**
 * Класс для расчета площади треугольника по формуле Герона.
 * 
 * Формула Герона позволяет вычислить площадь треугольника, зная длины всех трех сторон:
 * - s = (a + b + c) / 2 (полупериметр)
 * - площадь = √(s(s-a)(s-b)(s-c))
 */
public class TriangleAreaCalculator {

    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * Конструктор класса TriangleAreaCalculator
     * 
     * @param sideA длина первой стороны треугольника
     * @param sideB длина второй стороны треугольника
     * @param sideC длина третьей стороны треугольника
     * @throws IllegalArgumentException если стороны не образуют валидный треугольник
     */
    public TriangleAreaCalculator(double sideA, double sideB, double sideC) {
        validateTriangle(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Валидирует, что три стороны образуют корректный треугольник
     * 
     * Проверяет:
     * 1. Все стороны положительны (> 0)
     * 2. Неравенство треугольника: сумма любых двух сторон больше третьей
     * 
     * @param a первая сторона
     * @param b вторая сторона
     * @param c третья сторона
     * @throws IllegalArgumentException если условия не выполнены
     */
    private void validateTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(
                    "Ошибка: все стороны треугольника должны быть положительными числами. " +
                    "Получено: a=" + a + ", b=" + b + ", c=" + c);
        }

        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalArgumentException(
                    "Ошибка: стороны не образуют валидный треугольник. " +
                    "Условие неравенства треугольника не выполнено. " +
                    "Получено: a=" + a + ", b=" + b + ", c=" + c);
        }
    }

    /**
     * Рассчитывает полупериметр треугольника
     * 
     * @return полупериметр s = (a + b + c) / 2
     */
    private double calculateSemiperimeter() {
        return (sideA + sideB + sideC) / 2.0;
    }

    /**
     * Рассчитывает площадь треугольника по формуле Герона
     * 
     * Формула: площадь = √(s(s-a)(s-b)(s-c))
     * где s - полупериметр
     * 
     * @return площадь треугольника
     */
    public double calculateArea() {
        double s = calculateSemiperimeter();
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return area;
    }

    /**
     * Возвращает информацию о треугольнике в виде строки
     * 
     * @return строка с данными о сторонах и площади
     */
    @Override
    public String toString() {
        return String.format(
                "Треугольник: стороны a=%.2f, b=%.2f, c=%.2f | Площадь=%.2f",
                sideA, sideB, sideC, calculateArea());
    }

    // Getters для сторон
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
