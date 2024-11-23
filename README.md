# MJML

JVM library for [MJML (Mailjet Markup Language)](https://mjml.io/).

```xml
<dependency>
    <groupId>dev.mccue</groupId>
    <artifactId>mjml</artifactId>
    <version>2024.11.22</version>
</dependency>
```

## Why?

MJML lets you render html that is compatible with a wide range of email clients.
Doing this yourself is hard.

## Usage

```java
import dev.mccue.mjml.MJML;

void main() {
    var mjml = MJML.of("""
        <mjml>
              <mj-body>
                <mj-section>
                  <mj-column>
                    <mj-image width="100px" src="/assets/img/logo-small.png"></mj-image>
                    <mj-divider border-color="#F45E43"></mj-divider>
                    <mj-text font-size="20px" color="#F45E43" font-family="helvetica">Hello World</mj-text>
                  </mj-column>
                </mj-section>
              </mj-body>
            </mjml>
        """);
    
    var html = mjml.toHtmlString();

    System.out.println(html);
}
```
