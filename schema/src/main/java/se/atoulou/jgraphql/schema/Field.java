package se.atoulou.jgraphql.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import se.atoulou.jgraphql.annotations.NotNull;

public class Field {
    private final @NotNull String                    name;
    private final String                             description;
    private final @NotNull List<@NotNull InputValue> args;
    private final @NotNull Type                      type;
    private final @NotNull Boolean                   isDeprecated;
    private final String                             deprecationReason;

    public static Builder builder() {
        return new Builder();
    }

    protected Field(@NotNull String name, String description, @NotNull List<@NotNull InputValue> args, @NotNull Type type, @NotNull Boolean isDeprecated,
            String deprecationReason) {
        super();
        this.name = name;
        this.description = description;
        this.args = args;
        this.type = type;
        this.isDeprecated = isDeprecated;
        this.deprecationReason = deprecationReason;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<InputValue> getArgs() {
        return args;
    }

    public Type getType() {
        return type;
    }

    public Boolean isDeprecated() {
        return isDeprecated;
    }

    public String getDeprecationReason() {
        return deprecationReason;
    }

    public static class Builder {
        private String                   name;
        private String                   description;
        private List<InputValue.Builder> args;
        private Type.Builder             type;
        private Boolean                  isDeprecated;
        private String                   deprecationReason;

        protected Builder() {
            args = new ArrayList<>();
        }

        public Field build() {
            List<InputValue> args = this.args.stream().map(builder -> builder.build()).collect(Collectors.toList());
            Type type = this.type.build();
            return new Field(name, description, args, type, isDeprecated, deprecationReason);
        }

        public String name() {
            return name;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public String description() {
            return description;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public List<InputValue.Builder> args() {
            return args;
        }

        public Builder args(List<InputValue.Builder> args) {
            this.args = args;
            return this;
        }

        public Type.Builder type() {
            return type;
        }

        public Builder type(Type.Builder type) {
            this.type = type;
            return this;
        }

        public Boolean isDeprecated() {
            return isDeprecated;
        }

        public Builder isDeprecated(Boolean isDeprecated) {
            this.isDeprecated = isDeprecated;
            return this;
        }

        public String deprecationReason() {
            return deprecationReason;
        }

        public Builder deprecationReason(String deprecationReason) {
            this.deprecationReason = deprecationReason;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Field [args=" + args + ", deprecationReason=" + deprecationReason + ", description=" + description + ", isDeprecated=" + isDeprecated
                + ", name=" + name + ", type=" + type + "]";
    }
}
