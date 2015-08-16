package se.atoulou.jgraphql.schema;

import se.atoulou.jgraphql.annotations.NotNull;

public class InputValue {
    private final @NotNull String name;
    private final String          description;
    private final @NotNull Type   type;
    private final String          defaultValue;

    public static Builder builder() {
        return new Builder();
    }

    protected InputValue(@NotNull String name, String description, @NotNull Type type, String defaultValue) {
        super();
        this.name = name;
        this.description = description;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public static class Builder {
        private String name;
        private String description;
        private Type   type;
        private String defaultValue;

        protected Builder() {
        }

        public InputValue build() {
            return new InputValue(name, description, type, defaultValue);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder defaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
    }

    @Override
    public String toString() {
        return "InputValue [defaultValue=" + defaultValue + ", description=" + description + ", name=" + name + ", type=" + type + "]";
    }
}