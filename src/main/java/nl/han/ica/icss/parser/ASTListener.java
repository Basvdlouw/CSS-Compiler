package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
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
