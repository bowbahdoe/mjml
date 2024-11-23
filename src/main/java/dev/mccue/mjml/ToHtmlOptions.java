package dev.mccue.mjml;

import dev.mccue.json.Json;
import dev.mccue.json.JsonObject;

import java.util.Map;


public final class ToHtmlOptions {

    final Map<String, String> fonts;
    final Boolean keepComments;
    final ValidationLevel validationLevel;

    private ToHtmlOptions(Builder builder) {
        this.fonts = builder.fonts;
        this.keepComments = builder.keepComments;
        this.validationLevel = builder.validationLevel;
    }

    Json asJson() {
        var m = Json.objectBuilder();
        m.put("ignoreIncludes", true);

        if (fonts != null) {
            var o = JsonObject.builder();
            fonts.forEach(o::put);
            m.put("fonts", o.build());
        }

        if (keepComments != null) {
            m.put("keepComments", keepComments);
        }

        if (validationLevel != null) {
            switch (validationLevel) {
                case SKIP -> m.put("validationLevel", "skip");
                case SOFT -> m.put("validationLevel", "soft");
                case STRICT -> m.put("validationLevel", "strict");
            }
        }

        System.out.println(m.build());
        return m.build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Map<String, String> fonts = null;
        private Boolean keepComments = null;
        private ValidationLevel validationLevel = null;

        private Builder() {}

        public Builder fonts(Map<String, String> fonts) {
            this.fonts = Map.copyOf(fonts);
            return this;
        }

        public Builder keepComments() {
            keepComments = true;
            return this;
        }


        public Builder keepComments(boolean keepComments) {
            this.keepComments = keepComments;
            return this;
        }

        public Builder validationLevel(ValidationLevel validationLevel) {
            this.validationLevel = validationLevel;
            return this;
        }

        public ToHtmlOptions build() {
            return new ToHtmlOptions(this);
        }
    }
}
