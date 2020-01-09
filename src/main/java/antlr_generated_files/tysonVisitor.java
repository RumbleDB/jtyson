// Generated from tyson.g4 by ANTLR 4.7.1
package antlr_generated_files;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tysonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tysonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tysonParser#tyson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyson(tysonParser.TysonContext ctx);
	/**
	 * Visit a parse tree produced by {@link tysonParser#annotatedValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotatedValue(tysonParser.AnnotatedValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link tysonParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(tysonParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link tysonParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(tysonParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link tysonParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(tysonParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link tysonParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(tysonParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link tysonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(tysonParser.ValueContext ctx);
}