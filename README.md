# forge

A space to **_forge_** and experiment with various data structures and algorithms using modern Java features.

## Instructions

### Minimum Requirements

- Java 21+
- Maven 3.9.x

### Code Formatting

Always make sure to check if new or edited code conforms to the required code formatting standards:

```bash
mvn spotless:check
```

If required, apply the format:

```bash
mvn spotless:apply
```

### Testing

Ensure that all tests pass:

```bash
mvn test
```

### Packaging

To prepare the library (i.e. `jar`):

```bash
mvn clean package
```