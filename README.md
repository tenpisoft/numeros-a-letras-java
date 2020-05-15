# n2w

Libería de Java para convertir números a letras con tipo de moneda.

**Tabla de contenidos**

- [Instalación](#instalación)

  - [Maven](#maven)
  - [Gradle](#gradle)

- [Uso](#uso)

- [Créditos](#créditos)

## Instalación

### Maven

Agregar repositorio de jitpack

```
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Agregar dependecia

```
<dependency>
    <groupId>com.github.User</groupId>
    <artifactId>Repo</artifactId>
    <version>Tag</version>
</dependency>
```

### Gradle

En `build.gradle` agreagar al final de los repositorios

```groovy
llprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Agregar dependencia

```groovy
dependencies {
  implementation 'com.github.tenpisoft:n2w:0.1.0'
}
```

## Uso

```java
ValueConverters converter1 = ValueConverters.SPANISH_INTEGER;
String valueAsWords = converter1.asWords(1_234);
System.out.println(valueAsWords); # mil doscientos treinta y cuatro
```

```java
MoneyConverters converter = MoneyConverters.SPANISH_BANKING_MONEY_VALUE;
String moneyAsWords = converter.asWords(new BigDecimal("1234.56"));
System.out.println(moneyAsWords); # mil doscientos treinta y cuatro con 56/100
```

## Créditos

Esta librería esta basada en el código de [tradukisto](https://github.com/allegro/tradukisto) y el pull request para añadir el idioma español de [Carlos Feria](carlosthe19916).
