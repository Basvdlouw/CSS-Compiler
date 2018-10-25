package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static nl.han.ica.icss.transforms.CalculateOperation.calculateOperation;

//TODO: Fix transformer width variable + add nesting funcitonality
public class EvalExpressions implements Transform {

    //Converted LinkedList<HashMap<String, Literal>> to HashMap<String, Literal> because I don't see the use for the LinkedList
    private HashMap<String, Literal> variableValues;

    @Override
    public void apply(AST ast) {
        variableValues = new HashMap<>();
        evaluate(ast.root.getChildren());
    }

    /*/
    Loop recursively through tree and evaluate all individual nodes
     */
    private void evaluate(List<ASTNode> ast) {
        for (ASTNode astNode : ast) {
            addVariableToHashMap(astNode);
            evaluateExpression(astNode);
            if (astNode.getChildren() != null) {
                evaluate(astNode.getChildren());
            }
        }
    }

    /*/
    Check if the expression is an operation or a variable reference
     */
    private void evaluateExpression(ASTNode ast) {
        if (ast instanceof Declaration) {
            if (((Declaration) ast).expression instanceof VariableReference) {
                ((Declaration) ast).expression = variableValues.get(((VariableReference) ((Declaration) ast).expression).name);
            }
            if (((Declaration) ast).expression instanceof Operation) {
                ((Declaration) ast).expression = calculateOperation((Operation) ((Declaration) ast).expression);
            }

        }
    }

    /*/
    Fill the hashmap with variables
    */
    private void addVariableToHashMap(ASTNode astNode) {
        if (astNode instanceof VariableAssignment) {
            if (((VariableAssignment) astNode).expression instanceof ColorLiteral) {
                variableValues.put(((VariableAssignment) astNode).name.name, new ColorLiteral(((ColorLiteral) ((VariableAssignment) astNode).expression).value));
            } else if (((VariableAssignment) astNode).expression instanceof PercentageLiteral) {
                variableValues.put(((VariableAssignment) astNode).name.name, new PercentageLiteral(((PercentageLiteral) ((VariableAssignment) astNode).expression).value));
            } else if (((VariableAssignment) astNode).expression instanceof PixelLiteral) {
                variableValues.put(((VariableAssignment) astNode).name.name, new PixelLiteral(((PixelLiteral) ((VariableAssignment) astNode).expression).value));
            } else if (((VariableAssignment) astNode).expression instanceof ScalarLiteral) {
                variableValues.put(((VariableAssignment) astNode).name.name, new ScalarLiteral(((ScalarLiteral) ((VariableAssignment) astNode).expression).value));
            }
        }
    }
}
