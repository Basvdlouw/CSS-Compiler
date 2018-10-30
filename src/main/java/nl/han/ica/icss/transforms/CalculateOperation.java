package nl.han.ica.icss.transforms;

import com.google.common.base.Converter;
import nl.han.ica.icss.ast.Expression;
import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.Operation;
import nl.han.ica.icss.ast.VariableReference;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;

/*/
The executeCalculation method gets called in the EvalExpressions class
 */
class CalculateOperation {

    static Literal executeCalculation(Operation operation, ConvertVariable converter) {
        Expression lhs = operation.lhs;
        Expression rhs = operation.rhs;

        if (operation.lhs instanceof VariableReference) {
            lhs = converter.convertVariableReferenceToLiteral((VariableReference) operation.lhs);
        }

        if (operation.rhs instanceof VariableReference) {
            rhs = converter.convertVariableReferenceToLiteral((VariableReference) operation.rhs);
        }

        if (rhs instanceof Operation) {
            rhs = executeCalculation((Operation) rhs, converter);
        }
        if (lhs instanceof PixelLiteral && rhs instanceof PixelLiteral) {
            if (operation instanceof AddOperation) {
                return new PixelLiteral(((PixelLiteral) lhs).value + ((PixelLiteral) rhs).value);
            } else if (operation instanceof SubtractOperation) {
                return new PixelLiteral(((PixelLiteral) lhs).value - ((PixelLiteral) rhs).value);
            } else if (operation instanceof MultiplyOperation) {
                return new PixelLiteral(((PixelLiteral) lhs).value * ((PixelLiteral) rhs).value);
            }
        } else if (lhs instanceof PercentageLiteral && rhs instanceof PercentageLiteral) {
            if (operation instanceof AddOperation) {
                return new PercentageLiteral(((PercentageLiteral) lhs).value + ((PercentageLiteral) rhs).value);
            } else if (operation instanceof SubtractOperation) {
                return new PercentageLiteral(((PercentageLiteral) lhs).value - ((PercentageLiteral) rhs).value);
            } else if (operation instanceof MultiplyOperation) {
                return new PercentageLiteral(((PercentageLiteral) lhs).value * ((PercentageLiteral) rhs).value);
            }
        } else if (lhs instanceof ScalarLiteral && rhs instanceof PixelLiteral) {
            if (operation instanceof AddOperation) {
                return new PixelLiteral(((ScalarLiteral) lhs).value + ((PixelLiteral) rhs).value);
            } else if (operation instanceof SubtractOperation) {
                return new PixelLiteral(((ScalarLiteral) lhs).value - ((PixelLiteral) rhs).value);
            } else if (operation instanceof MultiplyOperation) {
                return new PixelLiteral(((ScalarLiteral) lhs).value * ((PixelLiteral) rhs).value);
            }
        } else if (lhs instanceof ScalarLiteral && rhs instanceof PercentageLiteral) {
            if (operation instanceof AddOperation) {
                return new PercentageLiteral(((ScalarLiteral) lhs).value + ((PercentageLiteral) rhs).value);
            } else if (operation instanceof SubtractOperation) {
                return new PercentageLiteral(((ScalarLiteral) lhs).value - ((PercentageLiteral) rhs).value);
            } else if (operation instanceof MultiplyOperation) {
                return new PercentageLiteral(((ScalarLiteral) lhs).value * ((PercentageLiteral) rhs).value);
            }
        }
        return null;
    }
}
