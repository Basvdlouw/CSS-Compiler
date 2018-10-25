// Generated from D:/school/ASD/APP/CSS-Compiler/src/main/antlr4/nl/han/ica/icss/parser\ICSS.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ICSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ICSSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(ICSSParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#stylerule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylerule(ICSSParser.StyleruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#stylesheetPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheetPart(ICSSParser.StylesheetPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableInOperation}
	 * labeled alternative in {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInOperation(ICSSParser.VariableInOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inversiveAddition}
	 * labeled alternative in {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInversiveAddition(ICSSParser.InversiveAdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(ICSSParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalInOperation}
	 * labeled alternative in {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralInOperation(ICSSParser.LiteralInOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(ICSSParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(ICSSParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pixelLiteral}
	 * labeled alternative in {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPixelLiteral(ICSSParser.PixelLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code percentageLiteral}
	 * labeled alternative in {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentageLiteral(ICSSParser.PercentageLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scalarLiteral}
	 * labeled alternative in {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarLiteral(ICSSParser.ScalarLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colorLiteral}
	 * labeled alternative in {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorLiteral(ICSSParser.ColorLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagSelector}
	 * labeled alternative in {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagSelector(ICSSParser.TagSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classSelector}
	 * labeled alternative in {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassSelector(ICSSParser.ClassSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idSelector}
	 * labeled alternative in {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSelector(ICSSParser.IdSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(ICSSParser.VariableReferenceContext ctx);
}