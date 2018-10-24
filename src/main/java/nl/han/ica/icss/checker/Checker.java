package nl.han.ica.icss.checker;

import java.lang.reflect.Array;
import java.util.*;

import com.google.errorprone.annotations.Var;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.*;

public class Checker {

    //Converted LinkedList<HashMap<String, ExpressionType>> to HashMap<String, ExpressionType> because I don't see the use for the LinkedList
    private HashMap<String, ExpressionType> variableTypes;
    private Validator validator;

    public void check(AST ast) {
        variableTypes = new HashMap<>();
        validator = new Validator();
        checkNodes(ast.root.getChildren());
    }


    /*/
    check every node in the ast tree using visitor class
     */
    private void checkNodes(List<ASTNode> ast) {
        for (ASTNode astNode : ast) {
            addVariableToHashMap(astNode);
            validator.checkNode(astNode, variableTypes);
            if (astNode.getChildren() != null) {
                checkNodes(astNode.getChildren());
            }
        }
    }

    /*/
    add variables to hashmap when they are assigned
     */
    private void addVariableToHashMap(ASTNode astNode) {
        if (astNode instanceof VariableAssignment) {
            if (((VariableAssignment) astNode).expression instanceof ColorLiteral) {
                variableTypes.put(((VariableAssignment) astNode).name.name, ExpressionType.COLOR);
            } else if (((VariableAssignment) astNode).expression instanceof PercentageLiteral) {
                variableTypes.put(((VariableAssignment) astNode).name.name, ExpressionType.PERCENTAGE);
            } else if (((VariableAssignment) astNode).expression instanceof PixelLiteral) {
                variableTypes.put(((VariableAssignment) astNode).name.name, ExpressionType.PIXEL);
            } else if (((VariableAssignment) astNode).expression instanceof ScalarLiteral) {
                variableTypes.put(((VariableAssignment) astNode).name.name, ExpressionType.SCALAR);
            } else {
                variableTypes.put(((VariableAssignment) astNode).name.name, ExpressionType.UNDEFINED);
            }
        }
    }
}