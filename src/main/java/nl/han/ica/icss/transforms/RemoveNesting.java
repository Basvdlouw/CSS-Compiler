package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.Selector;
import nl.han.ica.icss.ast.Stylerule;

import java.util.ArrayList;
import java.util.List;

public class RemoveNesting implements Transform {
    private List<ASTNode> addToRoot;

    @Override
    public void apply(AST ast) {
        checkNodes(ast);
    }


    private void checkNodes(AST ast) {
        addToRoot = new ArrayList<>();
        addSelectors(ast.root.getChildren());
        removeNesting(ast.root.getChildren(), ast, ast.root);
        for (ASTNode node : addToRoot) {
            ast.root.addChild(node);
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


    /*/
    Loop through tree and add parent selectors to children
     */
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


}

