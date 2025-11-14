package com.triangle;

/**
 * Класс с примерами использования TriangleAreaCalculator
 */
public class TriangleAreaExample {

    public static void main(String[] args) {
        System.out.println("=== Примеры расчета площади треугольника по формуле Герона ===\n");

        // Пример 1: Треугольник 3-4-5 (прямоугольный треугольник)
        System.out.println("Пример 1: Прямоугольный треугольник со сторонами 3, 4, 5");
        try {
            TriangleAreaCalculator triangle1 = new TriangleAreaCalculator(3, 4, 5);
            System.out.println(triangle1);
            System.out.println("Ожидаемая площадь: 6.0 (3*4/2)\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }

        // Пример 2: Равносторонний треугольник со стороной 2
        System.out.println("Пример 2: Равносторонний треугольник со стороной 2");
        try {
            TriangleAreaCalculator triangle2 = new TriangleAreaCalculator(2, 2, 2);
            System.out.println(triangle2);
            System.out.println("Ожидаемая площадь: ~1.73 (√3)\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }

        // Пример 3: Произвольный треугольник
        System.out.println("Пример 3: Произвольный треугольник со сторонами 5, 6, 7");
        try {
            TriangleAreaCalculator triangle3 = new TriangleAreaCalculator(5, 6, 7);
            System.out.println(triangle3);
            System.out.println("Полупериметр: " + (5 + 6 + 7) / 2.0);
            System.out.println("Расчет: √(9 * 4 * 3 * 2) = √216 ≈ 14.7\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }

        // Пример 4: Длинный и узкий треугольник
        System.out.println("Пример 4: Длинный и узкий треугольник со сторонами 10, 10.1, 0.1");
        try {
            TriangleAreaCalculator triangle4 = new TriangleAreaCalculator(10, 10.1, 0.1);
            System.out.println(triangle4);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }

        // Пример 5: Попытка создать треугольник с отрицательной стороной
        System.out.println("Пример 5: Попытка создать треугольник с отрицательной стороной (-3, 4, 5)");
        try {
            TriangleAreaCalculator triangle5 = new TriangleAreaCalculator(-3, 4, 5);
            System.out.println(triangle5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage() + "\n");
        }

        // Пример 6: Попытка создать треугольник с нулевой стороной
        System.out.println("Пример 6: Попытка создать треугольник с нулевой стороной (0, 4, 5)");
        try {
            TriangleAreaCalculator triangle6 = new TriangleAreaCalculator(0, 4, 5);
            System.out.println(triangle6);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage() + "\n");
        }

        // Пример 7: Попытка создать "треугольник", нарушающий неравенство треугольника
        System.out.println("Пример 7: Попытка создать треугольник, нарушающий неравенство (1, 2, 5)");
        try {
            TriangleAreaCalculator triangle7 = new TriangleAreaCalculator(1, 2, 5);
            System.out.println(triangle7);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage() + "\n");
        }

        // Пример 8: Другой граничный случай неравенства треугольника (1, 2, 3)
        System.out.println("Пример 8: Попытка создать треугольник на границе неравенства (1, 2, 3)");
        System.out.println("(1 + 2 = 3, но должно быть строго больше)");
        try {
            TriangleAreaCalculator triangle8 = new TriangleAreaCalculator(1, 2, 3);
            System.out.println(triangle8);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage() + "\n");
        }

        // Пример 9: Треугольник с дробными сторонами
        System.out.println("Пример 9: Треугольник с дробными сторонами (2.5, 3.5, 4.0)");
        try {
            TriangleAreaCalculator triangle9 = new TriangleAreaCalculator(2.5, 3.5, 4.0);
            System.out.println(triangle9);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }

        // Пример 10: Очень малые значения
        System.out.println("Пример 10: Треугольник с очень малыми сторонами (0.1, 0.1, 0.1)");
        try {
            TriangleAreaCalculator triangle10 = new TriangleAreaCalculator(0.1, 0.1, 0.1);
            System.out.println(triangle10);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }
    }
}
