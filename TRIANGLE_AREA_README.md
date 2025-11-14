# Калькулятор площади треугольника по формуле Герона

## Описание

Этот проект содержит Java-класс `TriangleAreaCalculator` для расчета площади треугольника по трем сторонам, используя формулу Герона.

## Структура проекта

```
src/
├── main/java/com/triangle/
│   ├── TriangleAreaCalculator.java    - Основной класс для расчета площади
│   └── TriangleAreaExample.java       - Примеры использования класса
└── test/java/com/triangle/
    └── TriangleAreaCalculatorTest.java - Юнит-тесты
```

## Формула Герона

Площадь треугольника, когда известны длины всех трех сторон (a, b, c), рассчитывается по формуле Герона:

```
s = (a + b + c) / 2        (полупериметр)
площадь = √(s(s-a)(s-b)(s-c))
```

## Класс TriangleAreaCalculator

### Конструктор

```java
TriangleAreaCalculator(double sideA, double sideB, double sideC)
```

Принимает три стороны треугольника. При создании объекта выполняется валидация.

### Публичные методы

#### `calculateArea(): double`
Рассчитывает и возвращает площадь треугольника.

#### `getSideA(): double`
#### `getSideB(): double`
#### `getSideC(): double`
Возвращают длины сторон треугольника.

#### `toString(): String`
Возвращает строковое представление треугольника с информацией о сторонах и площади.

## Валидация

Класс выполняет следующие проверки:

### 1. Проверка положительности сторон
Все стороны должны быть больше нуля:
```java
if (a <= 0 || b <= 0 || c <= 0) {
    throw new IllegalArgumentException(...)
}
```

### 2. Проверка неравенства треугольника
Сумма любых двух сторон должна быть строго больше третьей:
```java
if (a + b <= c || b + c <= a || a + c <= b) {
    throw new IllegalArgumentException(...)
}
```

## Примеры использования

### Пример 1: Прямоугольный треугольник

```java
TriangleAreaCalculator triangle = new TriangleAreaCalculator(3, 4, 5);
double area = triangle.calculateArea();  // 6.0
System.out.println(triangle);  // Треугольник: стороны a=3.00, b=4.00, c=5.00 | Площадь=6.00
```

### Пример 2: Равносторонний треугольник

```java
TriangleAreaCalculator triangle = new TriangleAreaCalculator(2, 2, 2);
double area = triangle.calculateArea();  // ~1.732
System.out.println(triangle);  // Треугольник: стороны a=2.00, b=2.00, c=2.00 | Площадь=1.73
```

### Пример 3: Обработка ошибок

```java
try {
    TriangleAreaCalculator triangle = new TriangleAreaCalculator(1, 2, 5);
} catch (IllegalArgumentException e) {
    System.out.println("Ошибка: " + e.getMessage());
    // Ошибка: стороны не образуют валидный треугольник...
}
```

### Пример 4: Запуск примеров

```bash
javac src/main/java/com/triangle/*.java
java -cp src/main/java com.triangle.TriangleAreaExample
```

## Граничные случаи

Класс обрабатывает следующие граничные случаи:

### 1. Отрицательные значения
```java
new TriangleAreaCalculator(-3, 4, 5);  // throws IllegalArgumentException
```

### 2. Нулевые значения
```java
new TriangleAreaCalculator(0, 4, 5);   // throws IllegalArgumentException
```

### 3. Нарушение неравенства треугольника
```java
new TriangleAreaCalculator(1, 2, 5);   // throws IllegalArgumentException
// (1 + 2 = 3 < 5)

new TriangleAreaCalculator(1, 2, 3);   // throws IllegalArgumentException
// (1 + 2 = 3, должно быть строго больше)
```

### 4. Дробные значения
```java
TriangleAreaCalculator triangle = new TriangleAreaCalculator(2.5, 3.5, 4.0);
double area = triangle.calculateArea();  // Поддерживаются корректно
```

### 5. Очень малые и очень большие значения
```java
// Малые значения
TriangleAreaCalculator small = new TriangleAreaCalculator(0.1, 0.1, 0.1);

// Большие значения
TriangleAreaCalculator large = new TriangleAreaCalculator(1000, 1000, 1000);
```

## Юнит-тесты

Проект включает комплексный набор юнит-тестов, которые проверяют:

- Корректный расчет площади для различных типов треугольников
- Валидацию отрицательных значений
- Валидацию нулевых значений
- Валидацию неравенства треугольника
- Работу с дробными числами
- Работу с очень малыми и большими значениями
- Getter методы
- Метод toString()

### Запуск тестов

```bash
# С использованием Maven
mvn test

# С использованием Gradle
gradle test

# Или напрямую через командную строку (если установлены JUnit зависимости)
javac -cp .:junit-jupiter-api-5.x.x.jar src/test/java/com/triangle/*.java
java -cp .:junit-jupiter-api-5.x.x.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## Зависимости

### Для компиляции и запуска основного кода
- Java 8 или выше

### Для запуска тестов
- JUnit 5 (Jupiter)

## Примеры результатов

```
=== Примеры расчета площади треугольника по формуле Герона ===

Пример 1: Прямоугольный треугольник со сторонами 3, 4, 5
Треугольник: стороны a=3.00, b=4.00, c=5.00 | Площадь=6.00
Ожидаемая площадь: 6.0 (3*4/2)

Пример 2: Равносторонний треугольник со стороной 2
Треугольник: стороны a=2.00, b=2.00, c=2.00 | Площадь=1.73
Ожидаемая площадь: ~1.73 (√3)

Пример 3: Произвольный треугольник со сторонами 5, 6, 7
Треугольник: стороны a=5.00, b=6.00, c=7.00 | Площадь=14.70
Полупериметр: 9.0
Расчет: √(9 * 4 * 3 * 2) = √216 ≈ 14.7

Пример 5: Попытка создать треугольник с отрицательной стороной (-3, 4, 5)
Ошибка (ожидаемо): Ошибка: все стороны треугольника должны быть положительными числами...
```

## Использованные технологии

- **Язык**: Java
- **Build Tool**: Maven (pom.xml) / Gradle (build.gradle) - опционально
- **Testing Framework**: JUnit 5 (Jupiter)
- **IDE**: IntelliJ IDEA / Eclipse / VS Code + Extension Pack for Java

## Лицензия

Этот проект доступен для свободного использования и модификации.
