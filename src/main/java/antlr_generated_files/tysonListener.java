// Generated from tyson.g4 by ANTLR 4.7.1
package antlr_generated_files;

import org.antlr.v4.runtime.tree.ParseTreeListener;

import antlr_generated_files.tysonParser.AnnotatedValueContext;
import antlr_generated_files.tysonParser.ArrayContext;
import antlr_generated_files.tysonParser.NumberContext;
import antlr_generated_files.tysonParser.ObjContext;
import antlr_generated_files.tysonParser.PairContext;
import antlr_generated_files.tysonParser.TysonContext;
import antlr_generated_files.tysonParser.ValueContext;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tysonParser}.
 */
public interface tysonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tysonParser#tyson}.
	 * @param ctx the parse tree
	 */
	void enterTyson(tysonParser.TysonContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#tyson}.
	 * @param ctx the parse tree
	 */
	void exitTyson(tysonParser.TysonContext ctx);
	/**
	 * Enter a parse tree produced by {@link tysonParser#annotatedValue}.
	 * @param ctx the parse tree
	 */
	void enterAnnotatedValue(tysonParser.AnnotatedValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#annotatedValue}.
	 * @param ctx the parse tree
	 */
	void exitAnnotatedValue(tysonParser.AnnotatedValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link tysonParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(tysonParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(tysonParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link tysonParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(tysonParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(tysonParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link tysonParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(tysonParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(tysonParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link tysonParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(tysonParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(tysonParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link tysonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(tysonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link tysonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(tysonParser.ValueContext ctx);
}