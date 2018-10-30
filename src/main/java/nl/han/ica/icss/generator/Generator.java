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
                selectors.append(" " + stylerule.selectors.get(i));
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
                .append(": ");
        if (declaration.expression instanceof ColorLiteral)
            builder.append(((ColorLiteral) declaration.expression).value);
        else if (declaration.expression instanceof PixelLiteral)
            builder.append(((PixelLiteral) declaration.expression).value + "px");
        else if (declaration.expression instanceof PercentageLiteral)
            builder.append(((PercentageLiteral) declaration.expression).value + "%");
        else if (declaration.expression instanceof ScalarLiteral)
            builder.append(((ScalarLiteral) declaration.expression).value);
        builder.append(";")
                .append(System.lineSeparator());
    }
}