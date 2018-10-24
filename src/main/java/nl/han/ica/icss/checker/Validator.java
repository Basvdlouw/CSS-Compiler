package nl.han.ica.icss.checker;

import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.Operation;
import nl.han.ica.icss.ast.VariableReference;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;
import java.util.Objects;

/*/
This class contains functions to validate individual nodes, the checker class validates the entire tree by calling the checkNode method on each node
 */
class Validator {

    /*/
    Check what type of node it is
     */
    void checkNode(ASTNode astNode, HashMap<String, ExpressionType> variableTypes) {
        if (astNode instanceof VariableReference)
            checkVariableReference((VariableReference) astNode, variableTypes);
        else if (astNode instanceof Operation)
            checkOperation((Operation) astNode, variableTypes);
        else if (astNode instanceof Declaration)
            checkDeclaration((Declaration) astNode, variableTypes);
    }


    /*/
    Check for declaration errors
     */
    private void checkDeclaration(Declaration declaration, HashMap<String, ExpressionType> variableTypes) {
        ExpressionType expressionType = null;

        //Check for the expression type if it's assigned to a variable
        if (declaration.expression instanceof VariableReference)
            expressionType = variableTypes.get(((VariableReference) declaration.expression).name);

        //Check if "width" or "height" use pixel or percentage literals
        if (declaration.property.name.equals("width") || declaration.property.name.equals("height")) {
            if (declaration.expression instanceof ColorLiteral || Objects.equals(expressionType, ExpressionType.COLOR)) {
                declaration.setError("width and height cannot contain color values");
            }
        }

        //Check if "color" or "background-color" use a color literal
        else if (declaration.property.name.equals("color") || declaration.property.name.equals("background-color")) {
            if (!(declaration.expression instanceof ColorLiteral) && !Objects.equals(expressionType, ExpressionType.COLOR)) {
                declaration.setError("A color cannot contain anything outside of color values");
            }
        }
    }

    /*/
    Check for variable reference errors
     */
    private void checkVariableReference(VariableReference variableReference, HashMap<String, ExpressionType> variableTypes) {

        //Checks if a variable reference does not reference a variable that was never declared
        if (!variableTypes.containsKey(variableReference.name)) {
            variableReference.setError("This variable reference was never been declared");
        }
    }


    /*/
    Check for operation errors
     */
    private void checkOperation(Operation operation, HashMap<String, ExpressionType> variableTypes) {
        ExpressionType expressionTypeLhs = null;
        ExpressionType expressionTypeRhs = null;

        if (operation.lhs instanceof VariableReference)
            expressionTypeLhs = variableTypes.get(((VariableReference) operation.lhs).name);
        if (operation.rhs instanceof VariableReference)
            expressionTypeRhs = variableTypes.get(((VariableReference) operation.rhs).name);

        //Checks if a color is used in an operation
        if (operation.lhs instanceof ColorLiteral
                || operation.rhs instanceof ColorLiteral
                || Objects.equals(expressionTypeLhs, ExpressionType.COLOR)
                || Objects.equals(expressionTypeRhs, ExpressionType.COLOR)) {
            operation.setError("A color can not be used in an operation");
        }

        //Check if the values are of the same type when adding or substracting values
        else if (operation instanceof AddOperation || operation instanceof SubtractOperation) {
            if (operation.lhs instanceof PercentageLiteral && operation.rhs instanceof PixelLiteral
                    || operation.lhs instanceof PixelLiteral && operation.rhs instanceof PercentageLiteral
                    || operation.lhs instanceof PercentageLiteral && Objects.equals(expressionTypeRhs, ExpressionType.PIXEL)
                    || Objects.equals(expressionTypeLhs, ExpressionType.PIXEL) && operation.rhs instanceof PercentageLiteral
                    || operation.lhs instanceof PixelLiteral && Objects.equals(expressionTypeRhs, ExpressionType.PERCENTAGE)
                    || Objects.equals(expressionTypeLhs, ExpressionType.PERCENTAGE) && operation.rhs instanceof PixelLiteral) {
                operation.setError("Can not substract or add values if they aren't from the same type");
            }
        }

        //Check if a scalar literal is used in a multiplication
        else if (operation instanceof MultiplyOperation) {
            if (!(operation.lhs instanceof ScalarLiteral
                    && !(operation.rhs instanceof ScalarLiteral))
                    && !Objects.equals(expressionTypeLhs, ExpressionType.SCALAR)
                    && !Objects.equals(expressionTypeRhs, ExpressionType.SCALAR)) {
                operation.setError("A scalar value needs to be used in a multiplication");
            }
        }
    }
}
