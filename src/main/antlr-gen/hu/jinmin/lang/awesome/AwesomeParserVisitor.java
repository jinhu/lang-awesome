// Generated from AwesomeParser.g4 by ANTLR 4.13.2
package hu.jinmin.lang.awesome;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AwesomeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AwesomeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AwesomeParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(AwesomeParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link AwesomeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(AwesomeParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link AwesomeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(AwesomeParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwesomeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AwesomeParser.LiteralContext ctx);
}