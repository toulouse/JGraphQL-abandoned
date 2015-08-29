package se.atoulou.jgraphql.example;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.atoulou.jgraphql.models.SchemaPrettyPrinter;
import se.atoulou.jgraphql.models.schema.Schema;
import se.atoulou.jgraphql.parser.ParseHelper;
import se.atoulou.jgraphql.parser.antlr.GraphQLSchemaLexer;

public class Test {
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IOException {
        InputStream in = Test.class.getResourceAsStream("/schemaSchema.graphqlSchema");

        ANTLRInputStream input = new ANTLRInputStream(in);
        GraphQLSchemaLexer lexer = new GraphQLSchemaLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        tokenStream.fill();
        for (Token token : tokenStream.getTokens()) {
            LOG.trace("token type: {} str: {}", GraphQLSchemaLexer.VOCABULARY.getSymbolicName(token.getType()), token);
        }

        in = Test.class.getResourceAsStream("/schemaSchema.graphqlSchema");
        Schema schema = ParseHelper.parseSchema(in);
        LOG.trace("Document: \n{}", new SchemaPrettyPrinter().writeSchema(schema));
    }
}
