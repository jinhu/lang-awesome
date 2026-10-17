import com.oracle.truffle.api.CallTarget;
import hu.jinmin.lang.awesome.AwesomeParser;
import hu.jinmin.lang.awesome.AwesomeRootNode;
import hu.jinmin.lang.awesome.AwesomeTruffleParser;
import hu.jinmin.lang.awesome.DoubleLiteralNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsingTest {
    @Test
    void parses_and_executes_Awesome_code_correctly() {
        var exprNode = AwesomeTruffleParser.parse("1 + 2 + 3.0 + 4");

        var rootNode = new AwesomeRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        Object result = callTarget.call();

        assertEquals(10.0, result);
    }

    @Test
    void throws_an_exception_when_the_code_cannot_be_parsed() {
        assertThrows(Exception.class, () -> {
            AwesomeTruffleParser.parse("xyz");
        });
    }

    @Test
    void parsing_a_large_integer_falls_back_to_double() {
        // this is 9,876,543,210
        String largeInt = "9876543210";
        var exprNode = AwesomeTruffleParser.parse(largeInt);

        assertInstanceOf(DoubleLiteralNode.class, exprNode);
    }
}
