// Generated from AwesomeParser.g4 by ANTLR 4.13.2
package hu.jinmin.lang.awesome;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AwesomeParser}.
 */
public interface AwesomeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AwesomeParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(AwesomeParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AwesomeParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(AwesomeParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link AwesomeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(AwesomeParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link AwesomeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(AwesomeParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link AwesomeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(AwesomeParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link AwesomeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(AwesomeParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AwesomeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(AwesomeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AwesomeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(AwesomeParser.LiteralContext ctx);
}