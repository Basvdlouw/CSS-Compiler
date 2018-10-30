package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveNesting implements Transform {

    @Override
    public void apply(AST ast) {
        removeNesting(ast);
    }

    private List<ASTNode> addToRoot;

    private void removeNesting(AST ast) {
        addToRoot = new ArrayList<>();
        addSelectors(ast.root.getChildren());
        removeNesting(ast.root.getChildren(), ast, ast.root);
        for (ASTNode node : addToRoot) {
            ast.root.addChild(node);
        }
    }

    /*/
    Loop through tree and add parent selectors to children
     */
    //TODO: remove 1 for loop
    private void addSelectors(List<ASTNode> astNodes) {
        for (ASTNode node : astNodes) {
            if (node instanceof Stylerule) {
                if (node.getChildren() != null) {
                    for (ASTNode node2 : node.getChildren()) {
                        if (node2 instanceof Stylerule) {
                            //Save selectors because it's not the top nesting level
                            for (Selector selector : ((Stylerule) node).selectors) {
                                node2.addChild(selector);
                            }
                            addSelectors(node2.getChildren());
                        }
                    }
                }
            }
        }
    }

    /*/
        Loop through tree and remove all nesting
         */
    private void removeNesting(List<ASTNode> astNodes, AST ast, ASTNode parent) {
        for (ASTNode node : astNodes) {
            if (node instanceof Stylerule) {
                if (!ast.root.getChildren().contains(node)) {
                    addToRoot.add(node);
                    parent.removeChild(node);
                }
                if (node.getChildren() != null) {
                    removeNesting(node.getChildren(), ast, node);
                }
            }
        }
    }
}

