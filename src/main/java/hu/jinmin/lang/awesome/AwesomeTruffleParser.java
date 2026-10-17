package hu.jinmin.lang.awesome;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.Reader;

public final class AwesomeTruffleParser {
    public static AwesomeNode parse(String program) {
        return parse(CharStreams.fromString(program));
    }

    public static AwesomeNode parse(Reader program) throws IOException {
        return parse(CharStreams.fromReader(program));
    }

    private static AwesomeNode parse(CharStream inputStream) {
        var lexer = new AwesomeLexer(inputStream);
        // remove the default console error listener
        lexer.removeErrorListeners();
        var parser = new AwesomeParser(new CommonTokenStream(lexer));
        // remove the default console error listener
        parser.removeErrorListeners();
        // throw an exception when a parsing error is encountered
        parser.setErrorHandler(new BailErrorStrategy());
        AwesomeParser.ExprContext context = parser.start().expr();
        return parseExpr(context);
    }

    private static AwesomeNode parseExpr(AwesomeParser.ExprContext expr) {
        return expr instanceof AwesomeParser.AddExprContext
                ? parseAdditionExpr((AwesomeParser.AddExprContext) expr)
                : parseLiteralExpr((AwesomeParser.LiteralExprContext) expr);
    }

    private static AdditionNode parseAdditionExpr(AwesomeParser.AddExprContext addExpr) {
        return AdditionNodeGen.create(
                parseExpr(addExpr.left),
                parseExpr(addExpr.right)
        );
    }

    private static AwesomeNode parseLiteralExpr(AwesomeParser.LiteralExprContext literalExpr) {
        TerminalNode intTerminal = literalExpr.literal().INT();
        return intTerminal != null
                ? parseIntLiteral(intTerminal.getText())
                : parseDoubleLiteral(literalExpr.getText());
    }

    private static AwesomeNode parseIntLiteral(String text) {
        try {
            return new IntLiteralNode(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            // it's possible that the integer literal is too big to fit in a 32-bit Java `int` -
            // in that case, fall back to a double literal
            return parseDoubleLiteral(text);
        }
    }

    private static DoubleLiteralNode parseDoubleLiteral(String text) {
        return new DoubleLiteralNode(Double.parseDouble(text));
    }
}
