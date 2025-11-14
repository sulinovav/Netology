# Руководство по установке и настройке

## Требования

- **Java**: Java 8 или выше
- **Maven** (опционально): для управления проектом и зависимостями
- **Gradle** (опционально): альтернатива Maven
- **IDE** (опционально): IntelliJ IDEA, Eclipse, VS Code или другая

## Проверка установки Java

```bash
java -version
javac -version
```

Должны вывести информацию о версии Java.

## Структура проекта

```
/
├── src/
│   ├── main/java/com/triangle/
│   │   ├── TriangleAreaCalculator.java       # Основной класс
│   │   └── TriangleAreaExample.java          # Примеры использования
│   └── test/java/com/triangle/
│       └── TriangleAreaCalculatorTest.java   # Тесты
├── pom.xml                                    # Maven конфигурация
├── build.gradle                               # Gradle конфигурация
├── TRIANGLE_AREA_README.md                   # Документация
├── USAGE_EXAMPLES.md                         # Примеры использования
├── SETUP.md                                   # Этот файл
└── .gitignore                                # Git ignore правила
```

## Установка и запуск

### Вариант 1: Использование Maven

#### 1.1 Установка Maven

**На Linux (Ubuntu/Debian):**
```bash
sudo apt-get update
sudo apt-get install maven
```

**На macOS:**
```bash
brew install maven
```

**На Windows:**
Скачайте с https://maven.apache.org/download.cgi и следуйте инструкциям.

#### 1.2 Компиляция проекта

```bash
cd /home/engine/project
mvn clean compile
```

#### 1.3 Запуск примеров

```bash
mvn exec:java -Dexec.mainClass="com.triangle.TriangleAreaExample"
```

#### 1.4 Запуск тестов

```bash
mvn test
```

#### 1.5 Создание JAR файла

```bash
mvn clean package
```

Это создаст файл `target/triangle-area-calculator-1.0.0.jar`

#### 1.6 Запуск JAR файла

```bash
java -jar target/triangle-area-calculator-1.0.0.jar
```

### Вариант 2: Использование Gradle

#### 2.1 Установка Gradle

**На Linux/macOS:**
```bash
sdk install gradle
```

**Или скачайте вручную:**
https://gradle.org/releases/

**На Windows:**
Скачайте с https://gradle.org/releases/ и добавьте в PATH.

#### 2.2 Компиляция проекта

```bash
cd /home/engine/project
gradle clean build
```

#### 2.3 Запуск примеров

```bash
gradle runExample
```

#### 2.4 Запуск тестов

```bash
gradle test
```

### Вариант 3: Компиляция вручную (без Maven/Gradle)

#### 3.1 Компиляция

```bash
cd /home/engine/project
mkdir -p bin
javac -d bin src/main/java/com/triangle/*.java
```

#### 3.2 Запуск примеров

```bash
java -cp bin com.triangle.TriangleAreaExample
```

#### 3.3 Компиляция тестов (требует JUnit)

```bash
# Сначала скачайте JUnit JAR файлы
# https://repo1.maven.org/maven2/org/junit/jupiter/

javac -cp bin:junit-jupiter-api-5.9.2.jar:junit-jupiter-engine-5.9.2.jar \
      -d bin \
      src/test/java/com/triangle/*.java

# Запуск тестов
java -cp bin:junit-jupiter-api-5.9.2.jar:junit-jupiter-engine-5.9.2.jar \
     org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## Настройка IDE

### IntelliJ IDEA

1. Откройте File → Open
2. Выберите директорию `/home/engine/project`
3. Выберите "Open as Project"
4. IDE автоматически распознает pom.xml и загрузит зависимости
5. Правый клик на TriangleAreaExample.java → Run

### Eclipse

1. Откройте File → Import...
2. Выберите "Existing Maven Projects"
3. Browse и выберите `/home/engine/project`
4. Finish
5. IDE загрузит зависимости
6. Правый клик на TriangleAreaExample.java → Run As → Java Application

### VS Code

1. Установите Extension Pack for Java
2. Откройте `/home/engine/project` в VS Code
3. VS Code распознает Java проект
4. Откройте TriangleAreaExample.java
5. Нажмите "Run" над методом main

## Проверка установки

После установки убедитесь, что все работает правильно:

```bash
# 1. Проверьте версию Java
java -version

# 2. Проверьте Maven (если установлен)
mvn --version

# 3. Перейдите в директорию проекта
cd /home/engine/project

# 4. Запустите примеры
mvn exec:java -Dexec.mainClass="com.triangle.TriangleAreaExample"
```

Если вы видите вывод с примерами расчета площадей треугольников, значит все работает правильно!

## Трубшутинг

### Проблема: "mvn: command not found"
**Решение**: Maven не установлен. Установите Maven или используйте Gradle/компиляцию вручную.

### Проблема: "javac: command not found"
**Решение**: Java Development Kit (JDK) не установлен. Установите JDK (не только JRE).

**Linux:**
```bash
sudo apt-get install default-jdk
```

**macOS:**
```bash
brew install openjdk
```

### Проблема: "BUILD FAILURE"
**Решение**: Проверьте:
1. Установлена ли правильная версия Java: `java -version`
2. Правильный ли PATH в окружении
3. Попробуйте очистить кэш: `mvn clean` или `gradle clean`

### Проблема: Тесты не запускаются
**Решение**: Убедитесь, что установлены зависимости:
```bash
mvn dependency:resolve
```

## Дополнительные команды

### Maven

```bash
# Очистка
mvn clean

# Компиляция
mvn compile

# Тестирование
mvn test

# Создание JAR
mvn package

# Установка локально
mvn install

# Просмотр зависимостей
mvn dependency:tree

# Запуск с параметрами
mvn exec:java -Dexec.mainClass="com.triangle.TriangleAreaExample" \
             -Dexec.args="arg1 arg2"
```

### Gradle

```bash
# Очистка
gradle clean

# Компиляция
gradle build

# Только компиляция (без тестов)
gradle compileJava

# Запуск примеров
gradle runExample

# Запуск тестов
gradle test

# Просмотр информации о проекте
gradle projects

# Просмотр задач
gradle tasks
```

## Интеграция с Git

Проект уже содержит `.gitignore` для правильного игнорирования файлов сборки.

```bash
# Проверьте статус
git status

# Добавьте изменения
git add .

# Создайте коммит
git commit -m "Add triangle area calculator"

# Отправьте на сервер
git push origin feat-triangle-area-heron-validation-examples
```

## Документация

- `TRIANGLE_AREA_README.md` - Полная документация проекта
- `USAGE_EXAMPLES.md` - 10 примеров использования
- Javadoc комментарии в исходном коде

## Поддержка и помощь

Если у вас есть вопросы или проблемы:

1. Проверьте примеры в `USAGE_EXAMPLES.md`
2. Посмотрите документацию в `TRIANGLE_AREA_README.md`
3. Посмотрите тесты в `src/test/java/com/triangle/TriangleAreaCalculatorTest.java`
4. Изучите исходный код с комментариями
