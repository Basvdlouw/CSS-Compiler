package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static nl.han.ica.icss.transforms.CalculateOperation.calculateOperation;

public class EvalExpressions implements Transform {

    private List<HashMap<String, Literal>> variableValues;
    private ConvertVariable converter;

    @Override
    public void apply(AST ast) {
        variableValues = new LinkedList<>();
        converter = new ConvertVariable(variableValues);
        evaluate(ast.root.getChildren());
    }

    /*/
    Loop recursively through tree and evaluate all individual nodes
     */
    private void evaluate(List<ASTNode> ast) {
        for (ASTNode astNode : ast) {
            HashMap<String, Literal> hashMap = new HashMap<>();
            addVariableToHashMap(astNode, hashMap);
            variableValues.add(hashMap);
            evaluateExpression(astNode, variableValues);
            if (astNode.getChildren() != null) {
                evaluate(astNode.getChildren());
            }
        }
    }

    /*/
    Check if the expression is an operation or a variable reference
     */
    private void evaluateExpression(ASTNode ast, List<HashMap<String, Literal>> variableValues) {
        if (ast instanceof Declaration) {
            if (((Declaration) ast).expression instanceof VariableReference) {
                ((Declaration) ast).expression = converter.convertVariableReferenceToLiteral((VariableReference) ((Declaration) ast).expression);
            }
            if (((Declaration) ast).expression instanceof Operation) {
                ((Declaration) ast).expression = calculateOperation((Operation) ((Declaration) ast).expression, converter);
            }
        }
    }

    /*/
    Fill the hashmap with variables
    */
    private void addVariableToHashMap(ASTNode astNode, HashMap<String, Literal> hashMap) {
        if (astNode instanceof VariableAssignment) {
            if (((VariableAssignment) astNode).expression instanceof ColorLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, new ColorLiteral(((ColorLiteral) ((VariableAssignment) astNode).expression).value));
            } else if (((VariableAssignment) astNode).expression instanceof PercentageLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, new PercentageLiteral(((PercentageLiteral) ((VariableAssignment) astNode).expression).value));
            } else if (((VariableAssignment) astNode).expression instanceof PixelLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, new PixelLiteral(((PixelLiteral) ((VariableAssignment) astNode).expression).value));
            } else if (((VariableAssignment) astNode).expression instanceof ScalarLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, new ScalarLiteral(((ScalarLiteral) ((VariableAssignment) astNode).expression).value));
            }
        }
    }
}
