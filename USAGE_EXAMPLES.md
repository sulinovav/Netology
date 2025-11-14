# Примеры использования TriangleAreaCalculator

## Быстрый старт

### Пример 1: Базовое использование

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        // Создание треугольника со сторонами 3, 4, 5
        TriangleAreaCalculator triangle = new TriangleAreaCalculator(3, 4, 5);
        
        // Получение площади
        double area = triangle.calculateArea();
        System.out.println("Площадь: " + area);  // Вывод: Площадь: 6.0
    }
}
```

### Пример 2: Использование с выводом информации

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator triangle = new TriangleAreaCalculator(5, 6, 7);
        
        // Вывод полной информации
        System.out.println(triangle);
        // Вывод: Треугольник: стороны a=5.00, b=6.00, c=7.00 | Площадь=14.70
        
        // Получение отдельных значений
        System.out.println("Сторона A: " + triangle.getSideA());
        System.out.println("Сторона B: " + triangle.getSideB());
        System.out.println("Сторона C: " + triangle.getSideC());
    }
}
```

### Пример 3: Обработка ошибок

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        // Попытка создать невалидный треугольник
        try {
            TriangleAreaCalculator triangle = new TriangleAreaCalculator(1, 2, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            // Вывод: Ошибка: стороны не образуют валидный треугольник...
        }
    }
}
```

### Пример 4: Различные типы треугольников

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        // Равносторонний треугольник
        TriangleAreaCalculator equilateral = new TriangleAreaCalculator(4, 4, 4);
        System.out.println("Равносторонний: " + equilateral.calculateArea());
        
        // Равнобедренный треугольник
        TriangleAreaCalculator isosceles = new TriangleAreaCalculator(5, 5, 6);
        System.out.println("Равнобедренный: " + isosceles.calculateArea());
        
        // Прямоугольный треугольник
        TriangleAreaCalculator right = new TriangleAreaCalculator(3, 4, 5);
        System.out.println("Прямоугольный: " + right.calculateArea());
        
        // Произвольный треугольник
        TriangleAreaCalculator arbitrary = new TriangleAreaCalculator(7, 8, 9);
        System.out.println("Произвольный: " + arbitrary.calculateArea());
    }
}
```

### Пример 5: Работа с коллекциями треугольников

```java
import com.triangle.TriangleAreaCalculator;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TriangleAreaCalculator> triangles = new ArrayList<>();
        
        // Добавление треугольников
        triangles.add(new TriangleAreaCalculator(3, 4, 5));
        triangles.add(new TriangleAreaCalculator(5, 6, 7));
        triangles.add(new TriangleAreaCalculator(4, 4, 4));
        
        // Вычисление общей площади
        double totalArea = 0;
        for (TriangleAreaCalculator triangle : triangles) {
            totalArea += triangle.calculateArea();
            System.out.println(triangle);
        }
        
        System.out.println("Общая площадь: " + totalArea);
    }
}
```

### Пример 6: Валидация пользовательского ввода

```java
import com.triangle.TriangleAreaCalculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите три стороны треугольника:");
        
        try {
            System.out.print("Сторона A: ");
            double a = scanner.nextDouble();
            
            System.out.print("Сторона B: ");
            double b = scanner.nextDouble();
            
            System.out.print("Сторона C: ");
            double c = scanner.nextDouble();
            
            TriangleAreaCalculator triangle = new TriangleAreaCalculator(a, b, c);
            System.out.println(triangle);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
```

### Пример 7: Создание утилитарного класса для работы с треугольниками

```java
import com.triangle.TriangleAreaCalculator;

public class TriangleUtils {
    
    public static boolean isValidTriangle(double a, double b, double c) {
        try {
            new TriangleAreaCalculator(a, b, c);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    public static double getArea(double a, double b, double c) {
        return new TriangleAreaCalculator(a, b, c).calculateArea();
    }
    
    public static void printTriangleInfo(double a, double b, double c) {
        try {
            TriangleAreaCalculator triangle = new TriangleAreaCalculator(a, b, c);
            System.out.println(triangle);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Использование утилит
        if (TriangleUtils.isValidTriangle(3, 4, 5)) {
            System.out.println("Площадь треугольника 3-4-5: " + 
                             TriangleUtils.getArea(3, 4, 5));
        }
        
        TriangleUtils.printTriangleInfo(5, 6, 7);
        TriangleUtils.printTriangleInfo(1, 2, 5);  // Выведет ошибку
    }
}
```

