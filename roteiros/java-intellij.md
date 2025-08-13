## Instalação do Java e Intellij


- - -
#### Java Development Kit (JDK)
- - -

1. O Java Development Kit possui várias implementações e versões. Para facilitar a instalação e munuseio de múltiplas versões, minha sugestão é usar a ferramenta SDKMAN. 

2. A ferramenta SDKMAN auxilia no gerenciamento de várias versões do SDK do Java. Ele também configura automaticamente a variável de ambiente JAVA_HOME. Veja como instalar em https://sdkman.io/install e seu uso básico em https://sdkman.io/usage. Instalado, o seguinte comando pode ser usado para instalar a última versão do Java: 

    ```sh
    sdk install java
    ```

3. Para testar se funcionou, executar em um terminal

    ```sh
    java -version
    javac -version
    ```



- - -
#### Intellij IDEA
- - -

A IDE que iremos usar será o Intellij IDEA. 

- Faça o download em https://www.jetbrains.com/pt-br/idea/download; a versão community é suficiente mas a versão Pro pode ser obtida pedindo uma licença acadêmica. 

- Execute PASTA_DESCOMPACTADA_INTELLIJ/bin/idea.sh

-  Crie um novo projeto -> Java + Maven

- Ver passo-a-passo em https://www.jetbrains.com/help/idea/junit.html

- Crie a classe a seguir:

```java
// Calculator.java 

package br.ufscar.dc.es2;

public class Calculator {

    static int add(int a, int b) {
        return a + b;
    }
}
```

- No código da classe, selecione o rótulo `Calculator`, botão direito -> Show Context Actions -> Create Test

    - Clique no botão `fix` para adicionar a dependência do JUnit. 

- Abra o arquivo `pom.xml`

- Adicione a dependência da biblioteca Mockito (vamos usar mais adiante). O arquivo deve ficar semelhante ao abaixo.
    - Clique no botão `Sync Maven Changes` para que as dependências sejam baixadas. 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.ufscar.dc.es2</groupId>
    <artifactId>test1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```