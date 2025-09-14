# forge

A space to **_forge_** and experiment with various data structures and algorithms using modern Java features.

There are certain rules to be followed while "forging":

- Avoid exceptions
  - an exception in method contract => leaving the fate in the hands of an end user
- Use latest language features wherever possible
  - learn how, when and where to use Java 9+ features
- Problem oriented approach
  - consider real problems in test cases

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