### Пример 8: Обработка граничных случаев

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        // Тестирование различных граничных случаев
        testTriangle(3, 4, 5, "Прямоугольный треугольник");
        testTriangle(2, 2, 2, "Равносторонний треугольник");
        testTriangle(0.1, 0.1, 0.1, "Очень малый треугольник");
        testTriangle(100, 100, 100, "Большой треугольник");
        testTriangle(1.5, 2.5, 3.0, "Дробный треугольник");
        testTriangle(-1, 2, 3, "Отрицательная сторона");
        testTriangle(1, 2, 3, "Граница неравенства треугольника");
    }
    
    static void testTriangle(double a, double b, double c, String description) {
        try {
            TriangleAreaCalculator triangle = new TriangleAreaCalculator(a, b, c);
            System.out.println("✓ " + description + ": " + triangle.calculateArea());
        } catch (IllegalArgumentException e) {
            System.out.println("✗ " + description + ": ОШИБКА");
        }
    }
}
```

### Пример 9: Сравнение треугольников по площади

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator triangle1 = new TriangleAreaCalculator(3, 4, 5);
        TriangleAreaCalculator triangle2 = new TriangleAreaCalculator(5, 6, 7);
        
        double area1 = triangle1.calculateArea();
        double area2 = triangle2.calculateArea();
        
        if (area1 > area2) {
            System.out.println("Первый треугольник больше");
        } else if (area1 < area2) {
            System.out.println("Второй треугольник больше");
        } else {
            System.out.println("Треугольники имеют одинаковую площадь");
        }
    }
}
```

### Пример 10: Использование в потоке

```java
import com.triangle.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        double[][] triangles = {
            {3, 4, 5},
            {5, 6, 7},
            {4, 4, 4},
            {7, 8, 9}
        };
        
        // Обработка в параллельном потоке
        java.util.Arrays.stream(triangles)
            .parallel()
            .forEach(sides -> {
                try {
                    TriangleAreaCalculator triangle = 
                        new TriangleAreaCalculator(sides[0], sides[1], sides[2]);
                    System.out.println(triangle);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка для сторон: " + java.util.Arrays.toString(sides));
                }
            });
    }
}
```

## Запуск примеров через командную строку

### С использованием Maven

```bash
# Скомпилировать проект
mvn clean compile

# Запустить основной пример
mvn exec:java -Dexec.mainClass="com.triangle.TriangleAreaExample"

# Запустить тесты
mvn test
```

### С использованием Gradle

```bash
# Скомпилировать проект
gradle clean build

# Запустить основной пример
gradle runExample

# Запустить тесты
gradle test
```

### Напрямую через Java

```bash
# Скомпилировать
javac -d bin src/main/java/com/triangle/*.java

# Запустить
java -cp bin com.triangle.TriangleAreaExample
```

## Типичные ошибки и их решение

### Ошибка 1: ImportError

```
error: package com.triangle does not exist
```
**Решение**: Убедитесь, что класс находится в правильном пакете и пути скомпилированы корректно.

### Ошибка 2: IllegalArgumentException с отрицательной стороной

```
Exception in thread "main" java.lang.IllegalArgumentException: 
Ошибка: все стороны треугольника должны быть положительными числами.
```
**Решение**: Убедитесь, что все три стороны - положительные числа (> 0).

### Ошибка 3: IllegalArgumentException с нарушением неравенства треугольника

```
Exception in thread "main" java.lang.IllegalArgumentException: 
Ошибка: стороны не образуют валидный треугольник. 
Условие неравенства треугольника не выполнено.
```
**Решение**: Проверьте, что сумма любых двух сторон строго больше третьей.

Пример некорректных комбинаций:
- `new TriangleAreaCalculator(1, 2, 3)` → 1 + 2 = 3 (не больше 3)
- `new TriangleAreaCalculator(1, 2, 5)` → 1 + 2 < 5
