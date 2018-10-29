package nl.han.ica.icss.checker;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.VariableAssignment;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Checker {
    private LinkedList<HashMap<String, ExpressionType>> variableTypes;
    private Validator validator;

    public void check(AST ast) {
        variableTypes = new LinkedList<>();
        validator = new Validator();
        checkNodes(ast.root.getChildren());
    }

    /*/
    check every node in the ast tree recursively
    For every nesting level make a new hashmap and add to linkedlist
     */
    private void checkNodes(List<ASTNode> ast) {
        for (ASTNode astNode : ast) {
            HashMap<String, ExpressionType> hashMap = new HashMap<>();
            addVariableToHashMap(astNode, hashMap);
            variableTypes.add(hashMap);
            validator.checkNode(astNode, variableTypes);
            if (astNode.getChildren() != null) {
                checkNodes(astNode.getChildren());
            }
        }
    }

    /*/
    add variables to hashmap when they are assigned
     */
    private void addVariableToHashMap(ASTNode astNode, HashMap<String, ExpressionType> hashMap) {
        if (astNode instanceof VariableAssignment) {
            if (((VariableAssignment) astNode).expression instanceof ColorLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, ExpressionType.COLOR);
            } else if (((VariableAssignment) astNode).expression instanceof PercentageLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, ExpressionType.PERCENTAGE);
            } else if (((VariableAssignment) astNode).expression instanceof PixelLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, ExpressionType.PIXEL);
            } else if (((VariableAssignment) astNode).expression instanceof ScalarLiteral) {
                hashMap.put(((VariableAssignment) astNode).name.name, ExpressionType.SCALAR);
            } else {
                hashMap.put(((VariableAssignment) astNode).name.name, ExpressionType.UNDEFINED);
            }
        }
    }
}