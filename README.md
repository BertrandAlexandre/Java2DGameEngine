# Java2DGameEngine

A simple 2D game engine made with Java.

## Requirements

- Java 8 JDK or greater
- Maven 3 or greater

## QuickStart

- Download the [latest release](https://github.com/BertrandAlexandre/Java2DGameEngine/releases).
- Import `java2d-game-engine.jar` into your project dependencies.
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

## On going

### Camera

Add camera options:
- Add zoom
- Add smooth motion

### Lights

Add lights:
- Types:
  - Point
  - Spot
  - Directionnal
  - Area (rectangle, elipse, polygon)
- Parameters:
  - Color
  - Intensity
  - Radius
  - Gradient

### Audio system

Add audio system:
- Audio source component
- Audio listener

### Input management system

Add input management system:
- JSON configuration (with maven archetype)
- Link to key listener

## License

**Java2DGameEngine** is licensed under the [MIT License](https://github.com/BertrandAlexandre/Java2DGameEngine/blob/master/LICENSE).
