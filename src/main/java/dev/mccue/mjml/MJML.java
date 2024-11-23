package dev.mccue.mjml;

import dev.mccue.json.Json;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.function.Consumer;

public final class MJML {
    private static final String mjmlSource;
    static  {
        try {
            mjmlSource = new String(
                    Objects.requireNonNull(
                            MJML.class.getResourceAsStream("/dev/mccue/mjml/mjml.js")
                    ).readAllBytes()
            );
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }

    }
    private final String contents;

    private MJML(String contents) {
        this.contents = contents;
    }

    public static MJML of(String contents) {
        return new MJML(contents);
    }
    public String toHtmlString() {
        return toHtmlString((Engine) null);
    }

    public String toHtmlString(Consumer<ToHtmlOptions.Builder> consumer) {
        return toHtmlString(null, consumer);
    }

    public String toHtmlString(ToHtmlOptions options) {
       return toHtmlString(null, options);
    }

    public String toHtmlString(Engine engine) {
        return toHtmlString(engine, __ -> {});
    }

    public String toHtmlString(Engine engine, Consumer<ToHtmlOptions.Builder> consumer) {
        var builder = ToHtmlOptions.builder();
        consumer.accept(builder);
        return toHtmlString(engine, builder.build());
    }

    public String toHtmlString(Engine engine, ToHtmlOptions options) {
        try {
            var contextBuilder = Context.newBuilder()
                    .allowHostAccess(HostAccess.NONE)
                    .logHandler(OutputStream.nullOutputStream());
            if (engine != null) {
                contextBuilder.engine(engine);
            }
            try (Context context = contextBuilder.build()) {
                var bindings = context.getBindings("js");
                bindings.putMember("code", contents);
                bindings.putMember("options", Json.write(options.asJson()));
                var result = context.eval("js", "window={};" + "process={};" + mjmlSource);
                return result.getMember("html").asString();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}