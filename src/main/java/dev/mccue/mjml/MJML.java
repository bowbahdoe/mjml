package dev.mccue.mjml;

import dev.mccue.json.Json;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

public final class MJML {
    private static final Object ENGINE_LOCK = new Object();
    private static Engine ENGINE = null;

    private static Engine getEngine() {
        synchronized (ENGINE_LOCK) {
            if (ENGINE == null) {
                ENGINE = Engine
                        .newBuilder("js")
                        .option("engine.WarnInterpreterOnly", "false")
                        .build();
            }
            return ENGINE;
        }
    }

    private static final String mjmlSource;
    static  {
        try {
            mjmlSource = "window={};" + "process={};" + new String(
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
        var contextBuilder = Context.newBuilder()
                .allowHostAccess(HostAccess.NONE)
                //.logHandler(OutputStream.nullOutputStream())
                ;
        if (engine != null) {
            contextBuilder.engine(engine);
        }
        else {
            contextBuilder.engine(getEngine());
        }

        try (Context context = contextBuilder.build()) {
            var bindings = context.getBindings("js");
            bindings.putMember("code", contents);
            bindings.putMember("options", Json.write(options.asJson()));
            var result = context.eval("js", mjmlSource);
            return result.getMember("html").asString();
        }
    }

    @Override
    public String toString() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof MJML mjml
                && Objects.equals(contents, mjml.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(contents);
    }
}
