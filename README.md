# Java2DGameEngine

A simple 2D game engine made with Java.

## Requirements

- Java 8 JDK or greater
- Maven 3 or greater

## QuickStart

- Download the [latest release](https://github.com/BertrandAlexandre/Java2DGameEngine/releases).
- Import `Java2DGameEngine.jar` into your project dependencies.
- Install into local repository using command :
```Shell
mvn install:install-file -Dfile={path-to-jar}
                         -DgroupId=fr.alexandrebertrand.game
                         -DartifactId=java2d-game-engine
                         -Dversion={version}
                         -Dpackaging=jar
                         -DgeneratePom=true
```
- Include dependency to your project pom using :
```xml
<dependencies>
  <dependency>
    <groupId>fr.alexandrebertrand.game</groupId>
    <artifactId>java2d-game-engine</artifactId>
    <version>{version}</version>
  </dependency>
</dependencies>
```
- Use.

## Presentation

### Available components

| Name            | Category |
| --------------- | -------- |
| BoxCollider     | Collider |
| OvalCollider    | Collider |
| ComplexCollider | Collider |
| ShapeRenderer   | Renderer |
| SpriteRenderer  | Renderer |

## License

**Java2DGameEngine** is licensed under the [MIT License](https://github.com/BertrandAlexandre/Java2DGameEngine/blob/master/LICENSE).