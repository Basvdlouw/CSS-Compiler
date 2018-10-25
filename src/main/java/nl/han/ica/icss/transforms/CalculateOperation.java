package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.Operation;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;

/*/
The calculateOperation method gets called in the EvalExpressions class
 */
public class CalculateOperation {


/*/
Calculate operation
 */
    public static Literal calculateOperation(Operation operation) {
        if (operation.lhs instanceof PixelLiteral && operation.rhs instanceof PixelLiteral) {
            return calculatePixelOperation(operation);
        } else if (operation.lhs instanceof PercentageLiteral && operation.rhs instanceof PercentageLiteral) {
            return calculatePercentageOperation(operation);
        }
        return calculateScalarOperation(operation);
    }

    /*/
    Calculate pixel operations
     */
    private static Literal calculatePixelOperation(Operation operation) {
        if (operation instanceof AddOperation) {
            return new PixelLiteral(((PixelLiteral) operation.lhs).value + ((PixelLiteral) operation.rhs).value);
        } else if (operation instanceof SubtractOperation) {
            return new PixelLiteral(((PixelLiteral) operation.lhs).value - ((PixelLiteral) operation.rhs).value);
        } else if (operation instanceof MultiplyOperation) {
            return new PixelLiteral(((PixelLiteral) operation.lhs).value * ((PixelLiteral) operation.rhs).value);
        }
        return null;
    }

    /*/
    Calculate percentage operations
     */
    private static Literal calculatePercentageOperation(Operation operation) {
        if (operation instanceof AddOperation) {
            return new PercentageLiteral(((PercentageLiteral) operation.lhs).value + ((PercentageLiteral) operation.rhs).value);
        } else if (operation instanceof SubtractOperation) {
            return new PercentageLiteral(((PercentageLiteral) operation.lhs).value - ((PercentageLiteral) operation.rhs).value);
        } else if (operation instanceof MultiplyOperation) {
            return new PercentageLiteral(((PercentageLiteral) operation.lhs).value * ((PercentageLiteral) operation.rhs).value);
        }
        return null;
    }

    /*/
    Calculate scalar operations
     */
    private static Literal calculateScalarOperation(Operation operation) {
        if (operation.lhs instanceof ScalarLiteral && operation.rhs instanceof PixelLiteral) {
            if (operation instanceof AddOperation) {
                return new PixelLiteral(((ScalarLiteral) operation.lhs).value + ((PixelLiteral) operation.rhs).value);
            } else if (operation instanceof SubtractOperation) {
                return new PixelLiteral(((ScalarLiteral) operation.lhs).value - ((PixelLiteral) operation.rhs).value);
            } else if (operation instanceof MultiplyOperation) {
                return new PixelLiteral(((ScalarLiteral) operation.lhs).value * ((PixelLiteral) operation.rhs).value);
            }
        } else if (operation.lhs instanceof ScalarLiteral && operation.rhs instanceof PercentageLiteral) {
            if (operation instanceof AddOperation) {
                return new PercentageLiteral(((ScalarLiteral) operation.lhs).value + ((PercentageLiteral) operation.rhs).value);
            } else if (operation instanceof SubtractOperation) {
                return new PercentageLiteral(((ScalarLiteral) operation.lhs).value - ((PercentageLiteral) operation.rhs).value);
            } else if (operation instanceof MultiplyOperation) {
                return new PercentageLiteral(((ScalarLiteral) operation.lhs).value * ((PercentageLiteral) operation.rhs).value);
            }
        }
        return null;
    }
}
