package nl.han.ica.icss.checker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.types.*;

public class Checker {

    private LinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new LinkedList<>();
        HashMap<String, ExpressionType> variables = null;
        variableTypes.add(variables);
        checkNodes(ast.root.getChildren());
    }

    private void checkNodes(List<ASTNode> ast) {
        for (ASTNode astNode : ast) {
            checkNode(astNode);
            if (astNode.getChildren() != null) {
                checkNodes(astNode.getChildren());
            }
        }
    }

    private void checkNode(ASTNode astNode) {
        if (astNode instanceof VariableAssignment) {
        }

        if (astNode instanceof Literal) {
            //TODO
        }
        if (astNode instanceof Operation) {
            //TODO
        }
        if (astNode instanceof Selector) {
            //TODO
        }
//        if(astNode instanceof VariableReference) {
//            if(!variableTypes.contains() {
//                astNode.setError("This variable was never declared");
//            }

    }
}



