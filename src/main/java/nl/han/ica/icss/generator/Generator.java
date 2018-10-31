package nl.han.ica.icss.generator;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;

public class Generator {

    public String generate(AST ast) {
        StringBuilder builder = new StringBuilder();
        checkNodes(ast, builder);
        return builder.toString();
    }

    private void checkNodes(AST ast, StringBuilder builder) {
        for (ASTNode node : ast.root.getChildren()) {
            if (node instanceof Stylerule) {
                generateStyleRule((Stylerule) node, builder);
            }
        }
    }

    private void generateStyleRule(Stylerule stylerule, StringBuilder builder) {
        StringBuilder selectors = new StringBuilder();
        for (int i = 0; i < stylerule.selectors.size(); i++) {
            if (i == 0)
                selectors.append(stylerule.selectors.get(i));
            else
                selectors.append(" ").append(stylerule.selectors.get(i));
        }
        builder.append(selectors.toString())
                .append(" {")
                .append(System.lineSeparator());
        for (ASTNode node : stylerule.getChildren()) {
            if (node instanceof Declaration) {
                generateDeclaration((Declaration) node, builder);
            }
        }
        builder.append('}')
                .append(System.lineSeparator());
    }

    private void generateDeclaration(Declaration declaration, StringBuilder builder) {
        builder.append("    ")
                .append(declaration.property.name)
                .append(": ")
                .append(getExpressionValue(declaration.expression))
                .append(";")
                .append(System.lineSeparator());
    }

    private String getExpressionValue(Expression expression) {
        if (expression instanceof ColorLiteral) {
            return ((ColorLiteral) expression).value;
        } else if (expression instanceof PercentageLiteral) {
            return ((PercentageLiteral) expression).value + "%";
        } else if (expression instanceof PixelLiteral) {
            return ((PixelLiteral) expression).value + "px";
        } else if (expression instanceof ScalarLiteral) {
            return Integer.toString(((ScalarLiteral) expression).value);
        }
        return expression.toString();
    }
}