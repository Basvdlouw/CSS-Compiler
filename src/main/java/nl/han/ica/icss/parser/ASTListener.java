package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;

import java.util.Stack;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {

    //Accumulator attributes:
    private AST ast;

    //Use this to keep track of the parent nodes when recursively traversing the ast
    private Stack<ASTNode> currentContainer;

    public ASTListener() {
        ast = new AST();
        currentContainer = new Stack<>();
    }

    public AST getAST() {
        return ast;
    }

    @Override
    public void enterStylesheet(ICSSParser.StylesheetContext ctx) {
        ast.setRoot(new Stylesheet());
    }

    @Override
    public void enterStylerule(ICSSParser.StyleruleContext ctx) {
        currentContainer.push(new Stylerule());
    }

    @Override
    public void exitStylerule(ICSSParser.StyleruleContext ctx) {
        ast.root.addChild(currentContainer.pop());
    }

    @Override
    public void enterVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
        currentContainer.push(new VariableAssignment());
    }

    @Override
    public void exitVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
        ast.root.addChild(currentContainer.pop());
    }

    @Override
    public void enterVariableReference(ICSSParser.VariableReferenceContext ctx) {
        currentContainer.peek().addChild(new VariableReference(ctx.getText()));
    }

    @Override
    public void enterTagSelector(ICSSParser.TagSelectorContext ctx) {
        currentContainer.peek().addChild(new TagSelector(ctx.getText()));
    }

    @Override
    public void enterIdSelector(ICSSParser.IdSelectorContext ctx) {
        currentContainer.peek().addChild(new IdSelector(ctx.getText()));
    }

    @Override
    public void enterClassSelector(ICSSParser.ClassSelectorContext ctx) {
        currentContainer.peek().addChild(new ClassSelector(ctx.getText()));
    }

    @Override
    public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
        currentContainer.push(new Declaration());
    }

    @Override
    public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
        Declaration declaration = (Declaration) currentContainer.pop();
        currentContainer.peek().addChild(declaration);
    }

    @Override
    public void enterAddition(ICSSParser.AdditionContext ctx) {
        currentContainer.push(new AddOperation());
    }

    @Override
    public void exitAddition(ICSSParser.AdditionContext ctx) {
        AddOperation addOperation = (AddOperation) currentContainer.pop();
        currentContainer.peek().addChild(addOperation);
    }

    @Override
    public void enterMultiplication(ICSSParser.MultiplicationContext ctx) {
        currentContainer.push(new MultiplyOperation());
    }

    @Override
    public void exitMultiplication(ICSSParser.MultiplicationContext ctx) {
        MultiplyOperation multiplyOperation = (MultiplyOperation) currentContainer.pop();
        currentContainer.peek().addChild(multiplyOperation);
    }

    @Override
    public void enterInversiveAddition(ICSSParser.InversiveAdditionContext ctx) {
        currentContainer.push(new SubtractOperation());
    }

    @Override
    public void exitInversiveAddition(ICSSParser.InversiveAdditionContext ctx) {
        SubtractOperation subtractOperation = (SubtractOperation) currentContainer.pop();
        currentContainer.peek().addChild(subtractOperation);
    }

    @Override
    public void enterProperty(ICSSParser.PropertyContext ctx) {
        currentContainer.peek().addChild(new PropertyName(ctx.getText()));
    }

    @Override
    public void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        currentContainer.peek().addChild(new PixelLiteral(ctx.getText()));
    }

    @Override
    public void enterScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        currentContainer.peek().addChild(new ScalarLiteral(ctx.getText()));
    }

    @Override
    public void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
      currentContainer.peek().addChild(new PercentageLiteral(ctx.getText()));
    }

    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        currentContainer.peek().addChild(new ColorLiteral(ctx.getText()));
    }

}
