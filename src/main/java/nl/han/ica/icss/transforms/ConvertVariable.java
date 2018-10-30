package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.VariableReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*/
This class has a function that converts a variable references back to it's original value (the Literal value)
 */
class ConvertVariable {

    private List<HashMap<String, Literal>> variableValues;

    ConvertVariable(List<HashMap<String, Literal>> variableValues) {
        this.variableValues = variableValues;
    }

    Literal convertVariableReferenceToLiteral(VariableReference variableReference) {
        Literal convertedVariable = null;
        for (HashMap hashMap : variableValues) {
            if (hashMap.get(variableReference.name) != null) {
                convertedVariable = (Literal) hashMap.get(variableReference.name);
            }
        }
        return convertedVariable;
    }
}
